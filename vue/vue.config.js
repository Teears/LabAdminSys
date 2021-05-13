module.exports = {
  publicPath: './',
  productionSourceMap: true,
  devServer:{
    port:81,
    host:'localhost',
    open:true,
    proxy: {
      '/api': {
          target: 'http://localhost:8080',
          ws: true,
          changeOrigin: true,
          pathRewrite: {
              '^/api': ''  //通过pathRewrite重写地址，将前缀/api转为/
          }
      }
    }
  },
  transpileDependencies: [
    'vue-echarts',
    'resize-detector'
  ]
}