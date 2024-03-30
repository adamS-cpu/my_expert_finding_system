package cn.hzy.expert.domain;

import cn.hzy.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.sql.Timestamp;
import java.util.List;

/*
* 功能描述：这是一个用户动态的实体类
*
*
*
*
* */
@Entity
@Data
@Table(name = "user_dynamic")
@org.hibernate.annotations.Table(appliesTo = "user_dynamic", comment = "用户动态信息表")
public class UserDynamic extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Long id;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="public_time", nullable = false)
    private Timestamp time;

    @Column(name="user_id", nullable =false)
    private Long User_id;

    @Column(name="user_name", nullable =false)
    private String User_name;

    @Column(name="field_id", nullable =false)
    private Long field_id;

    @Column(name="field_name", nullable =false)
    private String field_name;

}
