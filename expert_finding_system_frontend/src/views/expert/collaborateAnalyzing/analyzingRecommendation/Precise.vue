<script setup lang="ts">

import {getUserListApi5} from "@/api/expert/dynamic/dynamic";
import {onMounted, ref} from "vue";
import {message} from "ant-design-vue";

const userList = ref({})

const getUserList = async() =>{
  setTimeout(() => {
  }, 100);
  const {data} = await getUserListApi5()

  userList.value = data.result.userList
}

onMounted(()=>{

  getUserList()
})
</script>

<template>
  <el-card style="max-width: 480px" shadow="never">
    <template #header>
      💐 猜你感兴趣
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
          <div class="column is-one-third">
            <el-button type="warning" round>关注</el-button>
          </div>
        </div>
      </el-card>
    </div>
  </el-card>
</template>


<style scoped>

</style>