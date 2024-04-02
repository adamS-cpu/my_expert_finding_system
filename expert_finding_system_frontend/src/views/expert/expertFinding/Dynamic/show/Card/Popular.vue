<script setup lang="ts">
import {onMounted, reactive, ref} from "vue";
import {getUserListApi5} from "@/api/expert/dynamic/dynamic";

const userList = ref({})


const getUserList = async() =>{
  const {data} = await getUserListApi5()
  userList.value = data.result.userList
}

onMounted(()=>{
  getUserList()
})

</script>

<template>
  <div>
    <el-card style="max-width: 480px" shadow="never">
      <template #header>
        🥂 热门推荐
      </template>
      <div class="text item">
        <el-card style="height: 80px" shadow="never">
          <div class="columns">
            <div class="column is-one-quarter">
              <div class="avatar">李</div>
            </div>
            <div class="column">
              <p style="font-size: 16px;">李中伟</p>
              <p style="font-size: 12px;">南京理工大学</p>
            </div>
            <div class="column is-one-third">
              <el-button type="warning" round>关注</el-button>
            </div>
          </div>
        </el-card>
      </div>

<div class="text item">
  <el-card style="height: 80px" shadow="never">
    <div class="columns">
      <div class="column is-one-quarter">
        <div class="avatar">张</div>
      </div>
      <div class="column">
        <p style="font-size: 16px;">张顺力</p>
        <p style="font-size: 12px;">南京大学</p>
      </div>
      <div class="column is-one-third">
        <el-button type="warning" round>关注</el-button>
      </div>
    </div>
  </el-card>
</div>
    </el-card>
  </div>
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