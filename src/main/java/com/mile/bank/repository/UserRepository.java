package com.mile.bank.repository;

import com.mile.bank.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);
}
