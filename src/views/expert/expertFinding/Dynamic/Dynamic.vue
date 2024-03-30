<script setup lang="ts">
import TopHeader from "@/views/expert/comm/header/TopHeader.vue"
import Footer from "@/views/expert/comm/bottom/Footer.vue"
import DynamicCard from "@/views/expert/expertFinding/Dynamic/show/DynamicCard.vue"
import DynamicList from "@/views/expert/expertFinding/Dynamic/show/DynamicList.vue";
import {getBillboardApi} from "@/api/expert/dynamic/dynamic";
import {onMounted, ref} from "vue";

const billboard = ref({})

const getBillboard = async() =>{
  const {data} = await getBillboardApi()
  billboard.value = data.result.content
}

onMounted(()=>{
  getBillboard()
})

</script>

<template>
  <!--顶部-->
  <TopHeader/>
  <!--顶部结束-->

  <!--中间部分-->
  <div>
    <!--公告板-->
    <div class="box">🔔 {{billboard}}</div>

    <div class="columns">
      <div class="column is-three-quarters">
        <DynamicList/>
      </div>
      <div class="column">
        <DynamicCard/>
      </div>
    </div>
  </div>
  <!--中间部分结束-->

  <!--  底部-->
  <Footer/>
  <!--  底部结束-->

</template>

<style scoped>

</style>