<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: "App",
  components: {
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
  overflow: hidden;
}
.el-main{
  text-align: center;
}
</style>
