<script setup lang="ts">

</script>

<template>
<div style="height: auto">
  <el-form>
    <div class ="input-search">
      <div class = "search-expert">
        <el-input class= "el-input" placeholder="以专利、论文、姓名检索你感兴趣的专家..."></el-input>
        <el-button color="#5e6eba" class="expert-btn" icon="Search" size="large"></el-button>
      </div>
    </div>
  </el-form>
</div>
</template>

<style scoped>
.input-search{
  width: 100%;
  padding: 40px 0 10px;
  text-align: center;
  background-color: #fff;
}

.input-search .el-input{
  vertical-align: middle;
  font-size: 18px;
  width: 500px;
  height: 40px;
  background: #d9dfe0;
  border: none;
  outline: none;
  border-top-left-radius: 2px;
  border-bottom-left-radius: 2px;
}
</style>