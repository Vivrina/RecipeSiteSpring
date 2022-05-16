package ru.itis.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"user", "category, likeBy"})
@EqualsAndHashCode(exclude = {"user", "category, likeBy"})
@Builder
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String description;

    private Date created;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "recipe")
    private List<Comment> comments;

    @ManyToMany(mappedBy = "favourites")
    private List<User> likeBy;

    private String fileName;
}
