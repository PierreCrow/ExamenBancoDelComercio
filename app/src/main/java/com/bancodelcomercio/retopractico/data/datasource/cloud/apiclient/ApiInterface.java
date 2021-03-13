package com.bancodelcomercio.retopractico.data.datasource.cloud.apiclient;

import com.bancodelcomercio.retopractico.data.datasource.cloud.model.user.response.WsDataUser;
import com.bancodelcomercio.retopractico.presentation.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET(Constants.URLS.LIST_USERS)
    Call<List<WsDataUser>> listUsers();

}
