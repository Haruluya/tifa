package com.tifa.framework.config;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *  项目初始化
 *
 * @author wangziyang
 * @date 2020-09-08
 * */
@Component
public class ProjectInit implements ApplicationRunner {

    //应用id
    @Value("${alipay.appId}")
    private String appId;

    //私钥
    @Value("${alipay.privateKey}")
    private String privateKey;

    //公钥
    @Value("${alipay.publicKey}")
    private String publicKey;

    //支付宝网关
    @Value("${alipay.gateway}")
    private String gateway;

    //支付成功后的接口回调地址，不是回调的友好页面，不要弄混了
    @Value("${alipay.notifyUrl}")
    private String notifyUrl;

    /**
     *  项目初始化事件
     * */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //初始化支付宝SDK
        Factory.setOptions(getOptions());
        System.out.println("**********支付宝SDK初始化完成**********");
    }

    private Config getOptions() {
        //这里省略了一些不必要的配置，可参考文档的说明

        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = this.gateway;
        config.signType = "RSA2";

        config.appId = this.appId;

        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = this.privateKey;

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = this.publicKey;

        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = notifyUrl;

        return config;
    }
}
