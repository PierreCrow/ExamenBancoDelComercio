package com.bancodelcomercio.retopractico.presentation.ui.activities;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;

import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bancodelcomercio.retopractico.R;
import com.bancodelcomercio.retopractico.domain.model.Usuario;
import com.bancodelcomercio.retopractico.presentation.presenter.UserPresenter;
import com.bancodelcomercio.retopractico.presentation.ui.adapters.UsersListDataAdapter;
import com.bancodelcomercio.retopractico.presentation.ui.dialogfragment.UserDetailDialog;
import com.bancodelcomercio.retopractico.presentation.view.UserView;

import java.util.List;

import butterknife.BindView;

public class MisUsersActivity extends BaseActivity implements UsersListDataAdapter.OnUsersListDataAdapterClickListener, UserView {


    @BindView(R.id.rvUsers)
    RecyclerView rvUsers;


    UsersListDataAdapter.OnUsersListDataAdapterClickListener mlistener;
    UsersListDataAdapter adapter;
    UserPresenter userPresenter;
    List<Usuario> usuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appu_users);
        injectView();
        loadPresenter();
    }

    void loadPresenter() {
        mlistener = this;
        userPresenter = new UserPresenter();
        userPresenter.addView(this);
        userPresenter.listUsers();
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {

    }

    void showDetail(Usuario usuario) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("usuario", usuario);
        UserDetailDialog df = new UserDetailDialog();
        df.setArguments(bundle);
        df.show(getSupportFragmentManager(), "");
    }


    @Override
    public void listUsers(List<Usuario> usuarios) {
        this.usuarios = usuarios;

        adapter = new UsersListDataAdapter(mlistener, getContext(), usuarios);
        rvUsers.setHasFixedSize(true);
        rvUsers.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvUsers.setAdapter(adapter);

        int[] ATTRS = new int[]{android.R.attr.listDivider};
        TypedArray a = getContext().obtainStyledAttributes(ATTRS);
        Drawable divider = a.getDrawable(0);
        int inset = getResources().getDimensionPixelSize(R.dimen.marginrecyclwe);
        InsetDrawable insetDivider = new InsetDrawable(divider, inset, 0, inset, 0);
        a.recycle();
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(insetDivider);

        rvUsers.addItemDecoration(itemDecoration);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onUsersListDataAdapterClicked(Usuario usuario) {
        showDetail(usuario);
    }
}