<script setup lang="ts">
import TopHeader from "@/views/expert/comm/header/TopHeader.vue"
import Footer from "@/views/expert/comm/bottom/Footer.vue"
import { ref, reactive } from "vue";
import DynamicList from "@/views/expert/expertFinding/Dynamic/show/DynamicList.vue";
import DynamicCard from "@/views/expert/expertFinding/Dynamic/show/DynamicCard.vue";
import AnalyzingHeader from "@/views/expert/collaborateAnalyzing/analyzingHeader/AnalyzingHeader.vue";
import AnalyzingContent from "@/views/expert/collaborateAnalyzing/analyzingHeader/AnalyzingContent.vue";
import Recommendation from "@/views/expert/collaborateAnalyzing/analyzingRecommendation/Recommendation.vue";
import MyIntroduction from "@/views/expert/Information/InformationHead/MyIntroduction.vue";
import { RouterLink,RouterView } from "vue-router";

const user = ref({
  avatar: "@/assets/expert/image/example-user-icon.png",
  name: "张三",
  bio: "数据挖掘领域的学者",
});

defineExpose({user});

</script>

<template>
  <!--顶部-->
  <TopHeader/>
  <!--顶部结束-->

  <!--中间部分-->
  <!--  头部个人信息展示部分-->
  <div class="box"> <MyIntroduction/> </div>

  <!--    个人信息内容-->
  <div class="columns">

    <div class="column is-three-quarters">
      <!-- 导航区 -->
    <div class="navigate">
      <RouterLink :to="{path:'/expert/myInfo/achievementExhibition'}" active-class="active">成果展示</RouterLink>
      <RouterLink :to="{path:'/expert/myInfo/personalInfo'}" active-class="active">个人信息</RouterLink>
      <RouterLink :to="{path:'/expert/myInfo/socialRelation'}" active-class="active">社交关系</RouterLink>
      <RouterLink :to="{path:'/expert/myInfo/academicNetwork'}" active-class="active">学术网络</RouterLink>
    </div>
    <!-- 展示区 -->
    <div class="main-content">
      <RouterView></RouterView>
    </div>

    </div>
    <div class="column">

    </div>
  </div>


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

</style>