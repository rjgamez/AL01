package com.ahorrolibre.al01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

public class SplashScreenActivity extends AppCompatActivity
{

    private Thread thread;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

      // PREGUNTA ALEX.. no entiendo porque el stackoverflow tenia este codigo
      // final MyActivity myActivity = this;
        //un Synchronizaiton on a non-final field 'thread' warning

        thread=  new Thread(){
            @Override
            public void run(){
                try {
                    synchronized(this){
                        wait(2000);
                    }
                }
                //PREGUNTA ALEX, me salen un Empty 'catch' block warning aqui
                catch(InterruptedException ex){
                }

                continueToMain();
            }
        };

        thread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent evt)
    {
        if(evt.getAction() == MotionEvent.ACTION_DOWN)
        {
            //PREGUNTA ALEX, me salen un Synchronization on a non-final field 'thread'
            synchronized(thread){
                thread.notifyAll();
            }
        }
        continueToMain();
        return true;
    }

    private void continueToMain (){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}
