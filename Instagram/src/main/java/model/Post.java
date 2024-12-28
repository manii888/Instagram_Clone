//package model;

package model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caption;
    private String mediaUrl;
    private String backgroundMusicUrl;
    private String category;

    @Column(nullable = false)
    private LocalDateTime datetimePosted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private User publisher;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> likes = new HashSet<>();

    // Constructors, Getters, and Setters
    public Post() {}

    // Getters and Setters
    // ...
}
