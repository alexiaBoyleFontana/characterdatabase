package alexia.charactermanager.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CharacterFormBean {

    private Integer id;

    private String img;

    private String name;

    private String race;

    private String title;

    //@Unique(message = "World already exists.")
    //worldname
    private String world;

    //@exists?
    private List<String> links;

    private List<String> relationships;
}
