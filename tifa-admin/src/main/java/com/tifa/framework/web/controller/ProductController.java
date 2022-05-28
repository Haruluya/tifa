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
import java.util.List;
import java.util.Map;


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
        if ("all".equals(searchKey)){
            Page<Product> productPage = new Page<>(pageIndex, 20);
            JSONData rJsonData = new JSONData();
            rJsonData.put("pageData",productService.page(productPage,null));
            Page<Productimage> productimagePage = new Page<>(pageIndex, 20);
            rJsonData.put("imgData",productimageService.page(productimagePage,null));
            return AjaxReturnValue.success(rJsonData);
        }
        return AjaxReturnValue.success();
    }

    @PostMapping("/detailData")
    public AjaxReturnValue productDetailData(@RequestBody JSONData jsonData){
        Integer pid = Integer.parseInt((String) (jsonData.get("pid")));
        JSONData rJsonData = new JSONData();
        Map<String, Object> productInfo = JSONData.convertBeanToMap(productService.getById(pid));
        Map<String, Object> productImageInfo = JSONData.convertBeanToMap(productimageService.getById(pid));
        Map<String, Object> productCategoryInfo = JSONData.convertBeanToMap(categoryService.getById(pid));
        rJsonData.put("productInfo",productInfo );
        rJsonData.put("productImageInfo",productImageInfo);
        rJsonData.put("productCategoryInfo",productCategoryInfo);
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
        if (userService.userExisted(user.getUname(),user.getPassword())){
            List<Shoppingcartitem> shopCartItemInfo = shoppingcartitemService.list(
                    new QueryWrapper<Shoppingcartitem>()
                            .eq("sid", user.getUid())
            );
            ArrayList<Product> arrayList = new ArrayList<>();
            ArrayList<Integer> numList = new ArrayList<>();
            ArrayList<String> imgList = new ArrayList<>();
            shopCartItemInfo.forEach((item)->{
                Product product = productService.getById(item.getPid());
                String img = productimageService.getById(item.getPid()).getType();
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
        return AjaxReturnValue.error(438);
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


}
