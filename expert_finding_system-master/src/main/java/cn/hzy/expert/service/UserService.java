package cn.hzy.expert.service;

import cn.hzy.expert.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUserListByRandom(int k);
}
