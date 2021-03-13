package com.bancodelcomercio.retopractico.presentation.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bancodelcomercio.retopractico.R;
import com.bancodelcomercio.retopractico.domain.model.Usuario;

import java.util.List;

public class UsersListDataAdapter extends RecyclerView.Adapter<UsersListDataAdapter.SingleItemRowHolder> {

    private List<Usuario> itemsList;
    private Context mContext;
    public OnUsersListDataAdapterClickListener mlistener;

    public UsersListDataAdapter(OnUsersListDataAdapterClickListener mlistener, Context context, List<Usuario> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
        this.mlistener = mlistener;
    }

    public interface OnUsersListDataAdapterClickListener {
        void onUsersListDataAdapterClicked(Usuario usuario);
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.appu_item_users, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {
        Usuario usuario = itemsList.get(i);
        holder.tvemail.setText(usuario.getEmail());
        holder.tvname.setText(usuario.getName());
    }


    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected TextView tvname, tvemail;

        public SingleItemRowHolder(View view) {
            super(view);
            this.tvname = (TextView) view.findViewById(R.id.tvname);
            this.tvemail = (TextView) view.findViewById(R.id.tvemail);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mlistener.onUsersListDataAdapterClicked(itemsList.get(getPosition()));
        }
    }

}
