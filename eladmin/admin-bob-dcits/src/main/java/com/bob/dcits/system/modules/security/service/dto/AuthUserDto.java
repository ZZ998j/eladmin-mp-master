package com.bob.dcits.system.modules.security.service.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

/**
 * @author guoq
 * @date 2024-11-30
 */
@Getter
@Setter
public class AuthUserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String code;

    private String uuid = "";
}
