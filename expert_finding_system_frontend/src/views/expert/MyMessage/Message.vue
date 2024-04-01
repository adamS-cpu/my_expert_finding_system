<template>
  <TopHeader/>
  
  <div class="common-layout">
    <el-container>
      <el-container>
        <el-aside width="700px">
          <Contact/>
        </el-aside>
        <el-main>
          <RecommendedContact/>
        </el-main>
      </el-container>
    </el-container>
  </div>
  
  
</template>

<script lang="ts" setup>
  import TopHeader from "@/views/expert/comm/header/TopHeader.vue";
  import Contact from "@/views/expert/MyMessage/Contact.vue";
  import RecommendedContact from "@/views/expert/MyMessage/RecommendedContact.vue";
</script>

<style scoped>

</style>