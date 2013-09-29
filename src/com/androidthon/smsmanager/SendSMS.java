package com.androidthon.smsmanager;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMS  extends Activity{
	
	EditText phoneNumber, sms;
	Button smsSend;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		smsSend = (Button) findViewById(R.id.bt_send_sms);
		phoneNumber = (EditText) findViewById(R.id.et_phone);
		sms = (EditText) findViewById(R.id.et_sms);
		
		smsSend.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				String smsTEXT = sms.getText().toString();
				String phoneNo = phoneNumber.getText().toString();
				
				try {
					//Initializing SMS Manager and sending the message to the typed phone number
					SmsManager mysmsManager = SmsManager.getDefault();
					mysmsManager.sendTextMessage(phoneNo, null, smsTEXT, null, null);
					
					Toast.makeText(getApplicationContext(), "SMS SENT Successfully!", Toast.LENGTH_LONG).show();
					
					//to close the app after sending your message, you can add the finish(); method at the end as shown below
					//finish(); 					
					
				} catch (Exception e) {
					
					Toast.makeText(getApplicationContext(), "SMS failed to send  Please try again later", Toast.LENGTH_LONG).show();
					
					e.printStackTrace();
				}
				
			}
		});
	}
	
	

}
