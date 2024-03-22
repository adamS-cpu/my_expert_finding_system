package cn.hzy.expert.repository;

import cn.hzy.expert.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // 根据手机号获取用户数据
    User findByPhone(String phone);
    List<User> findAll();
}
