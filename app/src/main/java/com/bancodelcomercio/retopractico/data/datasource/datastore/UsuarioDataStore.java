package com.bancodelcomercio.retopractico.data.datasource.datastore;


import com.bancodelcomercio.retopractico.domain.repository.RepositoryCallback;


public interface UsuarioDataStore {

    void listUsers(RepositoryCallback repositoryCallback);

}
