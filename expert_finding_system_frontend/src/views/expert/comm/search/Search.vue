<script setup lang="ts">

</script>

<template>
<div class ="search">
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
/* .input-search{
  width: 100%;
  padding: 40px 10px 10px 90px;

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
} */
.search {
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  height: 100px;
  width: 100%;
}

.input-search {
  display: flex;
  justify-content: center; /* 为了确保内部元素也水平居中 */
  align-items: center; /* 垂直居中内部元素 */
  padding: 0px; /* 调整根据需求 */
  width: 100%;
  background-color: #fff;
}

.search-expert {
  display: flex; /* 使输入框和按钮水平排列 */
  align-items: center; /* 垂直居中 */
}

.input-search .el-input {
  vertical-align: middle;
  font-size: 18px;
  width: 500px; /* 或其他根据设计的宽度 */
  height: 40px;
  background: #d9dfe0;
  border: none;
  outline: none;
  border-top-left-radius: 2px;
  border-bottom-left-radius: 2px;
}
</style>