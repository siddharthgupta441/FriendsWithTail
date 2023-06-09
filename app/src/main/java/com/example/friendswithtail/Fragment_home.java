package com.example.friendswithtail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class Fragment_home extends Fragment {//implements NavigationView.OnNavigationItemSelectedListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_nav_view);
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_pets()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        return view;
    }

    //@Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.nav_pets)
            getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_pets()).commit();
        if(item.getItemId() == R.id.nav_event)
            getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_event()).commit();
        if (item.getItemId() == R.id.nav_report)
            getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_report()).commit();
        return true;
    }
}
