package com.bunroo.incidentmanagement.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequest {
    private  String userName;
    private String password;
    private String userId;

}
