package com.bancodelcomercio.retopractico.domain.repository;

import com.bancodelcomercio.retopractico.interactor.usuario.ListUserServicesCallback;

public interface UserRepository {

    void listUsers(ListUserServicesCallback listUserServicesCallback);

}
