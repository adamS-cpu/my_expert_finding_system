import { defineStore } from 'pinia'
export const useDataStore = defineStore({
    id: 'dataStore',
    state: ()=> {
        return {
            // 登录token
            token: '',
            // 登录用户信息
            dataInfo: {
                user: {
                    avatar: "https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png",
                    name: "张三",
                    bio: "数据挖掘领域的学者",
                },
            },
            // 角色
            roles: []
        }
    },
    getters: {},
    actions: {
        // 设置登录token
        setToken(token:string){
            this.token = token
        },
    },
    persist: true
})
