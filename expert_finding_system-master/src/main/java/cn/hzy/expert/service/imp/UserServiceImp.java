package cn.hzy.expert.service.imp;

import cn.hzy.expert.domain.User;
import cn.hzy.expert.repository.UserRepository;
import cn.hzy.expert.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<User> getUserListByRandom (int k) {
        List<User> UserListAll = userRepository.findAll();
        System.out.print(UserListAll);
        List<User> shuffledList = new ArrayList<>(UserListAll);
        Collections.shuffle(shuffledList);
        return shuffledList.subList(0, k);
    }
}