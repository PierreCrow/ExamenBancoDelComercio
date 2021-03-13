package com.bancodelcomercio.retopractico.presentation.ui.dialogfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.bancodelcomercio.retopractico.R;
import com.bancodelcomercio.retopractico.domain.model.Usuario;

public class UserDetailDialog extends DialogFragment {

    TextView tvName,tvId,tvUserName,tvEmail,tvAddress,tvPhone,tvWebsite,tvCompany;

    Usuario usuario;


    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.appu_user_detail_dialog, new LinearLayout(getActivity()), false);
        tvName = (TextView) view.findViewById(R.id.tvName);
        tvId = (TextView) view.findViewById(R.id.tvId);
        tvUserName = (TextView) view.findViewById(R.id.tvUserName);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvAddress = (TextView) view.findViewById(R.id.tvAddress);
        tvPhone = (TextView) view.findViewById(R.id.tvPhone);
        tvWebsite = (TextView) view.findViewById(R.id.tvWebsite);
        tvCompany = (TextView) view.findViewById(R.id.tvCompany);

        init();

        Dialog builder = new Dialog(getActivity());
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.setContentView(view);
        return builder;
    }

    void init()
    {
        Bundle bundle = getArguments();
        usuario = (Usuario) bundle.getSerializable("usuario");

        Integer id=usuario.getId();
        tvName.setText(usuario.getName());
        tvId.setText("ID: "+id.toString());
        tvUserName.setText("USERNAME: "+usuario.getUsername());
        tvEmail.setText("EMAIL: "+usuario.getEmail());
        tvAddress.setText("ADDRESS: "+usuario.getAddress().getStreet()+", "+usuario.getAddress().getSuite()+" ,"+usuario.getAddress().getCity()+" ,"+usuario.getAddress().getZipcode()+" ,"+usuario.getAddress().getUserGeo().getLat()+" "+usuario.getAddress().getUserGeo().getLng());
        tvPhone.setText("PHONE: "+usuario.getPhone());
        tvWebsite.setText("WEBSITE: "+usuario.getWebsite());
        tvCompany.setText("COMPANY: "+usuario.getCompany().getName()+" "+usuario.getCompany().getCatchPhrase()+" "+usuario.getCompany().getBs());
    }


    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);
            dialog.getWindow().getAttributes().alpha = 1f;
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        dismiss();
    }

}
