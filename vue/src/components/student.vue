<template>
  <div>
    <div class="wrapper-top">
      <div class="wrapper-top-right">
        <el-input placeholder="请输入搜索内容" v-model="search" clearable>
          <el-button slot="append" icon="el-icon-search" @click="searchStudent"></el-button>
        </el-input>
        <el-button class="add-button" type="primary" @click="addStudent">新增</el-button>
      </div>
    </div>

    <div class="wrapper-table">
      <el-table :data="studentTableData" border style="width:100%">
        <el-table-column prop="num" label="学号" width="100"></el-table-column>
        <el-table-column prop="name" label="姓名" width="200"></el-table-column>
        <el-table-column prop="labId" label="实验室ID" width="80"></el-table-column>
        <el-table-column prop="sex" label="性别" width="50"></el-table-column>
        <el-table-column prop="phone" label="联系方式" width="200"></el-table-column>
        <el-table-column prop="department" label="学院"></el-table-column>
        <el-table-column prop="major" label="专业"></el-table-column>
        <el-table-column prop="operate" label="操作" width="100">
          <template slot-scope="scope">
            <el-button size="mini" round plain type="danger" @click="deleteStudent(scope.$index,scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <el-pagination background
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange"
    :current-page="currentPage"
    :page-sizes="[12]"
    :page-size="pageSize"
    :total="total"
    layout="prev,pager,next,jumper,sizes,total">
    </el-pagination>

    <el-dialog :visible.sync="dialogVisible" 
    @closed="closedDialog" 
    :close-on-click-modal="false" 
    width="30%">
      <el-form :model="form" label-width="70px">
        <el-form-item label="学号">
          <el-input v-model="form.num" :disabled="lock" placeholder="请输入学号"></el-input>
        </el-form-item>
        <el-form-item label="实验室ID">
          <el-input v-model="form.labId" :disabled="lock" placeholder="ID可在实验管理查询"></el-input>
          <el-button type="text" @click="checkInfo" :icon="iconTip" :loading="loading">验证</el-button>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="form.name" disabled></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-input v-model="form.sex" disabled></el-input>
        </el-form-item>
        <el-form-item label="联系方式">
          <el-input v-model="form.phone" disabled></el-input>
        </el-form-item>
        <el-form-item label="学院">
          <el-input v-model="form.department" disabled></el-input>
        </el-form-item>
        <el-form-item label="专业">
          <el-input v-model="form.major" disabled></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer">
        <el-button @click="dialogVisible=false">取消</el-button>
        <el-button @click="enterAddStudent" type="primary" :disabled="!lock">添加</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name:'Student',
  data(){
    return{
      search:"",
      studentTableData:[],
      dialogVisible:false,
      currentPage:1,
      pageSize:12,
      total:12,
      form:{
        num:"",
        labId:"",
        name:"",
        sex:"",
        phone:"",
        department:"",
        major:""
      },
      loading:false,
      iconTip:"",
      lock:false
    }
  },
  methods:{
    searchStudent(){
      this.getStudentList(this.search,this.currentPage,this.pageSize)
    },
    handleSizeChange(val){
      this.pageSize = val
      this.getStudentList(this.search,this.currentPage,val)
    },
    handleCurrentChange(val){
      this.currentPage = val
      this.getStudentList(this.search,val,this.pageSize)
    },
    closedDialog(){
      this.loading = false
      this.iconTip=""
      this.lock = false
      this.form = {}
    },
    addStudent(){
      this.dialogVisible = true
    },
    checkInfo(){
      this.loading = true
      const that = this
      this.$axios
        .get("/api/admin/student/checkStudent?num="+that.form.num+"&labId="+that.form.labId)
        .then(res=>{
          if(res.data.statusCode == 200){
            var labId = that.form.labId
            that.form = res.data.data
            that.form.labId = labId
            that.loading = false
            that.iconTip = "el-icon-check"
            that.lock = true
          }else{
            that.loading = false
            that.iconTip = "el-icon-close"
            that.$message(res.data.msg)
          }
        })
        .catch(error=>{
          this.$message(error)
        })
    },
    enterAddStudent(){
      this.$axios
        .post("/api/admin/student/addStudent",{
          num:this.form.num,
          labId:this.form.labId
        })
        .then(()=>{
          this.studentTableData.unshift(this.form)
          this.dialogVisible = false
          this.$message({
            message: '添加成功',
            type: 'success'
          })
        })
        .catch(error=>{
          this.$message(error)
        })
    },
    deleteStudent(index,row){
      this.$axios
        .post("/api/admin/student/deleteStudent",{
          num:row.num
        })
        .then(()=>{
          this.studentTableData.splice(index,1)
          this.$message('已删除')
        })
        .catch(error=>{
          this.$message(error)
        })
    },
    getStudentList(content,currentPage,pageSize){
      this.$axios
        .get("/api/admin/student/getStudentList?content="+content+
        "&currentPage="+currentPage+"&pageSize="+pageSize)
        .then(res=>{
          this.studentTableData = res.data.data.list
          this.total = res.data.data.total
        })
        .catch(error=>{
          this.$message(error)
        })
    }
  },
  created(){
    this.getStudentList("",this.currentPage,this.pageSize)
  }
}
</script>

<style scoped>
.wrapper-top,
.wrapper-top-right{
  display: flex;
  flex-direction: row;
  justify-content:space-between;
  margin-bottom: 10px;
}
.add-button{
  margin-left: 30px
}
</style>