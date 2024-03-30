<script setup lang="ts">

</script>

<template>
  <!--顶部-->
  <div class="analyzing-header">
    <div class="objectUser">
      <img src= "@/assets/expert/image/example-user-icon.png" style="border: 1px solid lightgray; border-radius: 10px;" alt="user-icon" />
      <div class="userInfo">
        <div class="userName">
          <h3>张三</h3>
        </div>
        <div class="user-organization">
          <i class="el-icon-school"> </i> 苏州大学
        </div>
        <div class="userAbstract">
          数据挖掘 &emsp; 推荐系统
        </div>
      </div>
    </div>
    <div class="function-button">
      <div class="button-item">
        <el-button type="primary" plain>发送信息</el-button>
      </div>
      <div class="button-item">
        <el-button type="info" plain>个人主页</el-button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.analyzing-header{
  display: flex;
  align-items: center;
  background-color: #f8f9f8;
  justify-content: space-between;
  height: 150px;
  width: 100%;
  margin: 0 auto;
  border-bottom: 20px solid #edeff2; /* 设置底部灰色分割线 */
}




.objectUser {
  display: flex;
  margin-left: 15px;
}

.objectUser .userInfo {
  display: flex;

  position: relative;
  flex-direction: column; /* 设置主轴方向为垂直 */
  margin-left: 20px;
}

.objectUser .userInfo .userName{
  margin-top: 5px;
  margin-bottom: 15px;
  font-size: 21px;
}

.objectUser .userInfo .user-organization{
  margin-top: 5px;
  margin-bottom: 6px;
  font-size: 16px;
}

.objectUser .userInfo .userAbstract{
  font-size: 16px;
}

.objectUser .userInfo .userName{

}

.analyzing-header .function-button {
  display: flex;
  align-items: center;
  position: relative;
  flex-direction: column; /* 设置主轴方向为垂直 */
  margin-right: 50px;
}

.analyzing-header .function-button .button-item {
  align-items: center;
  margin-top: 5px;
  margin-bottom: 15px;
}
</style>