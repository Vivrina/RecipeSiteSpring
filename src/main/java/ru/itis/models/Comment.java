package ru.itis.models;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@ToString(exclude = {"recipe", "user"})
@EqualsAndHashCode(exclude = {"recipe", "user"})
@NoArgsConstructor
@Builder
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    private String comment;
}
