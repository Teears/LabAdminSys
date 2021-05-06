<template>
  <el-container class="container">
    <el-header class="header">
      <img src="../assets/logo.png" />
      <div>上次登录：{{lastTime}}</div>
    </el-header>

    <el-container>
      <el-menu router="true" collapse="true">
        <el-menu-item index="/main/student">
          <i class="el-icon-setting"></i>
        </el-menu-item>
        <el-menu-item index="/main/teacher">
          <i class="el-icon-setting"></i>
        </el-menu-item>
        <el-menu-item index="/main/lab">
          <i class="el-icon-setting"></i>
        </el-menu-item>
        <el-menu-item index="/main/statistic">
          <i class="el-icon-setting"></i>
        </el-menu-item>
        <el-menu-item index="/main/message">
          <i class="el-icon-setting"></i>
        </el-menu-item>
        <el-menu-item index="/main/super">
          <i class="el-icon-setting"></i>
        </el-menu-item>
      </el-menu>

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name:'MainPage',
  data(){
    return{
      lastTime:"2020/10/01 10:21:11"
    }
  }
}
</script>

<style scoped>
.container{
  height: 100%;
  background-color: rgb(245, 254, 255);
}
.header{
  background-color: rgb(76, 153, 216)
}
.header>img{
  height: 60px;
  width: auto;
  float: left;
}
.header>div{
  float: right;
  font-size: smaller;
  margin-top: 20px;
  color: white;
}
</style>