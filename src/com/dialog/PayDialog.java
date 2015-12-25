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

public class PayDialog extends Dialog {

	
	private EditText carid,carpay;
	private Button confirm,cancel;
	
	public PayDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_pay);
		setCanceledOnTouchOutside(false);
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		carid = (EditText) findViewById(R.id.dialog_carpayid);
		carpay = (EditText) findViewById(R.id.dialog_carpay);
		confirm  = (Button) findViewById(R.id.dialog_carpaycomfirm);
		cancel = (Button) findViewById(R.id.dialog_carpayancel);
		
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
				String id = carid.getText().toString().trim();
				String money = carpay.getText().toString().trim();
				
				if(TextUtils.isEmpty(id) || TextUtils.isEmpty(money)) {
					Toast.makeText(getContext(), "«Î»´≤ø ‰»Î!", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	
}
