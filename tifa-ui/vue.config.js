const path = require('path');

// 设置绝对路径。
function resolve(dir){
    return path.join(__dirname,dir);
}

module.exports = {
    productionSourceMap:false,
    // 关闭ESLINT校验工具
    lintOnSave: false,


    //代理。 
    devServer:{
	    proxy:{
        '/tifai':{
            target: 'http://localhost:8081',
	      }
      }
	  },

    // 别名配置。
    chainWebpack:(config)=>{
        config.resolve.alias
        .set('@',resolve('./src'))
        .set('_components',resolve('./src/components'))
        .set('_assets',resolve('./src/assets'))
        .set('_pages',resolve('./src/pages'))
        .set('_api',resolve('./src/api'))
        .set('_store',resolve('./src/store'))
        .set('_utils',resolve('./src/utils'))
    },
};
  