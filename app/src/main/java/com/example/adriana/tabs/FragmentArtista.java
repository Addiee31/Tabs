package com.example.adriana.tabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Adriana on 30/11/2015.
 */
public class FragmentArtista extends Fragment{
    View rootView;
    EditText txt;
    Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fram1_layout, container, false);
        txt = (EditText) rootView.findViewById(R.id.editText);

       btn= (Button) rootView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_click(txt);
            }
        });
        return rootView;
    }

    public void btn_click(EditText txt){
             String artista=txt.getText().toString();
             Toast.makeText(getActivity(), artista,
                Toast.LENGTH_SHORT).show();
    }



}
