package com.example.registerservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registerservice.entity.User;
import com.example.registerservice.entity.VerficationExpiryTime;
import com.example.registerservice.entity.VerifiedUser;

@Repository
public interface VerificationExpiryTimeRepo extends JpaRepository<VerficationExpiryTime, Long> {
}
