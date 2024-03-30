import request from "../../request"
export function registerApi(data:object){
    return request({
        url: 'expert/account/register',
        method: 'post',
        data
    })
}

export function loginApi(data:object){
    return request({
        url: 'expert/account/login',
        method: 'post',
        data
    })
}