package alexia.charactermanager.formbean;

import alexia.charactermanager.database.entity.World;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class CharacterFormBean {

    private Integer id;

    private String img;

    private String name;

    private String race;

    private String title;

    //worldname
    private String world;
}
