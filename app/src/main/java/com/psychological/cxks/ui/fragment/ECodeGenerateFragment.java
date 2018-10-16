package com.psychological.cxks.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.param.GeneDisCodeParam;
import com.psychological.cxks.http.ApiWrapper;

import io.reactivex.disposables.Disposable;

public class ECodeGenerateFragment extends BaseFragment {

    private TextView generate;
    private EditText etDiscount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_e_code_generate, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        generate = view.findViewById(R.id.generate);
        etDiscount = view.findViewById(R.id.et_discount);

        generate.setOnClickListener(v -> {
            String content = etDiscount.getText().toString();
            if (TextUtils.isEmpty(content)) {
                Toast.makeText(getActivity(), "折扣不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            if (Integer.parseInt(content) > 1 || Integer.parseInt(content) < 0) {
                Toast.makeText(getActivity(), "折扣范围:0-1", Toast.LENGTH_SHORT).show();
                return;
            }
            GeneDisCodeParam param = new GeneDisCodeParam();
            // TODO 请求参数与效果图不匹配
        });
    }
}
