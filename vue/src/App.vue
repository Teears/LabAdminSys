<template>
  <div id="app">
    <el-container>
			<el-main>
				<login></login>
			</el-main>
			<el-footer>
				{{footerText}}
			</el-footer>
		</el-container>
  </div>
</template>

<script>
import login from './components/Login.vue'

export default {
  name: 'App',
  components: {
    login
  },
	data(){
		return{
			footerText:"CopyRight@Teears 蜀ICP备2021003161号"
		}
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
</style>

<style scoped>
.el-container{
  background: url('./assets/back.jpg') no-repeat bottom;
  background-size:cover;
}
.el-footer{
	color: #DCDFE6;
	text-align: center;
	line-height: 40px;
	font-size: small;
}
</style>
