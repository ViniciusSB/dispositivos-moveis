package br.unitins.App1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.unitins.myapplication.R;

public class Tela_2 extends AppCompatActivity {

    Button botao2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_2);
        botao2 = findViewById(R.id.botao02);

        // recuperando os dados da outra activity atraves do codigo
        Bundle nume = getIntent().getExtras();
        Long n = nume.getLong("contador");
        // mostrando na tela e atualizando o valor do botão
        String txt = "Você já clicou: " + n;
        botao2.setText(n.toString());
        Toast.makeText(this, txt, Toast.LENGTH_LONG).show();
    }


    public void backView1(View view) {
        Intent intent = new Intent(getApplicationContext(), Tela_1.class);

        Bundle numero = getIntent().getExtras();
        Long n = numero.getLong("contador");
        // incrementando o valor
        intent.putExtra("contador", n+1);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();

        Bundle numero = getIntent().getExtras();
        Long n = numero.getLong("contador");
        // incrementando o valor ao pressionar o botão voltar
        intent.putExtra("contador", n+1);
        setResult(RESULT_OK, intent);
        finish();
    }
}
