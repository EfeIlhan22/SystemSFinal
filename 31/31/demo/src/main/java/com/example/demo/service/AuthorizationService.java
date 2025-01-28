package com.example.demo.service;


import com.example.demo.models.Doctor;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final JwtUtils jwtUtils;
    private final DoctorRepository doctorRepository;

    @Autowired
    public AuthorizationService(JwtUtils jwtUtils, DoctorRepository doctorRepository) {
        this.jwtUtils = jwtUtils;
        this.doctorRepository = doctorRepository;
    }

    // JWT doğrulama ve kullanıcı adı alma
    public String getUsernameFromJwt(String token) {
        if (jwtUtils.validateJwtToken(token)) {
            return jwtUtils.getUsernameFromJwtToken(token);
        }
        throw new RuntimeException("Invalid JWT token");
    }

    // Kullanıcıyı JWT'ye göre doğrulama
    public Doctor getAdminFromJwt(String token) {
        String username = getUsernameFromJwt(token);
        return doctorRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    // Kullanıcıyı doğrulama ve yeni JWT oluşturma
    public String authenticateAndGenerateToken(String username, String password) {
        Doctor admin = doctorRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Here, you would also check the password (e.g., using bcrypt) before generating the token
        if (admin.getPassword().equals(password)) {
            // Generate token if authentication is successful
            return jwtUtils.generateTokenFromUsername(username);
        } else {
            throw new RuntimeException("Invalid password");
        }
    }

    // Kullanıcının yetkilerini kontrol etme (örn. Admin yetkisi)
    public boolean isAdmin(String token) {
        Doctor admin = getAdminFromJwt(token);
        return admin.getRole().name().equals("ADMIN"); // Assuming role is stored as enum
    }

    // Authorization check: Ensures that the user has the correct role
    public boolean hasRole(String token, String requiredRole) {
        Doctor admin = getAdminFromJwt(token);
        return admin.getRole().name().equalsIgnoreCase(requiredRole);
    }
}


