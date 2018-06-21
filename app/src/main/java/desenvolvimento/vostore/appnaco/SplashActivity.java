package desenvolvimento.vostore.appnaco;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity implements Runnable {
    ImageView top;
    Animation fromlogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        top = findViewById(R.id.logosplash);
        fromlogo = AnimationUtils.loadAnimation(this, R.anim.fromlogo);
        top.setAnimation(fromlogo);

        //Determinando o tempo de 3 segundos para entrar na próxima activity
        Handler handler = new Handler();
        handler.postDelayed(this, 3000);
    }

    //Usando intent no método run
    public void run(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}


