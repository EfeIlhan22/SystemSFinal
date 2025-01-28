package com.example.demo.security;

import com.example.demo.models.Doctor;
import com.example.demo.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private final DoctorRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor user = adminRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Doctor not found"));
        return  UserDetailsImpl.build(user);

    }
}
