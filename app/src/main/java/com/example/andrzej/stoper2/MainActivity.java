package com.example.andrzej.stoper2;

import android.os.Handler;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int sekundnik = 0;
    private boolean CzyWlaczony;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        WlaczZegar();
    }

        public void onClickStart(View view){   //Starter
        CzyWlaczony = true;
        }

        public void onClickStop(View view) {
            CzyWlaczony = false;
        }

        public void onClickReset(View view) {
            CzyWlaczony = false;
            sekundnik = 0; //heuheuehue
        }


        private void WlaczZegar() {

            final TextView timeView = (TextView)findViewById(R.id.timeView);
            final Handler handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    int godziny = sekundnik / 3600;
                    int minuty = (sekundnik %  3600) / 60;
                    int Sekundy = sekundnik % 60;

                    String czas = String.format("%d:%02d:%02d", godziny,minuty,Sekundy);
                    timeView.setText(czas);

                    if (CzyWlaczony)
                    {
                        sekundnik++;
                    }
                    handler.postDelayed(this, 1000);
                }
            });
        }
}



