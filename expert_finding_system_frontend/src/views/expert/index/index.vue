<script setup lang="ts">
  import TopHeader from "@/views/expert/comm/header/TopHeader.vue";
  import Footer from "@/views/expert/comm/bottom/Footer.vue";
  import Search from "@/views/expert/comm/search/Search.vue";
  import RelationSchema from "@/views/expert/collaborateAnalyzing/analyzingHeader/RelationSchema.vue";
  import graph from '@/assets/les-miserables.json';
</script>

<template>
  <!--顶部 start-->
  <div><TopHeader/></div>
  <!--顶部 end-->

  <!--中间内容 开始-->
  <div class="expert-nav">
    <el-card  :body-style= "{ padding:  '0px'}" class="outer-card">
      <!-- <div class="node-item" >当前用户：MlleBaptistine</div> -->
      
      <div class="node-item" v-for="node in nodes" :key="node.id"
      :id="`node-${node.id}`" 
      @mouseover="coverNode(node)" 
      @mouseleave="leaveNode(null)"
      @click="selectNode(node)"
      :class="{'is-selected': node.id == selectedNodeId, 
                'is-covered': node.id == coverNodeId}"
      >
        <div>{{ node.name }}</div>
        <!-- 使用el-tag显示每个标签 -->
        <el-tag 
          v-for="label in labels" 
          :key="label" 
          type="info" 
          class="node-tag"
          style="margin-right: 5px; margin-top: 5px;">
          {{ label }}
        </el-tag>
      </div>
    </el-card>
    
    <div class="network-graph">
      <!--搜索组件 start-->
      <Search/>
      <!--搜索组件 end-->
      <div class="expert-index">
        <RelationSchema
        @node-clicked="handleNodeClicked" 
        ref="relationSchemaRef"/>
      </div>
    </div>
    
    <div class="node-details">
      <div class="abstractbox-column" v-for="(group, category) in groupedNodes" :key="category">
        <h3>{{ categoryMapping[category] }}</h3>
        <transition-group name="slide-fade" tag="div" class="card-container">
          <div class="scholar-card" v-if="group.nodes.length > 0" :key="currentIndices[category]">
            <h4>{{ group.nodes[currentIndices[category]]?.name }}</h4>
            <p>{{ group.nodes[currentIndices[category]]?.value }}</p>
            <p>{{ group.nodes[currentIndices[category]]?.symbolSize }}</p>
            <!-- 添加更多个人信息 -->
          </div>
        </transition-group>
      </div>
    </div>
  </div>
  <!--中间内容 结束-->


  <!--底部 start-->
    <Footer/>
  <!--底部 end-->
</template>

<script lang="ts">
export default {
  name: 'NodeList',

  data() {
    return {
      nodes: graph.nodes,
      labels: ["数据挖掘","自然语言处理","机器学习"],
      selectedNodeDetails: graph.nodes[0], // 用于存储选中节点的详细信息
      coverNodeDetails: null,
      selectedNodeId: null,
      coverNodeId: null,
      // 存储每个种类当前显示的节点索引
      currentIndices: {},
      categoryMapping: {
        0: '自然语言处理',
        1: '机器学习',
        2: '数据科学',
        // 添加更多映射...
      },
    };
  },
  
  methods: {
    selectNode(node) {
      this.selectedNodeDetails = node;
      this.selectedNodeId = node.id;
      this.$refs.relationSchemaRef.highlightNodeInChart(node.id);
    },
    coverNode(node) {
      this.coverNodeDetails = node;
      this.coverNodeId = node.id;
    },
    leaveNode(node) {
      this.coverNodeDetails = null;
      this.coverNodeId = null;
    },
    handleNodeClicked(node) {
      this.selectNode(node);
      this.scrollToNode(node.id);
    },
    scrollToNode(nodeId) {
      // 使用动态ID找到对应的DOM元素
      const nodeElement = document.getElementById(`node-${nodeId}`);
      if (nodeElement) {
        nodeElement.scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    },
    initializeCurrentIndices() {
      Object.keys(this.groupedNodes).forEach(category => {
        // 直接赋值来初始化索引
        this.currentIndices[category] = 0;
      });
    }
  },
  computed: {
    groupedNodes() {
      const groups = {};
      this.nodes.forEach(node => {
        if (!groups[node.category]) {
          groups[node.category] = { nodes: [], currentIndex: 0 };
        }
        groups[node.category].nodes.push(node);
      });
      return groups;
    }
  },
  mounted() {
    // 初始化 currentIndices
    this.initializeCurrentIndices();
    // 设置定时器更新每个类别的显示节点
    Object.keys(this.groupedNodes).forEach(category => {
      setInterval(() => {
        const length = this.groupedNodes[category].nodes.length;
        const currentIndex = (this.currentIndices[category] + 1) % length;
        this.currentIndices[category] = currentIndex;
      }, 3000); // 每3秒更新一次
    });
  }

  // 其它组件选项，如methods, computed等
};
</script>

<style scoped>


.expert-nav {
  display: flex;
  height: 100vh; /* 根据实际情况调整高度 */
  overflow: hidden; /* 防止内容溢出 */
}

.outer-card, .network-graph, .node-details {
  /* padding: 20px; */
  overflow-y: auto; /* 允许单独滚动 */
}

.outer-card {
  flex: 1; /* 调整宽度占比 */
  padding: 0;
  /* border-right: 1px solid #ccc; 分隔线 */
}
.node-list {
  width: 100%; /* 内层卡片宽度占满 */
}
.node-item {
  margin-bottom: 0px; /* 设置元素之间的间距 */
  padding: 30px; 
  /* 更多样式，如背景色、边框等 */
  transition: box-shadow 0.3s ease; /* 添加过渡效果让阴影出现更平滑 */
}
.node-item:hover {
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* 悬停时添加阴影效果 */
}
.node-item:not(:last-child) {
  border-bottom: 1px solid #ccc; /* 在元素下方添加一条细线 */
}
.node-tag {
  background-color: #083545; /* 设置标签背景颜色为蓝色 */
  color: white; /* 设置标签文本颜色为白色，确保对比度 */
  padding: 5px; /* 添加内边距，为标签文本提供一些空间 */
  margin-top: 5px; /* 在名称和标签之间添加一些空间 */
}

.network-graph {
  flex: 3; /* 更大的宽度占比 */
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  flex-direction: column; /* 使搜索组件位于顶部 */
}

.expert-index {
  flex: 3; /* 保证 RelationSchema 和 幻灯片充满剩余空间 */
  height: 100%;
  width: 100%;
}

.node-details {
  flex: 1; /* 调整宽度占比 */
  /* border-left: 1px solid #ccc; 分隔线 */
  display: flex;
  flex-direction: column; /* 确保子元素从上往下排列 */
  gap: 20px; /* 子元素之间的间距 */
  margin: 20px 0; /* 顶部和底部的外边距 */
}

/* 可选：为搜索组件和其他内容添加更具体的样式 */
.Search, .RelationSchema, .el-carousel {
  /* margin-bottom: 20px; 添加间距 */
}
.expert-nav {
  background-color: #FFF;
}
.is-selected {
  background-color: #cccccc; 
  /* 其他希望应用到选中节点的样式 */
}
.is-covered {
  background-color: #e0e0e0; 
  /* 其他希望应用到选中节点的样式 */
}


.abstractbox-column {
  background-color: #f9f9f9; /* 背景颜色 */
  border-radius: 8px; /* 边框圆角 */
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 轻微的阴影效果 */
  padding: 20px; /* 内边距 */
  transition: box-shadow 0.3s ease; /* 阴影过渡效果，提升交互体验 */
}

.abstractbox-column:hover {
  box-shadow: 0 6px 8px rgba(0, 0, 0, 0.2); /* 鼠标悬停时增强阴影 */
}

h3 {
  margin: 0 0 15px 0; /* 标题的外边距，确保标题与内容之间的间距 */
  color: #333; /* 标题颜色 */
  font-size: 20px; /* 标题字号 */
}

/* 额外的样式，用于美化节点信息显示 */
div[v-for] {
  padding: 10px;
  background-color: white;
  margin-bottom: 10px;
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
}

div[v-for]:hover {
  background-color: #e8e8e8; /* 提供简单的悬停反馈 */
}
.card-container {
  display: flex;
  overflow: hidden;
  
}

.scholar-card {
  width: 100%;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 20px;
  background-color: white;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
  transition: transform 0.3s ease;
}

.slide-fade-enter-active, .slide-fade-leave-active {
  transition: opacity 0.5s, transform 0.5s ease-in-out;
  will-change: transform, opacity;
}
.slide-fade-enter, .slide-fade-leave-to /* .slide-fade-leave-active for <2.1.8 */ {
  opacity: 0;
  transform: translate3d(10px, 0, 0); /* 使用 translate3d 开启 GPU 加速 */
}

/* 当元素进入或到达“进入”的最终状态时，确保其完全可见并位于原点 */
.slide-fade-enter-to, .slide-fade-leave {
  opacity: 1;
  transform: translate3d(0, 0, 0);
}


</style>