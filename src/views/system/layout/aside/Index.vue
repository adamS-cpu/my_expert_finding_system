<template>
 <el-menu color="white" text-color="#67879b" router
 :default-active="route.path"
 :unique-opened="false" :default-openeds="[route.path]"
 class="el-menu-vertical-demo"
 :collapse="isCollapse"
 :collapse-transition="true">
   <!--logo start-->
    <div class="imgBox hidden-xs-only" v-if="!isCollapse">
      <img src="/src/assets/expert/image/ourLogo.png">
    </div>
   <!--logo end-->

   <!--遍历菜单 start-->

   <template v-for="(v,index) in menuData" :key="index">
     <!--如果菜单有子菜单，则循环子菜单-->
     <el-sub-menu v-if="v.isMenu && v.funcNode!=1" :index="index">
       <template #title>
         <el-icon>
           <component :is="v.meta.icon"></component>
         </el-icon>
         <span>{{v.meta.title}}</span>
       </template>

       <el-menu-item v-for="child in v.children" :key="child.path" :index="v.path+'/'+child.path">
         <el-icon>
           <component :is="child.meta.icon"></component>
         </el-icon>
         {{child.meta.title}}
       </el-menu-item>

     </el-sub-menu>

     <!--没有子菜单-->
     <el-menu-item v-else-if="v.isMenu" :key="v.path" :index="v.path">
       <el-icon>
         <component :is="v.children[0].meta.icon"></component>
       </el-icon>
       <span>{{v.children[0].meta.title}}</span>
     </el-menu-item>

   </template>


   <!--遍历菜单 end-->


 </el-menu>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router'
import { computed ,ref} from 'vue'
import { useSettingStore } from "../../../../store/modules/setting"
import {useMenuStore} from "../../../../store/modules/menu";

const route = useRoute()
const settingStore = useSettingStore()
// 是否折叠
const isCollapse = computed(()=>!settingStore.isCollapse)
const { routers } = useMenuStore()
// 菜单数据
const menuData = ref()
menuData.value=routers

</script>

<style scoped>
.imgBox{
  width: 240px;
  height: 60px;
  background: #083a6d;
}

.imgBox img {
  border-top-left-radius: 5px;
  width: 190px;
  height: 52px;
  margin: 0;
}

.imgBox

.el-menu {
  height: 100%;
  border:0px;
}

/*选中的颜色*/
:deep(.el-menu-item.is-active){
  color: white;
  background: linear-gradient(to right, #083a6d, #5e6eba);
}

</style>
