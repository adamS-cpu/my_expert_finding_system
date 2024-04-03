<template>
  <TopHeader/>
  
  <div class="common-layout">
    <!-- <el-container> -->
      <el-container>
        <el-aside width="700px">
          <Contact/>
        </el-aside>
        <el-main>
          <RecommendedContact/>
        </el-main>
      </el-container>
    <!-- </el-container> -->
  </div>
  
  
</template>

<script lang="ts" setup>
  import TopHeader from "@/views/expert/comm/header/TopHeader.vue";
  import Contact from "@/views/expert/MyMessage/Contact.vue";
  import RecommendedContact from "@/views/expert/MyMessage/RecommendedContact.vue";
</script>

<style scoped>
.common-layout {
  display: flex;
  justify-content: center; /* 水平居中 */
  padding: 20px; /* 添加一些内边距 */
}

.el-container {
  max-width: 1200px; /* 限制最大宽度，根据实际需要调整 */
  width: 100%; /* 使用可用宽度 */
  display: flex;
  border: 1px solid #ebebeb; /* 添加边框看起来更清晰 */
  border-radius: 8px; /* 轻微的圆角效果 */
  overflow: hidden; /* 处理子元素的圆角 */
}

.el-aside {
  min-width: 300px; /* 侧边栏最小宽度 */
  max-width: 700px; /* 侧边栏最大宽度 */
  flex: 1; /* 侧边栏占用可用空间 */
  background-color: #f9f9f9; /* 侧边栏背景色 */
  padding: 20px; /* 侧边栏内边距 */
}

.el-main {
  flex: 2; /* 主内容区域占用更多空间 */
  padding: 20px; /* 主内容区域内边距 */
  background-color: #fff; /* 主内容区背景色 */
}
</style>