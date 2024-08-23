package kroryi.springex.dto;


import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int tno;
    @NotEmpty
    private String mid;
    @NotEmpty
    private String mpw;
    @NotEmpty
    private String mname;
    @NotEmpty
    private String phoneNumber;
}
