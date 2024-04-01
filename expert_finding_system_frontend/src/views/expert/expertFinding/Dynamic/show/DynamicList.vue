<!-- <script setup lang="ts"> -->
// import {onMounted, reactive} from "vue";
// import {getDynamicListApi} from "@/api/expert/dynamic/dynamic";
// import {Search} from '@element-plus/icons-vue'

// const activeFiled = reactive({
//   name : '全部',
// })

// const DynamicList = ref({})

// const getDynamicList = async() =>{
//   const {data} = await getDynamicListApi()
//   DynamicList.value = data.result.DynamicList
// }

// const pageSize = ref(12)
// const pageIndex = ref(1)
// const total = ref(2)

// const handleClick = async ()=> {
//   getDynamicList()
// }

// onMounted(()=>{
//   getDynamicList()
// })
<!-- </script> -->

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
              <div class="title">{{ news.title }}</div>
              <div class="authors">Authors: {{ news.authors }}</div>
              <div class="abstract">{{ news.abstract }}</div>
            </div>
          </el-card>
        </div>
      </el-tab-pane>
    </el-tabs>
  </div>


  <!-- <div>
    <el-card shadow="never">
      <template #header>
        <el-tabs v-model="activeFiled" @tab-click="handleClick">
          <el-tab-pane label="全部" name="data mining">
            <div v-for="item in DynamicList" :key="item" class="text item">
              <el-card style="height: 220px" shadow="never">
                <template #header style="height: 60px" >
                  <div class="columns">
                    <div class="column">
                      <router-link :to="{path:'expert/user', query:{id:item.id}}">
                        <img src= "@/assets/expert/image/example-user-icon-small.png" style="border: 1px solid lightgray; border-radius: 10px;" alt="user-icon" />
                      </router-link>
                    </div>
                    <div class="column">
                        <p style="font-size: 18px">{{item.user_name}}</p>
                        <p style="font-size: 12px">浙江大学</p>
                    </div>
                    <div class="column is-one-fifth"/>
                    <div class="column is-one-fifth"/>
                    <div class="column is-one-fifth"/>
                    <div class="column is-one-fifth">
                      <el-button type="primary">查看他的所有更新</el-button>
                    </div>

                  </div>
                </template>
                <div class="columns">
                  <div class="column">
                    <img src= "@/assets/expert/image/paper.png" style="border: 1px solid lightgray; border-radius: 10px;" alt="user-icon" />
                  </div>
                  <div class="column is is-three-fifths">
                    <p style="font-size: 18px">{{item.content}}</p>
                    <p style="font-size: 12px">{{item.user_name}}</p>
                    <p style="font-size: 12px"> ACM Trans. Recomm. Syst.，{{item.field_name}}，{{item.create_time}}</p>
                  </div>
                  <div class="column is-one-quarter"/>
                </div>
              </el-card>
            </div>
          </el-tab-pane>
          <el-tab-pane label="数据挖掘" name="data mining"> -->
<!--            <div v-for="item in DynamicList" :key="item" class="text item">-->
<!--              <el-card style="height: 220px" shadow="never">-->
<!--                <template #header style="height: 60px" >-->
<!--                  <div class="columns">-->
<!--                    <div class="column">-->
<!--                      <router-link :to="{path:'expert/user', query:{id:item.id}}">-->
<!--                        <img src= "@/assets/expert/image/example-user-icon-small.png" style="border: 1px solid lightgray; border-radius: 10px;" alt="user-icon" />-->
<!--                      </router-link>-->
<!--                    </div>-->
<!--                    <div class="column">-->
<!--                      <p style="font-size: 18px">{{item.user_name}}</p>-->
<!--                      <p style="font-size: 12px">浙江大学</p>-->
<!--                    </div>-->
<!--                    <div class="column is-one-fifth"/>-->
<!--                    <div class="column is-one-fifth"/>-->
<!--                    <div class="column is-one-fifth"/>-->
<!--                    <div class="column is-one-fifth">-->
<!--                      <el-button type="primary">查看他的所有更新</el-button>-->
<!--                    </div>-->

<!--                  </div>-->
<!--                </template>-->
<!--                <div class="columns">-->
<!--                  <div class="column">-->
<!--                    <img src= "@/assets/expert/image/paper.png" style="border: 1px solid lightgray; border-radius: 10px;" alt="user-icon" />-->
<!--                  </div>-->
<!--                  <div class="column is is-three-fifths">-->
<!--                    <p style="font-size: 18px">{{item.content}}</p>-->
<!--                    <p style="font-size: 12px">{{item.user_name}}</p>-->
<!--                    <p style="font-size: 12px"> ACM Trans. Recomm. Syst.，{{item.field_name}}，{{item.create_time}}</p>-->
<!--                  </div>-->
<!--                  <div class="column is-one-quarter"/>-->
<!--                </div>-->
<!--              </el-card>-->
<!--            </div>-->
          <!-- </el-tab-pane>
        </el-tabs>
      </template> -->
      <!--分页-->
      <!-- <el-pagination background layout="total,prev,pager,next,jumper" :total="total" v-model:page_size="pageSize">
      </el-pagination>
    </el-card>
  </div> -->
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
        avatar: 'https://example.com/avatar1.jpg',
        name: '周志华',
        timestamp: '2 hours ago',
        title: 'Top 10 algorithms in data mining',
        authors: '周志华',
        abstract: 'This paper presents the top 10 data mining algorithms identified by the IEEE International Conference on Data Mining (ICDM) in December 2006: C4.5, k-Means, SVM, Apriori, EM, PageRank, AdaBoost, kNN, Naive Bayes, and CART. These top 10 algorithms are among the most influential data mining algorithms in the research community. With each algorithm, we provide a description of the algorithm, discuss the impact of the algorithm, and review current and further research on the algorithm.These 10 algorithms cover classification, clustering, statistical learning, association analysis, and link mining, which are all among the most important topics in data mining research and development.'
      },
      {
        id: 2,
        avatar: 'https://example.com/avatar2.jpg',
        name: '高尉',
        timestamp: '1 day ago',
        title: 'On the consistency of multi-label learning',
        authors: '高尉',
        abstract: 'Multi-label learning has attracted much attention during the past few years. Many multi-label approaches have been developed, mostly working with surrogate loss functions because multi-label loss functions are usually difficult to optimize directly owing to their non-convexity and discontinuity. These approaches are effective empirically, however, little effort has been devoted to the understanding of their consistency, i.e., the convergence of the risk of learned functions to the Bayes risk. In this paper, we present a theoretical analysis on this important issue. We first prove a necessary and sufficient condition for the consistency of multi-label learning based on surrogate loss functions. Then, we study the consistency of two well-known multi-label loss functions, i.e., ranking loss and hamming loss. For ranking loss, our results disclose that, surprisingly, none of convex surrogate loss is consistent; we present the partial ranking loss, with which some surrogate losses are proven to be consistent. We also discuss on the consistency of univariate surrogate losses. For hamming loss, we show that two multi-label learning methods, i.e., one-vs-all and pairwise comparison, which can be regarded as direct extensions from multi-class learning, are inconsistent in general cases yet consistent under the dominating setting, and similar results also hold for some recent multi-label approaches that are variations of one-vs-all. In addition, we discuss on the consistency of learning approaches that address multi-label learning by decomposing into a set of binary classification problems.'
      },
      {
        id: 3,
        avatar: 'https://example.com/avatar3.jpg',
        name: '陈松灿',
        timestamp: '3 days ago',
        title: 'Face recognition from a single image per person: A survey',
        authors: '陈松灿',
        abstract: 'One of the main challenges faced by the current face recognition techniques lies in the difficulties of collecting samples. Fewer samples per person mean less laborious effort for collecting them, lower cost for storing and processing them. Unfortunately, many reported face recognition techniques rely heavily on the size and representative of training set, and most of them will suffer serious performance drop or even fail to work if only one training sample per person is available to the systems. This situation is called "one sample per person" problem: given a stored database of faces, the goal is to identify a person from the database later in time in any different and unpredictable poses, lighting, etc. from just one image. Such a task is very challenging for most current algorithms due to the extremely limited representative of training sample. Numerous techniques have been developed to attack this problem, and the purpose of this paper is to categorize and evaluate these algorithms. The prominent algorithms are described and critically analyzed. Relevant issues such as data collection, the influence of the small sample size, and system evaluation are discussed, and several promising directions for future research are also proposed in this paper.'
      },
      {
        id: 4,
        avatar: 'https://example.com/avatar4.jpg',
        name: 'Emily Davis',
        timestamp: '1 week ago',
        title: 'Advances in Natural Language Processing',
        authors: 'Emily Davis, Michael Brown',
        abstract: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut lectus vel ante tincidunt pellentesque.'
      },
      {
        id: 5,
        avatar: 'https://example.com/avatar5.jpg',
        name: '陈松灿',
        timestamp: '2 weeks ago',
        title: 'Sparsity preserving projections with applications to face recognition',
        authors: '陈松灿',
        abstract: 'Dimensionality reduction methods (DRs) have commonly been used as a principled way to understand the high-dimensional data such as face images. In this paper, we propose a new unsupervised DR method called sparsity preserving projections (SPP). Unlike many existing techniques such as local preserving projection (LPP) and neighborhood preserving embedding (NPE), where local neighborhood information is preserved during the DR procedure, SPP aims to preserve the sparse reconstructive relationship of the data, which is achieved by minimizing a L1 regularization-related objective function. The obtained projections are invariant to rotations, rescalings and translations of the data, and more importantly, they contain natural discriminating information even if no class labels are provided. Moreover, SPP chooses its neighborhood automatically and hence can be more conveniently used in practice compared to LPP and NPE. The feasibility and effectiveness of the proposed method is verified on three popular face databases (Yale, AR and Extended Yale B) with promising results.'
      },
      {
        id: 6,
        avatar: 'https://example.com/avatar6.jpg',
        name: '叶翰嘉',
        timestamp: '3 weeks ago',
        title: 'Zircon U-Pb chronology and Hf isotope of the Xingxingxia granodiorite from the Central Tianshan zone (NW China): Implications for the tectonic evolution of the southern Altaids',
        authors: '叶翰嘉',
        abstract: 'The Central Tianshan zone is located between the Turpan-Hami and Tarim   blocks and played a pivotal role in crustal evolution and collisional   tectonics of the southern Altaids (or the Central Asian orogenic belt).   The Xingxingxia granodiorite in the eastern Central Tianshan is an Early   Paleozoic (424.9 +/- 5.8 Ma) intrusion. Petrography, geochemistry and   Sr-Nd-Hf isotopes suggest that the Xingxingxia granodiorite was   genetically related to a volcanic arc, emplaced above a subduction zone.   Thus, the Central Tianshan zone was a magmatic arc above an early   Paleozoic subduction zone of the Paleoasian ocean. We present LA-ICP-MS   zircon U-Pb dating and Hf isotope determinations of Precambrian zircon   grains trapped in the Xingxingxia granodiorite. Three populations of   inherited zircons indicate that Neoproterozoic (809 +/- 41 Ma;   epsilon(Hf)(t)= 0.10-5.73), Mesoproterozoic (similar to 1400 Ma;   epsilon(Hf)(t) 8.71-10.05) and Paleoproterozoic (similar to 1750 Ma;   epsilon(Hf)(t) 0.11 and 4.80) tectonomagmatic events in the Central   Tianshan zone, which are comparable with those in the Tarim block.   Combined with a series of similar geological characteristics between   these two blocks, it is suggested that the Central Tianshan zone might   have been originally a part of the Tarim block, and was separated from   it during the Early Paleozoic time due to pull-apart caused by southward   subduction of the Northern Tianshan ocean, a branch of the Paleoasian   ocean.'
      },
      {
        id: 7,
        avatar: 'https://example.com/avatar7.jpg',
        name: '张道强',
        timestamp: '1 month ago',
        title: 'Top 10 algorithms in data mining',
        authors: '张道强',
        abstract: 'This paper presents the top 10 data mining algorithms identified by the IEEE International Conference on Data Mining (ICDM) in December 2006: C4.5, k-Means, SVM, Apriori, EM, PageRank, AdaBoost, kNN, Naive Bayes, and CART. These top 10 algorithms are among the most influential data mining algorithms in the research community. With each algorithm, we provide a description of the algorithm, discuss the impact of the algorithm, and review current and further research on the algorithm.These 10 algorithms cover classification, clustering, statistical learning, association analysis, and link mining, which are all among the most important topics in data mining research and development.'
      },
      {
        id: 8,
        avatar: 'https://example.com/avatar8.jpg',
        name: '张道强',
        timestamp: '2 months ago',
        title: 'Robust image segmentation using FCM with spatial constraints based on new kernel-induced distance measure',
        authors: '张道强',
        abstract: 'This paper presents the top 10 data mining algorithms identified by the IEEE International Conference on Data Mining (ICDM) in December 2006: C4.5, k-Means, SVM, Apriori, EM, PageRank, AdaBoost, kNN, Naive Bayes, and CART. These top 10 algorithms are among the most influential data mining algorithms in the research community. With each algorithm, we provide a description of the algorithm, discuss the impact of the algorithm, and review current and further research on the algorithm.These 10 algorithms cover classification, clustering, statistical learning, association analysis, and link mining, which are all among the most important topics in data mining research and development.'
      }
      // 添加更多学术动态
    ]
  },
        {
          label: '数据挖掘',
          name: 'dataMining',
          news: [
            {
              id: 1,
              avatar: 'https://example.com/avatar1.jpg',
              name: '徐桂芳',
              timestamp: '2 hours ago',
              title: 'Proton pump inhibitor pantoprazole abrogates adriamycin-resistant gastric cancer cell invasiveness via suppression of Akt/GSK-β/β-catenin signaling and epithelial–mesen',
              authors: '徐桂芳',
              abstract: 'The effect of proton pump inhibitor (PPI) on cancer risk has received much attention recently. In this study, we investigated the mechanism underlying multidrug resistance and the effect of a PPI pantoprazole using an adriamycin-resistant gastric cancer cell model (SGC7901/ADR). Compared with the parental cell line, SGC7901/ADR cells showed reduced proliferation rate, but higher resistance to adriamycin under both anchorage-dependent and -independent conditions. Notably, SGC7901/ADR cells underwent epithelial to mesenchymal transition (EMT) and showed increased migrating and invading capabilities. At molecular level, SGC7901/ADR cells showed strong activation of Wnt/β-catenin signaling pathway compared with parental sensitive cells. Interestingly, we found that a PPI pantoprazole can effectively reverse the aggressiveness and EMT marker expression of SGC7901/ADR cells. Furthermore, pantoprazole treatment resulted in a profound reduction of both total and phosphorylated forms of Akt and GSK-3β, which in turn suppressed the adriamycin-induced Wnt/β-catenin signaling in SGC7901/ADR cells. Taken together, we demonstrate that the aggressive phenotype of adriamycin-resistant SGC7901/ADR cells is mediated by induction of EMT and activation of the canonical Wnt/β-catenin signaling pathway. And for the first time, we show that it is possible to suppress the invasiveness of SGC7901/ADR cells by pantoprazole which targets the EMT and Akt/GSK-3β/β-catenin signaling.'
            },
            {
              id: 2,
              avatar: 'https://example.com/avatar2.jpg',
              name: '孙琦',
              timestamp: '1 day ago',
              title: 'Top 10 algorithms in data mining',
              authors: '孙琦',
              abstract: 'Differences in pathologic diagnosis between endoscopic forceps biopsy (EFB) and endoscopic submucosal dissection (ESD) for gastric intraepithelial neoplasia (GIN) and early gastric carcinoma (EGC) in Chinese patients remain unknown. The aim of the study was to investigate risk factors for under-diagnosed pathology in initial EFB, compared to final ESD. We reviewed endoscopic and histopathologic findings for tumor location, size, macroscopic pattern, nodularity, erythema, erosion, GIN (low and high grade), and EGC diagnosed with the WHO criteria. Differences in those features between EFB and ESD were compared and risk factors for under-diagnosis by EFB were analyzed. Although concordant in most (74.9 %) cases between EFBs and ESDs, pathological diagnoses in 57 (25.1 %) cases were upgraded in ESDs. Compared to the concordant group, the lesion size a parts per thousand yen2 cm, and depressed and excavated patterns were significantly more frequent in the upgraded group. Further multivariate regression analysis demonstrated the depressed pattern and lesion size a parts per thousand yen2 cm as independent risk factors for upgraded pathology with the odds ratio of 5.778 (95 % confidence interval 2.893-11.542) and 2.535 (95 % confidence interval 1.257-5.111), respectively. Lesion size a parts per thousand yen2.0 cm and the depressed pattern at initial EFB were independent risk factors for pathologic upgrade to advanced diseases in ESD. Therefore, these endoscopic characteristics should be considered together with the initial EFB diagnosis to guide the optimal clinical management of patients with GIN and EGC.'
            },
            // 添加更多数据挖掘相关学术动态
          ]
        },
        {
          label: '推荐系统',
          name: 'recommendation',
          news: [
            {
              id: 1,
              avatar: 'https://example.com/avatar1.jpg',
              name: '张伟杰',
              timestamp: '2 hours ago',
              title: 'Treatment of gallbladder stone with common bile duct stones in the laparoscopic',
              authors: '张伟杰',
              abstract: 'BACKGROUND: Laparoscopic common bile duct exploration (LCBDE) for stone can be      carried out by either laparoscopic transcystic stone extraction (LTSE) or      laparoscopic choledochotomy (LC). It remains unknown as to which approach is      optimal for management of gallbladder stone with common bile duct stones (CBDS)      in Chinese patients. METHODS: From May 2000 to February 2009, we prospective      treated 346 consecutive patients with gallbladder stones and CBDS with      laparoscopic cholecystectomy and LCBDE. Intraoperative findings, postoperative      complications, postoperative hospital stay and costs were analyzed. RESULTS:      Because of LCBDE failure,16 cases (4.6%) required open surgery. Of 330 successful      LCBDE-treated patients, 237 underwent LTSE and 93 required LC. No mortality      occurred in either group. The bile duct stone clearance rate was similar in both       groups. Patients in the LTSE group were significantly younger and had fewer      complications with smaller, fewer stones, shorter operative time and      postoperative hospital stays, and lower costs, compared to those in the LC group.      Compared with patients with T-tube insertion, patients in the LC group with      primary closure had shorter operative time, shorter postoperative hospital stay,       and lower costs. CONCLUSIONS: In cases requiring LCBDE, LTSE should be the first       choice, whereas LC may be restricted to large, multiple stones. LC with primary      closure without external drainage of the CBDS is as effective and safe as the'
            },
            {
              id: 2,
              avatar: 'https://example.com/avatar2.jpg',
              name: '张敏灵',
              timestamp: '1 day ago',
              title: 'COTRADE: Confident co-training with data editing',
              authors: '张敏灵',
              abstract: 'Co-training is one of the major semi-supervised learning paradigms that iteratively trains two classifiers on two different views, and uses the predictions of either classifier on the unlabeled examples to augment the training set of the other. During the co-training process, especially in initial rounds when the classifiers have only mediocre accuracy, it is quite possible that one classifier will receive labels on unlabeled examples erroneously predicted by the other classifier. Therefore, the performance of co-training style algorithms is usually unstable. In this paper, the problem of how to reliably communicate labeling information between different views is addressed by a novel co-training algorithm named COTRADE. In each labeling round, COTRADE carries out the label communication process in two steps. First, confidence of either classifier'
            },
            // 添加更多推荐系统相关学术动态
          ]
        },
        {
          label: '人工智能',
          name: 'artificialIntelligence',
          news: [
            {
              id: 1,
              avatar: 'https://example.com/avatar1.jpg',
              name: '吴建鑫',
              timestamp: '2 hours ago',
              title: 'Ensembling neural networks: Many could be better than all',
              authors: '吴建鑫',
              abstract: 'Neural network ensemble is a learning paradigm where many neural networks are jointly used to solve a problem. In this paper, the relationship between the ensemble and its component neural networks is analyzed from the context of both regression and classification, which reveals that it may be better to ensemble many instead of all of the neural networks at hand. This result is interesting because at present, most approaches ensemble all the available neural networks for prediction. Then, in order to show that the appropriate neural networks for composing an ensemble can be effectively selected from a set of available neural networks, an approach named GASEN is presented. GASEN trains a number of neural networks at first. Then it assigns random weights to those networks and employs genetic algorithm to evolve the weights so that they can characterize to some extent the fitness of the neural networks in constituting an ensemble. Finally it selects some neural networks based on the evolved weights to make up the ensemble. A large empirical study shows that, compared with some popular ensemble approaches such as Bagging and Boosting, GASEN can generate neural network ensembles with far smaller sizes but stronger generalization ability. Furthermore, in order to understand the working mechanism of GASEN, the bias-variance decomposition of the error is provided in this paper, which shows that the success of GASEN may lie in that it can significantly reduce the bias as well as the variance.'
            },
            {
              id: 2,
              avatar: 'https://example.com/avatar2.jpg',
              name: '邹晓平',
              timestamp: '1 day ago',
              title: 'Inhibition of activated Stat3 reverses drug resistance to chemotherapeutic agents in gastric cancer cells',
              authors: '邹晓平',
              abstract: 'Multidrug resistance is a major obstacle in the treatment of gastric cancer. The underlying mechanisms of this phenomenon have not been well understood. Accumulating evidence indicates that Stat3 plays an important role in tumorigenesis of various primary cancers and cancer cell lines by upregulating cell survival proteins and downregulating tumor suppressors. We propose that the Stat3 pathway is also involved in acquired drug resistance of gastric cancer. To test this hypothesis, we investigated the expression and activation of Stat3 in drug resistant gastric cancer cell lines. Western blotting and real-time reverse transcription-PCR determined that Stat3 and its target genes were overactivated and/or overexpressed in drug resistant cells. Inhibition of Stat3 function resulted in significant decreases in cisplatin resistance and enhanced apoptosis in drug resistant cells. The levels of Stat3 target oncogenes such as Bcl-2 and c-Myc were decreased with DPP, a Stat3 inhibitor, treatment, while the expression of tumor suppressor p53 was increased. Interestingly, the vacuolar ATPase, a proton pump which interferes the uptake of therapeutic drugs, was down regulated by Stat3 inhibition. In conclusion, these data supported the hypothesis that interruption of Stat3 signaling could reverse resistance to chemotherapy agents in human gastric cancer cells.'
            },
            // 添加更多人工智能相关学术动态
          ]
        },
        {
          label: '机器学习',
          name: 'machineLearning',
          news: [
            {
              id: 1,
              avatar: 'https://example.com/avatar1.jpg',
              name: '王魏',
              timestamp: '2 hours ago',
              title: 'Robust structured subspace learning for data representation',
              authors: '王魏',
              abstract: 'This paper presents the top 10 data mining algorithms identified by the IEEE International Conference on Data Mining (ICDM) in December 2006: C4.5, k-Means, SVM, Apriori, EM, PageRank, AdaBoost, kNN, Naive Bayes, and CART. These top 10 algorithms are among the most influential data mining algorithms in the research community. With each algorithm, we provide a description of the algorithm, discuss the impact of the algorithm, and review current and further research on the algorithm.These 10 algorithms cover classification, clustering, statistical learning, association analysis, and link mining, which are all among the most important topics in data mining research and development.'
            },
            {
              id: 2,
              avatar: 'https://example.com/avatar2.jpg',
              name: '耿新',
              timestamp: '1 day ago',
              title: 'Enhanced Visual Analysis for Cluster Tendency Assessment and Data Partitionin',
              authors: '耿新',
              abstract: 'Visual methods have been widely studied and used in data cluster analysis. Given a pairwise dissimilarity matrix D of a set of n objects, visual methods such as the VAT algorithm generally represent D as an n x n image I((D) over bar) where the objects are reordered to reveal hidden cluster structure as dark blocks along the diagonal of the image. A major limitation of such methods is their inability to highlight cluster structure when D contains highly complex clusters. This paper addresses this limitation by proposing a Spectral VAT algorithm, where D is mapped to D'
            },
            // 添加更多机器学习相关学术动态
          ]
        }
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