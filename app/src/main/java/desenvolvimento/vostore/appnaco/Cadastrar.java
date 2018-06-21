package desenvolvimento.vostore.appnaco;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import desenvolvimento.vostore.appnaco.R;

public class Cadastrar extends AppCompatActivity {
    private DBHelper dbHelper;
    private EditText txt_nome,txt_cpf,txt_telefone,txt_email;
    private ImageButton btn_salvar;
    private ImageButton voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);


        this.dbHelper = new DBHelper(this);

        txt_nome = findViewById(R.id.txt_nome);
        txt_cpf = findViewById(R.id.txt_cpf);
        txt_telefone = findViewById(R.id.txt_telefone);
        txt_email = findViewById(R.id.txt_email);
        voltar = findViewById(R.id.voltar);

        btn_salvar = findViewById(R.id.btn_salvar);

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt_nome.getText().length()>0 && txt_cpf.getText().length()>0 && txt_telefone.getText().length()>0 && txt_email.getText().length()>0){
                    dbHelper.insert(txt_nome.getText().toString(),txt_cpf.getText().toString(),txt_telefone.getText().toString(),txt_email.getText().toString());

                    AlertDialog.Builder dialog = new AlertDialog.Builder(Cadastrar.this);
                    dialog.setMessage("Os dados foram salvos com sucesso!");
                    dialog.setCancelable(false);
                    dialog.setIcon(R.drawable.ic_done);
                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(Cadastrar.this);
                            dialog.setTitle("E agora ?");
                            dialog.setMessage("O que deseja fazer ?");
                            dialog.setPositiveButton("Novo Cadastro", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                txt_nome.setText("");
                                txt_cpf.setText("");
                                txt_email.setText("");
                                txt_telefone.setText("");
                                    Toast.makeText(Cadastrar.this, "Os campos estão prontos para serem preenchidos", Toast.LENGTH_SHORT).show();
                                }

                            });
                           dialog.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialogInterface, int i) {

                                   Intent intent = new Intent(Cadastrar.this, MainActivity.class);
                                   startActivity(intent);
                                   finish();
                               }
                           });
                           dialog.create();
                           dialog.show();
                        }
                    });
                    dialog.create();
                    dialog.show();


                }
                else {
                    Toast.makeText(Cadastrar.this, "Todos os campos precisam ser preenchidos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cadastrar.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
