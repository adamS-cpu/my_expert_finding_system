<script setup lang="ts">
  import TopHeader from "@/views/expert/comm/header/TopHeader.vue";
  import Footer from "@/views/expert/comm/bottom/Footer.vue";
  import Search from "@/views/expert/comm/search/Search.vue";

</script>

<template>
  <!--顶部 start-->
    <TopHeader/>
  <!--顶部 end-->

  <!--中间内容 开始-->
  <div class="expert-nav">
    <!--搜索组件 start-->
    <Search/>
    <!--搜索组件 end-->
    <div class="expert-index">
      <!--示例广告幻灯片-->
      <el-carousel height="600px">
        <el-carousel-item>
          <img src="@/assets/expert/image/banner1.jpg" alt="专家发现1"/>
        </el-carousel-item>
        <el-carousel-item>
          <img src="@/assets/expert/image/banner1.jpg" alt="专家发现2"/>
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>
  <!--中间内容 结束-->


  <!--底部 start-->
    <Footer/>
  <!--底部 end-->
</template>

<style scoped>


.expert-nav {
  background-color: #FFF;
}

.expert-nav .expert-index {
  padding-top: 50px;
  padding-left: 280px;
  padding-right: 240px;
  padding-bottom: 50px;
}


</style>