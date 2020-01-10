package com.whut.oneworld.login;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.gson.Gson;
import com.whut.oneworld.R;
import com.whut.oneworld.bean.SignInfo;
import com.whut.oneworld.bean.UserInfo;
import com.whut.oneworld.login.conuserinfo.UserInfoViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SignUpFragment extends Fragment implements View.OnClickListener {

    private EditText sign_userid;
    private EditText sign_username;
    private EditText sign_password;
    private EditText sign_email;
    private EditText sign_code;
    private EditText sign_phonenum;
    private EditText sign_signature;
    private Button send_code;
    private Button btn_sign;
    private UserInfoViewModel viewModel;
    private String qcode = null;

    public SignUpFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_signup, container, false);
        sign_userid = view.findViewById(R.id.sign_userid);
        sign_username = view.findViewById(R.id.sign_username);
        sign_password = view.findViewById(R.id.sign_password);
        sign_email = view.findViewById(R.id.sign_email);
        sign_code = view.findViewById(R.id.sign_code);
        sign_phonenum = view.findViewById(R.id.sign_phonenum);
        sign_signature = view.findViewById(R.id.sign_signature);
        send_code = view.findViewById(R.id.send_code);
        btn_sign = view.findViewById(R.id.btn_sign);
        viewModel = ViewModelProviders.of(this).get(UserInfoViewModel.class);

        btn_sign.setOnClickListener(this);
        send_code.setOnClickListener(this);
        EventBus.getDefault().register(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEventCode(String code) {
        if (!code.equals("-1")) {
            Toast.makeText(getContext(), "发送成功", Toast.LENGTH_SHORT).show();
            qcode = code;
        } else {
            Toast.makeText(getContext(), "发送失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Subscribe
    public void onEventSign(Integer msg) {
        if (msg == 1) {
            Toast.makeText(getContext(), "注册成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "注册失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_code:
                sendCode();
                break;
            case R.id.btn_sign:
                signupUser();
                break;
            default:
                break;
        }
    }

    private void sendCode() {
        String userid = sign_userid.getText().toString();
        String username = sign_username.getText().toString();
        String password = sign_password.getText().toString();
        String email = sign_email.getText().toString();
        if (!TextUtils.isEmpty(userid)
                && !TextUtils.isEmpty(username)
                && !TextUtils.isEmpty(password)
                && !TextUtils.isEmpty(email)) {
            viewModel.sendCode(email);
        } else {
            Toast.makeText(getContext(), "请输入正确信息", Toast.LENGTH_SHORT).show();
        }
    }

    private void signupUser() {
        String userid = sign_userid.getText().toString();
        String username = sign_username.getText().toString();
        String password = sign_password.getText().toString();
        String email = sign_email.getText().toString();
        String code = sign_code.getText().toString();
        String phonenum = sign_phonenum.getText().toString();
        String signature = sign_signature.getText().toString();

        if (!TextUtils.isEmpty(userid)
                && !TextUtils.isEmpty(username)
                && !TextUtils.isEmpty(password)
                && !TextUtils.isEmpty(email)
                && !TextUtils.isEmpty(code)
                && !TextUtils.isEmpty(phonenum)
                && !TextUtils.isEmpty(signature)) {
            if (qcode == null || !qcode.equals(code)) {
                Toast.makeText(getContext(), "验证码不正确", Toast.LENGTH_SHORT).show();
                return;
            }
            UserInfo userInfo = new UserInfo(0, userid, username, password, email, phonenum, signature);
            SignInfo signInfo = new SignInfo(code, userInfo);
            String msg = (new Gson()).toJson(signInfo);
            viewModel.signUser(msg);
        } else {
            Toast.makeText(getContext(), "请输入正确信息", Toast.LENGTH_SHORT).show();
        }
    }
}
