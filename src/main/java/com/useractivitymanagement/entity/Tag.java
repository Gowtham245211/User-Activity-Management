package com.useractivitymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {

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
