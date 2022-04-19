package alexia.charactermanager.database.entity;
import alexia.charactermanager.database.entity.Character;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "characters_links")
public class CharLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "relation")
    private String relation;

    @ManyToOne
    private Character from;

    @ManyToOne
    private Character to;

}
