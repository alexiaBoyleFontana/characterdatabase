package alexia.charactermanager.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class WorldFormBean implements FormBean {

    private Integer id;

    //@Unique(message = "World already exists.")
    @NotBlank(message = "Worlds must be named.")
    private String name;

    private String medium;

    private String description;

    public void clean() {
        name = sanitize(name);
        medium = sanitize(medium);
        description = sanitize(description);
    }
}
