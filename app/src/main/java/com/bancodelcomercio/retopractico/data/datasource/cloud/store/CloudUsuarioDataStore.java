package com.bancodelcomercio.retopractico.data.datasource.cloud.store;

import com.bancodelcomercio.retopractico.data.datasource.cloud.apiclient.ApiClient;
import com.bancodelcomercio.retopractico.data.datasource.cloud.model.user.response.WsDataUser;
import com.bancodelcomercio.retopractico.data.datasource.datastore.UsuarioDataStore;
import com.bancodelcomercio.retopractico.data.mapper.UsuarioDataMapper;
import com.bancodelcomercio.retopractico.domain.model.Usuario;
import com.bancodelcomercio.retopractico.domain.repository.RepositoryCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CloudUsuarioDataStore implements UsuarioDataStore {
    private static final String TAG = "CloudUsuarioDataStore";

    UsuarioDataMapper usuarioDataMapper;

    public CloudUsuarioDataStore() {
        usuarioDataMapper = new UsuarioDataMapper();
    }

    @Override
    public void listUsers(RepositoryCallback repositoryCallback) {

        Call<List<WsDataUser>> call = ApiClient.getApiClient().listUsers();
        call.enqueue(new Callback<List<WsDataUser>>() {
            @Override
            public void onResponse(Call<List<WsDataUser>> call, Response<List<WsDataUser>> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        List<WsDataUser> wsDataUsers = response.body();
                        List<Usuario> usuarios = usuarioDataMapper.transformWsToLocal(wsDataUsers);
                        repositoryCallback.onSuccess(usuarios);
                    } else {
                        repositoryCallback.onError("Error");
                    }
                } else {
                    repositoryCallback.onError("Error Conexión al servidor");
                }
            }

            @Override
            public void onFailure(Call<List<WsDataUser>> call, Throwable t) {
                repositoryCallback.onError(t.getMessage());
            }
        });

    }
}
