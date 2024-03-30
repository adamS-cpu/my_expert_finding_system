import request from "../../request"
export function getBillboardApi(){
    return request({
        url: 'userDynamic/getBillboard',
        method: 'get',
    })
}

export function getUserListApi3(){
    return request({
        url: 'expert/user/getUserList/key=3',
        method: 'get',
    })
}

export function getUserListApi5(){
    return request({
        url: 'expert/user/getUserList/key=5',
        method: 'get',
    })
}


export function getDynamicListApi(){
    return request({
        url: 'userDynamic/allList',
        method: 'get',
    })
}