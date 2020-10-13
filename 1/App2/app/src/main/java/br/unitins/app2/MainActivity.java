package br.unitins.app2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNome;
    EditText edtIdade;
    EditText edtEmail;
    EditText edtTelefone;
    EditText edtCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando os dados do formulario
        edtNome = (EditText) findViewById(R.id.nome);
        edtIdade = (EditText) findViewById(R.id.idade);
        edtEmail = (EditText) findViewById(R.id.email);
        edtTelefone = (EditText) findViewById(R.id.telefone);
        edtCpf = (EditText) findViewById(R.id.cpf);

    }

    public void submeter(View view) {
        Toast.makeText(MainActivity.this, "Nome: " + edtNome.getText() + " \n Idade: " + edtIdade.getText() + " \n e-mail: " + edtEmail.getText() + " \n Telefone: " + edtTelefone.getText() + " \n Cpf: " + edtCpf.getText(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        // Função de Alerta de mesagem na tela
        AlertDialog.Builder saida = new AlertDialog.Builder(this);
        saida.setMessage("Deseja sair?");
        // ação se o usuario clicar em sim
        saida.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });
        // ação se o usuario clicar em não
        saida.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        // iniciando e mostrando o alerta criado
        AlertDialog alerta = saida.create();
        alerta.show();
    }
}