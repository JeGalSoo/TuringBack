package com.turing.api.common.service;


import com.turing.api.common.component.Messenger;

public interface CommandService<T> {

    Messenger save(T t);
    Messenger deleteById(Long id);
    Messenger modify(T t);
}
