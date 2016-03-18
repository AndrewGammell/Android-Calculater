package com.andrew.calcute;



import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

	boolean sum;
	StringBuilder sbd = new StringBuilder();
	StringBuilder sb = new StringBuilder();
	private String input ="0.0";
	private double input1 =0.0D;
	private String str="";
	private String displayInput ="";
	private double totalInput=0.0D;
	private String operator="";

	TextView second_view;
	private TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		createWidgets();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private class ClickFunction implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			try{
				switch(v.getId()){
				case R.id.button_add: input1 = Double.parseDouble(input);                
				input = sb.replace(0, sb.length(),str).toString();
				displayInput = sbd.append("+").toString();
				text.setText(displayInput); 
				doMath();
				operator = "+"; 
				break;
				case R.id.button_divide: input1 = Double.parseDouble(input);                
				input = sb.replace(0, sb.length(),str).toString();
				displayInput = sbd.append("\u00F7").toString();
				text.setText(displayInput); 
				doMath();
				operator = "/";
				break;
				case R.id.button_minus: input1 = Double.parseDouble(input);                
				input = sb.replace(0, sb.length(),str).toString();
				displayInput = sbd.append("\u2212").toString();
				text.setText(displayInput); 
				doMath();
				operator = "-"; 
				break;
				case R.id.button_multiply: input1 = Double.parseDouble(input);                
				input = sb.replace(0, sb.length(),str).toString();
				displayInput = sbd.append("\u00D7").toString();
				text.setText(displayInput); 
				doMath();
				operator = "*"; 
				break;
				case R.id.button_equals: displayInput = sbd.append("\u003D").toString();
				input1 = Double.parseDouble(input);
				doMath();
				if(totalInput % 1==0){
					displayInput = sbd.append(((int)totalInput)).toString();
				}else{
					displayInput = sbd.append(String.format("%.2f", totalInput)).toString();
				}
				text.setText(displayInput);
				operator = "=";
				break;
				case R.id.button_clear:  input ="";
		           text.setText(""); 
		           input1=0.0D;
		           totalInput=0.0D;
		           sb.replace(0, sb.length(),str).toString();
		           sbd.replace(0, sbd.length(),str).toString();
		           operator="";
				}
			}catch(NumberFormatException  | ArithmeticException e ){
				
			}
			
		}

		private void doMath(){
			switch(operator){
			case "": totalInput += input1;
			break;
			case "+": totalInput += input1;
			break;
			case "-": totalInput -= input1;
			break;
			case "*": totalInput *= input1;
			break;
			case "/": totalInput /= input1;
			break;
			case "=": totalInput += 0;
			break;
			}
		}
	}

	private class ClickInput implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			try{
				input(v);
			}catch(NumberFormatException nfe){
				text.setText("Please fill both text fields");
			}catch(ArithmeticException e){

			}
		}
		
		
		private void input(View v){
			switch(v.getId()){
			case R.id.button0:
				checkOperator();
				input = sb.append("0").toString();
			displayInput = sbd.append("0").toString();
			text.setText(displayInput);  
			break;
			case R.id.button1:
				checkOperator();
				input = sb.append("1").toString();
			displayInput = sbd.append("1").toString();
			text.setText(displayInput);
			break;
			case R.id.button2:
				checkOperator();
				input = sb.append("2").toString();
			displayInput = sbd.append("2").toString();
			text.setText(displayInput);
			break;
			case R.id.button3:
				checkOperator();
				input = sb.append("3").toString();
			displayInput = sbd.append("3").toString();
			text.setText(displayInput);
			break;
			case R.id.button4:
				checkOperator();
				input = sb.append("4").toString();
			displayInput = sbd.append("4").toString();
			text.setText(displayInput);
			break;
			case R.id.button5:
				checkOperator();
				input = sb.append("5").toString();
			displayInput = sbd.append("5").toString();
			text.setText(displayInput);
			break;
			case R.id.button6:
				checkOperator();
				input = sb.append("6").toString();
			displayInput = sbd.append("6").toString();
			text.setText(displayInput);
			break;
			case R.id.button7:
				checkOperator();
				input = sb.append("7").toString();
			displayInput = sbd.append("7").toString();
			text.setText(displayInput);
			break;
			case R.id.button8:
				checkOperator();
				input = sb.append("8").toString();
			displayInput = sbd.append("8").toString();
			text.setText(displayInput);
			break;
			case R.id.button9:
				checkOperator();
				input = sb.append("9").toString();
			displayInput = sbd.append("9").toString();
			text.setText(displayInput);
			break;
			case R.id.button_point:
				checkOperator();
				input = sb.append(".").toString();
			displayInput = sbd.append(".").toString();
			text.setText(displayInput);
			break;
			}
		}

	}

	private void checkOperator(){
		if(operator.equals("=")){
			text.setText("");
			input1=0.0D;
			totalInput=0.0D;
			sb.replace(0, sb.length(),str).toString();
			sbd.replace(0, sbd.length(),str).toString();
			operator="";
		}
	}

	private void createWidgets(){
		text = (TextView)findViewById(R.id.text_view);
		ViewGroup vg = (ViewGroup)findViewById(R.id.grid);
		List<View>  inputList =  getViewsByTag(vg,"input");
		List<View>  functionList =  getViewsByTag(vg,"function");

		for(View button: inputList){
			button.setOnClickListener(new ClickInput());
		}

		for(View button: functionList){
			button.setOnClickListener(new ClickFunction());
		}


	}


	private ArrayList<View> getViewsByTag(ViewGroup root, String tag){
		ArrayList<View> views = new ArrayList<View>();
		final int childCount = root.getChildCount();
		for (int i = 0; i < childCount; i++) {
			final View child = root.getChildAt(i);
			if (child instanceof ViewGroup) {
				views.addAll(getViewsByTag((ViewGroup) child, tag));
			}

			final Object tagObj = child.getTag();
			if (tagObj != null && tagObj.equals(tag)) {
				views.add(child);
			}

		}
		return views;
	}




}