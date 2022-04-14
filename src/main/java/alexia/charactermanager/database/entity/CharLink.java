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
//    @JoinColumns ({
//        @JoinColumn(name = "from_id", referencedColumnName = "id",
//                nullable = false, updatable = false)})
//    @JoinTable (name = "characters", joinColumns = {
//            @JoinColumn(name = "from_id", referencedColumnName = "id",
//                    nullable = false, updatable = false)})
    private Character from;

    @ManyToOne
//    @JoinColumns ({
//                    @JoinColumn(name = "to_id", referencedColumnName = "id",
//                            nullable = false, updatable = false)})
//    @JoinTable (name = "characters", inverseJoinColumns = {
//            @JoinColumn(name = "to_id", referencedColumnName = "id",
//                    nullable = false, updatable = false)})
    private Character to;

}
