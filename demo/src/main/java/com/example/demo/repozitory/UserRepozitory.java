package com.example.demo.repozitory;

import com.example.demo.domen.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepozitory extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
