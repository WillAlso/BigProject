package com.whut.oneworld.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.whut.oneworld.PersonalActivity;
import com.whut.oneworld.R;
import com.whut.oneworld.login.LoginActivity;

public class MeFragment extends Fragment {

    private ImageView image_head;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ImageView imageView = view.findViewById(R.id.image_more);
        image_head = view.findViewById(R.id.image_head);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonalActivity.class);
                startActivity(intent);
            }
        });

        image_head.setOnClickListener((View v) -> {
            getActivity().getSupportFragmentManager().popBackStack();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
        });
        return view;
    }
}
