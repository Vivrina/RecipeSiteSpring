package ru.itis.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String passwordHash;

    private String email;

    private Integer achievement;

    private Date created;

    private String fileName;

    @OneToMany(mappedBy = "user")
    private List<Auth> auth;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<Recipe> recipes;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"))
    private List<Recipe> favourites;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public enum Role{
        USER, ADMIN
    }

}
