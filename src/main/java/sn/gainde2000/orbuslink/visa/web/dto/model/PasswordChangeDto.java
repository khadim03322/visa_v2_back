package sn.gainde2000.orbuslink.visa.web.dto.model;

import lombok.Data;

@Data
public class PasswordChangeDto {
    String oldPassword;
    String newPassword ;
    String confirmPassword ;
}
