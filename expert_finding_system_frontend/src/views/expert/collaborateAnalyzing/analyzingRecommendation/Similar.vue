<script setup lang="ts">

import {getUserListApi3} from "@/api/expert/dynamic/dynamic";
import {onMounted, ref} from "vue";

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
      🥂 和他相似的专家
    </template>
    <div v-for="item in userList" :key="item" class="text item">
      <el-card style="height: 80px" shadow="never">
        <div class="columns">
          <div class="column is-one-quarter" >
            <router-link :to="{path:'expert/user', query:{id:item.id}}">
              <img src= "@/assets/expert/image/example-user-icon-small.png" style="border: 1px solid lightgray; border-radius: 10px;" alt="user-icon" />
            </router-link>
          </div>
          <div class="column" >
            <p style="font-size: 16px;"> {{item.username}}</p>
            <p style="font-size: 12px;"> {{item.organization}} </p>
          </div>
          <div class="column is-twp-fifth">
            <p>
              <el-button type="info" plain>个人主页</el-button>
            </p>
          </div>
        </div>
      </el-card>
    </div>
  </el-card>
</template>


<style scoped>

</style>