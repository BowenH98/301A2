package com.example.bowenhu.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Button save=(Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date=((EditText)findViewById(R.id.date)).getText().toString();
                String time=((EditText)findViewById(R.id.time)).getText().toString();
                String SystolicPressure=((EditText)findViewById(R.id.SystolicPressure)).getText().toString();
                String DiastolicPressure=((EditText)findViewById(R.id.DiastolicPressure)).getText().toString();
                String HeartRate=((EditText)findViewById(R.id.HeartRate)).getText().toString();
                String comment=((EditText)findViewById(R.id.comment)).getText().toString();

                if ("".equals(comment)){
                    comment = "No comment";
                }

                if (!"".equals(date) && !"".equals(time) && !"".equals(SystolicPressure) && !"".equals(DiastolicPressure) && !"".equals(HeartRate)){
                    Intent intent = new Intent(AddActivity.this,MainActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putCharSequence("SystolicPressure",SystolicPressure);
                    bundle.putCharSequence("DiastolicPressure",DiastolicPressure);
                    bundle.putCharSequence("HeartRate",HeartRate);
                    bundle.putCharSequence("Date",date);
                    bundle.putCharSequence("time",time);
                    bundle.putCharSequence("comment",comment);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(AddActivity.this,"fill the empty",Toast.LENGTH_LONG).show();
                }



            }
        });
    }
}
