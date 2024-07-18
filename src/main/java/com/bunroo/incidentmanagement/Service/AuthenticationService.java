package com.bunroo.incidentmanagement.Service;

import com.bunroo.incidentmanagement.Request.AuthRequest;
import com.bunroo.incidentmanagement.Response.AuthResponse;
import org.springframework.stereotype.Service;


public interface AuthenticationService {
    public AuthResponse login(AuthRequest request);
}
