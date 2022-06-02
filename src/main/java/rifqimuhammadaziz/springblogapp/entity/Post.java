package rifqimuhammadaziz.springblogapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    private Category category;

    @Lob
    @Column(name = "body")
    private String body;

}
