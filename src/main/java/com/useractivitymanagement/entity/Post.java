package com.useractivitymanagement.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
@Schema(description = "post entity")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "firstProcedure",
                procedureName = "get_posts_byuserid",
                parameters = {@StoredProcedureParameter(mode=ParameterMode.IN, name = "userId", type = String.class)}
        )
        // @NamedStoredProcedureQuery(name = "firstProcedure", procedureName = "get_posts_byuserid")
})
public class Post implements Serializable {

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
