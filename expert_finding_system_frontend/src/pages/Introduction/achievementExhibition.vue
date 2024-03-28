<template>
  <div>
    <h2>论文：</h2>
    <ul>
      <li v-for="(paper, index) in papers" :key="index">
        {{ paper.authors }}. {{ paper.title }}. {{ paper.journal }}, {{ paper.year }}
      </li>
    </ul>

    <h2>著作：</h2>
    <ul>
      <li v-for="(book, index) in books" :key="index">
        {{ book.authors }}. {{ book.title }}. {{ book.publisher }}, {{ book.year }}
      </li>
    </ul>

    <h2>项目：</h2>
    <ul>
      <li v-for="(project, index) in projects" :key="index">
        {{ project.title }} - {{ project.duration }}. 主持人: {{ project.leader }}
      </li>
    </ul>
  </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue';
const papers = reactive([
      { authors: 'Ling Huang, Ye Zhu, Yuefang Gao*, Tuo Liu, Chao Chang, Caixing Liu, Yong Tang*, Chang-Dong Wang', title: 'Hybrid-Order Anomaly Detection on Attributed Networks', journal: 'IEEE Transactions on Knowledge and Data Engineering', year: 'Dec. 2023' },
      { authors: 'Binjie09', title: 'AI Development with Vue', journal: 'Vue Publications', year: '2022' },
      // 其他论文数据...
    ]);

    const books = reactive([
      { authors: 'Yong Tang, Qiaohong Zu, José G. Rodríguez García', title: 'Human Centered Computing (HCC 2018)', publisher: 'Springer', year: '2019.03' },
      { authors: 'Binjie09', title: 'Mastering Vue 3', publisher: 'Vue Press', year: '2021' },
      // 其他著作数据...
    ]);

    const projects = reactive([
      { title: '基于教育大数据的精准教学评估与学习行为预测方法研究', duration: '2019.01-2022.12', leader: '汤庸' },
      { title: '智能交通系统优化设计', duration: '2020.05-2023.08', leader: '张三' },
      // 其他项目数据...
    ]);

</script>

<style scoped>

</style>