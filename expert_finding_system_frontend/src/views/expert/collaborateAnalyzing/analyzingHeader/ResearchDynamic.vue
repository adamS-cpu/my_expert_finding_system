<template>
  <div>
    <el-tabs v-model="activeTab">
      <el-tab-pane v-for="tab in tabs" :label="tab.label" :name="tab.name" :key="tab.name">
        <div>
          <el-card class="academic-news-card" v-for="news in tab.news" :key="news.id">
            <div class="academic-news-header">
              <div class="avatar">
                {{ news.name[0] }}
              </div>
              <div class="info">
                <div class="name">{{ news.name }}</div>
                <div class="timestamp">{{ news.timestamp }}</div>
              </div>
            </div>
            <div class="academic-news-content">
              <div class="title">标题：{{ news.title }}</div>
              <div class="authors">作者: {{ news.authors }}</div>
              <div class="abstract">摘要: {{ news.abstract }}</div>
            </div>
          </el-card>
        </div>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script  lang="ts" setup>
import {  ref } from 'vue';
const activeTab = ref('all');
const tabs=ref([
  {
    label: '全部',
    name: 'all',
    news: [
      {
        id: 1,
        avatar: 'https://example.com/avatar2.jpg',
        name: '高尉',
        timestamp: '15 day ago',
        title: 'Bi-CryptoNets: Leveraging Different-Level Privacy For Encrypted Inference(Preprint)',
        authors: 'Yuan, M.-J., Zou, Z., Gao, W.',
        abstract: 'Privacy-preserving neural networks have attracted increasing attention in recent years, and various algorithms have been developed to keep the balance between accuracy, computational complexity and information security from the cryptographic view. This work takes a different view from the input data and structure of neural networks. We decompose the input data (e.g., some images) into sensitive and insensitive segments according to importance and privacy. The sensitive segment includes some important and private information such as human faces and we take strong homomorphic encryption to keep security, whereas the insensitive one contains some background and we add perturbations. We propose the bi-CryptoNets, i.e., plaintext and ciphertext branches, to deal with two segments, respectively, and ciphertext branch could utilize the information from plaintext branch by unidirectional connections. We adopt knowledge distillation for our bi-CryptoNets by transferring representations from a well-trained teacher neural network. Empirical studies show the effectiveness and decrease of inference latency for our bi-CryptoNets. © 2024, CC BY'},
      // 添加更多学术动态
    ]
  },
  {
    label: '数据挖掘',
    name: 'dataMining',
    news: [
      {
        id: 1,
        avatar: 'https://example.com/avatar2.jpg',
        name: '高尉',
        timestamp: '1 day ago',
        title: 'On the consistency of multi-label learning',
        authors: '高尉',
        abstract: 'Multi-label learning has attracted much attention during the past few years. Many multi-label approaches have been developed, mostly working with surrogate loss functions because multi-label loss functions are usually difficult to optimize directly owing to their non-convexity and discontinuity. These approaches are effective empirically, however, little effort has been devoted to the understanding of their consistency, i.e., the convergence of the risk of learned functions to the Bayes risk. In this paper, we present a theoretical analysis on this important issue. We first prove a necessary and sufficient condition for the consistency of multi-label learning based on surrogate loss functions. Then, we study the consistency of two well-known multi-label loss functions, i.e., ranking loss and hamming loss. For ranking loss, our results disclose that, surprisingly, none of convex surrogate loss is consistent; we present the partial ranking loss, with which some surrogate losses are proven to be consistent. We also discuss on the consistency of univariate surrogate losses. For hamming loss, we show that two multi-label learning methods, i.e., one-vs-all and pairwise comparison, which can be regarded as direct extensions from multi-class learning, are inconsistent in general cases yet consistent under the dominating setting, and similar results also hold for some recent multi-label approaches that are variations of one-vs-all. In addition, we discuss on the consistency of learning approaches that address multi-label learning by decomposing into a set of binary classification problems.'
      },
      // 添加更多学术动态
    ]
  },
])
</script>

<style scoped>
.academic-news-card {
  margin-bottom: 20px;
}

.academic-news-header {
  display: flex;
  align-items: center;
  padding: 10px;
}

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

.info {
  flex-grow: 1;
}

.name {
  font-weight: bold;
  font-size: 14px;
}

.timestamp {
  font-size: 12px;
  color: #999;
}

.academic-news-content {
  padding: 10px;
}

.title {
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 10px;
}

.authors {
  font-size: 14px;
  margin-bottom: 10px;
}

.abstract {
  font-size: 14px;
  line-height: 1.5;
}
</style>