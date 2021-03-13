package com.bancodelcomercio.retopractico.interactor.usuario;

import com.bancodelcomercio.retopractico.domain.model.Usuario;
import java.util.List;

public interface ListUserServicesCallback {

    void onListUsersSuccess(List<Usuario> usuarios);

    void onListUsersError(String message);
}
