package cn.hzy.expert.controller;

import cn.hzy.annotation.EnableSysLog;
import cn.hzy.base.BaseResult;
import cn.hzy.expert.domain.MyNumber;
import cn.hzy.expert.domain.User;
import cn.hzy.expert.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("expert/user")
public class ResearcherController {
    private final UserService userSevice;

    public ResearcherController(UserService userSevice) {
        this.userSevice = userSevice;
    }

    @EnableSysLog("获取推荐用户列表")
    @GetMapping("getUserList/key=3")
    public BaseResult getUserList3(){
        int k = 3;
        HashMap<String, Object> resultMap = new HashMap<>();
        List<User> userList = this.userSevice.getUserListByRandom(k);
        resultMap.put("userList", userList);
        System.out.print("返回推荐列表成功");
        return BaseResult.success(resultMap);
    }
    @EnableSysLog("获取推荐用户列表5")
    @GetMapping("getUserList/key=5")
    public BaseResult getUserList5(){
        int k = 5;
        HashMap<String, Object> resultMap = new HashMap<>();
        List<User> userList = this.userSevice.getUserListByRandom(k);
        resultMap.put("userList", userList);
        return BaseResult.success(resultMap);
    }
}
