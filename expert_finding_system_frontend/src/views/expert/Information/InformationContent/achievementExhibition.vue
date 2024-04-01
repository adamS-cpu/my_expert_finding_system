<template>
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
</template>

<script setup>
import { reactive, ref } from 'vue';

const activeType = ref('论文');

const types = ['论文', '著作', '项目'];

const papers = reactive([
  { authors: 'Ling Huang, Ye Zhu, Yuefang Gao*, Tuo Liu, Chao Chang, Caixing Liu, Yong Tang*, Chang-Dong Wang', 
  title: 'Hybrid-Order Anomaly Detection on Attributed Networks', 
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
</script>


<style scoped>
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