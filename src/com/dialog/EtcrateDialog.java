package com.dialog;

import com.example.jiaotong.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EtcrateDialog extends Dialog {

	private EditText etcrate,etcmoney;
	private Button confirm,cancel;
	
	public EtcrateDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_etcrate);
		setCanceledOnTouchOutside(false);
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		etcrate  = (EditText) findViewById(R.id.dialog_etcratetype);
		etcmoney = (EditText) findViewById(R.id.dialog_etcratemoney);
		
		confirm = (Button) findViewById(R.id.dialog_etcratecomfirm);
		cancel = (Button) findViewById(R.id.dialog_etcratecancel);
		
		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cancel();
			}
		});
		confirm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String type = etcrate.getText().toString().trim();
				String money = etcmoney.getText().toString();
				if(TextUtils.isEmpty(type) || TextUtils.isEmpty(money)) {
					Toast.makeText(getContext(), "«Î»´≤ø ‰»Î", Toast.LENGTH_SHORT);
					return;
				}
			}
		});
	}

	
}
