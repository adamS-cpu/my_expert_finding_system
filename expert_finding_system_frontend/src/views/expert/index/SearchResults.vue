<template>
    <TopHeader/>
    <search/>
    <div class="container">
        <div class="search-results">
        <h2>搜索结果</h2>
        <ul>
            <li v-for="(scholar, index) in scholars" :key="index">
                <div class="avatar">{{ scholar.name[0] }}</div> <!-- 显示姓氏首字母 -->
                <div class="scholar-info">
                    <!-- class="scholar-name" -->
                    <router-link :to="{ name: 'ScholarDetails', params: { id: scholar.id }}">{{ scholar.name }}</router-link>
                    <div class="scholar-affiliation">{{ scholar.universe }}</div>
                    <div class="scholar-field">
                        <span class="field-tag" v-for="(field, fieldIndex) in scholar.tags" :key="fieldIndex" 
                        :style="{ backgroundColor: colors[fieldIndex % colors.length] }">
                        {{ field }}
                        </span>
                    </div>
                </div>
            </li>
        </ul>
        </div>
    </div>
    <Footer/>
</template>

<script setup lang="ts">
import TopHeader from "@/views/expert/comm/header/TopHeader.vue";
import Footer from "@/views/expert/comm/bottom/Footer.vue";
import Search from "@/views/expert/comm/search/Search.vue";
import { useScholarsStore } from '@/store/scholarsStore';
import { useRoute } from 'vue-router';
import { onMounted, ref } from 'vue';
// 全局定义的ref，用于接收从路由获取的查询参数
const searchQuery = ref('');
const route = useRoute();
const scholars = ref([]);
const colors = ['#007bff', '#28a745', '#dc3545', '#ffc107', '#17a2b8'];
const scholarsStore = useScholarsStore();

onMounted(async () => {
  // 直接使用全局的searchQuery更新值
  searchQuery.value = route.query.searchQuery;
  // 调用异步函数并等待结果
  scholars.value = await fetchScholars(searchQuery.value);
});

async function fetchScholars(query) {
    
    return scholarsStore.scholars; // 直接返回生成的学者数组
}
</script>

<style scoped>
/* 添加一些样式来美化列表 */
.container {
  display: flex;
  justify-content: center;
  align-items: start; /* 如果你想让模块垂直也居中可以使用 center */
  /* height: 100vh; 视窗高度 */
  padding: 20px; /* 根据需要调整 */
}

.search-results {
  width: 50%; /* 或你希望的宽度，这将决定模块的宽度 */
  background-color: #f9f9f9; /* 背景色 */
  padding: 20px; /* 内边距 */
  border-radius: 10px; /* 圆角边框 */
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 阴影效果 */
}

.search-results ul {
  list-style: none;
  padding: 0;
  margin: 0; /* 移除默认的外边距 */
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
.search-results li {
  list-style: none;
  margin: 10px 0;
  font-size: 16px;
  padding-bottom: 10px;
  border-bottom: 1px solid #e0e0e0;
  display: flex; /* 使用Flex布局让头像和文本对齐 */
  align-items: flex-start; /* 垂直居中对齐 */
  padding: 10px 0;
}
.scholar-info {
  display: flex;
  flex-direction: column;
}
.search-results li:not(:last-child) {
  border-bottom: 1px solid #e0e0e0; /* 仅在非最后一个元素下添加边框 */
}
.scholar-name, .scholar-affiliation, .scholar-field {
  margin: 2px 0; /* 调整间距 */
}
.scholar-field {
  display: flex; /* 使标签横向排列 */
  flex-wrap: wrap; /* 允许标签在必要时换行 */
  gap: 5px; /* 在标签之间添加一些间隙 */
}

.field-tag {
  background-color: #007bff; /* 蓝色背景 */
  color: white; /* 白色文字 */
  padding: 2px 8px; /* 内边距 */
  border-radius: 4px; /* 轻微的圆角效果 */
  font-size: 14px; /* 字体大小 */
}
</style>
