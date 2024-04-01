<script setup lang="ts">

import {getUserListApi3} from "@/api/expert/dynamic/dynamic";
import {onMounted, reactive, ref} from "vue";

const userList = ref({})

const getUserList = async() =>{
  const {data} = await getUserListApi3()
  userList.value = data.result.userList
}

onMounted(()=>{
  getUserList()
})
</script>

<template>
  <el-card style="max-width: 480px" shadow="never">
    <template #header>
      🥳 最近浏览
    </template>
    <div class="text item">
      <el-card style="height: 80px" shadow="never">
        <div class="columns">
          <div class="column is-one-quarter">
            <a href="/expert/user?id=1">
              <div class="avatar">王</div>
            </a>
          </div>
          <div class="column">
            <p style="font-size: 16px;">王磊</p>
            <p style="font-size: 12px;">苏州大学</p>
          </div>
          <div class="column is-one-third">
            <el-button type="primary" round>发消息</el-button>
          </div>
        </div>
      </el-card>
    </div>

    <div class="text item">
      <el-card style="height: 80px" shadow="never">
        <div class="columns">
          <div class="column is-one-quarter">
            <a href="/expert/user?id=2">
              <div class="avatar">孙</div>
            </a>
          </div>
          <div class="column">
            <p style="font-size: 16px;">孙建</p>
            <p style="font-size: 12px;">清华大学</p>
          </div>
          <div class="column is-one-third">
            <el-button type="primary" round>发消息</el-button>
          </div>
        </div>
      </el-card>
    </div>
  </el-card>
</template>


<style scoped>
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
</style>