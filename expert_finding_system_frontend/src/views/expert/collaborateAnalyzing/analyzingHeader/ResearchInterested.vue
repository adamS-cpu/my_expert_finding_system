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
              你与 Raghu Machiraju 有着共同的研究兴趣
            </div>
            <div class="column">
              <el-button type="primary" round>查看他在这些领域的论文</el-button>
            </div>
          </div>
        </template>
        <div class="flex gap-2">
          <el-check-tag checked>social network</el-check-tag>
          <el-check-tag :checked="checked" @change="onChange">dynamic network analysis</el-check-tag>
        </div>
      </el-card>

      <el-card>
        <template #header>
          <div class="columns">

            <div class="column is-three-quarters">
              Raghu Machiraju 所独有的研究方向
            </div>
            <div class="column">
              <el-button type="primary" round>查看他在这些领域的论文</el-button>
            </div>
          </div>
        </template>
        <div class="flex gap-2">
          <el-check-tag checked>computational biology</el-check-tag>
          <el-check-tag :checked="checked1" @change="onChange1">cancer</el-check-tag>
        </div>
      </el-card>






    </section>



</template>



<style scoped>

</style>

