//package cn.hzy.utils;
//
//
//import cn.hutool.core.date.DateField;
//import cn.hutool.core.date.DateTime;
//import cn.hzy.expert.domain.User;
//import cn.hzy.system.domain.SysUser;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**功能描述：jwt工具类
//
// */
//public class HutoolJWTUtil {
//    public static String createToken(User user){
//        DateTime now= DateTime.now();
//        DateTime newTime = now.offsetNew(DateField.MINUTE, 120);
//        Map<String, Object> payload = new HashMap<>();
//        // 签发时间
//        payload.put(JWTPayload.ISSUE_AT, now);
//        payload.put(JWTPayload.EXPIRES_AT, newTime);
//        payload.put(JWTPayload.NOT_BEFORE, now);
//        payload.put("username", user.getUsername());
//        payload.put("uid", user.getId());
//        String key = "123456789";
//        String token = JWTUtil.createToken(payload, key.getBytes());
//        return token;
//    }
//
//}
