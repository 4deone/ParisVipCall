package com.bydeone.parisvipcall.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bydeone.parisvipcall.R;

import java.util.ArrayList;

public class LoginPasswordAdapter extends ArrayAdapter<LoginPassword> {

    Context context;
    private ArrayList<LoginPassword> loginPasswords;

    public LoginPasswordAdapter(Context context, int textViewResourceId, ArrayList<LoginPassword> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.loginPasswords = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.pass_adapter, null);
        }

        LoginPassword loginPassword = loginPasswords.get(position);

        if (loginPassword != null) {
            TextView passPosition = (TextView) v.findViewById(R.id.position);
            TextView nomService = (TextView) v.findViewById(R.id.nomService);
            TextView typeLogin = (TextView) v.findViewById(R.id.typeLogin);
            TextView login = (TextView) v.findViewById(R.id.login);
            TextView password = (TextView) v.findViewById(R.id.password);
            TextView commentaires = (TextView) v.findViewById(R.id.commentaires);

            passPosition.setText(String.valueOf(loginPassword.getPosition()));
            nomService.setText(String.valueOf(loginPassword.getNomService()));
            typeLogin.setText(String.valueOf(loginPassword.getType()));
            login.setText(String.valueOf(loginPassword.getLogin()));
            password.setText(String.valueOf(loginPassword.getPassword()));
            commentaires.setText(String.valueOf(loginPassword.getCommentaire()));
        }
        return v;
    }
}
