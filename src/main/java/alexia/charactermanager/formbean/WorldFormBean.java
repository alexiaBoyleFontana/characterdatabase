package alexia.charactermanager.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class WorldFormBean {

    private Integer id;

    //@Unique(message = "World already exists.")
    @NotBlank(message = "Worlds must be named.")
    private String name;

    private String medium;

    private String description;
}
