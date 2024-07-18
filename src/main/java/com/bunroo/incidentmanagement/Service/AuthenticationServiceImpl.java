package com.bunroo.incidentmanagement.Service;

import com.bunroo.incidentmanagement.DAO.AuthenticationDAO;
import com.bunroo.incidentmanagement.DTO.UserDTO;
import com.bunroo.incidentmanagement.Request.AuthRequest;
import com.bunroo.incidentmanagement.Response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AuthenticationServiceImpl implements  AuthenticationService{
    @Autowired
    private AuthenticationDAO userRepository;

    @Override
    public AuthResponse login(AuthRequest request) {
        AuthResponse response=new AuthResponse();
//        authenticate(request.getUserName(), request.getPassword());

        final UserDTO userDetails = userRepository.findByUsername(request.getUserName());

//        final String token = JWTUtility.generateToken(userDetails.getUserName());
//        System.out.println(token);

        return response;

    }
    private  void authenticate(String username, String password) throws Exception {
        /*try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }*/
    }


}
