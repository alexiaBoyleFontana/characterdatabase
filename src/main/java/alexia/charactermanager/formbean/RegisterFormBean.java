package alexia.charactermanager.formbean;

import alexia.charactermanager.validation.UserUnique;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class RegisterFormBean {

    private Integer id;

    @UserUnique(message="Username already exists.")
    @NotBlank(message="Missing username.")
    private String username;

    @NotBlank(message="Missing password.")
    private String password;
}
