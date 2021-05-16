<template>
  <el-container class="container">
    <el-header class="header">
      <img src="../assets/logo.png" />
      <div>考勤管理系统</div>
    </el-header>

    <el-container>
      <el-menu router="true" collapse="true">
        <el-menu-item index="/main/student">
          <i class="iconfont iconxuesheng"></i>
        </el-menu-item>
        <el-menu-item index="/main/teacher">
          <i class="iconfont iconjiaoshi"></i>
        </el-menu-item>
        <el-menu-item index="/main/lab">
          <i class="iconfont iconshiyan"></i>
        </el-menu-item>
        <el-menu-item index="/main/message">
          <i class="iconfont iconxiaoxi"></i>
        </el-menu-item>
        <!-- <el-menu-item index="/main/statistic">
          <i class="iconfont icontongji"></i>
        </el-menu-item>
        <el-menu-item index="/main/super">
          <i class="iconfont iconshezhi"></i>
        </el-menu-item> -->
      </el-menu>

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name:'MainPage'
}
</script>

<style scoped>
.container{
  height: 100%;
  background-color: #F2F6FC;
}
.header{
  background-color: #233B6E;
}
.header>img{
  height: 60px;
  width: auto;
  float: left;
}
.header>div{
  font-size: x-large;
  margin-top: 20px;
  color: white;
}
i{
  font-size: large;
  font-weight: bold;
}
</style>