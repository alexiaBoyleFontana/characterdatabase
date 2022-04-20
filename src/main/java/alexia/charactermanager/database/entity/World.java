package alexia.charactermanager.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "worlds")
public class World {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "medium")
    private String medium;

    @Column(name = "`desc`")
    private String desc;

    @OneToMany(mappedBy = "world")
    private Set<Character> characters;
}
