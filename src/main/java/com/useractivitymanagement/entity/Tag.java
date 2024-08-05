package com.useractivitymanagement.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tag")
@Schema(description = "tag entity")
public class Tag  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tagId;

    @Column(unique = true)
    private String name;

    /*@ManyToMany(
        mappedBy = "tagList", fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<Post> postList;*/
}
