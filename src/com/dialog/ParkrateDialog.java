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

public class ParkrateDialog extends Dialog {

	private EditText type,money;
	private Button confirm,cancel;
	
	
	public ParkrateDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_parkrate);
		setCanceledOnTouchOutside(false);
		
		initView();
	}


	private void initView() {
		// TODO Auto-generated method stub
		type = (EditText) findViewById(R.id.dialog_parkratetype);
		money = (EditText) findViewById(R.id.dialog_parkratemoney);
		confirm = (Button) findViewById(R.id.dialog_parkratecomfirm);
		cancel = (Button) findViewById(R.id.dialog_parkratecancel);
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
				String type1 = type.getText().toString().trim();
				String money1 = money.getText().toString().trim();
				
				if(TextUtils.isEmpty(type1) || TextUtils.isEmpty(money1)) {
					Toast.makeText(getContext(), "«Î»´≤ø ‰»Î!", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	
	
}
