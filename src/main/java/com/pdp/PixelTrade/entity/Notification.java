package com.pdp.PixelTrade.entity;

import com.pdp.PixelTrade.enums.NotificationDeliveryMethod;
import com.pdp.PixelTrade.enums.NotificationEventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  10:20
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Notification extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(name = "message", nullable = false)
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_delivery_method", nullable = false)
    private NotificationDeliveryMethod deliveryMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_event_type", nullable = false)
    private NotificationEventType eventType;

    @Column(name = "metadata", columnDefinition = "TEXT")
    private String metadata;
}
