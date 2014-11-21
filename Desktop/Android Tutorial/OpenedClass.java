package com.example.shit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener{
	TextView question, test;
	Button returnData;
	RadioGroup selectionList;
	String gotEditText, setData;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initialize();
		/*try{
			Bundle gotEdTxt = getIntent().getExtras();
			gotEditText = gotEdTxt.getString("edTxt");
			question.setText(gotEditText);
		}catch(NullPointerException e){
			e.printStackTrace();
		}*/
	}
	private void initialize(){
		question = (TextView)findViewById(R.id.tvQuestion);
		test = (TextView)findViewById(R.id.tvText);
		returnData = (Button)findViewById(R.id.bReturn);
		returnData.setOnClickListener(this);
		selectionList = (RadioGroup)findViewById(R.id.rgAnswers);
		selectionList.setOnCheckedChangeListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent carrier = new Intent();
		Bundle pack = new Bundle();
		pack.putString("answer", setData);
		carrier.putExtras(pack);
		setResult(RESULT_OK, carrier); // operation succeeded
		finish();
	}
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch(checkedId){
		case R.id.radio1:
			setData = "Hakuna matata";
			break;
		case R.id.radio2:
			setData = "Choice 2 is the red pill";
			break;
		case R.id.radio3:
			setData = "A sworday, a red day, eres the sun rises";
			break;
		}
		test.setText(setData);
	}
}
