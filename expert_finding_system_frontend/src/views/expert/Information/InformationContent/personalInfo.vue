<template>
  <el-card class="teacher-card">
    <el-descriptions :bordered="true" column="1" border>
      <el-descriptions-item label="姓名">{{ teacher.name }}</el-descriptions-item>
      <el-descriptions-item label="所属学校">{{ teacher.university }}</el-descriptions-item>
      <el-descriptions-item label="职称">{{ teacher.title }}</el-descriptions-item>
      <el-descriptions-item label="研究方向">{{ teacher.research }}</el-descriptions-item>
      <el-descriptions-item label="学历">{{ teacher.education }}</el-descriptions-item>
      <el-descriptions-item label="荣誉奖项">{{ teacher.awards }}</el-descriptions-item>
    </el-descriptions>
    <div class="tags">
      <el-tag type="success">{{ teacher.tags[0] }}</el-tag>
      <el-tag type="info">{{ teacher.tags[1] }}</el-tag>
      <el-tag type="warning">{{ teacher.tags[2] }}</el-tag>
    </div>
  </el-card>
</template>
<script lang="ts" setup>
import { reactive } from "vue";
const teacher = reactive({
    name: '周志华',
    university: '南京大学',
    title: '教授',
    research: '数据智能与社交网络',
    education: '南京大学学士，硕士和博士',
    awards: '获得国家自然科学二等奖两项 （2013，2020）、教育部自然科学一等奖 三项（2005，2011，2019)',
    tags: ["数据挖掘","人工智能","机器学习"]
});

</script>

<style scoped>

</style>