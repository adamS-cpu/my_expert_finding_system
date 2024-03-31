<script setup lang="ts">
  import {ref, computed} from 'vue'
  import  {useRoute} from 'vue-router'
  import {useExpertStore} from "@/store/modules/expert";
  // const route = useRoute()
  // const expertActive = ref()
  // const {expertInfo} = useExpertStore()
  // expertActive.value = route.path
  const route = useRoute();
  const { expertInfo } = useExpertStore();

  // 使用计算属性来判断导航项是否应该激活
  const expertActive = computed(() => route.path);

  // 检查给定路径是否与当前路由匹配
  const isActive = (path) => {
    return expertActive.value === path;
  };

</script>

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
          <li class="expert-nav-item" :class="{'expert-active': isActive('/index')}">
            <router-link to="/index">发现</router-link>
          </li>

          <li class="expert-nav-item" :class="{'expert-active': isActive('/expert/dynamic')}">
            <router-link to="/expert/dynamic">好友动态</router-link>
          </li>

          <li class="expert-nav-item" :class="{'expert-active': isActive('/expert/myInfo')}">
            <router-link to="/expert/myInfo">我的主页</router-link>
          </li>

          <li class="expert-nav-item" :class="{'expert-active': isActive('/expert/message')}">
            <router-link to="/expert/message">消息中心</router-link>
          </li>

          <li class="expert-nav-item" :class="{'expert-active': isActive('/expert/analyzing')}">
            <router-link to="/expert/analyzing">合作分析</router-link>
          </li>
        </template>

        <!--未登录 start-->
        <template v-else>
          <li class="expert-nav-item" :class="{'expert-active': isActive('/index')}">
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
          <li class="expert-nav-item" :class="{'expert-active': isActive('/expert/selfInform')}">
            <!-- <router-link to="/account/userInfo">个人中心</router-link> -->
            <router-link to="/expert/selfInform">个人中心</router-link>
          </li>

          <li class="expert-nav-item" :class="{'expert-active': isActive('/account/exitAccount')}">
            <router-link to="/account/exitAccount">退出登录</router-link>
          </li>
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

<style scoped>
.expert-header{
  height: 68px;
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

.expert-nav .expert-nav-item.expert-active::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 2px;
  background-color: #ffffff; /* 横线的颜色 */
}
.expert-nav .expert-nav-item {
  position: relative;
  /* 其他样式保持不变 */
}
</style>