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
            v = vi.inflate(R.layout.team, null);
        }

        LoginPassword loginPassword = loginPasswords.get(position);

        if (loginPassword != null) {
            TextView pos = (TextView) v.findViewById(R.id.position);
            TextView name = (TextView) v.findViewById(R.id.name);
            TextView wins = (TextView) v.findViewById(R.id.wins);
            TextView draws = (TextView) v.findViewById(R.id.draws);
            TextView losses = (TextView) v.findViewById(R.id.losses);
            TextView points = (TextView) v.findViewById(R.id.points);

            pos.setText(String.valueOf(o.getPosition()));
            name.setText(String.valueOf(o.getName()));
            wins.setText(String.valueOf(o.getWins()));
            draws.setText(String.valueOf(o.getDraws()));
            losses.setText(String.valueOf(o.getLosses()));
            points.setText(String.valueOf(o.getPoints()));
        }
        return v;
    }
}
