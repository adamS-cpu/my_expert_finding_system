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
        name: 'John Doe',
        timestamp: '2 hours ago',
        title: 'New Research Paper Published',
        authors: 'John Doe, Jane Smith',
        abstract: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut lectus vel ante tincidunt pellentesque.'
      },
      {
        id: 2,
        avatar: 'https://example.com/avatar2.jpg',
        name: 'Jane Smith',
        timestamp: '1 day ago',
        title: 'Conference Announcement',
        authors: 'Jane Smith',
        abstract: 'Sed ut lectus vel ante tincidunt pellentesque. Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
      },
      {
        id: 3,
        avatar: 'https://example.com/avatar3.jpg',
        name: 'David Johnson',
        timestamp: '3 days ago',
        title: 'New Machine Learning Framework Released',
        authors: 'David Johnson',
        abstract: 'Sed ut lectus vel ante tincidunt pellentesque. Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
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
        name: 'Michael Brown',
        timestamp: '2 weeks ago',
        title: 'New Deep Learning Models for Computer Vision',
        authors: 'Michael Brown',
        abstract: 'Sed ut lectus vel ante tincidunt pellentesque. Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
      },
      {
        id: 6,
        avatar: 'https://example.com/avatar6.jpg',
        name: 'Sophia Wilson',
        timestamp: '3 weeks ago',
        title: 'Applications of Reinforcement Learning in Robotics',
        authors: 'Sophia Wilson, William Johnson',
        abstract: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut lectus vel ante tincidunt pellentesque.'
      },
      {
        id: 7,
        avatar: 'https://example.com/avatar7.jpg',
        name: 'William Johnson',
        timestamp: '1 month ago',
        title: 'Graph Neural Networks: A Comprehensive Survey',
        authors: 'William Johnson, Sophia Wilson',
        abstract: 'Sed ut lectus vel ante tincidunt pellentesque. Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
      },
      {
        id: 8,
        avatar: 'https://example.com/avatar8.jpg',
        name: 'Jessica Lee',
        timestamp: '2 months ago',
        title: 'Emerging Trends in Artificial Intelligence',
        authors: 'Jessica Lee',
        abstract: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut lectus vel ante tincidunt pellentesque.'
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
              name: 'John Doe',
              timestamp: '2 hours ago',
              title: '新的数据挖掘算法发布',
              authors: 'John Doe, Jane Smith',
              abstract: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut lectus vel ante tincidunt pellentesque.'
            },
            {
              id: 2,
              avatar: 'https://example.com/avatar2.jpg',
              name: 'Jane Smith',
              timestamp: '1 day ago',
              title: '数据挖掘实践经验分享',
              authors: 'Jane Smith',
              abstract: 'Sed ut lectus vel ante tincidunt pellentesque. Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
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
              name: 'John Doe',
              timestamp: '2 hours ago',
              title: '新的推荐算法发布',
              authors: 'John Doe, Jane Smith',
              abstract: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut lectus vel ante tincidunt pellentesque.'
            },
            {
              id: 2,
              avatar: 'https://example.com/avatar2.jpg',
              name: 'Jane Smith',
              timestamp: '1 day ago',
              title: '推荐系统实践经验分享',
              authors: 'Jane Smith',
              abstract: 'Sed ut lectus vel ante tincidunt pellentesque. Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
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
              name: 'John Doe',
              timestamp: '2 hours ago',
              title: '新的人工智能算法发布',
              authors: 'John Doe, Jane Smith',
              abstract: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut lectus vel ante tincidunt pellentesque.'
            },
            {
              id: 2,
              avatar: 'https://example.com/avatar2.jpg',
              name: 'Jane Smith',
              timestamp: '1 day ago',
              title: '人工智能应用领域扩展',
              authors: 'Jane Smith',
              abstract: 'Sed ut lectus vel ante tincidunt pellentesque. Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
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
              name: 'John Doe',
              timestamp: '2 hours ago',
              title: '新的机器学习算法发布',
              authors: 'John Doe, Jane Smith',
              abstract: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut lectus vel ante tincidunt pellentesque.'
            },
            {
              id: 2,
              avatar: 'https://example.com/avatar2.jpg',
              name: 'Jane Smith',
              timestamp: '1 day ago',
              title: '机器学习在自然语言处理中的应用',
              authors: 'Jane Smith',
              abstract: 'Sed ut lectus vel ante tincidunt pellentesque. Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
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