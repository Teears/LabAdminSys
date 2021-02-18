<template>
  <div class="login_box">
		<div class="title">
			<img src="../assets/titleIllustration.png" />
			<p class="titleText">考勤管理</p>
		</div>
		<el-form :model="userForm">
			<el-input placeholder="请输入职工号" prefix-icon="iconfont iconzhanghao" v-model="userForm.userNumber" size="medium"></el-input>
			<el-input placeholder="请输入密码" prefix-icon="iconfont iconmima" v-model="userForm.password" show-password size="medium"></el-input>
			<el-button type="primary" round>登 录</el-button>
		</el-form>
		<div class="footer">
			<el-popover
			  placement="right"
			  title="扫描下方二维码,进入教师学生端"
			  width="230"
			  trigger="click">
				<el-image :src="erweimaUrl" :fit="cover"></el-image>
				<el-link slot="reference" type="primary">教师学生端</el-link>
			</el-popover>
		</div>
  </div>
</template>

<script>
export default {
  name: 'Login',
	data(){
		return{
			userForm:{
				userNumber:'',
				password:''
			},
			erweimaUrl:"https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"
		}
	}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.title{
	display: inline-flex;
	/* justify-content: space-around; */
	height: 25%;
	width: 100%;
	margin: 30px;
}
img{
	width:auto;
	height: 100%;
}
.titleText{
	line-height: 250%;
	width: 40%;
	color: #233B6E;
	font-family: YOUYUAN;
	font-size: 250%;
	text-align: right;
	vertical-align: middle;
}

.login_box{
	box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
	height: 500px;
	width: 400px;
	/* background-color: white;
	opacity: 0.65; */
	background: rgba(255,255,255,0.65);
	border-radius: 4px;
	position: absolute;
	top: 45%;
	right: 50%;
	margin-right: -200px;
	margin-top: -250px;
}
.el-form{
	margin: 50px;
	margin-top: 0px;
}
.el-input{
	margin-bottom: 30px;
}
.el-button{
	margin-top: 30px;
	width: 100%;
}

.footer{
	margin-top: 20px;
	text-align: center;
}
.el-popover{
	text-align: center;
	font-size: x-small;
}
.el-image{
	width: 230px;
	height: 230px;
}
</style>
