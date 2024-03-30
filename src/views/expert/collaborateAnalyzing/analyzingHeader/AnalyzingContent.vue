<script setup lang="ts" xmlns="http://www.w3.org/1999/html">
import {
  Location,
} from '@element-plus/icons-vue'
import Explainable from "@/views/expert/collaborateAnalyzing/analyzingHeader/Explainable.vue";
import ResearchDynamic from "@/views/expert/collaborateAnalyzing/analyzingHeader/ResearchDynamic.vue";
import ResearchInterested from "@/views/expert/collaborateAnalyzing/analyzingHeader/ResearchInterested.vue";
import Charts from "@/views/expert/collaborateAnalyzing/analyzingHeader/Charts.vue";
import RelationSchema from "@/views/expert/collaborateAnalyzing/analyzingHeader/RelationSchema.vue";
// import { RelationshipType } from 'exceljs';

</script>

<template>
  <section>
    <el-card>
      <template #header>
        <el-icon><location/></el-icon> 研究内容分析
      </template>
      <ResearchInterested/>
      <Charts/>
    </el-card>

    <el-card>
      <template #header>
        <el-icon><location/></el-icon> 可解释性分析
      </template>
      <Explainable/>
    </el-card>


    <!-- 网络分析 -->
    <el-card>
      <template #header>
        <el-icon><location/></el-icon> 网络关系
      </template>
      <RelationSchema/>
    </el-card>

    <el-card>
      <template #header>
        <el-icon><location/></el-icon> 他最近的动态
      </template>
      <ResearchDynamic/>
    </el-card>
  </section>

</template>


<style scoped>

</style>