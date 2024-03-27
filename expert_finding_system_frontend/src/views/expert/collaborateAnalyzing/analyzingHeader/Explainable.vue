<template>
  <el-row :gutter="16">
    <el-col :span="8">
      <div class="statistic-card">
        <el-statistic :value="89">
          <template #title>
            <div style="display: inline-flex; align-items: center">
              你们的研究兴趣相似性得分为
              <el-tooltip
                  effect="dark"
                  content="你们所拥有的共同研究内容得分经平滑后的归一化标准值*100"
                  placement="top"
              >
                <el-icon style="margin-left: 4px" :size="12">
                  <Warning />
                </el-icon>
              </el-tooltip>
            </div>
          </template>
        </el-statistic>
        <div class="statistic-footer">
          <div class="footer-item">
            <span>最大的共同兴趣是</span>
            <span class="green">
              网络分析
              <el-icon>
                <CaretTop />
              </el-icon>
            </span>
          </div>
        </div>
      </div>
    </el-col>
    <el-col :span="8">
      <div class="statistic-card">
        <el-statistic :value="83">
          <template #title>
            <div style="display: inline-flex; align-items: center">
              你们的共同好友得分为
              <el-tooltip
                  effect="dark"
                  content="你们所拥有的共同好友得分经平滑后的归一化标准值*100"
                  placement="top"
              >
                <el-icon style="margin-left: 4px" :size="12">
                  <Warning />
                </el-icon>
              </el-tooltip>
            </div>
          </template>
        </el-statistic>
        <div class="statistic-footer">
          <div class="footer-item">
            <span>可能因为钱九而互相认识</span>
            <span class="red">
              钱九
              <el-icon>
                <CaretBottom />
              </el-icon>
            </span>
          </div>
        </div>
      </div>
    </el-col>
    <el-col :span="8">
      <div class="statistic-card">
        <el-statistic :value="73" title="你们的专业知识互补性得分为">
          <template #title>
            <div style="display: inline-flex; align-items: center">
              你们的专业知识互补性得分为
            </div>
            <el-tooltip
                effect="dark"
                content="你们知识的互补性得分经平滑后的归一化标准值*100"
                placement="top"
            >
              <el-icon style="margin-left: 4px" :size="12">
                <Warning />
              </el-icon>
            </el-tooltip>
          </template>
        </el-statistic>
        <div class="statistic-footer">
          <div class="footer-item">
            <span>良好的合作背景知识</span>
            <span class="green">
              聚类算法与蛋白质交互
              <el-icon>
                <CaretTop />
              </el-icon>
            </span>
          </div>
          <div class="footer-item">
            <el-icon :size="14">
              <ArrowRight />
            </el-icon>
          </div>
        </div>
      </div>
    </el-col>
  </el-row>
  <div id="mainofPie" style="width: 600px;height:400px;"></div>
</template>

<script lang="ts" setup>
import {
  ArrowRight,
  CaretBottom,
  CaretTop,
  Warning,
} from '@element-plus/icons-vue'
import * as echarts from 'echarts/core';
import {
  TitleComponent,
  TitleComponentOption,
  PolarComponent,
  PolarComponentOption,
  TooltipComponent,
  TooltipComponentOption
} from 'echarts/components';
import { BarChart, BarSeriesOption } from 'echarts/charts';
import { CanvasRenderer } from 'echarts/renderers';
import { onMounted } from 'vue';

echarts.use([
  TitleComponent,
  PolarComponent,
  TooltipComponent,
  BarChart,
  CanvasRenderer
]);

type EChartsOption = echarts.ComposeOption<
  | TitleComponentOption
  | PolarComponentOption
  | TooltipComponentOption
  | BarSeriesOption
>;
onMounted(()=>{
  var chartDom = document.getElementById('mainofPie')!;
  var myChart = echarts.init(chartDom);
  var option: EChartsOption;

  option = {
    title: [
      {
        text: '可解释性分析'
      }
    ],
    polar: {
      radius: [40, '90%']
    },
    radiusAxis: {
      max: 4
    },
    angleAxis: {
      type: 'category',
      data: ['研究兴趣相似性得分', '共同好友得分', '专业知识互补性得分'],
      startAngle: 50
    },
    tooltip: {},
    series: {
      type: 'bar',
      data: [0.89, 0.83, 0.73],
      coordinateSystem: 'polar',
      label: {
        show: true,
        position: 'middle', // or 'start', 'insideStart', 'end', 'insideEnd'
        formatter: '{b}: {c}'
      }
    },
    animation: false
  };

  option && myChart.setOption(option);

  })
</script>

<style scoped>
:global(h2#card-usage ~ .example .example-showcase) {
  background-color: var(--el-fill-color) !important;
}

.el-statistic {
  --el-statistic-content-font-size: 28px;
}

.statistic-card {
  height: 100%;
  padding: 20px;
  border-radius: 4px;
  background-color: var(--el-bg-color-overlay);
}

.statistic-footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  font-size: 12px;
  color: var(--el-text-color-regular);
  margin-top: 16px;
}

.statistic-footer .footer-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.statistic-footer .footer-item span:last-child {
  display: inline-flex;
  align-items: center;
  margin-left: 4px;
}

.green {
  color: var(--el-color-success);
}
.red {
  color: var(--el-color-error);
}
</style>