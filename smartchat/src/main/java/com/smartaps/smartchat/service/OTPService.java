package com.smartaps.smartchat.service;

import com.smartaps.smartchat.domain.Otp;
import com.smartaps.smartchat.domain.Client;
import com.smartaps.smartchat.repository.OtpRepository;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Random;

@Service
public class OTPService {

    private final OtpRepository otpRepository;

    public OTPService(OtpRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    public Otp genererCodeUnique(Client client) {
        // Code à 6 chiffres pour la sécurité mobile
        String code = String.valueOf(100000 + new Random().nextInt(900000));

        Otp otp = Otp.builder()
                .code(code)
                .client(client)
                .dateCreation(new Date())
                // Expiration après 5 minutes pour limiter les risques [7]
                .dateExpiration(new Date(System.currentTimeMillis() + 300000))
                .utilise(false)
                .build();

        return otpRepository.save(otp);
    }
}