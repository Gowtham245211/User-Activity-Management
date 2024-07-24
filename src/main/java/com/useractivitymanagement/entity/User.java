package com.useractivitymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "user_name", unique = true)
    @NotNull
    private String userName;

    @Column(length = 100)
    private String encryptedPassword;

    @Column(length = 100)
    private String originalPassword;

    @Column(unique = true)
    @Email
    private String email;

    private String role;

    @OneToOne(
           cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, optional = false
    )
    @JoinColumn(
            name = "profile_id",
            referencedColumnName = "profileId"
    )
    @ToString.Exclude
    @JsonIgnore
    private Profile profile;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @JsonIgnore
    private List<Post> postList;

    /*@Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }*/
}
