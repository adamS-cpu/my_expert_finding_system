<template>
  <div>
    <el-tree :data="treeData" :props="treeProps" @node-click="handleNodeClick" class="tree"></el-tree>
  </div>
</template>

<script lang="ts" setup>
  import {ref} from 'vue';
  const treeData=ref([
        {
          id: 1,
          label: '同学',
          children: [
            { id: 11, label: 'Alice' },
            { id: 12, label: 'Bob' },
          ],
        },
        {
          id: 2,
          label: '同事',
          children: [
            { id: 21, label: 'Charlie' },
            { id: 22, label: 'David' },
          ],
        },
        {
          id: 3,
          label: '我的关注',
          children: [
            { id: 31, label: 'Eve' },
            { id: 32, label: 'Frank' },
          ],
        },
        {
          id: 4,
          label: '我的粉丝',
          children: [
            { id: 41, label: 'Grace' },
            { id: 42, label: 'Henry' },
          ],
        },
      ],)
  const treeProps=ref({
        children: 'children',
        label: 'label'
      }) 
  const nodeClicked = ref(null);

  const handleNodeClick = (node: null) => {
    nodeClicked.value = node;
  };
</script>

<style scoped>
.tree {
  border: 1px solid #e0e0e0;
  border-radius: 5px;
  padding: 10px;
  height: 1000px;
}

.el-tree-node__content {
  padding: 5px 10px;
  transition: background-color 0.3s;
}

.el-tree-node__content:hover {
  background-color: #f0f0f0;
}
</style>