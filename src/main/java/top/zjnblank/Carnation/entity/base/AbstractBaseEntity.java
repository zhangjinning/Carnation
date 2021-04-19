package top.zjnblank.Carnation.entity.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import top.zjnblank.Carnation.enums.DataLevel;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@ToString
@EqualsAndHashCode
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public abstract class AbstractBaseEntity {

    @CreatedDate
    @Column(updatable = false, name = "created_date", columnDefinition = "timestamp default CURRENT_TIMESTAMP comment '创建时间'")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "last_modified_date", columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间'")
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    @Column(updatable = false, name = "created_by", columnDefinition = "varchar(255) DEFAULT NULL comment '创建者'")
    private String createdBy;

    @LastModifiedBy
    @Column(name = "last_modified_by", columnDefinition = "varchar(255) DEFAULT NULL comment '更新者'")
    private String lastModifiedBy;

    @Column(name = "data_level", columnDefinition = "tinyint(1) default '1' comment '数据级别 0:已删除 1:未删除'")
    private DataLevel dataLevel;
}
