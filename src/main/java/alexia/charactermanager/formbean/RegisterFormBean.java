package alexia.charactermanager.formbean;

import alexia.charactermanager.validation.UserUnique;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class RegisterFormBean implements FormBean {

    private Integer id;

    @UserUnique
    @NotBlank(message="Missing username.")
    private String username;

    @NotBlank(message="Missing password.")
    private String password;

    @Override
    public void clean() {
        System.out.println(username);
        username = sanitize(username);
        password = sanitize(password);
    }
}
