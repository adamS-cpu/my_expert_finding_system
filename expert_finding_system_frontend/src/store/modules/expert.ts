import { defineStore } from 'pinia'
export const useExpertStore = defineStore({
    id: 'expertStore',
    state: ()=> {
        return {
            // 会员登录token
            expertToken: '',
            // 登录会员信息
            expertInfo: {
                expertIcon: '',
                nickname: ''
            }
        }
    },
    getters: {},
    actions: {
        // 设置会员登录token
        setExpertToken(token:string){
            this.expertToken = token
        },
        setExpertInfo(expertInfo: any){
            this.expertInfo = expertInfo
        },
        // 更新部分会员信息
        setPartExpertInfo(expertInfo:any){
            this.expertInfo.expertIcon = expertInfo.userIcon
            this.expertInfo.nickname = expertInfo.nickname
        },
    },
    persist: true
})
