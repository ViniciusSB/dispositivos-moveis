package br.unitins.ex_thread;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button botao;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recupera o contexto do botão e do textView
        botao = findViewById(R.id.botao);
        texto = findViewById(R.id.texto);
    }

    public void evento(View view) {
        //desabilita o botão quando pressionado
        botao.setEnabled(false);
        executarThread();
    }

    public void executarThread() {
        Runnable r = new Runnable() {
            int i = 10;
            @Override
            public void run() {
                //decrementa e atualiza o valor do textView
                while (true && i>0) {
                    SystemClock.sleep(1000);
                    CharSequence car = texto.getText();
                    String text = car.toString();
                    Integer num = Integer.parseInt(text);
                    num -= 1;
                    text = num.toString();
                    texto.setText(text);
                    i--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // exibe a msg na tela e reseta os valores do botao e do textView
                        Toast.makeText(MainActivity.this, "A contagem terminou!", Toast.LENGTH_LONG).show();
                        botao.setEnabled(true);
                        SystemClock.sleep(1000);
                        texto.setText("10");
                    }
                });
            }
        };

        Thread t = new Thread(r);
        t.start();
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


