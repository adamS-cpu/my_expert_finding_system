package cn.hzy.expert.service;

import cn.hzy.expert.domain.User;
import cn.hzy.system.domain.SysUser;

public interface AccountService {
    // 用户注册方法
    void register(User userInfo);

    User login(User user);
}
