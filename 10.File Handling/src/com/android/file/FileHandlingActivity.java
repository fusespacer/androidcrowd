package com.android.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FileHandlingActivity extends Activity {
EditText edit;
Button btnWrite,btnRead;
FileInputStream fIp;
FileOutputStream fOp;
File f =new File(Environment.getExternalStorageDirectory()+"/Aj.txt");
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        edit = (EditText)findViewById(R.id.editText1);
        btnWrite = (Button)findViewById(R.id.button1);
        btnRead = (Button)findViewById(R.id.button2);
        btnWrite.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String value = edit.getText().toString();
				try {
					fOp =new FileOutputStream(f);
					
					byte  b[] =value.getBytes();	//Change String to bytes
						fOp.write(b);
								//Write to file , IO Exception
				Toast.makeText(getApplicationContext(), "file writed", 4000).show();

				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		});
        btnRead.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int val;
				try{
				fIp =new FileInputStream(f);
				String input=" ";
				while((val=fIp.read())!=-1)
				{
				input =input+(char)val;	//Read the file and store in string
				}
				edit.setText(null);
				edit.setText(input);
				Toast.makeText(getApplicationContext(), input, 4000).show();
				}catch(FileNotFoundException e){
					e.printStackTrace();
				}catch(IOException ee){
					ee.printStackTrace();
				}
			}
		});
    }
}