package desenvolvimento.vostore.appnaco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.bloder.magic.view.MagicButton;

public class Sobre extends AppCompatActivity {
    private DBHelper dbHelper;
    MagicButton face,git;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sobre);
        face = findViewById(R.id.magic_button_facebook);
        git = findViewById(R.id.magic_button_twiter);

        face.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sobre.this, facebook.class);
                startActivity(intent);
                finish();
            }
        });
        git.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sobre.this, github.class);
                startActivity(intent);
                finish();
            }
        });

        }

    }

