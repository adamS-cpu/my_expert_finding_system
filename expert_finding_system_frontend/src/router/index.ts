// 1、导入Vue Router模块
import { createRouter,createWebHashHistory } from 'vue-router'
import Nprogress from "../config/nprogress";
import {useUserStore} from "../store/modules/user";
import {useMenuStore} from "../store/modules/menu";
import {useMemberStore} from "../store/modules/member";
import achievementExhibition from "../pages/Introduction/achievementExhibition.vue";
import personalInfo from "../pages/Introduction/personalInfo.vue";
import socialRelation from "../pages/Introduction/socialRelation.vue";

// 定义一些路由，每一个都需要映射到一个组件

// 定义静态路由
export const staticRouter = [
    {
        path: '/',
        // redirect: '/expert/index',
        redirect: '/index',
        meta: {title: '发现-首页'},
    },
    {
        path: '/expert',
        name: 'Expert',
        redirect: '/index',
        isMenu: false,
        children: [
            {
                path: 'dynamic',
                name: 'Dynamic',
                meta: {
                    title: '用户动态',
                },
                component: ()=> import('@/views/expert/expertFinding/Dynamic/Dynamic.vue'),
            },
            {
                path: 'analyzing',
                name: 'Analyzing',
                meta: {
                    title: '合作分析',
                },
                component: ()=> import('@/views/expert/collaborateAnalyzing/Analyzing.vue'),
            },
            {
                path: 'myInfo',
                name: 'information',
                meta: {
                    title: '我的主页',
                },
                component: ()=> import('@/views/expert/Information/Introduction.vue'),
                children:[
                    {
                        path:'achievementExhibition',
                        
                        component:achievementExhibition
                    },
                    {
                        path:'personalInfo',
                        
                        component:personalInfo
                    },
                    {
                        path:'socialRelation',
                        
                        component:socialRelation
                    },
                ]
            },
            {
                path: 'register',
                name: 'Register',
                meta: {title: '跨领域专家发现系统-注册账户'},
                component: ()=> import('@/views/expert/account/Register.vue')
            },
            {
                        path: 'login',
                        name: 'Login',
                        meta: {title: '跨领域专家发现系统-用户登录'},
                        component: ()=> import('@/views/expert/account/Login.vue')
            },
        ]
    },
    {
        path: '/index',
        name: 'Index',
        meta: {title: '跨领域专家发现系统-发现'},
        isMenu: false,
        component: ()=> import('@/views/expert/index/index.vue')
    },

    {
        // 后台登录是后台管理系统的模板，我这边没有动它
        path: '/endLogin',
        name: 'endLogin',
        meta: {title: '后台登录'},
        isMenu: false,
        component: ()=> import('@/views/system/login/Login.vue')
    },
]

// 定义动态路由
export const asyncRoutes = [
    {
        path: '/system',
        name: 'system',
        meta: {
            title: '系统管理',
            icon: 'GoldMedal',
            role: ['ROLE_ADMIN']
        },
        redirect: '/system/user',
        component: ()=> import('@/views/system/layout/Index.vue'),
        isMenu: true,
        funcNode: 2,
        children: [
            {
                path: 'user',
                name: 'user',
                meta: {
                    title: '用户管理',
                    icon: 'UserFilled',
                    role: ['ROLE_ADMIN']
                },
                component: ()=> import('@/views/system/user/UserList.vue')
            },
            {
                path: 'role',
                name: 'Role',
                meta: {
                    title: '角色管理',
                    icon: 'Stamp',
                    role: ['ROLE_ADMIN']
                },
                component: () => import('@/views/system/role/RoleList.vue')
            },
            {
                path: 'log',
                name: 'Log',
                meta: {
                    title: '日志管理',
                    icon: 'Histogram',
                    role: ['ROLE_ADMIN']
                },
                component: () => import('@/views/system/log/LogList.vue')
            }
        ]
    }
]


// 3、创建路由实例并传递‘routes’配置
const router = createRouter({
    history: createWebHashHistory(),
    routes: staticRouter
})

// 设置白名单
const whiteList = ['/expert/login','/expert/register', '/expert/index', '/endLogin']
// 路由拦截守卫
router.beforeEach(async (to,from,next)=> {
    // 1.Nprogress 开始
    Nprogress.start()

    // 2.设置标题
    if(typeof(to.meta.title) === 'string'){
        document.title = to.meta.title||'登录'
    }

    // 3.如果是白名单的路径，直接放行
    const some = whiteList.some(function (item) {
        return to.path.indexOf(item)!==-1
    })
    //4. 白名单直接放行
    if (some) {
        next()
    }else{
        // 5.判断访问路径是前台还是后台
        if(to.path.indexOf('hotel')!==-1){
            // 6.判断前台是否有token，没有重定向login
            const memberStore = useMemberStore()
            // 已经登录,直接放行
            if(memberStore.memberToken!=''){
                next()
            // 未登录，跳转到前台登录页
            }else{
                return next({path: `/account/login?redirect=${to.path}`,replace:true})
            }
        }else {
            // 7.判断是否有token，没有重定向login
            const userStore = useUserStore()
            if(userStore.token!=''){
                // 获取登录用户的角色
                const { userInfo } =userStore
                const roles = []
                roles.push(userInfo.role.code)

                // 根据角色动态生成路由访问映射
                const menuStore = useMenuStore()

                if(!menuStore.routers.length){
                    const accessRoutes = menuStore.generateRouter({roles: roles})
                    accessRoutes.forEach(item => router.addRoute(item))
                    next({...to,replace:true})
                }else {
                    // 正常访问页面
                    next()
                }

            }else {
                return next({path: `/account/login?redirect=${to.path}`,replace:true})
            }

        }

    }

})

// 路由跳转结束
router.afterEach(()=> {
    Nprogress.done()
})

// 路由跳转失败
router.onError(error=> {
    Nprogress.done()
    console.warn("路由错误",error.message)
})

export default router
