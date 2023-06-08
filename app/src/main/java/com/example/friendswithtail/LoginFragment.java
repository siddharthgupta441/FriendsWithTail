package com.example.friendswithtail;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    private Button login;
    private EditText e_mail, pass;
    private String email, password;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        e_mail = view.findViewById(R.id.et_email);
        pass = view.findViewById(R.id.et_password);
        login = view.findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = e_mail.getText().toString();
                password = pass.getText().toString();
                if(Objects.equals(email, "shukla") && password.equals("1234")){
                    //Toast.makeText(getActivity(), "kmnv", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), MainActivity2.class);
                    startActivity(intent);
                    //getActivity().finish();
                }
                else{
                    Toast.makeText(getActivity(), "wrong credential", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}