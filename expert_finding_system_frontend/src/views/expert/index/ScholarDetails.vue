<template>
  <TopHeader/>
  
   <!--中间部分-->
  <!--  头部个人信息展示部分-->
  <!-- <div class="box"> -->
  <div class="analyzing-header">
    <div class="objectUser">
      <div class="userAvatar">
        高
      </div>
      <div class="userInfo">
        <div class="userName">
          <h3>高尉</h3>
        </div>
        <div class="user-organization">
          <i class="el-icon-school"></i> 南京大学
        </div>
        <div class="userAbstract">
          复杂性科学与人工智能理论 &emsp; 机器学习
        </div>
      </div>
    </div>
    <div class="function-button">
      <div class="button-item">
        <el-button type="primary" plain>添加好友</el-button>
      </div>
      <div class="button-item">
        <el-button type="info" plain>合作分析</el-button>
      </div>
    </div>
  </div>


<div class="main-container">
<!--    个人信息内容-->
<el-card class="custom-card info-card">
  <template #header>
    <el-icon><User /></el-icon> 个人信息
  </template>
  <!-- <el-card class="teacher-card"> -->
<div class="teacher-info">
  <div class="info-item">
    <div class="info-label">姓名</div>
    <hr>
    <div class="info-content">{{ teacher.name }}</div>
    <!-- <hr> -->
  </div>

  <div class="info-item">
    <div class="info-label">所属学校</div>
    <hr>
    <div class="info-content">{{ teacher.university }}</div>
    <!-- <hr> -->
  </div>

  <div class="info-item">
    <div class="info-label">职称</div>
    <hr>
    <div class="info-content">{{ teacher.title }}</div>
  </div>

  <div class="info-item">
    <div class="info-label">研究方向</div>
    <hr>
    <div class="info-content">{{ teacher.research }}</div>
    <!-- <hr> -->
  </div>
  <div class="info-item">
    <div class="info-label">学历</div>
    <hr>
    <div class="info-content">{{ teacher.education }}</div>
    <!-- <hr> -->
  </div>
  <div class="info-item">
    <div class="info-label">荣誉奖项</div>
    <hr>
    <div class="info-content">{{ teacher.awards }}</div>
    <!-- <hr> -->
  </div>
  <div class="tags">
    <el-tag type="success">{{ teacher.tags[0] }}</el-tag>
    <el-tag type="info">{{ teacher.tags[1] }}</el-tag>
    <el-tag type="warning">{{ teacher.tags[2] }}</el-tag>
  </div>
</div>
</el-card>
<div class="right-container">
<el-card class="custom-card social-academic-card">
  <template #header>
    <el-icon><location/></el-icon> 社交关系
  </template>
  <socialRelation/>
</el-card>
<el-card class="custom-card social-academic-card">
  <template #header>
    <el-icon><DataAnalysis/></el-icon> 学术网络
  </template>
  <academicNetwork/>
</el-card>
</div>
</div>

  <el-card class="custom-card">
    <template #header>
      <el-icon><Medal /></el-icon> 成果展示
    </template>
    <div>
      <el-collapse v-model="activeType" accordion>
        <el-collapse-item v-for="(type, index) in types" :title="type" :name="type" :key="index">
          <ul v-if="type === '论文'" class="paper-list">
            <li v-for="(paper, index) in papers" :key="index">
              <span class="paper-info">{{ paper.authors }}. {{ paper.title }}. {{ paper.journal }}, {{ paper.year }}</span>
            </li>
          </ul>

          <ul v-if="type === '著作'" class="book-list">
            <li v-for="(book, index) in books" :key="index">
              <span class="book-info">{{ book.authors }}. {{ book.title }}. {{ book.publisher }}, {{ book.year }}</span>
            </li>
          </ul>

          <ul v-if="type === '项目'" class="project-list">
            <li v-for="(project, index) in projects" :key="index">
              <span class="project-info">{{ project.title }} - {{ project.duration }}. 主持人: {{ project.leader }}</span>
            </li>
          </ul>
        </el-collapse-item>
      </el-collapse>
    </div>
    <Charts/>
  </el-card>
  
<!--中间部分结束-->

  <Footer/>
</template>
  
<script setup>
import { ref,onMounted } from 'vue';
import { useRoute } from 'vue-router';
import { useScholarsStore } from '@/store/scholarsStore';
import TopHeader from "@/views/expert/comm/header/TopHeader.vue";
import Footer from "@/views/expert/comm/bottom/Footer.vue";
import DynamicList from "@/views/expert/expertFinding/Dynamic/show/DynamicList.vue";
import DynamicCard from "@/views/expert/expertFinding/Dynamic/show/DynamicCard.vue";
import AnalyzingHeader from "@/views/expert/collaborateAnalyzing/analyzingHeader/AnalyzingHeader.vue";
import AnalyzingContent from "@/views/expert/collaborateAnalyzing/analyzingHeader/AnalyzingContent.vue";
import Recommendation from "@/views/expert/collaborateAnalyzing/analyzingRecommendation/Recommendation.vue";
import MyIntroduction from "@/views/expert/Information/InformationHead/MyIntroduction.vue";
import socialRelation from "@/views/expert/Information/InformationContent/socialRelation.vue";
import personalInfo from "@/views/expert/Information/InformationContent/personalInfo.vue";
import achievementExhibition from "@/views/expert/Information/InformationContent/achievementExhibition.vue";
import academicNetwork from "@/views/expert/Information/InformationContent/academicNetwork.vue";

import { reactive } from "vue";
const scholarsStore = useScholarsStore();
const route = useRoute();
const scholar = ref({});
const user = ref({
  avatar: "@/assets/expert/image/example-user-icon.png",
  name: "张三",
  bio: "数据挖掘领域的学者",
});
const teacher = reactive({
    name: '高尉',
    university: '南京大学',
    title: '教授',
    research: '复杂性科学与人工智能理论, 机器学习',
    education: '南开大学学士，南京大学博士',
    awards: '中国电子学会优秀博士学位论文奖,哈尔滨工业大学优秀博士学位论文奖',
    tags: ["复杂性科学与人工智能理论","机器学习"]
});
const activeType = ref('论文');

const types = ['论文', '著作', '项目'];

const papers = reactive([
  { authors: '高尉', 
  title: 'On the consistency of multi-label learning', 
  journal: 'IEEE Transactions on Knowledge and Data Engineering', 
  year: 'Dec. 2023' },
  { authors: 'Binjie09', title: 'AI Development with Vue', journal: 'Vue Publications', year: '2022' },
]);

const books = reactive([
  { authors: 'Yong Tang, Qiaohong Zu, José G. Rodríguez García', title: 'Human Centered Computing (HCC 2018)', publisher: 'Springer', year: '2019.03' },
  { authors: 'Binjie09', title: 'Mastering Vue 3', publisher: 'Vue Press', year: '2021' },
]);

const projects = reactive([
  { title: '基于教育大数据的精准教学评估与学习行为预测方法研究', duration: '2019.01-2022.12', leader: '汤庸' },
  { title: '智能交通系统优化设计', duration: '2020.05-2023.08', leader: '张三' },
]);

defineExpose({user});

onMounted(() => {
    // 通过路由参数获取学者ID或其他标识符
    const scholarId = Number(route.params.id); // 确保ID是数字类型，如果你的ID是字符串，这一步不需要
    // 查找对应的学者信息
    scholar.value = scholarsStore.scholars.find(s => s.id === scholarId) || {};
});
</script>

<style scoped>
.analyzing-header {
  background-color: #ffffff; 
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 20px; /* 调整内边距以适应内容 */
  margin-left: auto; /* 与左边缘有间距 */
  margin-right: auto; /* 与右边缘有间距 */
  max-width: calc(100% - 40px); /* 假设您希望整体宽度稍小于视口宽度 */
  box-sizing: border-box; /* 确保边框和内边距不会增加元素的总宽度 */
}

.userAvatar {
  background-color: #007bff; /* 蓝色背景 */
  color: white; /* 白色文字 */
  width: 100px; /* 增大头像尺寸 */
  height: 100px; /* 增大头像尺寸 */
  border-radius: 50%; /* 圆形 */
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  font-size: 40px; /* 根据头像尺寸调整字体大小 */
  margin-right: 20px; /* 与用户信息之间的间距 */
}

.main-container {
  /* background-color: #0349b1; */
  display: flex;
  justify-content: space-between; /* 确保左右列有间隔 */
  margin: 0px 0px; /* 根据实际需要调整外边距 */
  
}

.info-card {
  flex: 1.8; /* 个人信息卡片占据更多空间 */
  margin-right: 20px; /* 与右侧容器之间留出间隔 */
}

.right-container {
  display: flex;
  flex-direction: column; /* 让社交关系和学术网络卡片垂直堆叠 */
  flex: 1.2;
  gap: 0px; /* 卡片之间的间隔 */
  max-width: 500px;
}

.social-academic-card {
  flex: 1; /* 使社交关系和学术网络卡片占据相等的空间 */
}




.objectUser {
  display: flex;
  margin-left: 15px;
}



.objectUser .userInfo .userName{
  margin-top: 5px;
  margin-bottom: 15px;
  font-size: 21px;
}

.objectUser .userInfo .user-organization{
  margin-top: 5px;
  margin-bottom: 6px;
  font-size: 16px;
}

.objectUser .userInfo .userAbstract{
  font-size: 16px;
}



.analyzing-header .function-button {
  display: flex;
  align-items: center;
  position: relative;
  flex-direction: column; /* 设置主轴方向为垂直 */
  margin-right: 50px;
}

.analyzing-header .function-button .button-item {
  align-items: center;
  margin-top: 5px;
  margin-bottom: 15px;
}

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
  .custom-card {
    padding: 0 20px; /* 内部留白 */
    margin: 0px 00px; /* 外部留白 */
    background-color: #ffffff;
  }

.teacher-info .info-block {
  margin-bottom: 20px; /* 为每个信息块留出一些空间 */
}

.teacher-info .info-label {
  font-weight: bold;
  margin-bottom: 4px; /* 标签与下划线之间留出空间 */
  font-size: 23px; /* 调整为所需的字体大小 */
}

.teacher-info hr {
  border: none;
  height: 1px;
  background-color: #e0e0e0;
  margin-bottom: 8px; /* 下划线与内容之间留出空间 */
}

.teacher-info .info-content {
  /* 如果需要，这里可以添加样式 */
}

.teacher-info .tags {
  display: flex;
  gap: 10px;
  margin-top: 20px; /* 标签部分与前一个信息块之间留出一些空间 */
}
.info-item {
  margin-bottom: 40px; /* 或其他更大的值，根据需要调整 */
}
</style>
