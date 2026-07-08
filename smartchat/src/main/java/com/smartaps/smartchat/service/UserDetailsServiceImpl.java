package com.smartaps.smartchat.service;

import com.smartaps.smartchat.domain.Admin;
import com.smartaps.smartchat.repository.AdminRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AdminRepository repository; // Utilise votre repository Admin

    public UserDetailsServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Cherche dans la table 'admin' via le champ 'login'
        Admin admin = repository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Admin non trouvé"));

        return User.builder()
                .username(admin.getLogin())
                .password(admin.getMotDePasse())
                .roles(admin.getRole())
                .build();
    }
}