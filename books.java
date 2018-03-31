package com.example.android.book_store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.book_store.R.layout.activity_books;

public class books extends AppCompatActivity {

    public int book1=0,book2=0,book3=0,book4=0,book5=0,book6=0,total;
    public TextView tb1,tb2,tb3,tb4,tb5,tb6,before1,after1,after2;
    public int price1=220,price2=300,price3=190,price4=240,price5=320,price6=300;
    public ImageButton order_img;
    public ImageView be_logo_img;
    public String summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       /* tb1.setVisibility(View.INVISIBLE);
        tb2.setVisibility(View.INVISIBLE);
        tb3.setVisibility(View.INVISIBLE);
        tb4.setVisibility(View.INVISIBLE);
        tb5.setVisibility(View.INVISIBLE);
        tb6.setVisibility(View.INVISIBLE);*/
        setContentView(activity_books);
        super.onCreate(savedInstanceState);

        tb1=(TextView)findViewById(R.id.count1);
        tb2=(TextView)findViewById(R.id.count2);
        tb3=(TextView)findViewById(R.id.count3);
        tb4=(TextView)findViewById(R.id.count4);
        tb5=(TextView)findViewById(R.id.count5);
        tb6=(TextView)findViewById(R.id.count6);
        before1=(TextView)findViewById(R.id.welcomemsg1);
        after1=(TextView)findViewById(R.id.ordermsg1);
        after2=(TextView)findViewById(R.id.ordermsg2);
        be_logo_img=(ImageView)findViewById(R.id.applogo);
        order_img=(ImageButton)findViewById(R.id.ordernow);

        order_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderSum();
                openNext1();
            }
        });


    }

    public void inc1(View view)
    {
        book1+=1;

        if(book1>=1)
        {
            tb1.setVisibility(View.VISIBLE);
            tb1.setText(""+book1);
        }
        order(view);

    }
    public void inc2(View view)
    {
        book2+=1;

        if(book2>=1)
        {
            tb2.setVisibility(View.VISIBLE);
            tb2.setText(""+book2);
        }
        order(view);
    }
    public void inc3(View view)
    {
        book3+=1;

        if(book3>=1)
        {

            tb3.setVisibility(View.VISIBLE);
            tb3.setText(""+book3);
        }
        order(view);
    }
    public void inc4(View view)
    {
        book4+=1;
        if(book4>=1)
        {

            tb4.setVisibility(View.VISIBLE);
            tb4.setText(""+book4);
        }

        order(view);
    }
    public void inc5(View view)
    {
        book5+=1;
        if(book5>=1)
        {

            tb5.setVisibility(View.VISIBLE);
            tb5.setText(""+book5);
        }
        order(view);

    }
    public void inc6(View view)
    {
        book6+=1;
        if(book6>=1)
        {

            tb6.setVisibility(View.VISIBLE);
            tb6.setText(""+book6);
        }
        order(view);
    }

    public void dec1(View view)
    {
        if(book1>1)
        {
            book1-=1;
            tb1.setVisibility(View.VISIBLE);
            tb1.setText(""+book1);
        }
        else if(book1==1)
        {
            book1-=1;
            tb1.setVisibility(View.INVISIBLE);
        }
        else
        {
            Toast.makeText(this,"Item count is already 0",Toast.LENGTH_LONG).show();
            tb1.setVisibility(View.INVISIBLE);
            return;
        }
        order(view);
    }
    public void dec2(View view)
    {
        if(book2>1)
        {
            book2-=1;
            tb2.setVisibility(View.VISIBLE);
            tb2.setText(""+book2);
        }
        else if(book2==1)
        {
            book2-=1;
            tb2.setVisibility(View.INVISIBLE);
        }
        else
        {
            Toast.makeText(this,"Item count is already 0",Toast.LENGTH_LONG).show();
            tb2.setVisibility(View.INVISIBLE);
            return;
        }
        order(view);
    }
    public void dec3(View view)
    {
        if(book3>1)
        {
            book3-=1;
            tb3.setVisibility(View.VISIBLE);
            tb3.setText(""+book3);
        }
        else if(book3==1)
        {
            book3-=1;
            tb3.setVisibility(View.INVISIBLE);
        }
        else
        {
            Toast.makeText(this,"Item count is already 0",Toast.LENGTH_LONG).show();
            tb3.setVisibility(View.INVISIBLE);
            return;
        }
        order(view);
    }
    public void dec4(View view)
    {
        if(book4>1)
        {
            book4-=1;
            tb4.setVisibility(View.VISIBLE);
            tb4.setText(""+book4);
        }
        else if(book4==1)
        {
            book4-=1;
            tb4.setVisibility(View.INVISIBLE);
        }
        else
        {
            Toast.makeText(this,"Item count is already 0",Toast.LENGTH_LONG).show();
            tb4.setVisibility(View.INVISIBLE);
            return;
        }
        order(view);
    }
    public void dec5(View view)
    {
        if(book5>1)
        {
            book5-=1;
            tb5.setVisibility(View.VISIBLE);
            tb5.setText(""+book5);
        }
        else if(book5==1)
        {
            book5-=1;
            tb5.setVisibility(View.INVISIBLE);
        }
        else
        {
            Toast.makeText(this,"Item count is already 0",Toast.LENGTH_LONG).show();
            tb5.setVisibility(View.INVISIBLE);
            return;
        }
        order(view);
    }
    public void dec6(View view)
    {
        if(book6>1)
        {
            book6-=1;
            tb6.setVisibility(View.VISIBLE);
            tb6.setText(""+book6);
        }
        else if(book6==1)
        {
            book6-=1;
            tb6.setVisibility(View.INVISIBLE);
        }
        else
        {
            Toast.makeText(this,"Item count is already 0",Toast.LENGTH_LONG).show();
            tb6.setVisibility(View.INVISIBLE);
            return;
        }
        order(view);
    }

    public void order(View view)
    {
        total=0;
        TextView amount=(TextView)findViewById(R.id.amount) ;
        if(book1>=1 || book2>=1 || book3>=1 || book4>=1 ||book5>=1 ||book6>=1)
        {

            total+=book1*price1+book2*price2+book3*price3+book4*price4+book5*price5+book6*price6;
            onPurchase();

        }

        else
        {
           noPurchase();
        }

        amount.setText(" Rs "+total);
    }


    public void noPurchase()
    {
        before1.setVisibility(View.VISIBLE);
        be_logo_img.setVisibility(View.VISIBLE);
        after1.setVisibility(View.INVISIBLE);
        after2.setVisibility(View.INVISIBLE);
        order_img.setVisibility(View.INVISIBLE);
    }

    public void onPurchase()
    {
        after1.setVisibility(View.VISIBLE);
        after2.setVisibility(View.VISIBLE);
        order_img.setVisibility(View.VISIBLE);
        before1.setVisibility(View.INVISIBLE);
        be_logo_img.setVisibility(View.INVISIBLE);
    }

    public void orderSum()
    {
        summary="\n";
        if(book1>=1)
        {
            summary+=" Da Vinci Code ( "+book1+" )\n";
        }
        if(book2>=1)
        {
            summary+=" After the Funeral ( "+book2+" )\n";
        }
        if(book3>=1)
        {
            summary+=" When Captain Flint was still a good man ( "+book3+" )\n";
        }
        if(book4>=1)
        {
            summary+=" Looking for Alaska ( "+book4+" )\n";
        }
        if(book5>=1)
        {
            summary+=" Turtles all the way down ( "+book5+" )\n";
        }
        if(book6>=1)
        {
            summary+=" Native Son ( "+book6+" )\n";
        }


    }
    public void openNext1()
    {
        Intent intent = new Intent(this,order_summary.class);
        intent.putExtra("orderDetails",summary);
        startActivity(intent);
    }
}
