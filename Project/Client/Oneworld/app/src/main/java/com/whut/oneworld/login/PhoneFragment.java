package com.whut.oneworld.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.UserInfo;
import com.whut.oneworld.login.conuserinfo.UserInfoViewModel;
import com.whut.oneworld.util.ServerInfo;

public class PhoneFragment extends Fragment implements View.OnClickListener {

    private UserInfoViewModel viewModel;
    private EditText login_phone_phonenum;
    private EditText login_phone_password;
    private Button btn_login_phone;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_phone, container, false);
        viewModel = ViewModelProviders.of(this).get(UserInfoViewModel.class);
        login_phone_phonenum = view.findViewById(R.id.login_phone_phonenum);
        login_phone_password = view.findViewById(R.id.login_phone_password);
        btn_login_phone = view.findViewById(R.id.btn_login_phone);
        // 事件监听，可以使用this，代替匿名函数，让本类implements View.OnClickListener，在onClick处理事件
        btn_login_phone.setOnClickListener(this);
        createObserver();
        return view;
    }

    // 处理Livedata回调
    public void createObserver() {
        viewModel.getUserInfo().observe(this, new Observer<UserInfo>() {
            @Override
            public void onChanged(UserInfo userInfo) {
                if (userInfo != null) {
                    Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
                    viewModel.insertLocal(userInfo);
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences(ServerInfo.MY_USERINFO, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("userName", userInfo.getUserName());
                    editor.apply();
                } else {
                    Toast.makeText(getActivity(), "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_phone:
                String phoneNum = login_phone_phonenum.getText().toString();
                String passWord = login_phone_password.getText().toString();
                if (TextUtils.isEmpty(phoneNum) || TextUtils.isEmpty(passWord)) {
                    Toast.makeText(getActivity(), "请输入正确信息", Toast.LENGTH_SHORT).show();
                    return;
                }Toast.makeText(getActivity(), phoneNum, Toast.LENGTH_SHORT).show();
                viewModel.getNetUserInfoByPhone(phoneNum, passWord);
                break;
        }
    }
}
