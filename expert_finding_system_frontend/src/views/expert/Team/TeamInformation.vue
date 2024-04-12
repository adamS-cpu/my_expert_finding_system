<script setup lang="ts">
import TopHeader from "@/views/expert/comm/header/TopHeader.vue"
import Footer from "@/views/expert/comm/bottom/Footer.vue"
import { ref } from "vue";
import TeamIntroduction from "@/views/expert/Team/TeamHead/TeamIntroduction.vue";
import teamRelation from "@/views/expert/Team/TeamContent/TeamRelation.vue";
import teamInfo from "@/views/expert/Team/TeamContent/TeamInfo.vue";
import achievementExhibition from "@/views/expert/Information/InformationContent/achievementExhibition.vue";
import TeamRelation from "@/views/expert/Team/TeamContent/TeamRelation.vue";


const user = ref({
  avatar: "@/assets/expert/image/example-user-icon.png",
  name: "周志华",
  bio: "数据挖掘领域的学者",
});

defineExpose({user});

</script>

<template>
  <!--顶部-->
  <TopHeader/>
  <!--顶部结束-->

  <!--中间部分-->
  <!--  头部团队信息展示部分-->
  <div class="box"> <TeamIntroduction/> </div>

  <!--    个人信息内容-->
  <section>
    <el-card>
      <template #header>
        <el-icon><User /></el-icon> 团队介绍
      </template>
      <teamInfo/>
    </el-card>

    <el-card>
      <template #header>
        <el-icon><Medal /></el-icon> 团队成员
      </template>
      <teamRelation/>
    </el-card>

    <el-card>
      <template #header>
        <el-icon><DataAnalysis /></el-icon> 团队成果
      </template>
      <achievementExhibition/>
    </el-card>
  </section>



  <!--中间部分结束-->

  <!--  底部-->
  <Footer/>
  <!--  底部结束-->

</template>

<style scoped>
.navigate {
  display: flex;
  justify-content: space-around;
  margin: 0 10px;
}
.navigate a {
  color: #ffffff; /* 文本颜色 */
  background-color: #007bff; /* 背景颜色 */
  border: 1px solid #007bff; /* 边框样式 */
  border-radius: 4px; /* 圆角 */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2); /* 阴影效果 */
  text-decoration: none; /* 去除下划线 */
  padding: 8px 16px; /* 内边距 */
}
.navigate a.active {
  color: yellow;
  font-weight: 900;
  text-shadow: 0 0 1px black;
  font-family: 微软雅黑;
}
.main-content {
  margin: 0 auto;
  margin-top: 30px;
  width: 100%;
  flex: 1;
  display: flex;
  flex-direction: column;
  align-items: stretch;
  height: 100%;
}
.paper-list {
  font-family: 'Arial', sans-serif; /* 论文列表字体 */
}

.book-list {
  font-family: 'Georgia', serif; /* 著作列表字体 */
}

.project-list {
  font-family: 'Verdana', sans-serif; /* 项目列表字体 */
}

.paper-info,
.book-info,
.project-info {
  font-size: 16px; /* 设置内容字体大小 */
  margin-bottom: 8px; /* 设置内容间距 */
}

</style>