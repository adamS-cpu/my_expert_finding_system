<template>
  <div>
    <el-card v-for="(contact, index) in contacts" :key="index" class="contact-card">
      <!-- 联系人容器 -->
      <div class="contact-container">
        <!-- 头像 -->
        <div class="avatar-container">
          <div class="avatar">{{ contact.name[0] }}</div>
        </div>

        <!-- 信息 -->
        <div class="info-container">
          <p>{{ contact.name }}</p>
          <p>项目数: {{ contact.projects }}</p>
          <p>成果数: {{ contact.achievements }}</p>
          <!-- el-tag -->
          <el-tag v-for="tag in contact.tags" :key="tag" type="success">{{ tag }}</el-tag>
        </div>
      </div>

      <!-- 按钮 -->
        <el-button type="danger" class="button">移除</el-button>
        <el-button type="primary"  class="button">添加联系人</el-button>
    </el-card>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue';

const contacts = ref([
      // 联系人数据
      {
        name: '张三',
        projects: 5,
        achievements: 10,
        tags: ['人工智能', '深度学习']
      },
      {
        name: '李四',
        projects: 3,
        achievements: 7,
        tags: ['图像处理', '数据挖掘']
      },
      {
        name: '王五',
        projects: 2,
        achievements: 6,
        tags: ['推荐系统']
      },
      {
        name: '赵六',
        projects: 4,
        achievements: 8,
        tags: ['人工智能', '数据挖掘']
      },
      {
        name: '钱七',
        projects: 6,
        achievements: 12,
        tags: ['深度学习', '推荐系统']
      },
    ]);
</script>

<style scoped>

.contact-container {
  display: flex;
  justify-content: space-between;
  align-items: stretch;
  width: 100%; 
}

.info-container {
  flex: 1;
  margin-left: 10px;
}

.button{
  align-items: center;
  text-align: center;
  float: right;
  margin-right:5px ;
}
/* .buttons {
  display: flex;
  float: right;
} */

.avatar {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  background-color: #007bff;
  color: white;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-right: 15px;
  font-weight: bold;
}
</style>
