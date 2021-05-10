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
              changeOrigin: true
          }
      }
  }
}