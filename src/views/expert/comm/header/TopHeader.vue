<template>
<div class="expert-header header-store">
  <div class="expert-container">
    <div class="my_logo">
      <router-link class="logo" to="/index">
        <img src="@/assets/expert/image/ourLogo.png" alt="跨领域专家发现系统">
      </router-link>
    </div>

    <div class="expert-component-left">
      <ul class="expert-nav">
        <template v-if="expertInfo.nickname != ''">
          <li class="expert-nav-item" :class="{'expert-active': expertActive='/expert/index'}">
            <router-link to="/index">发现</router-link>
          </li>

          <li class="expert-nav-item" :class="{'expert-active': expertActive='/expert/contacts'}">
            <router-link to="/expert/dynamic">好友动态</router-link>
          </li>

          <li class="expert-nav-item" :class="{'expert-active': expertActive='/expert/MyInfo'}">
            <router-link to="/expert/myInfo">我的主页</router-link>
          </li>

          <li class="expert-nav-item" :class="{'expert-active': expertActive='/expert/Information'}">
            <router-link to="/expert/message">消息中心</router-link>
          </li>

          <li class="expert-nav-item" :class="{'expert-active': expertActive='/expert/analyzing'}">
            <router-link to="/expert/analyzing">合作分析</router-link>
          </li>
        </template>

        <!--未登录 start-->
        <template v-else>
          <li class="expert-nav-item" :class="{'expert-active': expertActive='/index'}">
            <router-link to="/index">发现</router-link>
          </li>
        </template>
        <!--未登录不可见 end-->

      </ul>
    </div>

    <div class="expert-component-right">
      <ul class="expert-nav">
        <!--已登录内容 start-->
        <template v-if="expertInfo.nickname != '' ">
          <!-- <li class="expert-nav-item" :class="{'expert-active': expertActive='/account/userInfo'}">
            <router-link to="/account/userInfo">个人中心</router-link>
          </li> -->
          <div>
            <img src="/src/assets/logo4.png" class="avatar" alt="">
  
            <u-dropdown>
              <u-dropdown-item @click="$router.push('/expert/selfInform')">个人信息</u-dropdown-item>
              <u-dropdown-item @click="$router.push('/expert/changeCode')">修改密码</u-dropdown-item>
              <u-dropdown-item @click="$router.push('/expert/account/exitAccount')">退出登录</u-dropdown-item>
            </u-dropdown>
          
        </div>

          <!-- <li class="expert-nav-item" :class="{'expert-active': expertActive='/account/exitAccount'}">
            <router-link to="/account/exitAccount">退出登录</router-link>
          </li> -->
        </template>
        <!-- end-->

        <!--未登录内容 -->
        <template v-else>
          <li class="expert-nav-item" :class="{'expert-active': expertActive='/expert/login'}">
            <router-link to="/expert/login">登录</router-link>
          </li>

          <li class="expert-nav-item" :class="{'expert-active': expertActive='/expert/register'}">
            <router-link to="/expert/register">立即注册</router-link>
          </li>
        </template>
        <!-- end-->
      </ul>
    </div>
  </div>

</div>
</template>
<script setup lang="ts">
  import {ref} from 'vue'
  import  {useRoute} from 'vue-router'
  import {useExpertStore} from "@/store/modules/expert";
  const route = useRoute()
  const expertActive = ref()
  const {expertInfo} = useExpertStore()
  expertActive.value = route.path
  let user: any = JSON.parse(localStorage.getItem('honey-user') || '{}'); //获取用户信息 登录页面的登录按钮点击事件绑定的方法里面修改
</script>
<style scoped>
.user-avatar {
  position: relative;
  display: inline-block;
}
.avatar {
  width: 40px;
  height: 40px; 
  border-radius: 50%; 
}
.expert-header{
  height: 75px;
  width: 100%;
  border-bottom: 1px solid #404553;
  background-color: #083545;
  z-index: 1000;
  position: relative;
}

.expert-container{
  width: 1700px;
  padding: 0;
  position: relative;
  margin: 0 auto;
  box-sizing: border-box;
}

.expert-container .my_logo{
  left: 10px;
  position: absolute;
  top: 0;
}

.expert-container .my_logo img{
  width: 250px;
  height: 70px;
  border: 10px;
}

.expert-container .expert-nav{
  position: absolute;
  top: 0;
  padding: 0;
  background: none;
  color: #fff;
  border-radius: 2px;
  box-sizing: border-box;
}

.expert-nav .expert-nav-item{
  position: relative;
  display: inline-block;
  vertical-align: middle;
  line-height: 60px;
  margin: 10px 20px
}

.expert-nav *{
  font-size: 18px;
}

.expert-nav .expert-nav-item a{
  display: block;
  color: #fff;
  transition: all .3s;
  -webkit-transition: all .3s;
}

.expert-active {
  color: #fff!important;
}

.expert-component-left{
  left: 290px;
  top: auto;
  bottom: 0;
  width: 1100px;
  position: absolute;
  height: 5px;
  background-color: #5fe878;
  transition: all .2s;
  -webkit-transition: all .2s;
}

.expert-component-left .expert-nav .expert-nav-item{
  padding: 0 20px;
}

.expert-component-right .expert-nav .expert-nav-item{
  padding: 0 10px;
}

.expert-component-right{
  right: 15px;
  top: auto;
  bottom: 0;
  position: absolute;
  left: 1050px;
  height: 5px;
  background-color: #5fe878;
  transition: all .2s;
  -webkit-transition: all .2s;
}
</style>