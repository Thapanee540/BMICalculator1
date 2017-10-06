package com.example.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.bmicalculator.R.drawable.bmi;

public class MainActivity extends AppCompatActivity {

    private EditText mHeightEditText, mWeightEditText ;
    private Button mCalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeightEditText = (EditText) findViewById(R.id.height_edit_text);
        mWeightEditText = (EditText) findViewById(R.id.weight_edit_text);
        mCalculateButton = (Button) findViewById(R.id.calculate_button);

        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightText = mHeightEditText.getText().toString();
                Double height = Double.valueOf(heightText);///แปลง String เป็น double
                Double weight = Double.valueOf(mWeightEditText.getText().toString());///แปลง String เป็น double
                Double BMI = weight/((height/100)*(height/100)) ;

                String bmiText = getBmiText(BMI);
                Intent intent = new Intent(MainActivity.this,BmiResultActivity.class);
//                String result = "ค่า BMI ที่ได้คือ "+String.valueOf(BMI);
                String result = "ค่า BMI ที่ได้คือ "+String.format("%.2f",BMI);
                intent.putExtra("ResultBMI",result);
                String result1="อยู่ในเกณฑ์ : "+ bmiText;
                intent.putExtra("ResultBMI1",result1);
//                String result = String.format("ค่า BMI ที่ได้คือ %.1f\n\nอยู่ในเกณฑ์ : %s",BMI,bmiText);


                /*AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("BMI Result");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //โค้ดที่ต้องการให้ทำงาน เมื่อกดปุ่มOK ในไดอะลอกถูกคลิก
//                        finish(); ///ปิด แอตทริวิตี้ ปัจจุบัน
                        mHeightEditText.setText("");
                        mWeightEditText.setText("");
                        mHeightEditText.requestFocus();
                    }
                });
                dialog.show(); */
//                intent.putExtra("bmi_value",BMI);
//                intent.putExtra("bmi_text",bmiText);
                startActivity(intent);
//                Toast t = Toast.makeText(MainActivity.this,"ค่า ฺBMI ที่ได้คือ "+BMI,Toast.LENGTH_LONG);
//                t.show();
            }

            private String getBmiText(Double bmi) {

                String bmiText = "";
                if(bmi < 18.5){
                    bmiText = "น้ำหนักน้อยกว่าปกติ";
                }else if(bmi < 25){
                    bmiText = "น้ำหนักปกติ";
                }else if(bmi < 30){
                    bmiText = "น้ำหนักมากว่าปกติ (ท้วม)";
                }else{
                    bmiText = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
                }
                return bmiText;
            }
        });

        //fire intent
        ///สร้างออบเจกที่ทำหน้าที่ เป็น listener ของปุ่ม
        //MyListener listener = new MyListener();
        /// กำหนดออบเจกที่เป็น listener ให้กับปุ่ม
        //mCalculateButton.setOnClickListener(listener);

    }/// ปิดเมธอดonCrete


    /*private class MyListener implements View.OnClickListener{


        @Override
        public void onClick(View v) {
            ///โค้ดที่เราต้องการให้ทำงาน เมื่อปุ่มถูกคลิก
            Toast t = Toast.makeText(MainActivity.this,/*context"Hello"/*ข้อความที่แสดงในtoast,
                    Toast.LENGTH_SHORT/*ระยะเวลาในการแสดงtoast);///สร้าวออบเจกtoast
            t.show();///แสดงtoast
        }
    }*/

}///ปิดคลาส MainActivity
