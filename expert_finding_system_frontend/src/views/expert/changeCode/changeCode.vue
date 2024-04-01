
<template>
<TopHeader/>
<div class="form-wrapper">
    <el-card style="width:70%">
   <el-form ref = "formRef" :model="user" :rules="rules" label-width="80px" style="padding-right:20px">

    <el-form-item show-password label="原始密码" prop="password">
        <el-input v-model="user.password" placeholder ="原始密码"></el-input>
    </el-form-item>
    <el-form-item show-password label="新密码" prop="newPassword">
        <el-input v-model="user.newPassword" placeholder ="新密码"></el-input>
    </el-form-item>
    <el-form-item show-password label="确认密码" prop="confirmPassword">
        <el-input v-model="user.confirmPassword" placeholder ="确认密码"></el-input>
    </el-form-item>
    <div style ="text-align:center;margin-bottom: 20px">
        <el-button type="primary" @click="update">确认</el-button>
    </div>
   </el-form>
</el-card>

</div>
<Footer/>
</template>
<script setup lang = "ts" name = "change">
import Footer from "@/views/expert/comm/bottom/Footer.vue"
 import TopHeader from  '../comm/header/TopHeader.vue';
 let user: any = JSON.parse(localStorage.getItem('honey-user') || '{}'); //获取用户信息 登录页面的登录按钮点击事件绑定的方法里面修改
let rules: {
    username:[
        {required: true,message:'请输入原始密码',trigger: 'blur'},
    ],
    password:[
        {required: true , message:'请输入新密码', trigger: 'blur'},
    ],
    confirmPassword:[
        {required: true , message:'请确认新密码', trigger: 'blur'},
    ],
}
</script>

<style scoped>
.form-wrapper {
   
    display: flex;
  justify-content: center;
  align-items: center;
 
  }
</style>