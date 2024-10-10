package com.pdp.PixelTrade.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  11:41
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
public class Blog extends Auditable {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String banner;

    @ManyToMany
    private Set<PostCategory> categories;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<BlogPart> parts;
}
