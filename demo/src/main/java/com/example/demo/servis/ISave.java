package com.example.demo.servis;

import com.example.demo.domen.User;
import com.example.demo.dto.RegistrationUser;

public interface ISave<T,B> {
    T save(B item);



}
