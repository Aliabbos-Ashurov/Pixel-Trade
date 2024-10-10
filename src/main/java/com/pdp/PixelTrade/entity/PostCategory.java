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
 * @since 10/October/2024  11:36
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "post_category")
public class PostCategory extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "upload_id")
    private Upload upload;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<Blog> blogs;
}
