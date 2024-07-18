package com.bunroo.incidentmanagement.Controller;

import com.bunroo.incidentmanagement.Request.AuthRequest;
import com.bunroo.incidentmanagement.Response.AuthResponse;
import com.bunroo.incidentmanagement.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Authentication {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) throws Exception {
      return   authenticationService.login(request);
    }
}
