<template>
<v-chart :options="option" />
  <!-- <div class="out-wrapper">
    <div class="entire-data-wrapper">
      <div class="tag-wrapper">
        <div v-for="item in tagList" :key="item.id"></div>
      </div>
      <div class="chart-wrapper">
        <div>
          <v-chart :options="option" />
        </div>
        <div></div>
      </div>
    </div>

    <div class="lab-wrapper">
      <div v-for="item in labList" :key="item.id"></div>
    </div>
  </div> -->
</template>

<script>
export default {
  name:'Statistic',
  data(){
    return{
      option:{
        xAxis: {
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [{
          data: [120, 200, 150, 80, 70, 110, 130],
          type: 'bar'
        }]
      },
      tagList:[{
        id:1
      },{
        id:2
      },{
        id:3
      },{
        id:4
      }],
      labList:[{
        id:1
      },{
        id:2
      }]
    }
  },
  mounted(){
  },
  methods:{
  }
}
</script>

<style scoped>
.out-wrapper {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: row;
}
.entire-data-wrapper {
  width: 100%;
  height: 100%;
}
.lab-wrapper {
  box-sizing: border-box;
  padding: 2px 10px 0 10px;
  height: 100%;
  width: 450px;
  overflow: auto;
}
.lab-wrapper > div {
  height: 150px;
  width: 100%;
  margin-bottom: 10px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.tag-wrapper {
  box-sizing: border-box;
  padding: 0 10px 10px 0;
  height: 35%;
  width: 100%;
}
.tag-wrapper > div {
  display: inline-block;
  width: 300px;
  height: 42%;
  margin: 0 20px 20px 0;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.chart-wrapper {
  box-sizing: border-box;
  padding: 10px 10px 0 0;
  height: 65%;
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.chart-wrapper > div {
  height: 100%;
  width: 48%;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
</style>