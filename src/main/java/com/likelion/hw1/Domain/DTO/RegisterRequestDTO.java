package com.likelion.hw1.Domain.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class RegisterRequestDTO {
    private String userId;
    private String password;
    private String email;
}
