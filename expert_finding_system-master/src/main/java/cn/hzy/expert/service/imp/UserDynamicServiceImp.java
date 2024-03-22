package cn.hzy.expert.service.imp;

/*
 * 功能：用户动态接口实现类
 * 业务
 * 1. 用户创建动态
 * 2. 用户删除自己的动态
 * 3. 调出用户的历史动态
 * 4. 调出用户关注人的动态
 * 5. 调出热门动态
 * 6. 按照相关的领域调出动态
 * */


import cn.hzy.expert.domain.User;
import cn.hzy.expert.domain.UserDynamic;
import cn.hzy.expert.repository.UserDynamicRepository;
import cn.hzy.expert.service.UserDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserDynamicServiceImp implements UserDynamicService {

    private final UserDynamicRepository userDynamicRepository;

    public UserDynamicServiceImp(UserDynamicRepository userDynamicRepository){
        this.userDynamicRepository = userDynamicRepository;
    }

    @Override
    public List<UserDynamic> getDynamicList() {
        List<UserDynamic> UserListAll = userDynamicRepository.findAll();
        return UserListAll;
    }
}
