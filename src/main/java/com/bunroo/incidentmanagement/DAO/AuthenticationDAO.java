package com.bunroo.incidentmanagement.DAO;

import com.bunroo.incidentmanagement.DTO.UserDTO;
import com.bunroo.incidentmanagement.Request.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AuthenticationDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDTO findByUsername(String username) {
        String sql = "SELECT * FROM USER_PROFILE WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, new RowMapper<UserDTO>() {
            @Override
            public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserDTO user = new UserDTO();
                user.setId(rs.getString("USER_ID"));
                user.setUserName(rs.getString("USER_NAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setRoles(rs.getString("USER_TYPE"));
                return user;
            }
        });
    }

    public boolean checkExistingUser(AuthRequest request) {

        return false;
    }

    public String registerUser(AuthRequest request) {
        
    }

    public boolean validateSecretQuestion(AuthRequest request) {
        return false;
    }
}
