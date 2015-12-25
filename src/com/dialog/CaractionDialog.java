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

public class CaractionDialog extends Dialog {

	private EditText caridtext,caractionet;
	private Button comfirm,cancel;
	
	
	public CaractionDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_caraction);
		setCanceledOnTouchOutside(false);
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		caridtext = (EditText) findViewById(R.id.dialog_caractionid);
		caractionet = (EditText) findViewById(R.id.dialog_caraction);
		
		comfirm = (Button) findViewById(R.id.dialog_caractioncomfirm);
		cancel = (Button) findViewById(R.id.dialog_caractioncancel);
		
		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cancel();
			}
		});
		
		comfirm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String id = caridtext.getText().toString();
				String action = caractionet.getText().toString().trim();
				
				if(TextUtils.isEmpty(id) || TextUtils.isEmpty(action)) {
					Toast.makeText(getContext(), "«Î»´≤ø ‰»Î£°", Toast.LENGTH_SHORT).show();
				    return;
				}
				
				
			}
		});
	}
	

}
