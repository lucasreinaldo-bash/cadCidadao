package desenvolvimento.vostore.appnaco;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btninserir,btnlistar;
    DBHelper dbHelper;
    ImageButton dev;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dbHelper = new DBHelper(this);
        btninserir = findViewById(R.id.btn_inserir);
        btnlistar = findViewById(R.id.btn_listar);
        dev = findViewById(R.id.imageView2);

        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sobre.class);
                startActivity(intent);
            }
        });

        btninserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cadastrar.class);
                startActivity(intent);
            }
        });
        btnlistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Cidadao> cidadao = dbHelper.queryGetAll();

                if (cidadao == null) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Banco de Dados está vazio");
                    dialog.setMessage("Não há informações cadastradas.");
                    dialog.create();
                    dialog.show();
                    return;
                }

                 for (int i= 0; i < cidadao.size(); i++){

                    Cidadao cidadao1 = (Cidadao) cidadao.get(i);
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setTitle("Cadastro " + i);
                     alertDialog.setMessage("Nome:" + cidadao1.getNome() +"\nCPF:" + cidadao1.getCpf() +"\nTelefone: "+ cidadao1.getTelefone() +"\nE-mail: " +cidadao1.getEmail());
                     alertDialog.setPositiveButton("Ver Mais", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             dialogInterface.dismiss();
                         }
                     });
                     alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             Intent intent = new Intent(MainActivity.this, MainActivity.class);
                             startActivity(intent);
                             finish();
                         }
                     });
                     alertDialog.show();
                }


            }

        });

    }
}
