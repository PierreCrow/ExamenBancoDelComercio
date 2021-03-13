package com.bancodelcomercio.retopractico.presentation.view;

import com.bancodelcomercio.retopractico.domain.model.Usuario;

import java.util.List;

public interface UserView extends BaseView {

    void listUsers(List<Usuario> usuarios);

    void showLoading();

    void hideLoading();

    void showErrorMessage(String message);
}
