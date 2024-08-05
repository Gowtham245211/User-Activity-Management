package com.useractivitymanagement.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
@Schema(description = "comment entity")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*@SequenceGenerator(name = "comment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")*/
    private Long commentId;

    @Column(length = 500)
    private String content;

    @ManyToOne(
        cascade = CascadeType.ALL, fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "postId"
    )
    @ToString.Exclude
    private Post post;
}
