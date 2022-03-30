module.exports = {
    productionSourceMap:false,
    // 关闭ESLINT校验工具
    lintOnSave: false,
    //代理。 
    devServer:{
	    proxy:{
        '/api':{
            target: 'http://localhost:8081',
            changeOrigin: true,
            pathRewrite: {
                '/api': '/' 
            }  
	      }
      }
	  },
};
  