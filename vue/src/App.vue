<template>
  <div id="app">
    <el-container>
      <el-main>
        <login></login>
      </el-main>
      <el-footer>
          <a
            href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=51078202110194"
            target="_blank"
          >
            <img src="./assets/police.png" style="float:left;" />
            <p>川公网安备 51078202110194号</p>
          </a>
					<p>CopyRight@Teears 蜀ICP备2021003161号</p>
          <p>联系方式:18011108917</p>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import login from "./components/Login.vue";

export default {
  name: "App",
  components: {
    login
  },
  data() {
    return {};
  }
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
}
#app,
html,
body,
.el-container {
  height: 100%;
}
</style>

<style scoped>
.el-container {
  background: url("./assets/back.jpg") no-repeat bottom;
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
</style>
