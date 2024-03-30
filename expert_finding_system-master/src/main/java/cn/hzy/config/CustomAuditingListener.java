package cn.hzy.config;

import cn.hzy.utils.JWTUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Field;

/**实现自定义listener
 * 其中有两个核心的接口 @PrePersist 和 @PreUpdate
 * 第一个是在保存的前置方法（新增 和 更新）
 * 第二个是更新的前置方法 通过这两个方法就可以实现自己填充
 */
@Component
@Slf4j
public class CustomAuditingListener {
    /**
     * 新增数据时，填充创建人和创建时间
     */
    @PrePersist
    public void prePersist(Object object)
            throws IllegalArgumentException, IllegalAccessException {
        // 如果填充字段被分装在一个父类中：
        Class<?> aClass = object.getClass().getSuperclass();
        // 否则
        //Class<?> aClass = object.getClass();
        try {
            // 填充创建用户Id
            addUserId(object, aClass, "createBy");
            // 填充更新用户Id
            addUserId(object, aClass, "updateBy");
            // 填充创建时间
            //addOperateTime(object, aClass, "createTime");
        } catch (NoSuchFieldException e) {
            log.error("反射获取属性异常：", e);
        }
    }

    /**
     * 填充用户id
     *
     * @param object
     * @param aClass
     * @param propertyName 属性名（对应实体类中的属性）
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    protected void addUserId(Object object, Class<?> aClass, String propertyName) throws NoSuchFieldException, IllegalAccessException {
        Field userId = aClass.getDeclaredField(propertyName);
        userId.setAccessible(true);
        // 获取userId值
        Object userIdValue = userId.get(object);
        if (userIdValue == null) {
            // 在此处使用当前用户id或默认用户id
            Long id = getLoginUserId();
            userId.set(object, id);
        }
    }


    /**
     * 更新数据时，填充更新人和更新时间
     */
    @PreUpdate
    public void preUpdate(Object object)
            throws IllegalArgumentException, IllegalAccessException {
        Class<?> aClass = object.getClass().getSuperclass();
        try {
            // 填充更新用户Id
            addUserId(object, aClass, "updateBy");
            // 填充更新时间
            //addOperateTime(object, aClass, "updateTime");
        } catch (NoSuchFieldException e) {
            log.error("反射获取属性异常：", e);
        }
    }

    /**
     * 获取登录用户ID
     *
     * @return
     */
    private Long getLoginUserId() {
        // 获取登录用户ID
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = (String) request.getHeader("userToken");
        String memberToken = (String) request.getHeader("memberToken");
        if (null == token && null == memberToken) {
            return 1L;
        } else {
            try {
                String usedToken = null;
                if (null == token && null != memberToken && memberToken.trim().length() > 0) {
                    usedToken = memberToken;
                } else if (StringUtils.isNotBlank(token) && StringUtils.isBlank(memberToken)) {
                    usedToken = token;
                } else if (StringUtils.isNotBlank(token) && null != memberToken && memberToken.trim().length() > 0) {
                    String uri = request.getRequestURI();
                    // 说明是前台访问路径
                    if (uri.indexOf("hotel") != -1) {
                        usedToken = token;
                    } else {
                        usedToken = token;
                    }
                }
                if (usedToken != null) {
                    DecodedJWT decodedJWT = JWTUtil.verify(usedToken);
                    return Long.parseLong(decodedJWT.getClaim("id").asString());
                }
            } catch (Exception e) {
                log.error("JWT令牌验证失败：", e);
                // 在这里，您可以选择抛出一个自定义的异常，或者返回一个特殊的用户ID值来表示验证失败
                return -1L;
            }
        }
        return 1L;
    }
}