package cn.hzy.expert.controller;

/*
 * 功能：用户动态前端控制器
 * 业务
 * 1. 用户创建动态
 * 2. 用户删除自己的动态
 * 3. 调出用户的历史动态
 * 4. 调出用户关注人的动态
 * 5. 调出热门动态
 * 6. 按照相关的领域调出动态
 * */

import cn.hzy.annotation.EnableSysLog;
import cn.hzy.base.BaseResult;
import cn.hzy.expert.domain.User;
import cn.hzy.expert.domain.UserDynamic;
import cn.hzy.expert.service.UserDynamicService;
import cn.hzy.expert.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("userDynamic")
public class UserDynamicController {

    private final UserDynamicService userDynamicService;


    public UserDynamicController(UserDynamicService userDynamicService) {
        this.userDynamicService = userDynamicService;
    }

    @EnableSysLog("获取动态页面公告板内容")
    @GetMapping("getBillboard")
    public BaseResult getBillboard(){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("content", "当前版本 1.0.0");
        System.out.print("返回版本信息成功");
        return BaseResult.success(resultMap);
    }

    @EnableSysLog("获取动态页面内容")
    @GetMapping("allList")
    public BaseResult getDynamicList(){
        HashMap<String, Object> resultMap = new HashMap<>();
        List<UserDynamic> DynamicList = this.userDynamicService.getDynamicList();
        System.out.print("返回全部动态成功");
        System.out.print(DynamicList);
        resultMap.put("DynamicList", DynamicList);
        return BaseResult.success(resultMap);
    }


}
