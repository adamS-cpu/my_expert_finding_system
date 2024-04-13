<template>
  <div ref="chartDiv" style="width: 100%; height: 500px;"></div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import * as echarts from 'echarts';
import socialRelationDataset from '@/assets/expert/teamInfo/teamRelation.json';

const chartDiv = ref(null);

onMounted(() => {
  const myChart = echarts.init(chartDiv.value);

  const option = {
    title: {
      // text: 'socialRelation',
      subtext: '',
      top: 'top',
      left: 'left',
    },
    tooltip: {},
    legend: [
      {
        data: socialRelationDataset.categories.map((a) => a.name),
      },
    ],
    series: [
      {
        name: 'socialRelation',
        type: 'graph',
        layout: 'force',
        data: socialRelationDataset.nodes.map((node) => ({
          ...node,
          symbolSize: 40,
        })),
        links: socialRelationDataset.links,
        categories: socialRelationDataset.categories,
        roam: true,
        label: {
          position: 'left',
        },
        force: {
          repulsion: 3000,
        },
      },
    ],
  };

  myChart.setOption(option);
});
</script>

<style scoped>

</style>