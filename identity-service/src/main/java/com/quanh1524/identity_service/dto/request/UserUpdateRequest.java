package com.quanh1524.identity_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
//    private String username; -thường ko update username
    String password;
    String firstName;
    String lastName;
    LocalDate dob;

}
