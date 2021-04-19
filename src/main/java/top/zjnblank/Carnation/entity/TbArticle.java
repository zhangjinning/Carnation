package top.zjnblank.Carnation.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import top.zjnblank.Carnation.entity.base.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "tb_article")
public class TbArticle extends AbstractBaseEntity {

    @Id
    @Column(name = "id", columnDefinition = "varchar(32) NOT NULL comment 'ID'")
    private String id;

    @Column(name = "title", columnDefinition = "varchar(255) NOT NULL comment '文章标题'")
    private String title;

    @Column(name = "content", columnDefinition = "text NOT NULL comment '文章内容'")
    private String content;
}
