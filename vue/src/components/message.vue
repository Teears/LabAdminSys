<template>
  <div class="out-wrapper">
    <!-- 第一版 -->
    <div>
      <div class="top">
        <img src="../assets/write.png" />
        <div></div>
        <span>新发布</span>
      </div>
      <div class="post-new">
        <el-form :model="form" label-width="40px">
          <el-form-item label="发布">
            <el-checkbox-group v-model="form.type">
              <el-checkbox label="学生"></el-checkbox>
              <el-checkbox label="教师"></el-checkbox>
            </el-checkbox-group>
          </el-form-item>
          <el-form-item label="标题">
            <el-input v-model="form.title" type="text" show-word-limit maxlength="30"></el-input>
          </el-form-item>
          <el-form-item label="内容">
            <el-input
              :autosize="{ minRows: 15, maxRows: 20}"
              v-model="form.content"
              type="textarea"
              show-word-limit
              maxlength="500"
              placeholder="请输入"
            ></el-input>
          </el-form-item>
          <el-button type="primary" @click="submit">发 布</el-button>
        </el-form>
      </div>
    </div>

    <!-- 第二版 -->
    <div>
      <div class="top">
        <img src="../assets/posted.png" />
        <div></div>
        <span>已发布</span>
      </div>
      <div class="post-history">
        <el-collapse>
          <el-collapse-item v-for="item in messageList" :key="item.id" :title="item.title">
            <div style="color:gray">{{item.content}}</div>
          </el-collapse-item>
        </el-collapse>
      </div>
    </div>

    <!-- 第三版 -->
    <div>
      <div class="top">
        <img src="../assets/feedback.png" />
        <div></div>
        <span>反馈</span>
      </div>
      <div class="post-history">
        <div class="feedback-wrapper" v-for="item in feedbackList" :key="item.id">
          <div class="feedback-title">
            <div>{{item.name}}</div>
            <div>{{item.time}}</div>
          </div>
          <div>{{item.content}}</div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "Message",
  data() {
    return {
      form: {
        type: [],
        title: "",
        content: ""
      },
      messageList:[{
        id:1,
        title:"一致性 Consistency",
        content:"与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念"
      },{
        id:2,
        title:"一致性 Consistency",
        content:"与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念"
      }],
      feedbackList:[{
        id:1,
        name:"一致性 Consistency",
        time:"2020-10-10 12:31",
        content:"与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念"
      },{
        id:2,
        name:"一致性 Consistency",
        time:"2020-10-10 12:31",
        content:"与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念"
      }]
    };
  },
  methods:{
    submit(){
      this.$axios
        .post("/api/admin/message/addMessage",{
          form:this.form
        })
        .then((res)=>{
          this.messageList.unshift(res.data.data)
          this.$message({
            message: '添加成功',
            type: 'success'
          })
        })
        .catch(error=>{
          this.$message(error)
        })
    },
    initPageList(){
      this.$axios
        .get("/api/admin/message/getPageList")
        .then(res=>{
          this.messageList = res.data.data.messageList
          this.feedbackList = res.data.data.feedbackList
        })
        .catch(error=>{
          this.$message(error)
        })
    }
  },
  created(){
    initPageList()
  }
};
</script>

<style scoped>
.out-wrapper {
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.out-wrapper > div {
  box-sizing: border-box;
  padding: 5px;
  width: 32%;
  height: 100%;
  background-color: white;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.top {
  display: flex;
  flex-direction: row;
  justify-content: start;
  align-items: center;
  height: 60px;
  width: 100%;
  margin-bottom: 20px;
}
.top > .el-image {
  height: 60px;
  width: auto;
}
.top > div {
  background-color: rgba(0, 0, 0, 0.12);
  width: 1px;
  height: 90%;
  margin: 0 20px 0;
}
.top > span {
  font-size: large;
  font-weight: bold;
}
.post-history {
  height: 88%;
  text-align: start;
  overflow-y: auto;
  overflow-x: hidden;
}
.feedback-wrapper{
  display: flex;
  flex-direction: column;
  padding: 5px;
  margin: 0 3px 10px 3px;
  border: 1px solid rgba(0, 0, 0, 0.12);
}
.feedback-title{
  color: gray;
  font-size: smaller;
  padding-bottom: 5px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
/* .post-history {
  height: 88%;
  text-align: start;
  overflow-y: auto;
  overflow-x: hidden;
}
.post-history > div {
  height: 150px;
  width: 100%;
  margin: 0 2px 2px 2px;
  border-bottom: 1px solid rgba(0, 0, 0, 0.12);
} */
.el-button {
  width: 200px;
}
</style>