package cn.hzy.expert.service.imp;

import cn.hzy.exception.BadRequestException;
import cn.hzy.expert.domain.User;
import cn.hzy.expert.repository.UserRepository;
import cn.hzy.expert.service.AccountService;
import cn.hzy.system.domain.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AccountServiceImp implements AccountService {
    private final UserRepository userRepository;

    public AccountServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(User userInfo) {
        /*
         * 用户注册*/
        // 判断手机号是否已经注册
        User dbUserInfo = userRepository.findByPhone(userInfo.getPhone());
        if (dbUserInfo != null) {
            throw new BadRequestException("注册失败，该手机号已被注册");
        } else {
            //初始化数据
            userInfo.setStatus(1);
            userInfo.setLoginTimes(0);
            char letter = userInfo.getUsername().toUpperCase().charAt(0);
            String iconFileName = "C:\\expert_finding_system\\expert_finding_system-master\\src\\main\\java\\cn\\hzy\\res\\images\\exampleIcon\\" + letter + ".png";
            userInfo.setUserIcon(iconFileName);
            userRepository.save(userInfo);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User login(User user) {
        User dbUser = userRepository.findByPhone(user.getPhone());
        if(dbUser == null){
            throw new BadRequestException("登陆失败， 手机号未注册");
        }else if(!dbUser.getPassword().equals(user.getPassword())){
            throw new BadRequestException("登陆失败， 请输入正确密码");
        }else{
            dbUser.setLoginTimes(dbUser.getLoginTimes()+1);
            userRepository.save(dbUser);
        }
        return dbUser;
    }

}
