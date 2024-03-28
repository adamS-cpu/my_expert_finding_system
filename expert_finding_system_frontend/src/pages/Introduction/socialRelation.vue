<template>
  <div ref="chart" style="width: 600px; height: 400px;"></div>
</template>

<script lang="ts">
  import * as echarts from 'echarts';
  // 导入本地 JSON 文件
  import graph from '@/assets/les-miserables.json';

  export default {
    name: 'LesMiserablesChart',
    mounted() {
      this.initChart();
    },
    methods: {
      initChart() {
        const ChartDom = this.$refs.chart;
        const myChart = echarts.init(ChartDom);
        const option = {
          tooltip: {},
          legend: [
            {
              data: graph.categories.map((a) => a.name),
            },
          ],
          series: [
            {
              name: 'Les Miserables',
              type: 'graph',
              layout: 'none',
              data: graph.nodes,
              links: graph.links,
              categories: graph.categories,
              roam: true,
              label: {
                show: true,
                position: 'right',
                formatter: '{b}',
              },
              labelLayout: {
                hideOverlap: true,
              },
              scaleLimit: {
                min: 0.4,
                max: 2,
              },
              lineStyle: {
                color: 'source',
                curveness: 0.3,
              },
            },
          ],
        };
        myChart.setOption(option);
      },
    },
  };
</script>

<style scoped>

</style>