package com.example.friendswithtail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {
    private EditText name, email, pass, confirm_pass;
    private Button register;
    private String username, e_mail, password, cpass;
    FirebaseDatabase db;
    private DatabaseReference reference;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        name = view.findViewById(R.id.et_name);
        email = view.findViewById(R.id.et_email);
        pass = view.findViewById(R.id.et_password);
        confirm_pass = view.findViewById(R.id.et_repassword);
        register = view.findViewById(R.id.btn_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password = pass.getText().toString();
                cpass = confirm_pass.getText().toString();
                if(password.equals(cpass)){
                    username = name.getText().toString();
                    e_mail = email.getText().toString();
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference().child("");
                }
            }
        });


        return view;
    }

}