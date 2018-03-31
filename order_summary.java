package com.example.android.book_store;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class order_summary extends AppCompatActivity {

    public TextView tv;
    public EditText ev1,ev2,ev3,ev4;
    public String message,orderdets,name;
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        orderdets = getIntent().getExtras().getString("orderDetails");
        tv = (TextView) findViewById(R.id.t5);
        tv.setText(orderdets);
        button = (Button) findViewById(R.id.confirm);
        ev1 = (EditText) findViewById(R.id.t1);
        ev2 = (EditText) findViewById(R.id.t2);
        ev3 = (EditText) findViewById(R.id.t3);
        ev4 = (EditText) findViewById(R.id.t4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getDetails();
                openNext2();
            }
        });

        ev3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    validateInput(view);
                }
            }
        });

    }

    public void getDetails()
    {
        message="";
        message+="Customer :  "+ev1.getText().toString()+"\n";
        message+="My order is : ";
        message+=orderdets+"\n";
        message+="\nMy delivery address is  "+ev4.getText().toString()+".\n";
        message+="\nYou can reach me online :  "+ev2.getText().toString()+".\n Contact number : "+ev3.getText().toString() +" .";


    }

    public void validateInput(View view)
    {
        int len=ev3.getText().toString().length();
        if(len!=10)
        {
            button.setEnabled(false);
            Toast.makeText(this,"Invalid contact number.",Toast.LENGTH_LONG).show();
        }
        else if(len==10)
        {
            button.setEnabled(true);
            Toast.makeText(this,"Valid",Toast.LENGTH_LONG).show();
        }

    }

    public void openNext2()
    {
        name=ev1.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto: "+"book_express@gmail.com"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "\n BookExpress order for "+name);
        emailIntent.putExtra(Intent.EXTRA_TEXT,message);
        if(emailIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(emailIntent);
        }


    }
}
