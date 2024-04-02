<script setup lang="ts" xmlns="http://www.w3.org/1999/html">

import {ref} from "vue";

const checked = ref(false)
const checked1 = ref(true)
const onChange = (status: boolean) => {
  checked.value = status
}

const onChange1 = (status: boolean) => {
  checked1.value = status
}


</script>

<template>



    <section>
      <el-card>
        <template #header>
          <div class="columns">

            <div class="column is-three-quarters">
              你与高尉有着共同的研究兴趣
            </div>
            <div class="column">
              <el-button type="primary" round>查看他在这些领域的论文</el-button>
            </div>
          </div>
        </template>
        <div class="flex gap-2">
          <el-check-tag checked>机器学习</el-check-tag>
          <el-check-tag :checked="checked" @change="onChange">数据挖掘</el-check-tag>
        </div>
      </el-card>

      <el-card>
        <template #header>
          <div class="columns">

            <div class="column is-three-quarters">
              高尉所独有的研究方向
            </div>
            <div class="column">
              <el-button type="primary" round>查看他在这些领域的论文</el-button>
            </div>
          </div>
        </template>
        <div class="flex gap-2">
          <el-check-tag checked>复杂性科学与人工智能理论</el-check-tag>
          <!-- <el-check-tag :checked="checked1" @change="onChange1">药理学</el-check-tag> -->
        </div>
      </el-card>






    </section>



</template>



<style scoped>

</style>

