package com.bancodelcomercio.retopractico.data.repository;

import com.bancodelcomercio.retopractico.data.datasource.datastore.UsuarioDataStore;
import com.bancodelcomercio.retopractico.data.datasource.datastore.UserDataStoreFactory;
import com.bancodelcomercio.retopractico.domain.model.Usuario;
import com.bancodelcomercio.retopractico.domain.repository.RepositoryCallback;
import com.bancodelcomercio.retopractico.domain.repository.UserRepository;
import com.bancodelcomercio.retopractico.interactor.usuario.ListUserServicesCallback;
import com.bancodelcomercio.retopractico.presentation.utils.Constants;

import java.util.List;

public class UserDataRepository implements UserRepository {

    private final UserDataStoreFactory userDataStoreFactory;

    public UserDataRepository(UserDataStoreFactory userDataStoreFactory) {
        this.userDataStoreFactory = userDataStoreFactory;
    }

    @Override
    public void listUsers(ListUserServicesCallback listUserServicesCallback) {
        final UsuarioDataStore usuarioDataStore = userDataStoreFactory.create(Constants.STORE.CLOUD);
        usuarioDataStore.listUsers(new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                listUserServicesCallback.onListUsersError(message);
            }

            @Override
            public void onSuccess(Object object) {
                List<Usuario> usuarios = (List<Usuario>) object;
                listUserServicesCallback.onListUsersSuccess(usuarios);
            }
        });
    }
}
