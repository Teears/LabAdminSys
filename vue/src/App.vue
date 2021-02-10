<template>
  <div id="app">
    <el-container>
			<el-main>
				
			</el-main>
			<el-footer>
				这是 footer text
			</el-footer>
		</el-container>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    // HelloWorld
  }
}
</script>

<style>
*{
	margin: 0;
	padding: 0;
}
#app,html,body,.el-container{
	height:100%;
}
.el-footer{
	background-color: #233B6E;
	color: #DCDFE6;
	text-align: center;
	line-height: 40px;
	font-size: small;
}
</style>
<style scoped>
	background:url('')
</style>
