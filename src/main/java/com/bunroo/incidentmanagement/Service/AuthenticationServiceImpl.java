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

    @Override
    public AuthResponse resetPassword(AuthRequest request) {
        AuthResponse response= new AuthResponse();
        if(!userRepository.checkExistingUser(request)) {

        response.setStatusCode("-1");
        response.setStatusMessage("Invalid user name");
        }
        else
        {
            if(userRepository.validateSecretQuestion(request))
            {



                response.setStatusMessage("Password successfully changed");
                response.setStatusCode("200");
            }
            else
            {
                response.setStatusMessage("Invalid Secret Answer");
                response.setStatusCode("-1");
            }
        }

        return response;
    }

    @Override
    public AuthResponse logout(AuthRequest request) {
        return null;
    }

    @Override
    public AuthResponse register(AuthRequest request) {
        AuthResponse response=new AuthResponse();
        if(userRepository.checkExistingUser(request))
        {
            response.setStatusCode("-1");
            response.setStatusMessage("Existing User");
        }
        else
        {
            String result=userRepository.registerUser(request);
            response.setStatusCode("200");
            response.setStatusMessage("User registered Successfully");

        }
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
