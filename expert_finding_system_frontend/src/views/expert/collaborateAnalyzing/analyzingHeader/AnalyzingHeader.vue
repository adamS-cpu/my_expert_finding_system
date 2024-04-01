<script>
import {Location} from "@element-plus/icons-vue";

export default {
  components: {Location},
  data() {
    return {
      user_form: {
        icon: '周',
        name: '周志华',
        org: '南京大学',
        tagList: [
          '数据挖掘',
           '人工智能',
          '机器学习',
        ]
      },
      collaborator_form: {
        icon: '高',
        name: '高尉',
        org: '南京大学',
        tagList: [
          '复杂性科学与人工智能理论',
          '机器学习',
          '数据挖掘',
        ]
      },
    }
  },
  methods(){

  },
  computed: {
    currentDate() {
      const now = new Date();
      const year = now.getFullYear();
      const month = String(now.getMonth() + 1).padStart(2, '0');
      const day = String(now.getDate()).padStart(2, '0');
      return `${year}-${month}-${day}`;
    },
  },
}

</script>

<template>
  <!--顶部-->
  <div class="analyzing-header">
    <div class="columns">
      <div class="column">
        <div class="objectUser">
          <div class="avatar">{{ user_form.icon }}</div>
          <div class="userInfo">
            <div class="userName">
              <h3>{{user_form.name}} </h3>
            </div>
            <div class="user-organization">
              <i class="el-icon-school"> </i> {{user_form.org}}
            </div>
            <div class="userAbstract">
              <el-tag
                  :key="tag"
                  v-for="tag in user_form.tagList"
                  closable
                  :disable-transitions="false"
                  @close="handleClose(tag)"
              >
                {{tag}}
              </el-tag>
            </div>
          </div>
        </div>
      </div>

      <div class="column">
        <div class="collaborationUser">
          <div class="avatar">{{ collaborator_form.icon }}</div>
          <div class="userInfo">
            <div class="userName">
              <h3>{{collaborator_form.name}} （分析目标）</h3>
            </div>
            <div class="user-organization">
              <i class="el-icon-school"> </i> {{ collaborator_form.org }}
            </div>
            <div class="userAbstract">
              <el-tag
                  :key="tag"
                  v-for="tag in collaborator_form.tagList"
                  closable
                  :disable-transitions="false"
                  @close="handleClose(tag)"
              >
                {{tag}}
              </el-tag>
            </div>
          </div>
          <div class="function-button">
            <div class="button-item">
              <el-button type="info" plain>查看Ta的个人主页</el-button>
            </div>
            <div class="button-item">
              <el-button type="success" plain>向Ta发送信息</el-button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.analyzing-header{
  align-items: center;
  background-color: #fafafa;
  height: 170px;
  width: 100%;
  margin: 0 auto;
  border-bottom: 20px solid #edeff2; /* 设置底部灰色分割线 */
}

.objectUser {
  display: flex;
  margin-left: 15px;
}

.collaborationUser{
  display: flex;
  margin-left: 1%;
}

.userInfo {
  display: flex;
  position: relative;
  flex-direction: column; /* 设置主轴方向为垂直 */
  margin-left: 15px;
}

.userInfo .userName{
  margin-top: 5px;
  margin-bottom: 15px;
  font-size: 19px;
}

.userInfo .user-organization{
  margin-top: 5px;
  margin-bottom: 6px;
  font-size: 16px;
}

.userInfo .userAbstract{
  font-size: 16px;
}


.analyzing-header .function-button {
  display: flex;
  align-items: center;
  position: relative;
  flex-direction: column; /* 设置主轴方向为垂直 */
}

.analyzing-header .function-button .button-item {
  width: 70px;
  align-items: center;
  margin-top: 1px;
  margin-bottom: 15px;
  margin-left: 30px;
}
.avatar {
  width: 80px;
  height: 80px;
  border-radius: 50%;
  background-color: #007bff;
  color: white;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-right: 15px;
  font-weight: bold;
  border: 1px solid lightgray;
}
</style>