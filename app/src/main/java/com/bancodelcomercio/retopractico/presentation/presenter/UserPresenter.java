package com.bancodelcomercio.retopractico.presentation.presenter;

import com.bancodelcomercio.retopractico.data.datasource.datastore.UserDataStoreFactory;
import com.bancodelcomercio.retopractico.data.repository.UserDataRepository;
import com.bancodelcomercio.retopractico.domain.model.Usuario;
import com.bancodelcomercio.retopractico.domain.repository.UserRepository;
import com.bancodelcomercio.retopractico.interactor.usuario.ListUserServicesCallback;
import com.bancodelcomercio.retopractico.interactor.usuario.UserInteractor;
import com.bancodelcomercio.retopractico.presentation.view.UserView;

import java.util.List;

public class UserPresenter implements Presenter<UserView>, ListUserServicesCallback {

    private UserView userView;
    private UserInteractor userInteractor;

    public void listUsers() {
        userInteractor.listUsers(this);
    }

    @Override
    public void addView(UserView view) {
        this.userView = view;
        UserRepository requestRepository = new UserDataRepository(new UserDataStoreFactory(this.userView.getContext()));
        userInteractor = new UserInteractor(requestRepository);
    }

    @Override
    public void removeView(UserView view) {
    }


    @Override
    public void onListUsersSuccess(List<Usuario> usuarios) {
        userView.listUsers(usuarios);
    }

    @Override
    public void onListUsersError(String message) {
        userView.showErrorMessage(message);
    }
}
