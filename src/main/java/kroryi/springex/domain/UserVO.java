package kroryi.springex.domain;

import lombok.*;

import java.time.LocalDate;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private int tno;
    private String mid;
    private String mpw;
    private String mname;
    private String phoneNumber;
}