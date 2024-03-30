import request from "../../request"
export function getRoleListApi(params:object){
    return request({
        url: 'role',
        method: 'get',
        params
    })
}

// 添加角色
export function addRoleApi(data:object){
    return request({
        url: 'role',
        method: 'post',
        data
    })
}

// 根据ID获取角色信息
export function getRoleApi(id:number){
    return request({
        url: `role/${id}`,
        method: 'get'
    })
}

// 更新角色信息
export function editRoleApi(data:object){
    return request({
        url: 'role',
        method: 'put',
        data
    })
}

// 根据ID删除角色信息
export function deleteRoleApi(id:number) {
    return request({
        url: `role/${id}`,
        method: 'delete'
    })
}
