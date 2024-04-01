
<template>
    <TopHeader/>
    <div class="form-wrapper">
        <el-card style="width:70%">
            <!-- <div style="margin:15px;text-align:center"> -->
                <!-- 头像设置部分 -->
                   <!-- 文件上传header -->
                   <!-- action后台文件上的地址,这里不是很清楚 -->
                <!-- <el-upload
                class="avatar-uploader"
                action="https://localhost:5173/file/upload"
                :show-file-list="false"
                :headers="{token:user.token}"   
                :on-success="handleAvatarSuccess"
                >
                <img v-if="user.avatar" :src="user.avatar" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
              </el-upload> -->
            <!-- </div> -->
            <el-form :model="user" label-width="80px" style="padding-right:20px">
            <el-form-item label="用户名" prop="username">
                <el-input v-model="user.username" placeholder ="用户名"></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="name">
                <el-input v-model="user.name" placeholder ="姓名"></el-input>
            </el-form-item>
            <el-form-item label="电话" prop="phone">
                <el-input v-model="user.phone" placeholder ="电话"></el-input>
            </el-form-item>
            <el-form-item label="邮箱" prop="address">
                <el-input v-model="user.address" placeholder ="邮箱"></el-input>
            </el-form-item>
            <el-form-item label="地址" prop="address">
                <el-input type="textarea" v-model="user.address" placeholder ="地址"></el-input>
            </el-form-item>
            <div style ="text-align:center;margin-bottom: 20px">
                <el-button type="primary" @click="update">保存</el-button>
            </div>
            <!-- <div class="change-wrapper">
                <RouterLink to="/expert/selfInform/password" class="change-link">修改密码</RouterLink>
              </div> -->
              <div style ="text-align:center;margin-bottom: 20px">
                <el-button type="primary" @click="update">
                    <router-link to="/expert/changeCode" class ="change">修改密码</router-link>
                </el-button>
            </div>
        </el-form>
            
        </el-card>
        <div>
          <router-view></router-view>
        </div>
        
    </div>
    <Footer/>
</template>
<script setup lang = "ts" name = "person">
import Footer from "@/views/expert/comm/bottom/Footer.vue"
    let user: any = JSON.parse(localStorage.getItem('honey-user') || '{}'); //获取用户信息 登录页面的登录按钮点击事件绑定的方法里面修改
    import TopHeader from "@/views/expert/comm/header/TopHeader.vue"
    import {RouterView,RouterLink} from 'vue-router'
    function handleAvatarSuccess(response: { data: any; },file: any,fileList: any){
        //把user的头像换成上传的图片的链接
        user.value.avatar = response.data;
    }
    function update(this: any){
        //向后台更新当前数据,刷掉浏览器缓存中用户的个人信息
        this.$request.put('user/update',this.user).then((res: { code: string; msg: any; }) =>{
            if(res.code === '200'){
                //成功更新
                this.$message.success('保存成功')
                localStorage.setItem('honey-user',JSON.stringify(this.user))
            }else{
                this.$message.error(res.msg)
            }
        })
    }
</script>
<style scoped>
.change{
    color: #fff;
}
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .form-wrapper {
   
    display: flex;
  justify-content: center;
  align-items: center;
 
  }
  
  .change-link {
    padding: 7px 7px; /* 调整内边距 */
    font-size: 14px; /* 调整字体大小 */
    background-color: #0099ff;
    color: #fff;
    border-radius: 5px;
    text-decoration: none;
    font-weight: bold;
    
    transition: background-color 0.3s ease;
  }
  
  .change-link:hover {
    background-color: #0056b3;
  }
.el-upload{
    border-radius:50%;
}
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
    border-radius: 50%;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
    border-radius: 50%;
  }
</style>