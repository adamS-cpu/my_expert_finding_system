<script setup lang="ts">
import TopHeader from "@/views/expert/comm/header/TopHeader.vue"
import Footer from "@/views/expert/comm/bottom/Footer.vue"
import { ref, reactive} from 'vue'
import {ElMessage, FormInstance, FormRules} from "element-plus"
import {registerApi} from "@/api/expert/account/account"
// 表单实例对象
const formRef = ref<FormInstance>()
// 表单约束规则对象
const rules = reactive<FormRules>({
      username: [{required: true, message: '会员昵称不能为空', trigger:'blur'}],
      phone: [{required: true, message: '手机号不能为空', trigger:'blur'}],
      password:[{required: true, message: '密码不能为空', trigger:'blur'}],
}
)
// 点击按钮
const subLoading = ref(false)
// 注册表单数据内容
const userForm = reactive({
  username:'',
  phone:'',
  password:'',
})

const register = async (formEl: FormInstance |undefined)=> {
  if(!formRef) return
  await formEl?.validate(async (valid, fields)=>{
    subLoading.value = true
    if(valid){
      subLoading.value = true
      const {data} = await registerApi(userForm)
      if (data.status===200) {
        ElMessage.success(data.message)
      }else{
        ElMessage.error(data.message)
      }
      subLoading.value = false
    }else{
      ElMessage.error("提交表单失败，你还有未填写的项！")
    }
  })
}


</script>

<template>
<!--顶部-->
  <TopHeader/>
<!--顶部结束-->

<!--中间部分-->

  <div class="expert-container expert-data">
    <el-card class="expert-data-intro">
      <div class="register-content">
        <!--注册 start-->
        <div class ="register-bg">
          <div class="register-main">
            <div class="register-box">
              <el-form ref="formRef" :rules="rules" :model="userForm">
                <legend>
                  用户注册
                </legend>
                <el-form-item prop="username">
                  <el-input v-model="userForm.username" placeholder="请输入昵称">
                    <template #prefix>
                      <el-icon><User /></el-icon>
                    </template>
                  </el-input>
                </el-form-item>

                <el-form-item prop="phone">
                  <el-input v-model="userForm.phone" placeholder="请输入注册手机号">
                    <template #prefix>
                      <el-icon><Iphone /></el-icon>
                    </template>
                  </el-input>
                </el-form-item>

                <el-form-item prop="password">
                  <el-input type="password" v-model="userForm.password" placeholder="请输入密码">
                    <template #prefix>
                      <el-icon><Lock /></el-icon>
                    </template>
                  </el-input>
                </el-form-item>

                <el-form-item>
                  <el-button :loading="subLoading" color="#6171af" @click="register" style="width: 100%;">
                    立即注册
                  </el-button>
                </el-form-item>
              </el-form>
            </div>
          </div>
        </div>
        <!--注册结束-->
      </div>
    </el-card>
  </div>

<!--中间部分结束-->

<!--  底部-->
  <Footer/>
<!--  底部结束-->

</template>

<style scoped>
  .expert-container{
    width: 1350px;
    height: 820px;
    padding: 0;
    position: relative;
    margin: 0 auto;
    box-sizing: border-box;
  }
  .expert-data-intro{
    margin: 20px 0;
    background-color: #fff;
  }

  .register-content .register-bg{
    width: 100%;
    background: url(../../../assets/expert/image/login_bg.jpg) no-repeat;
    background-size: cover;
  }

  .register-content .register-bg .register-main{
    height: 795px;
    position: relative;
  }

  .register-content .register-bg .register-main .register-box{
    width: 320px;
    height: 290px;
    border: 1px solid #d8cfcf;
    background: #fff;
    position: absolute;
    top: 205px;
    right: 70px;
    padding: 30px 20px 1px;
  }

  .register-content .register-bg .register-main .register-box legend{
    font-size: 20px;
    color: #404553;
    text-align: center;
    padding: 12px 0;
  }
</style>