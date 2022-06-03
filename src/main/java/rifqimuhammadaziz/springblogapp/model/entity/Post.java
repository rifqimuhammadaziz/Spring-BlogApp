package rifqimuhammadaziz.springblogapp.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;

    @Lob
    @Column(name = "body", nullable = false)
    private String body;

}
