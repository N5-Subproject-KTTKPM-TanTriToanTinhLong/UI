package com.example.ui.model;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    private String username;

    private String email;

    private Set<String> role;

    private String password;

}
