<script setup lang="ts">
import TopHeader from "@/views/expert/comm/header/TopHeader.vue"
import Footer from "@/views/expert/comm/bottom/Footer.vue"
import { ref, reactive } from "vue";
import DynamicList from "@/views/expert/expertFinding/Dynamic/show/DynamicList.vue";
import DynamicCard from "@/views/expert/expertFinding/Dynamic/show/DynamicCard.vue";
import AnalyzingHeader from "@/views/expert/collaborateAnalyzing/analyzingHeader/AnalyzingHeader.vue";
import AnalyzingContent from "@/views/expert/collaborateAnalyzing/analyzingHeader/AnalyzingContent.vue";
import Recommendation from "@/views/expert/collaborateAnalyzing/analyzingRecommendation/Recommendation.vue";
import MyIntroduction from "@/views/expert/Information/InformationHead/MyIntroduction.vue";

const user = ref({
  avatar: "@/assets/expert/image/example-user-icon.png",
  name: "张三",
  bio: "数据挖掘领域的学者",
});

defineExpose({user});

const sendMessage = () => {
  // 发送消息的逻辑
  console.log("发送消息给", user.value.name);
};

</script>

<template>
  <!--顶部-->
  <TopHeader/>
  <!--顶部结束-->

  <!--中间部分-->
  <div class="box"> <MyIntroduction/> </div>

  <div class="columns">
    <div class="column is-three-quarters">

    </div>
    <div class="column">

    </div>
  </div>


  <!--中间部分结束-->

  <!--  底部-->
  <Footer/>
  <!--  底部结束-->

</template>

<style scoped>


</style>