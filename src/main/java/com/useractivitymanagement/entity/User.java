package com.useractivitymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@ToString
// @RedisHash("User")
@Schema(description = "user entity")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Unique identifier of the user", example = "1")
    private Long userId;

    @Column(name = "user_name", unique = true/*, columnDefinition = "Abc"*/)
    @NotNull
    @Schema(description = "Username of the user", example = "aj")
    private String userName;

    @Column(length = 100)
    private String encryptedPassword;

    @Column(length = 100)
    private String originalPassword;

    @Column(unique = true)
    @Email
    @Schema(description = "Email of the user", example = "xxx@gmail.com")
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
