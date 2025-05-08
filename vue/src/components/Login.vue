<template>
  <el-container>
    <el-main>
      <div class="login_box">
        <div class="title">
          <img src="../assets/titleIllustration.png" />
          <p class="titleText">考勤管理</p>
        </div>
        <el-form :model="userForm">
          <el-input
            placeholder="请输入职工号"
            prefix-icon="iconfont iconzhanghao"
            v-model="userForm.userNumber"
            size="medium"
          ></el-input>
          <el-input
            placeholder="请输入密码"
            prefix-icon="iconfont iconmima"
            v-model="userForm.password"
            show-password
            size="medium"
          ></el-input>
          <el-button type="primary" round @click="login">登 录</el-button>
        </el-form>
        <div class="footer">
          <el-popover placement="right" title="扫描下方二维码,进入教师学生端" width="230" trigger="click">
            <img src="../assets/miniprogram.jpg" style="height:230px;width:auto"/>
            <el-link slot="reference" type="primary">教师学生端</el-link>
          </el-popover>
        </div>
      </div>
    </el-main>
    <el-footer>
      <a
        href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=51078202110194"
        target="_blank">
        <img src="../assets/police.png" style="float:left;" />
        <p>川公网安备 51078202110194号</p>
      </a>
      <p>CopyRight@Teears 蜀ICP备2021003161号</p>
      <p>联系方式:18011108917</p>
    </el-footer>
  </el-container>
</template>

<script>
import {setCookie} from '../cookie'
export default {
  name: "Login",
  data() {
    return {
      userForm: {
        userNumber: "",
        password: ""
      }
    }
  },
  methods: {
    login() {
      this.$axios
        .post("/api/admin/login",{
          userNumber:this.$data.userForm.userNumber,
          password:this.$data.userForm.password
        })
        .then(res=>{
          if(res.data.statusCode == 200){
            setCookie("token",res.data.data.token,1)
            setCookie("roleId",res.data.data.roleId,1)
            this.$router.replace({ path: "/main" });
          }else{
            this.$message('账号或密码错误');
          }
        })
        .catch(error=>{
          this.$message(error)
        })
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.el-container {
  background: url("../assets/back.jpg") no-repeat bottom;
  background-size: cover;
}
.el-footer {
  color: #dcdfe6;
  font-size: small;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center
}
a {
  display: inline-block;
  text-decoration: none;
  height: 20px;
  line-height: 20px;
}
p {
  float: left;
  height: 20px;
  line-height: 20px;
  margin: 0px 0px 0px 5px;
  color: #939393;
}

/* 登录组件 */
.title {
  display: inline-flex;
  /* justify-content: space-around; */
  height: 25%;
  width: 100%;
  margin: 30px;
}
img {
  width: auto;
  height: 100%;
}
.titleText {
  line-height: 250%;
  width: 40%;
  color: #233b6e;
  font-family: YOUYUAN;
  font-size: 250%;
  text-align: right;
  vertical-align: middle;
}

.login_box {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  height: 500px;
  width: 400px;
  /* background-color: white;
	opacity: 0.65; */
  background: rgba(255, 255, 255, 0.65);
  border-radius: 4px;
  position: absolute;
  top: 45%;
  right: 50%;
  margin-right: -200px;
  margin-top: -250px;
}
.el-form {
  margin: 50px;
  margin-top: 0px;
}
.el-input {
  margin-bottom: 30px;
}
.el-button {
  margin-top: 30px;
  width: 100%;
}

.footer {
  margin-top: 20px;
  text-align: center;
}
.el-popover {
  text-align: center;
  font-size: x-small;
}
</style>
