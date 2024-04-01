<script setup lang="ts">


import PreciseRecommendation  from "@/views/expert/collaborateAnalyzing/analyzingRecommendation/Precise.vue";
import RecentFollow from "@/views/expert/collaborateAnalyzing/analyzingRecommendation/RecentFollow.vue";
import Similar from "@/views/expert/collaborateAnalyzing/analyzingRecommendation/Similar.vue";
</script>

<template>
  <!--顶部-->
  <section>
    <!--最近关注-->
    <RecentFollow/>

<!--    &lt;!&ndash;精准推荐&ndash;&gt;-->
<!--    <PreciseRecommendation/>-->
    <!--相似推荐-->
    <Similar/>
  </section>
</template>

<style scoped>

</style>