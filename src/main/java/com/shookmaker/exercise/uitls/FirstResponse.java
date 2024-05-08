package com.shookmaker.exercise.uitls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstResponse {
    String refresh_token;
    Integer expires_in;
    String session_key;
    String access_token;
    String scope;
    String session_secret;
}
