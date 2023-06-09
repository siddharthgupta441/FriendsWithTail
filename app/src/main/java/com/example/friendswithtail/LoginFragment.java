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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
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
    DatabaseReference db;
    User user;

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

                /*db = FirebaseDatabase.getInstance().getReference().child("user");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                            User user =dataSnapshot.getValue(User.class);
                            assert user != null;
                            final ArrayList<String> db_email = new ArrayList<>();
                            final ArrayList<String> db_password = new ArrayList<>();
                            db_email.add(user.email);
                            db_password.add(user.password);
                            for (int i = 0; i < db_email.size(); i++){
                                if(Objects.equals(email, db_email.get(i)) && Objects.equals(password, db_password.get(i))){
                                    Intent intent = new Intent(getActivity(), MainActivity2.class);
                                    startActivity(intent);
                                    getActivity().finish();
                                }
                            }
                            *//*else
                                Toast.makeText(getActivity(), "wrong credential", Toast.LENGTH_LONG).show();*//*
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });*/

                Intent intent = new Intent(getActivity(), MainActivity2.class);
                startActivity(intent);
                //Toast.makeText(getActivity(), "wrong credential", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}