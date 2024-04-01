// store/scholarsStore.ts

import { defineStore } from 'pinia';
import { ref } from 'vue';
import scholarData from "@/assets/expert/newdata.json";

// 假设的生成学者数组的函数
function generateScholars() {
  // 生成学者数据的逻辑
  // 模拟的领域和名字数据
  const fields = ["计算机视觉","自然语言处理","深度学习","强化学习","生成对抗网络","机器学习理论","数据挖掘","语音识别","图像处理"];
  const names = [
      "张伟", "王芳", "李伟", "张敏", "李静", "张丽", "王静", "王丽",
      "李强", "张磊", "王军", "李军", "王勇", "张勇", "李杰", "张杰", "王杰", "李娟",
      "赵思琪", "钱晓生", "孙悟空", "李白云", "周杰伦", "吴语嫣", "郑小琪", "王大雷",
      "杨过", "林黛玉", "薛宝钗", "贾宝玉", "陆小凤", "西门吹雪", "司马懿", "诸葛亮",
      "慕容复", "乔峰", "段誉", "虚竹", "黄蓉", "郭靖", "杨康", "穆念慈"
  ];
  const universities = [
      "北京大学",
      "清华大学",
      "斯坦福大学",
      "麻省理工学院",
      "哈佛大学",
      "加州理工学院",
      "牛津大学",
      "剑桥大学",
      "伦敦大学学院",
      "帝国理工学院",
      "芝加哥大学",
      "耶鲁大学",
      "加州大学伯克利分校",
      "哥伦比亚大学",
      "普林斯顿大学",
      "康奈尔大学",
      "宾夕法尼亚大学",
      "密歇根大学",
      "约翰霍普金斯大学",
      "多伦多大学"
  ];
  let scholars = []; // 直接使用一个普通数组

  // 生成50个学者模拟数据
  for (let i = 0; i < 50; i++) {
      const nameIndex = i % names.length;
      const fieldIndexes = new Set();
      const numberOfFields = Math.floor(Math.random() * 5) + 1; // 确定1到5个标签的随机数
      const universityIndex = Math.floor(Math.random() * universities.length); // 随机选择大学
      while (fieldIndexes.size < numberOfFields) { // 根据随机确定的标签数量来填充
          const fieldIndex = Math.floor(Math.random() * fields.length);
          fieldIndexes.add(fields[fieldIndex]);
      }
      const scholarFields = Array.from(fieldIndexes);
      scholars.push({
          id: i,
          name: names[nameIndex],
          affiliation: universities[universityIndex], // 使用真实的大学名称
          field: scholarFields
      });
  }
  return scholars;
}


export const useScholarsStore = defineStore('scholars', () => {
  const scholars = ref(scholarData.scholars);
  
  // 返回状态和操作
  return { scholars };
});
