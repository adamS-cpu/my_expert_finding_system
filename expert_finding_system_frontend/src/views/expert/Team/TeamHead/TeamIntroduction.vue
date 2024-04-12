<script>
  export default {

  }

</script>

<template>
  <!--顶部-->
<!--  <div class="analyzing-header">-->
<!--    <div class="objectUser">-->
<!--      <img src= "@/assets/expert/image/example-user-icon.png" style="border: 1px solid lightgray; border-radius: 10px;" alt="user-icon" />-->
<!--      <div class="userInfo">-->
<!--        <div class="userName">-->
<!--          <h3>周志华</h3>-->
<!--        </div>-->
<!--        <div class="user-organization">-->
<!--          <i class="el-icon-school"> </i> 南京大学-->
<!--        </div>-->
<!--        <div class="userAbstract">-->
<!--          机器学习 &emsp; 人工智能-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--    <div class="function-button">-->
<!--      <div class="button-item">-->
<!--        <el-button type="primary" plain>发送信息</el-button>-->
<!--      </div>-->
<!--      <div class="button-item">-->
<!--        <el-button type="info" plain>个人主页</el-button>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
  <div class="box">
    <div class="columns">
      <div class="column is-10">
        <div class="columns">
          <div class="column is-narrow">
            <img src= "@/assets/expert/image/gdmec_1708307113748.jpg" style="border: 1px solid lightgray; border-radius: 10px;" alt="user-icon" />
          </div>
          <div class="column">
            <p class="title is-8">图数据挖掘与智能教育研究组</p>
            <p> </p>
            <p class="subtitle">
              www.expertFindingSystem.com/team/gdmec
            </p>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="function-button">
          <div class="button-item">
            <el-button type="primary" plain>加入团队</el-button>
          </div>
          <div class="button-item">
            <el-button type="info" plain>分享主页</el-button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.function-button {
  display: flex;
  align-items: center;
  position: relative;
  flex-direction: column; /* 设置主轴方向为垂直 */
  margin-right: 50px;
}

.function-button .button-item {
  align-items: center;
  margin-top: 5px;
  margin-bottom: 15px;
}
</style>