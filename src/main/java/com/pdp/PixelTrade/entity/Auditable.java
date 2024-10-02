package com.pdp.PixelTrade.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024  12:34
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable extends BaseEntity {

    @Column(name = "created_by", nullable = false, updatable = false)
    @CreatedBy
    private Long createdBy;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    @LastModifiedBy
    private Long updatedBy;

    @Builder.Default
    @Column(name = "deleted", nullable = false)
    // @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    private boolean deleted = false;
}
