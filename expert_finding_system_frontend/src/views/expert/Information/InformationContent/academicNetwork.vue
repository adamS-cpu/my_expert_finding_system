<template>
  <div ref="Net" style="width: 100%; height: 500px;"></div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import * as echarts from 'echarts';
import academicNetworkDataset from '@/assets/expert/academicNetwork/academicNetworkDataset.json';

const Net = ref(null);

onMounted(() => {
  const myChart = echarts.init(Net.value);

  academicNetworkDataset.nodes.forEach((node) => {
    node.label = {
      show: node.symbolSize > 30,
    };
  });

  const option = {
    title: {
      text: 'academicNetwork',
      subtext: '',
      top: 'top',
      left: 'left',
    },
    tooltip: {},
    legend: [
      {
        data: academicNetworkDataset.categories.map((a) => a.name),
      },
    ],
    animationDuration: 1500,
    animationEasingUpdate: 'quinticInOut',
    series: [
      {
        name: 'academicNetwork',
        type: 'graph',
        layout: 'none',
        data: academicNetworkDataset.nodes,
        links: academicNetworkDataset.links,
        categories: academicNetworkDataset.categories,
        roam: true,
        label: {
          position: 'right',
          formatter: '{b}',
        },
        lineStyle: {
          color: 'source',
          curveness: 0.3,
        },
        emphasis: {
          focus: 'adjacency',
          lineStyle: {
            width: 10,
          },
        },
      },
    ],
  };

  myChart.setOption(option);
});
</script>
<style scoped>

</style>