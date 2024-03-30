package cn.hzy.expert.controller;

import cn.hzy.base.BaseResult;
import cn.hzy.expert.domain.User;
import cn.hzy.annotation.EnableSysLog;
import cn.hzy.expert.service.AccountService;
import cn.hzy.system.domain.SysUser;
import cn.hzy.utils.JWTUtil;
import cn.hzy.utils.Md5Util;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("expert/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @EnableSysLog("[前台]专家发现系统用户注册")
    @PostMapping("register")
    public BaseResult register(@RequestBody User userInfo){
        accountService.register(userInfo);
        return BaseResult.success("注册成功");
    }

    @PostMapping("login")
    @EnableSysLog("用户登录系统")
    public BaseResult login(@RequestBody User user,
                            HttpServletRequest request){
        User dbUser = accountService.login(user);

        // 生成token
        Map<String,String> userMap = new HashMap<>();
        userMap.put("id",dbUser.getId().toString());
        // 生成token
        String token = JWTUtil.getToken(userMap);
        //request.getServletContext().setAttribute("token",token);
        dbUser.setUserToken(token);
        // 返回登录用户信息
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("username",dbUser.getUsername());
        resultMap.put("token",token);
        resultMap.put("email",dbUser.getEmail());
        resultMap.put("sex",dbUser.getSex());
        resultMap.put("createTime",dbUser.getCreateTime());
        resultMap.put("userIcon",dbUser.getUserIcon());
        return BaseResult.success("登录成功",resultMap);
    }


}
