import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
import register from '../views/register.vue';
Vue.use(VueRouter)

const routes = [
    // 主页
    {
        path: '/',
        name: 'index',
        component: index,
        meta: {
            index: 0,
            title: '首页'
        }
    },

    // 登录
    {
        path: '/login',
        name: 'login',
        component: login,
        meta: {
            index: 0,
            title: '登录'
        }
    },

            // 注册
        {
            path: '/register',
            name: 'register',
            component: register,
            meta: {
                index: 0,
                title: '注册'
            }
        },
    
    // 忘记密码
    {
        path: '/forgot',
        name: "forgot",
        component: forgot,
        meta: {
            index: 0,
            title: '忘记密码'
        }
    },

    // 修改密码
    {
        path: '/user/password',
        name: "password",
        component: () => import("../views/user/password.vue"),
        meta: {
            index: 0,
            title: '修改密码'
        }
    },

    // 视频播放页
    {
        path: "/media/video",
        name: "video",
        component: () => import('../views/media/video.vue'),
        meta: {
            index: 0,
            title: "视频"
        }
    },

    // 音频播放页
    {
        path: "/media/audio",
        name: "audio",
        component: () => import('../views/media/audio.vue'),
        meta: {
            index: 0,
            title: "音频"
        }
    },

    
    
    
    
                
        
            // 车主用户路由
        {
            path: '/car_owners_and_users/table',
            name: 'car_owners_and_users_table',
            component: () => import('../views/car_owners_and_users/table.vue'),
            meta: {
                index: 0,
                title: '车主用户列表'
            }
        },
        {
            path: '/car_owners_and_users/view',
            name: 'car_owners_and_users_view',
            component: () => import('../views/car_owners_and_users/view.vue'),
            meta: {
                index: 0,
                title: '车主用户详情'
            }
        },
            // 维护用户路由
        {
            path: '/maintaining_users/table',
            name: 'maintaining_users_table',
            component: () => import('../views/maintaining_users/table.vue'),
            meta: {
                index: 0,
                title: '维护用户列表'
            }
        },
        {
            path: '/maintaining_users/view',
            name: 'maintaining_users_view',
            component: () => import('../views/maintaining_users/view.vue'),
            meta: {
                index: 0,
                title: '维护用户详情'
            }
        },
            // 检测用户路由
        {
            path: '/detecting_users/table',
            name: 'detecting_users_table',
            component: () => import('../views/detecting_users/table.vue'),
            meta: {
                index: 0,
                title: '检测用户列表'
            }
        },
        {
            path: '/detecting_users/view',
            name: 'detecting_users_view',
            component: () => import('../views/detecting_users/view.vue'),
            meta: {
                index: 0,
                title: '检测用户详情'
            }
        },
            // 车辆信息路由
        {
            path: '/vehicle_information/table',
            name: 'vehicle_information_table',
            component: () => import('../views/vehicle_information/table.vue'),
            meta: {
                index: 0,
                title: '车辆信息列表'
            }
        },
        {
            path: '/vehicle_information/view',
            name: 'vehicle_information_view',
            component: () => import('../views/vehicle_information/view.vue'),
            meta: {
                index: 0,
                title: '车辆信息详情'
            }
        },
            // 维修记录路由
        {
            path: '/maintenance_records/table',
            name: 'maintenance_records_table',
            component: () => import('../views/maintenance_records/table.vue'),
            meta: {
                index: 0,
                title: '维修记录列表'
            }
        },
        {
            path: '/maintenance_records/view',
            name: 'maintenance_records_view',
            component: () => import('../views/maintenance_records/view.vue'),
            meta: {
                index: 0,
                title: '维修记录详情'
            }
        },
            // 检测地址路由
        {
            path: '/detection_address/table',
            name: 'detection_address_table',
            component: () => import('../views/detection_address/table.vue'),
            meta: {
                index: 0,
                title: '检测地址列表'
            }
        },
        {
            path: '/detection_address/view',
            name: 'detection_address_view',
            component: () => import('../views/detection_address/view.vue'),
            meta: {
                index: 0,
                title: '检测地址详情'
            }
        },
            // 年检预约路由
        {
            path: '/annual_inspection_appointment/table',
            name: 'annual_inspection_appointment_table',
            component: () => import('../views/annual_inspection_appointment/table.vue'),
            meta: {
                index: 0,
                title: '年检预约列表'
            }
        },
        {
            path: '/annual_inspection_appointment/view',
            name: 'annual_inspection_appointment_view',
            component: () => import('../views/annual_inspection_appointment/view.vue'),
            meta: {
                index: 0,
                title: '年检预约详情'
            }
        },
            // 取消预约路由
        {
            path: '/cancel_reservation/table',
            name: 'cancel_reservation_table',
            component: () => import('../views/cancel_reservation/table.vue'),
            meta: {
                index: 0,
                title: '取消预约列表'
            }
        },
        {
            path: '/cancel_reservation/view',
            name: 'cancel_reservation_view',
            component: () => import('../views/cancel_reservation/view.vue'),
            meta: {
                index: 0,
                title: '取消预约详情'
            }
        },
            // 年检报告路由
        {
            path: '/annual_inspection_report/table',
            name: 'annual_inspection_report_table',
            component: () => import('../views/annual_inspection_report/table.vue'),
            meta: {
                index: 0,
                title: '年检报告列表'
            }
        },
        {
            path: '/annual_inspection_report/view',
            name: 'annual_inspection_report_view',
            component: () => import('../views/annual_inspection_report/view.vue'),
            meta: {
                index: 0,
                title: '年检报告详情'
            }
        },
            // 消息通知路由
        {
            path: '/message_notification/table',
            name: 'message_notification_table',
            component: () => import('../views/message_notification/table.vue'),
            meta: {
                index: 0,
                title: '消息通知列表'
            }
        },
        {
            path: '/message_notification/view',
            name: 'message_notification_view',
            component: () => import('../views/message_notification/view.vue'),
            meta: {
                index: 0,
                title: '消息通知详情'
            }
        },
    
    // 用户路由
    {
        path: '/user/table',
        name: 'user_table',
        component: () => import('../views/user/table.vue'),
        meta: {
            index: 0,
            title: '用户列表'
        }
    },
    {
        path: '/user/view',
        name: 'user_view',
        component: () => import('../views/user/view.vue'),
        meta: {
            index: 0,
            title: '用户详情'
        }
    },
    {
        path: '/user/info',
        name: 'user_info',
        component: () => import('../views/user/info.vue'),
        meta: {
            index: 0,
            title: '个人信息'
        }
    },
    // 用户组路由
    {
        path: '/user_group/table',
        name: 'user_group_table',
        component: () => import('../views/user_group/table.vue'),
        meta: {
            index: 0,
            title: '用户组列表'
        }
    },
    {
        path: '/user_group/view',
        name: 'user_group_view',
        component: () => import('../views/user_group/view.vue'),
        meta: {
            index: 0,
            title: '用户组详情'
        }
    }
]

const router = new VueRouter({
    mode: 'hash',
    base: process.env.BASE_URL,
    routes
})

router.beforeEach((to, from, next) => {
    let token = to.query.token;
    if (token) {
        $.db.set("token", token, 120);
    }
    next();
})

router.afterEach((to, from, next) => {
    let title = "车辆年检系统-admin";
    document.title = title;
})

export default router
