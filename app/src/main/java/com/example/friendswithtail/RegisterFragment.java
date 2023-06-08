package com.example.friendswithtail;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

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

                    registerSuccess(username, e_mail, password);
                }
                else
                    Toast.makeText(getActivity(), "username", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
    public void registerSuccess(String username, String e_mail, String password){
        db = FirebaseDatabase.getInstance();
        reference = db.getReference().child("user");
        HashMap<String, String> hs = new HashMap<>();
        hs.put("name", username);
        hs.put("email", e_mail);
        hs.put("password", password);
        reference.push().setValue(hs).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(getActivity(), "registration successfully.", Toast.LENGTH_LONG).show();
            }
        });
        Toast.makeText(getActivity(), "registration successfully.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}