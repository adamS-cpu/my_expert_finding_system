<template>
  <!-- <TopHeader/> -->

  <!-- <div class="my_container"> -->
    <div class="box">
      <div class="columns">
        <div class ="column is-one-quarter">
          <el-col :span="27">
            <div style="height: 240px;">
              <el-steps direction="vertical" :active="active_step">
                <el-step title="个人经历"></el-step>
                <el-step title="兴趣标签"></el-step>
                <el-step title="同步成果"></el-step>
              </el-steps>
            </div>
          </el-col>
        </div>
        <div class="column">
<!--          el-card1 完善个人经历-->
          <template v-if="active_step == 0">
            <el-card class="box-card">
              <template #header>

                <el-icon><location/></el-icon> 完善个人经历
              </template>
            <!--内容-->
              <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="目前状态">
                  <el-radio-group v-model="form.status">
                    <el-radio :label="1">在读</el-radio>
                    <el-radio :label="2">就职</el-radio>
                    <el-radio :label="3">其他</el-radio>
                  </el-radio-group>
                </el-form-item>
                <el-form-item label="所在机构">
                  <el-input style="width: 100%;" maxlength="20" show-word-limit placeholder="请输入当前所在研究机构" v-model="form.org"></el-input>
                </el-form-item>
                <el-form-item label="部门">
                  <el-input style="width: 80%;" maxlength="15" show-word-limit placeholder="请输入所在部门" v-model="form.dpt"></el-input>
                </el-form-item>
                <el-form-item label="职称">
                  <el-input style="width: 60%;"  maxlength="10" show-word-limit v-model="form.title" placeholder="请输入职称"></el-input>
                </el-form-item>
                <el-form-item label="开始时间">
                  <el-col :span="12">
                    <el-date-picker
                        type="date"
                        placeholder="选择日期"
                        v-model="form.date1"
                        style="width: 100%;"
                    ></el-date-picker>
                  </el-col>
                </el-form-item>
                <el-form-item label="结束时间">
                  <el-col :span="12">
                    <el-date-picker
                        type="date"
                        placeholder="选择日期"
                        v-model="form.date2"
                        style="width: 100%;"
                    ></el-date-picker>
                  </el-col>
                  <el-col :span="2"> </el-col>
                  <el-col :span="6">
                    <el-radio v-model="form.date2" :label="currentDate">至今</el-radio>
                  </el-col>
                </el-form-item>

                <el-form-item>
                  <el-button type="primary" @click="onNextStep">下一步</el-button>
                  <el-col :span="6"> </el-col>
                  <el-button>取消</el-button>
                </el-form-item>
              </el-form>
            </el-card>
          </template>

          <template v-if="active_step == 1">
            <el-card class="box-card">
              <template #header>
                <el-icon><location/></el-icon> 选择您感兴趣的学科领域
              </template>
              <!--内容-->
              <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="学科分类">
                  <el-select style="width: 50%;" @change="onSubjectChange" v-model="value" placeholder="请选择">
                    <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value"
                    >
                    </el-option>
                  </el-select>
                </el-form-item>

                <el-form-item label="子领域">
                  <el-select style="width: 60%;" v-model="sub_value">
                    <el-option
                        v-for="item in sub_option"
                        :key="item.value"
                        :label="item.label"
                        :value="item.label"
                    >
                    </el-option>
                  </el-select>
                  <el-col :span="2"> </el-col>
                  <el-button type="success" @click="addTag">添加</el-button>
                </el-form-item>

                <el-form-item label="已选择">
                  <div class="box" style="height: 140px; width:360px;">
                    <el-tag
                        :key="tag"
                        v-for="tag in tag_list"
                        closable
                        :disable-transitions="false"
                        @close="handleClose(tag)"
                    >
                      {{tag}}
                    </el-tag>
                    <el-input
                        class="input-new-tag"
                        v-if="inputVisible"
                        v-model="inputValue"
                        ref="saveTagInput"
                        size="small"
                        @keyup.enter="handleInputConfirm"
                        @blur="handleInputConfirm"
                    >
                    </el-input>
                    <el-button v-else class="button-new-tag" size="small" @click="showInput"
                    >+ 自定义标签</el-button
                    >
                  </div>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="onNextStep">下一步</el-button>
                  <el-col :span="6"> </el-col>
                  <el-button @click="onPreStep">上一步</el-button>
                </el-form-item>
              </el-form>
            </el-card>
          </template>

          <template v-if="active_step == 2">
            <el-card class="box-card">
              <template #header>
                <div class="columns">
                  <div class = "column is-four-fifths">
                    <el-icon><location/></el-icon> 导入学术信息
                  </div>
                  <div class = "column">
                    <el-button @click="onComplete">跳过</el-button>
                  </div>
                </div>
              </template>
              <!--内容-->
              <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="邮箱">
                  <el-input style="width: 80%;" placeholder="请输入谷歌学术绑定邮箱" v-model="form.org"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                  <el-input style="width: 50%;" placeholder="请输入您的真实姓名" v-model="form.dpt"></el-input>
                </el-form-item>

                <el-form-item label="进行校验">
                  <el-button type="primary" @click="dialogVisible = true">校验信息</el-button>
                </el-form-item>
                <el-form-item>
                  <el-button type="success" @click="onComplete">完成</el-button>
                  <el-col :span="6"> </el-col>
                  <el-button @click="onPreStep">上一步</el-button>
                </el-form-item>
              </el-form>
            </el-card>
          </template>
        </div>
      </div>
    </div>
  <!-- </div> -->

</template>

<script>
import {Location} from "@element-plus/icons-vue";
import TopHeader from "@/views/expert/comm/header/TopHeader.vue";
import Footer from "@/views/expert/comm/bottom/Footer.vue";
import { userStore } from '@/store/userStore';
import { defineEmits } from 'vue';
// 定义 emit 函数用来发出事件
const emit = defineEmits(['close-dialog']);
export default {
  components: {Location},
  data() {
    return {
      tableData: [
        {
          title: 'Learning Only When It Matters: Cost-Aware Long-Tailed Classification',
          abstract: 'Most current long-tailed classification approaches assume the cost-agnostic scenario, where the training distribution of classes is long-tailed while the testing distribution of classes is balanced. Meanwhile, the misclassification...',
          authors: 'YC He, YX Ding, HJ Ye, ZH Zhou',
          venue: 'Proceedings of the AAAI Conference on Artificial Intelligence, 2024',
          public_time: '2024',
          citation_num: 0,
          fields: 'ML: Multi-class/Multi-label Learning & Extreme Classification',
        },
        {
          title: 'Safe Abductive Learning in the Presence of Inaccurate Rules',
          abstract: 'xxx',
          authors: 'XW Yang, JJ Shao, WW Tu, YF Li, WZ Dai, ZH Zhou',
          venue: 'xxx',
          public_time: '2024',
          citation_num: 0,
          fields: 'data mining, data science',
        },
        {
          title: 'Towards Making Learnware Specification and Market Evolvable',
          abstract: '江浙小吃、小吃零食',
          authors: 'LF Li, P Zhao, ZH Zhou',
          venue: 'xxx',
          public_time: '2024',
          citation_num: 0,
          fields: 'data mining, data science',
        },
        {
          title: 'Improved Algorithm for Adversarial Linear Mixture MDPs with Bandit Feedback and Unknown Transition',
          abstract: '江浙小吃、小吃零食',
          authors: 'XR Xie, MJ Yuan, X Bai, W Gao, ZH Zhou',
          venue: 'xxx',
          public_time: '2024',
          citation_num: 0,
          fields: 'data mining, data science',
        },
      ],
      form: {
        status: 1,
        org: '',
        title: '',
        date1: '',
        date2: '',
        dpt: '',
      },
      user_information: {
        name: '',
        org: '',
        tag: '',
        export_num: 5,
      },
      options: [
        {
          value: '0',
          label: 'a.数理科学',
        },
        {
          value: '1',
          label: 'b.化学科学',
        },
        {
          value: '2',
          label: 'c.生命科学',
        },
        {
          value: '3',
          label: 'd.工程与材料科学',
        },
        {
          value: '4',
          label: 'e.信息科学',
        },
      ],
      subOptions0: [
        {
          value: 'a1',
          label: 'a01.代数与几何',
        },
        {
          value: 'a2',
          label: 'a02.数学分析学',
        },
        {
          value: 'a3',
          label: 'a03.微分方程与动力系统',
        },
        {
          value: 'a4',
          label: 'a04.统计与运筹',
        },
        {
          value: 'a5',
          label: 'a05.计算数学',
        },
        {
          value: 'a6',
          label: 'a06.动力学与控制',
        },
      ],
      subOptions4: [
        {
          value: 'e1',
          label: 'e01.电子学与信息系统',
        },
        {
          value: 'e2',
          label: 'e02.计算机科学',
        },
        {
          value: 'e3',
          label: 'e03.自动化',
        },
        {
          value: 'e4',
          label: 'e04.半导体科学与信息器件',
        },
        {
          value: 'e5',
          label: 'e05.光学与光电子学',
        },
        {
          value: 'e6',
          label: 'e06.人工智能',
        },
      ],
      value: '',
      sub_value: '',
      sub_option: [
        {
          value: 'unselected',
          label: '请先选择学科分类',
        },
      ],
      tag_list: [

      ],
      inputVisible: false,
      inputValue: '',
      active_step: 0,
      dialogVisible: false,
    }
  },
  methods: {
    onNextStep() {
      if (this.active_step++ > 2) this.active_step = 0
    },
    onPreStep() {
      if (this.active_step-- < 0) this.active_step = 0
    },
    onComplete(){
      // userStore.completeSettings();
      // emit('close-dialog');
      this.$emit('close-dialog');
      this.$router.push('/index');
    },
    addTag(){
      this.tag_list.push(this.sub_value)
    },
    onSubjectChange(){
      // 以后需要用接口实现
      if (this.value == '0')
        this.sub_option = this.subOptions0
      if (this.value == '4')
        this.sub_option = this.subOptions4
      this.sub_value = this.sub_option[0].label
    },
    handleClose(tag) {
      this.tag_list.splice(this.tag_list.indexOf(tag), 1)
    },

    showInput() {
      this.inputVisible = true
      this.$nextTick((_) => {
        this.$refs.saveTagInput.$refs.input.focus()
      })
    },
    handleInputConfirm() {
      let inputValue = this.inputValue
      if (inputValue) {
        this.tag_list.push(inputValue)
      }
      this.inputVisible = false
      this.inputValue = ''
    },
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

<style scoped>

.my_container{
  /* width: 45%;
  align-items: center;
  height: 60%; */
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  height: 100vh; /* 使容器高度填满视口高度 */
  width: 100vw; /* 使容器宽度填满视口宽度 */
  
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.box-card {
  width: 500px;
  
}
.table-box{
  width: 95%;
}
.el-tag + .el-tag {
  margin-left: 10px;
}
.button-new-tag {
  margin-left: 10px;
  height: 32px;
  line-height: 30px;
  padding-top: 0;
  padding-bottom: 0;
}
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}


.my_container {
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  height: 100vh; /* 使容器高度填满视口高度 */
  width: 100vw; /* 使容器宽度填满视口宽度 */
}

.box {
  display: flex;
  flex-direction: column; /* 垂直布局 */
  align-items: center; /* 内容居中 */
  width: 100%;
  max-width: 1200px; /* 最大宽度，根据需要调整 */
}

.columns {
  width: 100%; /* 列宽度占满容器 */
  display: flex;
  justify-content: space-between; /* 列之间的间距 */
}

.box-card {
  flex: 1; /* 卡片占满剩余空间 */
  margin: 10px;
}

</style>