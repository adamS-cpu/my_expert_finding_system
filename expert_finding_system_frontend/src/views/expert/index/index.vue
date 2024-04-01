<script setup lang="ts">
  import TopHeader from "@/views/expert/comm/header/TopHeader.vue";
  import Footer from "@/views/expert/comm/bottom/Footer.vue";
  import Search from "@/views/expert/comm/search/Search.vue";
  import RelationSchema from "@/views/expert/collaborateAnalyzing/analyzingHeader/RelationSchema.vue";
  import frontpage from "@/views/expert/index/frontpage.vue";
  import graph from '@/assets/les-miserables.json';
</script>

<template>
  <!--顶部 start-->
  <div><TopHeader/></div>
  <!--顶部 end-->

  <!--中间内容 开始-->
  <frontpage/>
  <!--中间内容 结束-->


  <!--底部 start-->
    <Footer/>
  <!--底部 end-->
</template>

<script lang="ts">
</script>

<style scoped>
</style>