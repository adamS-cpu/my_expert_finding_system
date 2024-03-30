
<template>
    <TopHeader/>
    <div>
        <el-card style="width:50%">
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
        </el-form>
            
        </el-card>
    </div>
</template>
<script setup lang = "ts" name = "person">
    let user: any = JSON.parse(localStorage.getItem('honey-user') || '{}'); //获取用户信息 登录页面的登录按钮点击事件绑定的方法里面修改
    import TopHeader from "@/views/expert/comm/header/TopHeader.vue"
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
/deep/.el-upload{
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