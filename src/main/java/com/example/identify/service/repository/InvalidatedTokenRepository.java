package com.example.identify.service.repository;

import com.example.identify.service.entity.InvalidatedToken;
import com.example.identify.service.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {

}
