package cn.hzy.expert.service;

import cn.hzy.expert.domain.User;
import cn.hzy.expert.domain.UserDynamic;

import java.util.List;

/*
 * 功能：用户动态业务接口
 * 业务
 * 1. 用户创建动态
 * 2. 用户删除自己的动态
 * 3. 调出用户的历史动态
 * 4. 调出用户关注人的动态
 * 5. 调出热门动态
 * 6. 按照相关的领域调出动态
 * */
public interface UserDynamicService {
    List<UserDynamic> getDynamicList();
}
