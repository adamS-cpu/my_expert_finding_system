<script setup lang="ts">
import TopHeader from "@/views/expert/comm/header/TopHeader.vue"
import Footer from "@/views/expert/comm/bottom/Footer.vue"
import { ref, reactive} from 'vue'
import {ElMessage, FormInstance, FormRules} from "element-plus"
import {loginApi} from "@/api/expert/account/account"
import {useRouter} from 'vue-router'
import {useExpertStore} from '@/store/modules/expert'

// 校验
const formRef = ref<FormInstance>()
// 表单约束规则对象
const rules = reactive<FormRules>({
  phone: [{required: true, message: '手机号不能为空', trigger:'blur'}],
  password:[{required: true, message: '密码不能为空', trigger:'blur'}],
})

// 点击按钮
const subLoading = ref(false)
// 注册表单数据内容
const userForm = reactive({
  phone:'',
  password:'',
})

// 获取路由对象
const router = useRouter()

// 获取用户对象
const userStore = useExpertStore()

const login = async (formEl: FormInstance |undefined)=> {
  if(!formRef) return
  await formEl?.validate(async (valid, fields)=>{
    subLoading.value = true
    if(valid){
      subLoading.value = true
      const {data} = await loginApi(userForm)
      if (data.status===200) {
        // 用户token
        userStore.setExpertToken(data.result.expertToken)
        // 用户信息
        userStore.setExpertInfo({
          expertIcon: data.result.userIcon,
          nickname: data.result.username
        })
        ElMessage.success(data.message)
        // 跳转到首页
        router.push({
          path: '/index'
        })
      }else{
        ElMessage.error(data.message)
      }
      subLoading.value = false
    }else {
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
      <div class="login-content">
        <!--注册 start-->
        <div class ="login-bg">
          <div class="login-main">
            <div class="login-box">
              <el-form :model="userForm">
                <legend>
                  用户登录
                </legend>
                <el-form-item>
                  <el-input v-model="userForm.phone" placeholder="请输入手机号">
                    <template #prefix>
                      <el-icon><Iphone/></el-icon>
                    </template>
                  </el-input>
                </el-form-item>

                <el-form-item>
                  <el-input type="password" v-model="userForm.password" placeholder="请输入密码">
                    <template #prefix>
                      <el-icon><Lock /></el-icon>
                    </template>
                  </el-input>
                </el-form-item>

                <el-form-item>
                  <el-button :loading="subLoading" color="#6171af" @click="login" style="width: 100%;">
                    登录
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

.login-content .login-bg{
  width: 100%;
  background: url(../../../assets/expert/image/login_bg.jpg) no-repeat;
  background-size: cover;
}

.login-content .login-bg .login-main{
  height: 795px;
  position: relative;
}

.login-content .login-bg .login-main .login-box{
  width: 280px;
  height: 225px;
  border: 1px solid #d8cfcf;
  background: #fff;
  position: absolute;
  top: 205px;
  right: 70px;
  padding: 30px 20px 1px;
}

.login-content .login-bg .login-main .login-box legend{
  font-size: 20px;
  color: #404553;
  text-align: center;
  padding: 6px 0 20px;
}
</style>