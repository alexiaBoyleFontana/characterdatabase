package alexia.charactermanager.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CharacterFormBean implements FormBean{

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

    public void clean() {
        img = sanitize(img);
        name = sanitize(name);
        race = sanitize(race);
        title = sanitize(title);
        world = sanitize(world);

        if (links != null) {
            for (String link : links
            ) {
                link = sanitize(link);
            }
        }

        if (relationships != null) {
            for (String relation : relationships
            ) {
                relation = sanitize(relation);
            }
        }
    }
}
