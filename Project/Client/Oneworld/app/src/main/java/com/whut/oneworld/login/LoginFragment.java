package com.whut.oneworld.login;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.whut.oneworld.R;


public class LoginFragment extends Fragment {

    private Button login_to_signup;
    private Button login_to_phone;

    public LoginFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        login_to_signup = view.findViewById(R.id.login_to_signup);
        login_to_phone = view.findViewById(R.id.login_to_phone);

        // 使用lambda
        login_to_signup.setOnClickListener((View v) -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            Fragment fragment = fragmentManager.findFragmentById(R.id.frag_signup);
            if (fragment == null) {
                fragment = new SignUpFragment();
                fragmentManager.beginTransaction().remove(this).add(R.id.frag_signup, fragment).commit();
            }
        });

        login_to_phone.setOnClickListener((View v) -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            Fragment fragment = fragmentManager.findFragmentById(R.id.frag_phone);
            if (fragment == null) {
                fragment = new PhoneFragment();
                fragmentManager.beginTransaction().remove(this).add(R.id.frag_phone, fragment).commit();
            }
        });
        return view;
    }

}
