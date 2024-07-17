package com.bunroo.incidentmanagement.Service;

import com.bunroo.incidentmanagement.DAO.AuthenticationDAO;
import com.bunroo.incidentmanagement.DTO.UserDTO;
import com.bunroo.incidentmanagement.Request.AuthRequest;
import com.bunroo.incidentmanagement.Response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationDAO userRepository;

    public static AuthResponse login(AuthRequest request) {
        AuthResponse response=new AuthResponse();
        return response;

    }
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = (UserDetails) userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
