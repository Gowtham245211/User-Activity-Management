package com.useractivitymanagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @NotNull
    private String title;

    @Column(length = 500)
    private String content;

    @ManyToOne(
        cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    @ToString.Exclude
    private User user;

    /*@OneToMany(
            mappedBy = "post", fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<Comment> commentList;*/

    @ManyToMany(
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn (
                    name = "post_id",
                    referencedColumnName = "postId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "tag_id",
                    referencedColumnName = "tagId"
            )
    )
    @ToString.Exclude
    private List<Tag> tagList;
}
