package alexia.charactermanager.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "race")
    private String race;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String imageLink;

    //many to one
    @ManyToOne
    private World world;

    @OneToMany(mappedBy = "from")
    private List<CharLink> links;


}
