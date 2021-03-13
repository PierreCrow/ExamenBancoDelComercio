package com.bancodelcomercio.retopractico.interactor.usuario;

import com.bancodelcomercio.retopractico.domain.repository.UserRepository;

public class UserInteractor {

    private final UserRepository userRepository;

    public UserInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void listUsers(ListUserServicesCallback listUserServicesCallback) {
        userRepository.listUsers(listUserServicesCallback);
    }

}
