// src/store/userStore.js
import { defineStore } from 'pinia';

export const userStore = defineStore({
  id: 'user',
  state: () => ({
    isFirstLogin: true, // 假设所有用户初始都是第一次登录
  }),
  actions: {
    // 调用这个方法来标记用户已经完成了第一次登录的设置
    completeFirstLogin() {
      this.isFirstLogin = false;
    },
    completeSettings() {
        // 假设完成设置后你要做的事情，比如更新 isFirstLogin 状态
        this.isFirstLogin = false;
      },
  },
});
