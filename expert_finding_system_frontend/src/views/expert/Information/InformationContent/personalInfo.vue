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
    name: '张三',
    university: '苏州大学',
    title: '创始人、学者网\n二级教授，国务院政府特殊津贴专家\n教育部新世纪优秀人才，广东特支计划教学名师',
    research: '数据智能与社交网络',
    education: '武汉大学学士和硕士，中国科学技术大学博士',
    awards: '丁颖科技奖、宝钢教育奖等多个奖项',
    tags: ['计算机科学', '人工智能', '数据分析']
});

</script>

<style scoped>

</style>