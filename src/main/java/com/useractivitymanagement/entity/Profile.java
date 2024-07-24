package com.useractivitymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long profileId;

    @Column(name = "first_name", length = 20)
    @NotNull
    private String firstName;

    @Column(name = "last_name", length = 20)
    private String lastName;

    @Column(length = 200)
    private String bio;

    /*@OneToOne(
            mappedBy = "profile",
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private User user;*/
}
