

<template>
  <div class="chat-box">
    <el-chat-list class="message-list">
      <el-chat-item
        v-for="(message, index) in messages"
        :key="index"
        :class="{ 'my-message': message.isMe }"
      >
        {{ message.text }}
      </el-chat-item>
    </el-chat-list>
    <div class="input-box">
      <el-input v-model="inputText" placeholder="输入消息"></el-input>
      <el-button class="send-button" @click="sendMessage">发送</el-button>
    </div>
  </div>
</template>

<script lang="ts" setup>
  import { nextTick, onMounted, ref } from "vue";
  const inputText = ref('');
    const messages = ref([
      { text: 'Hello', isMe: true },
      { text: 'Hi', isMe: false },
      { text: 'How are you?', isMe: true },
      { text: "I'm fine, thanks!", isMe: false },
    ]);

    const sendMessage = () => {
      const text = inputText.value.trim();
      if (text) {
        const newMessage = {
          text: text,
          isMe: true,
        };
        messages.value.push(newMessage);
        inputText.value = '';

        // 滚动到底部
        nextTick(() => {
          const messageList = document.querySelector('.message-list');
          messageList?.scrollTo?.(0, messageList.scrollHeight);
        });
      }
    };

    // 在组件挂载完成后滚动到底部
    onMounted(() => {
      nextTick(() => {
        const messageList = document.querySelector('.message-list');
        messageList?.scrollTo?.(0, messageList.scrollHeight);
      });
    });
</script>

<style scoped>
  .chat-box {
  display: flex;
  flex-direction: column;
  height: 400px;
  border: 1px solid #ccc;
  border-radius: 4px;
  overflow: hidden;
}

.message-list {
  flex: 1;
  padding: 10px;
  overflow-y: auto;
  scrollbar-width: thin;
}

.my-message {
  align-self: flex-end;
}

.input-box {
  display: flex;
  align-items: center;
  padding: 10px;
  border-top: 1px solid #ccc;
}

.send-button {
  margin-left: 10px;
}
</style>