package br.unitins.App1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.unitins.myapplication.R;

public class Tela_1 extends AppCompatActivity {

    Button botao1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botao1 = findViewById(R.id.botao01);
    }

    public void goView2(View view) {
        // permite a navegação entre activities(telas) através do intent
        Intent intent = new Intent(getApplicationContext(), Tela_2.class);
        Bundle num = new Bundle();
        Long n = Long.parseLong(botao1.getText().toString());
        num.putLong("contador",  n + 1);
        intent.putExtras(num);

        // funcao que espera retorno de outra activity
        startActivityForResult(intent, 5);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // recuperando os dados da outra activity atraves do codigo
        if(requestCode == 5) {
            // salvando o numero retornado para adicionar ao botão 1
            Long numero = data.getExtras().getLong("contador");
            String texto = "Você já clicou: " + numero;
            Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
            botao1.setText(numero.toString());
        }
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