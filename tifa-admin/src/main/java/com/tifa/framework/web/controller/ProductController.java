package com.tifa.framework.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tifa.framework.web.pojo.*;
import com.tifa.framework.web.service.impl.*;
import com.tifa.framework.web.util.AjaxReturnValue;
import com.tifa.framework.web.util.JSONData;
import net.minidev.json.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.sql.JDBCType.NULL;


@CrossOrigin
@RestController
@RequestMapping("/tifai/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductimageServiceImpl productimageService;

    @Autowired
    private CategoryServiceImpl categoryService;


    @Autowired
    private ShoppingcartitemServiceImpl shoppingcartitemService;

    @Autowired
    private UserServiceImpl userService;

//    @GetMapping("/pageData")
//    public Page<Product> productData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
//        Page<Product> productPage = new Page<>(pageNum,10);
//        return productService.page(productPage,null);
//    }
    @PostMapping("/searchGoods")
    public AjaxReturnValue productData(@RequestBody JSONData jsonData) {
        String searchKey = (String) jsonData.get("searchKey");
        Integer pageIndex = (Integer) jsonData.get("pageIndex");
        JSONData rJsonData = new JSONData();
        IPage<Product> iPage = new Page<>();
        if ("all".equals(searchKey)){
            Page<Product> productPage = new Page<>(pageIndex, 20);
            iPage = productService.page(productPage,null);
        }else{
            Page<Product> productPage = new Page<>(pageIndex,20);
            iPage = productService.page(productPage,
                    new QueryWrapper<Product>()
                            .like("pname","%"+searchKey+"%")
                            .or()
                            .like("subTitle","%"+searchKey+"%")
            );
        }
        rJsonData.put(
                "pageData",iPage
        );
        ArrayList<Productimage> productimages = new ArrayList<>();
        ArrayList<Category> categories = new ArrayList<>();
        iPage.getRecords().forEach((item)->{
            productimages.add(productimageService.getOne(
                    new QueryWrapper<Productimage>()
                            .eq("pid",item.getPid())
            ));
            categories.add(categoryService.getOne(
                    new QueryWrapper<Category>()
                            .eq("pid",item.getPid())
            ));
        });
        rJsonData.put(
                "imgData",productimages
        );
        rJsonData.put(
                "categorys",categories
        );
        return AjaxReturnValue.success(rJsonData);
    }

    @PostMapping("/detailData")
    public AjaxReturnValue productDetailData(@RequestBody JSONData jsonData){
        Integer pid = Integer.parseInt((String) (jsonData.get("pid")));
        JSONData rJsonData = new JSONData();
        Map<String, Object> productInfo = JSONData.convertBeanToMap(productService.getById(pid));
        Map<String, Object> productImageInfo = JSONData.convertBeanToMap(productimageService.getOne(
                new QueryWrapper<Productimage>()
                        .eq("pid",pid)
        ));
        Map<String, Object> productCategoryInfo = JSONData.convertBeanToMap(categoryService.getById(pid));
        rJsonData.put("productInfo",productInfo );
        rJsonData.put("productImageInfo",productImageInfo);
        rJsonData.put("productCategoryInfo",productCategoryInfo);

        Integer bid = new Integer(productService.getById(pid).getBid());
        String merchantName = "TIFA官方店铺";
        if (bid != 0){
            merchantName = "TIFA个人店铺";
        }
        rJsonData.put("merchantName",merchantName);
        return AjaxReturnValue.success(rJsonData);
    }



    @PostMapping("/updateShopCart")
    public AjaxReturnValue updateShopCart(@RequestBody Shoppingcartitem shoppingcartitem){
        if (shoppingcartitem.getPid() > 0){
            shoppingcartitemService.save(shoppingcartitem);
            return AjaxReturnValue.success();
        }
        return AjaxReturnValue.error(438);
    }

    @PostMapping("/getShopCartData")
    public AjaxReturnValue getShopCartData(@RequestBody User user){
        List<Shoppingcartitem> shopCartItemInfo = shoppingcartitemService.list(
                new QueryWrapper<Shoppingcartitem>()
                        .eq("sid", user.getUid())
        );
        ArrayList<Product> arrayList = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<String> imgList = new ArrayList<>();
        shopCartItemInfo.forEach((item)->{
            Product product = productService.getById(item.getPid());
            String img = productimageService.getOne(
                    new QueryWrapper<Productimage>()
                            .eq("pid",item.getPid())
            ).getType();
            Integer num = item.getNum();
            arrayList.add(product);
            numList.add(num);
            imgList.add(img);
        });

        JSONData jsonData = new JSONData();
        jsonData.put("productInfo",arrayList);
        jsonData.put("numList", numList);
        jsonData.put("imgList", imgList);

        return AjaxReturnValue.success(jsonData);
    }

    @PostMapping("/deleteCart")
    public AjaxReturnValue getShopCartData(@RequestBody JSONData jsonData){
        shoppingcartitemService.remove(
                new QueryWrapper<Shoppingcartitem>()
                        .eq("sid",jsonData.get("sid"))
                        .eq("pid",jsonData.get("pid"))
        );
        return AjaxReturnValue.success();
    }

    @PostMapping("/clearCart")
    public AjaxReturnValue clearCart(@RequestBody JSONData jsonData){
        Integer uid = (Integer) (jsonData.get("uid"));
        shoppingcartitemService.remove(
                new QueryWrapper<Shoppingcartitem>()
                        .eq("sid",uid));
        return AjaxReturnValue.success();
    }

    @PostMapping("/deleteMeProduct")
    public AjaxReturnValue deleteMeProduct(@RequestBody JSONData jsonData){
        Integer pid = (Integer) (jsonData.get("pid"));
        Product product = new Product();
        product.setPid(pid);
        product.setBid(0);
        productService.updateById(product);
        productimageService.remove(
                new QueryWrapper<Productimage>()
                        .eq("pid",pid)
        );
        categoryService.remove(
                new QueryWrapper<Category>()
                        .eq("pid",pid)
        );
        productService.remove(
                new QueryWrapper<Product>()
                        .eq("pid",pid)
        );
        return AjaxReturnValue.success();
    }


    @PostMapping("/getMerchantProductData")
    public AjaxReturnValue getMerchantProductData(@RequestBody JSONData jsonData){
        Integer uid = (Integer) (jsonData.get("uid"));
        List<Product> products = productService.list(
                new QueryWrapper<Product>()
                        .eq("bid",uid)
        );
        List<Productimage> productImgs = new ArrayList<>();
        products.forEach((item)->{
            productImgs.add(
                    productimageService.getOne(
                            new QueryWrapper<Productimage>()
                                    .eq("pid",item.getPid())
                    )
            );

        });
        JSONData rJsonData = new JSONData();
        rJsonData.put("products",products);
        rJsonData.put("productImgs",productImgs);
        return AjaxReturnValue.success(rJsonData);
    }
    @PostMapping("/addProduct")
    public AjaxReturnValue addProduct(@RequestBody JSONData jsonData){
        Integer uid = (Integer) (jsonData.get("uid"));
        Product product = new Product();
        product.setPname((String)(jsonData.get("pname")));
        product.setSubtitle((String)(jsonData.get("subTitle")));
        product.setOrignalprice(Double.parseDouble((String) (jsonData.get("orignalPrice"))));
        product.setPromoteprice(Double.parseDouble((String) (jsonData.get("orignalPrice"))));
        product.setBid(uid);
        product.setStock(Integer.parseInt((String) (jsonData.get("stock"))));
        product.setCreatedate(new Date(System.currentTimeMillis()));

        productService.save(product);
        Productimage productimage = new Productimage();
        productimage.setPid(productService.getOne(
                new QueryWrapper<Product>()
                        .eq("pname",product.getPname())
        ).getPid());
        productimage.setType((String)jsonData.get("img"));

        productimageService.save(productimage);

        return AjaxReturnValue.success();
    }
}
