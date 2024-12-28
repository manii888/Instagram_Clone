//package model;

package model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // Additional Attributes
    private String bio;
    private String profilePictureUrl;

    // Followers and Following
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "follows",
        joinColumns = @JoinColumn(name = "follower_id"),
        inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    private Set<User> following = new HashSet<>();

    @ManyToMany(mappedBy = "following", fetch = FetchType.LAZY)
    private Set<User> followers = new HashSet<>();

    // Constructors, Getters, and Setters
    public User() {}

    // Getters and Setters
    // ...
}

