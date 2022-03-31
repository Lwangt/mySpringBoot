package my.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginVo implements Serializable {

    @NotBlank(message = "登录账号不能为空!")
    private String name;

    @NotBlank(message = "登录密码不能为空!")
    private String password;
}
