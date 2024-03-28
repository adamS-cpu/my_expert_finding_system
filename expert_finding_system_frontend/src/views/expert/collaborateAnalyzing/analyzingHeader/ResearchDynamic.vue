<script setup lang="ts">
import {onMounted, reactive, ref} from "vue";
import {getDynamicListApi} from "@/api/expert/dynamic/dynamic";
import {Search} from '@element-plus/icons-vue'

const activeFiled = reactive({
  name : '全部',
})

const DynamicList = ref({})

const getDynamicList = async() =>{
  const {data} = await getDynamicListApi()
  DynamicList.value = data.result.DynamicList
}

const pageSize = ref(12)
const pageIndex = ref(1)
const total = ref(2)

const handleClick = async ()=> {
  DynamicList = null
  getDynamicList()
}

onMounted(()=>{
  getDynamicList()
})
</script>

<template>
  <div>
    <el-card shadow="never">
      <template #header>
        <el-tabs v-model="activeFiled" @tab-click="handleClick">
          <el-tab-pane label="全部" name="data mining">
            <div v-for="item in DynamicList" :key="item" class="text item">
              <el-card style="height: 220px" shadow="never">
                <template #header style="height: 60px" >
                  <div class="columns">
                    <div class="column">
                      <router-link :to="{path:'expert/user', query:{id:item.id}}">
                        <img src= "@/assets/expert/image/example-user-icon-small.png" style="border: 1px solid lightgray; border-radius: 10px;" alt="user-icon" />
                      </router-link>
                    </div>
                    <div class="column is-four-fifths">
                      <p style="font-size: 18px">Raghu Machiraju</p>
                      <p style="font-size: 12px">Ohio State University, USA</p>
                    </div>

                    <div class="column">
                    </div>


                  </div>
                </template>
                <div class="columns">
                  <div class="column">
                    <img src= "@/assets/expert/image/paper.png" style="border: 1px solid lightgray; border-radius: 10px;" alt="user-icon" />
                  </div>
                  <div class="column is is-three-fifths">
                    <p style="font-size: 18px">{{item.content}}</p>
                    <p style="font-size: 12px">{{item.user_name}}</p>
                    <p style="font-size: 12px"> {{item.venue}}，{{item.field_name}}，{{item.create_time}}</p>
                  </div>
                  <div class="column is-one-quarter"/>
                </div>
              </el-card>
            </div>
          </el-tab-pane>
          <el-tab-pane label="数据挖掘" name="data mining">
            <!--            <div v-for="item in DynamicList" :key="item" class="text item">-->
            <!--              <el-card style="height: 220px" shadow="never">-->
            <!--                <template #header style="height: 60px" >-->
            <!--                  <div class="columns">-->
            <!--                    <div class="column">-->
            <!--                      <router-link :to="{path:'expert/user', query:{id:item.id}}">-->
            <!--                        <img src= "@/assets/expert/image/example-user-icon-small.png" style="border: 1px solid lightgray; border-radius: 10px;" alt="user-icon" />-->
            <!--                      </router-link>-->
            <!--                    </div>-->
            <!--                    <div class="column">-->
            <!--                      <p style="font-size: 18px">{{item.user_name}}</p>-->
            <!--                      <p style="font-size: 12px">浙江大学</p>-->
            <!--                    </div>-->
            <!--                    <div class="column is-one-fifth"/>-->
            <!--                    <div class="column is-one-fifth"/>-->
            <!--                    <div class="column is-one-fifth"/>-->
            <!--                    <div class="column is-one-fifth">-->
            <!--                      <el-button type="primary">查看他的所有更新</el-button>-->
            <!--                    </div>-->

            <!--                  </div>-->
            <!--                </template>-->
            <!--                <div class="columns">-->
            <!--                  <div class="column">-->
            <!--                    <img src= "@/assets/expert/image/paper.png" style="border: 1px solid lightgray; border-radius: 10px;" alt="user-icon" />-->
            <!--                  </div>-->
            <!--                  <div class="column is is-three-fifths">-->
            <!--                    <p style="font-size: 18px">{{item.content}}</p>-->
            <!--                    <p style="font-size: 12px">{{item.user_name}}</p>-->
            <!--                    <p style="font-size: 12px"> ACM Trans. Recomm. Syst.，{{item.field_name}}，{{item.create_time}}</p>-->
            <!--                  </div>-->
            <!--                  <div class="column is-one-quarter"/>-->
            <!--                </div>-->
            <!--              </el-card>-->
            <!--            </div>-->
          </el-tab-pane>
        </el-tabs>
      </template>
      <!--分页-->
      <el-pagination background layout="total,prev,pager,next,jumper" :total="total" v-model:page_size="pageSize">
      </el-pagination>
    </el-card>
  </div>
</template>

<style scoped>

</style>