<template>
  <div ref="chart" style="width: 100%; height: 100%;"></div>
</template>

<script>
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
      const chartDom = this.$refs.chart;
      const myChart = echarts.init(chartDom);
      this.myChart = myChart;
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
      // 添加点击事件监听
      myChart.on('click', (params) => {
        if (params.componentType === 'series' && params.seriesType === 'graph' 
        && params.dataType === 'node') {
          // 发射自定义事件，params为点击的节点数据
          this.$emit('node-clicked', params.data);
        }
      });

    },
    highlightNodeInChart(nodeId) {
      // 直接使用nodeId作为dataIndex来高亮节点
      this.myChart.dispatchAction({
        type: 'highlight',
        seriesIndex: 0, // 假设图表只有一个系列且其索引为0
        dataIndex: nodeId // 因为id即为索引，直接使用nodeId
      });
      // 如果需要，这里还可以添加逻辑来调整图表视图，将视图中心移动到高亮的节点

    },
  },
};
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