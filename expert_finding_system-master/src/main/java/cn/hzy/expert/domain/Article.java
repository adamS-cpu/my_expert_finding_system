//package cn.hzy.expert.domain;
//
//import cn.hzy.expert.domain.Venue;
//
//import cn.hzy.base.BaseEntity;
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Entity
//@Data
//@Table(name = "article")
//@org.hibernate.annotations.Table(appliesTo = "article", comment = "论文表")
//public class Article extends BaseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    /*
//    * 文章名称
//    * */
//    @Column(name = "article_title", nullable = false)
//    private String title;
//
//    /*
//     * 文章发表期刊/会议
//     * */
//    @ManyToOne(targetEntity = Venue.class)
//    @Column(name = "article_venue", nullable = false)
//    private Venue venue;
//}
