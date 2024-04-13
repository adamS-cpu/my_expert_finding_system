<template>
  <div class="conference-list">
    <el-collapse v-model="activeConferences">
      <el-collapse-item v-for="(conference, index) in conferenceData" :key="index" :title="conference.name">
        <ul>
          <li v-for="(paper, idx) in conference.papers" :key="idx">
            {{ paper.authors }}. {{ paper.title }}. In: Proceedings of the {{ conference.name }} ({{ conference.abbreviation }}'{{ conference.year }}), {{ conference.year }}.
          </li>
        </ul>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue';

const activeConferences = ref([]);

const conferenceData = ref([
  {
    name: "AAAI Conference on Artificial Intelligence",
    abbreviation: "AAAI",
    year: 2023,
    papers: [
      { authors: "H. Sun, Z. Xie, X.-Y. Li, and M. Li", title: "Cooperative and Adversarial Learning: Co-enhancing Discriminability and Transferability in Domain Adaptation" },
      { authors: "Y.-X. Huang, W.-Z. Dai, Y. Jiang, and Z.-H. Zhou", title: "Enabling Knowledge Refinement upon New Concepts in Abductive Learning" },
      { authors: "F.-G. Han and Z.-Z. Zhang", title: "Expert Data Augmentation in Imitation Learning (Student Abstract)" },
      { authors: "D.-X. Liu, X. Mu, and C. Qian", title: "Human Assisted Learning by Evolutionary Multi-objective Optimization" },
      { authors: "Y.-C. Li, W.-J. Shen, B.-Y. Zhang, F. Mao, Z.-Z. Zhang, and Y. Yu", title: "Learning Generalizable Batch Active Learning Strategies via Deep Q-Networks (Student Abstract)" },
      { authors: "R.-Z. Zhou, Z.-Z. Zhang, and Y. Yu", title: "Model-based Offline Weighted Policy Optimization (Student Abstract)" },
      { authors: "W.-J. Liao, Z.-Z. Zhang, and Y. Yu", title: "Policy-Independent Behavioral Metric-Based Representation for Deep Reinforcement Learning" },
      { authors: "L. Yuan, Z.-Q. Zhang, K. Xue, H. Yin, F. Chen, C. Guan, L.-H. Li, C. Qian, and Y. Yu", title: "Robust Multi-agent Coordination via Evolutionary Generation of Auxiliary Adversarial Attackers" },
      { authors: "Y.-R. Gu, C. Bian, and C. Qian", title: "Submodular Maximization Under the Intersection of Matroid and Knapsack Constraints" },
      { authors: "F. Chen, C.-H. Wang, F.-X. Zhang, H. Ding, Q.-Y. Zhong, S.-L. Pu, and Z.-Z. Zhang", title: "Towards Deployment-Efficient and Collision-Free Multi-Agent Path Finding (Student Abstract)" }
    ]
  },
  {
    name: "AAMAS International Conference on Autonomous Agents and Multiagent Systems",
    abbreviation: "AAMAS",
    year: 2023,
    papers: [
      { authors: "X.-H. Liu, F. Xu, X.-Y. Zhang, T.-Y. Liu, S.-Y. Jiang, R.-F. Chen, Z.-Z. Zhang, and Y. Yu", title: "How To Guide Your Learner: Imitation Learning with Active Adaptive Expert Involvement" },
      { authors: "S.-W. Zhang, J.-H. Cao, L. Yuan, Y. Yu, and D.-C. Zhan", title: "Self-Motivated Multi-Agent Exploration" }
    ]
  },
  {
    name: "AISTATS International Conference on Artificial Intelligence and Statistics",
    abbreviation: "AISTATS",
    year: 2023,
    papers: [
      { authors: "J.-W. Shan, P. Zhao, and Z.-H. Zhou", title: "Beyond Performative Prediction: Open-environment Learning with Presence of Corruptions" },
      { authors: "Q.-C. Zheng, S.-H. Lyu, S.-Q. Zhang, Y. Jiang, and Z.-H. Zhou", title: "On the Consistency Rate of Decision Tree Learning Algorithms" },
      { authors: "J. Wang, P. Zhao, and Z.-H. Zhou", title: "Revisiting Weighted Strategy for Non-stationary Parametric Bandits" }
    ]
  },
  {
    name: "CEC IEEE Congress on Evolutionary Computation",
    abbreviation: "CEC",
    year: 2023,
    papers: [
      { authors: "F. Neumann, A. Neumann, C. Qian, V.-A. Do, J. de Nobel, D. Vermetten, S. S. Ahouei, F.-R. Ye, H. Wang, and T. Bäck", title: "Benchmarking Algorithms for Submodular Optimization Problems Using IOHProfiler" }
    ]
  },
  {
    name: "CIKM ACM International Conference on Information and Knowledge Management",
    abbreviation: "CIKM",
    year: 2023,
    papers: [
      { authors: "Y.-X. Sun, Y.-L. Zhang, W. Wang, L.-F. Li, and J. Zhou", title: "Treatment effect estimation across domains" }
    ]
  },
  {
    name: "CVPR IEEE Computer Society Conference on Computer Vision and Pattern Recognition",
    abbreviation: "CVPR",
    year: 2023,
    papers: [
      { authors: "Y.-K. Zhang, Q.-W. Wang, D.-C. Zhan, and H.-J. Ye", title: "Learning Debiased Representations via Conditional Attribute Interpolation" },
      { authors: "Y.-H. Cao, P.-Q. Sun, and S.-C. Zhou", title: "Three Guidelines You Should Know for Universally Slimmable Self-Supervised Learning" }
    ]
  },
  {
    name: "DSAA IEEE International Conference on Data Science and Advanced Analytics",
    abbreviation: "DSAA",
    year: 2023,
    papers: [
      { authors: "C.-Y. Cai, W. Wang, and Y. Jiang", title: "Adaptive clustered federated learning with representation similarity" }
    ]
  },
  {
    name: "ECAI European Conference on Artificial Intelligence",
    abbreviation: "ECAI",
    year: 2023,
    papers: [
      { authors: "Y. Xie, Z.-H. Tan, Y. Jiang, and Z.-H. Zhou", title: "Identifying Helpful Learnwares without Examining the Whole Market" }
    ]
  },
  // Add more conferences...
]);
</script>

<style scoped>
.conference-list {
  font-size: 20px;
}

.authors, .title {
  font-weight: bold;
}

.conference {
  font-weight: bold;
}
</style>
