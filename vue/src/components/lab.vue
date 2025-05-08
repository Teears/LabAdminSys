<template>
  <div>
    <div class="wrapper-top">
      <div class="wrapper-top-right">
        <el-input placeholder="请输入搜索内容" v-model="search" clearable>
          <el-button slot="append" icon="el-icon-search" @click="searchLab"></el-button>
        </el-input>
        <el-button class="add-button" type="primary" @click="addLab">新增</el-button>
      </div>
    </div>

    <div class="wrapper-table">
      <el-table :data="labTableData" 
      border highlight-current-row
      ref="singleTable"
      style="width:100%">
        <el-table-column prop="num" label="编号" width="80"></el-table-column>
        <el-table-column prop="name" label="名称" width="200"></el-table-column>
        <el-table-column prop="seat" label="座位数" width="80"></el-table-column>
        <el-table-column prop="room" label="门牌号" width="80"></el-table-column>
        <el-table-column prop="address" label="地址"></el-table-column>
        <el-table-column prop="time" label="创建时间" width="100"></el-table-column>
        <el-table-column prop="operate" label="操作" width="200">
          <template slot-scope="scope">
            <el-button size="mini" round plain type="primary" @click="updateLab(scope.$index,scope.row)">修改</el-button>
            <el-button size="mini" round plain type="danger" @click="deleteLab(scope.$index,scope.row)">删除</el-button>
            <el-button size="mini" type="text" @click="detailLab(scope.row)">详情</el-button>
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

    <el-dialog :visible.sync="addDialogVisible" 
    @closed="closedDialog" 
    :destroy-on-close="true" 
    :close-on-click-modal="false"
    width="30%">
      <el-form :model="addForm" label-width="70px">
        <el-form-item label="编号">
          <el-input v-model="addForm.num"></el-input>
        </el-form-item>
        <el-form-item label="名称">
          <el-input v-model="addForm.name"></el-input>
        </el-form-item>
        <el-form-item label="门牌号">
          <el-input v-model="addForm.room"></el-input>
        </el-form-item>
        <el-form-item label="座位数">
          <el-input v-model="addForm.seat"></el-input>
        </el-form-item>
        <el-form-item label="地址">
          <el-input v-model="addForm.address"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer">
        <el-button @click="addDialogVisible=false">取消</el-button>
        <el-button @click="enterAddLab" type="primary">添加</el-button>
      </span>
    </el-dialog>

    <el-dialog :visible.sync="updateDialogVisible" :close-on-click-modal="false" width="30%">
      <el-form :model="updateForm" label-width="70px">
        <el-form-item label="编号">
          <el-input v-model="updateForm.num"></el-input>
        </el-form-item>
        <el-form-item label="名称">
          <el-input v-model="updateForm.name"></el-input>
        </el-form-item>
        <el-form-item label="门牌号">
          <el-input v-model="updateForm.room"></el-input>
        </el-form-item>
        <el-form-item label="座位数">
          <el-input v-model="updateForm.seat"></el-input>
        </el-form-item>
        <el-form-item label="地址">
          <el-input v-model="updateForm.address"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer">
        <el-button @click="updateDialogVisible=false">取消</el-button>
        <el-button @click="enterUpdateLab" type="primary">提交</el-button>
      </span>
    </el-dialog>

    <el-dialog :visible.sync="drawerVisible" 
    :title="detailInfo.labNumber" width="400px">
      <div>
        <div>
          签到:{{detailInfo.checkinStart}}~{{detailInfo.checkinEnd}}&nbsp;&nbsp;&nbsp;&nbsp;
          签退:{{detailInfo.checkoutStart}}~{{detailInfo.checkoutEnd}}
        </div>
        <div class="detail-title">介绍</div>
        <div class="detail-content">
          &emsp;&emsp;{{detailInfo.basicDesc}}
          <img :src="detailInfo.picUrl">
        </div>
        <div class="detail-title">守则</div>
        <div class="detail-content">
          &emsp;&emsp;{{detailInfo.ruleDesc}}
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name:'Lab',
  data(){
    return{
      search:"",
      addDialogVisible:false,
      updateDialogVisible:false,
      drawerVisible:false,
      currentIndex:1,
      addForm:{},
      updateForm:{},
      detailInfo:{},
      labTableData:[],
      currentPage:1,
      pageSize:12,
      total:12
    }
  },
  methods:{
    searchLab(){
      this.getLabList(this.search,this.currentPage,this.pageSize)
    },
    handleSizeChange(val){
      this.pageSize = val
      this.getLabList(this.search,this.currentPage,val)
    },
    handleCurrentChange(val){
      this.currentPage = val
      this.getLabList(this.search,val,this.pageSize)
    },
    closedDialog(){
      this.addForm = {}
    },
    updateLab(index,row){
      this.updateDialogVisible = true
      this.currentIndex = index
      this.updateForm = JSON.parse(JSON.stringify(row))
    },
    enterUpdateLab(){
      this.$axios
        .post("/api/admin/lab/updateLab",{
          updateForm:this.updateForm
        })
        .then(()=>{
          this.labTableData.splice(this.currentIndex,1)
          this.labTableData.unshift(this.updateForm)
          this.updateDialogVisible = false
          this.$message({
            message: '修改成功',
            type: 'success'
          })
        })
        .catch(error=>{
          this.$message(error)
        })
    },
    addLab(){
      this.addDialogVisible = true
    },
    enterAddLab(){
      this.$axios
        .post("/api/admin/lab/addLab",{
          addForm:this.addForm
        })
        .then(()=>{
          this.labTableData.unshift(this.addForm)
          this.addDialogVisible = false
          this.$message({
            message: '添加成功',
            type: 'success'
          })
        })
        .catch(error=>{
          this.$message(error)
        })
    },
    deleteLab(index,row){
      this.$axios
        .post("/api/admin/lab/deleteLab",{
          id:row.id
        })
        .then(()=>{
          this.labTableData.splice(index,1)
          this.$message('已删除')
        })
        .catch(error=>{
          this.$message(error)
        })
    },
    detailLab(row){
      this.drawerVisible = true
      this.$axios
        .get("/api/admin/lab/getDetail?id="+row.id)
        .then(res=>{
          var detail = res.data.data
          detail.checkinStart = res.data.data.checkinStart.substring(0,5)
          detail.checkinEnd = res.data.data.checkinEnd.substring(0,5)
          detail.checkoutStart = res.data.data.checkoutStart.substring(0,5)
          detail.checkoutEnd = res.data.data.checkoutEnd.substring(0,5)
          this.detailInfo = detail
        })
        .catch(error=>{
          this.$message(error)
        })
    },
    getLabList(content,currentPage,pageSize){
      this.$axios
        .get("/api/admin/lab/getLabList?content="+content+
        "&currentPage="+currentPage+"&pageSize="+pageSize)
        .then(res=>{
          this.labTableData = res.data.data.list
          this.total = res.data.data.total
        })
        .catch(error=>{
          this.$message(error)
        })
    }
  },
  created(){
    this.getLabList("",this.currentPage,this.pageSize)
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
img{
  width: 350px;
  height: auto;
}
.detail-title{
  font-size: larger;
  border-bottom: 1px solid rgba(0, 0, 0, .12);
  margin: 10px 120px 10px;
}
.detail-content{
  text-align: start;
}
el-dialog{
  height: 500px;
}
</style>