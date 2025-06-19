package com.tcs.user.repository;

import com.tcs.user.model.Login;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
  Optional<Login> findByEmail(String email);
}
