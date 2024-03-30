package cn.hzy.expert.domain;

import cn.hzy.base.BaseEntity;
import cn.hzy.system.domain.SysRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

/**功能描述：专家发现系统用户表
 */
@Data
@Entity
@Table(name = "User")
@org.hibernate.annotations.Table(appliesTo = "user",comment = "专家发现系统用户信息表")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    /**
     * 登录用户名
     */
    @Getter
    @Column(name = "username")
    private String username;

    /**
     * 登录密码
     */
    @Getter
    @Column(name = "password")
    private String password;

    /**
     * 用户性别
     */
    @Getter
    @Column(name = "sex")
    private String sex;

    /**
     * 用户状态
     */
    @Getter
    @Column(name = "status")
    private Integer status;

    /**
     * 邮箱
     */
    @Getter
    @Column(name="email")
    private String email;

    /**
     * 电话
     */
    @Getter
    @Column(name="phone")
    private String phone;

    /**
     * 用户头像
     */
    @Getter
    @Column(name = "user_icon")
    private String userIcon;

    @Getter
    @Column(name = "login_times")
    private Integer loginTimes;

    @Getter
    @Column(name = "organization")
    private String organization;

    /*
    * user 的token 信息
    * */
    @Transient
    private String userToken;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public void organization(String organization) {
        this.organization = organization;
    }

    public void setLoginTimes(Integer login_times) {
        this.loginTimes = login_times;
    }




}



