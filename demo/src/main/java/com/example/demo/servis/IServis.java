package com.example.demo.servis;

import java.util.List;

public interface IServis<T> {
    T save(T item);
    List<T> getAll();
    T update(T item);




}
