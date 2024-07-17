package com.bunroo.incidentmanagement.Controller;

import com.bunroo.incidentmanagement.Request.AuthRequest;
import com.bunroo.incidentmanagement.Response.AuthResponse;
import com.bunroo.incidentmanagement.Service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public class Authentication {
    @PostMapping
    public AuthResponse login(@RequestBody AuthRequest request)
    {
      return   AuthenticationService.login(request);
    }
}
