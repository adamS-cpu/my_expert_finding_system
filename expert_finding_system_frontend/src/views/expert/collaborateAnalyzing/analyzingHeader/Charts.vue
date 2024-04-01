<template>
  <el-card>
    <template #header>
      研究兴趣分布对比
    </template>
    <div id="mainofRadar" style="width: 600px;height:400px;"></div>
  </el-card>
</template>

<script lang="ts" setup>

import * as echarts from 'echarts/core';
import {
  TitleComponent,
  TitleComponentOption,
  LegendComponent,
  LegendComponentOption
} from 'echarts/components';
import { RadarChart, RadarSeriesOption } from 'echarts/charts';
import { CanvasRenderer } from 'echarts/renderers';
import { onMounted } from 'vue';
import {Location} from "@element-plus/icons-vue";


echarts.use([TitleComponent, LegendComponent, RadarChart, CanvasRenderer]);
type EChartsOption = echarts.ComposeOption<
  TitleComponentOption | LegendComponentOption | RadarSeriesOption
>;
onMounted(()=>{
  var chartDom = document.getElementById('mainofRadar')!;
  var myChart = echarts.init(chartDom);
  var option: EChartsOption;

  option = {
    title: {
      text: '研究兴趣分布'
    },
    legend: {
      data: ['我', '高尉']
    },
    radar: {
      // shape: 'circle',
      indicator: [
        { name: '深度学习', max: 6500 },
        { name: '人工智能', max: 16000 },
        { name: '复杂性科学与人工智能理论', max: 30000 },
        { name: '数据挖掘', max: 38000 },
        { name: '机器学习', max: 52000 }
      ]
    },
    series: [
      {
        name: 'Budget vs spending',
        type: 'radar',
        data: [
          {
            value: [4200, 10000, 20000, 35000, 50000, 18000],
            name: '我'
          },
          {
            value: [5000, 14000, 28000, 26000, 42000, 21000],
            name: '高尉'
          }
        ]
      }
    ]
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