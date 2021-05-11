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
    :page-sizes="[10,15,20,30,50]"
    :page-size="10"
    :total="total"
    layout="prev,pager,next,jumper,sizes,total">
    </el-pagination>

    <el-dialog></el-dialog>
  </div>
</template>

<script>
export default {
  name:'Student',
  data(){
    return{
      search:"",
      studentTableData:[{
        num:"2017110323",
        name:"李小明",
        sex:"男",
        phone:"18011108917",
        department:"计算机科学学院",
        major:"网络工程"
      },{
        num:"2017110323",
        name:"李小明",
        sex:"男",
        phone:"18011108917",
        department:"计算机科学学院",
        major:"网络工程"
      },{
        num:"2017110323",
        name:"李小明",
        sex:"男",
        phone:"18011108917",
        department:"计算机科学学院",
        major:"网络工程"
      }],
      studentForm:{},
      dialogVosible:false,
      currentPage:1
    }
  },
  methods:{
    getStudentInfo(){

    },
    addStudent(){

    },
    deleteStudent(index,row){
      alert(index + row)
    },
    searchStudent(){

    }
  },
  created(){

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