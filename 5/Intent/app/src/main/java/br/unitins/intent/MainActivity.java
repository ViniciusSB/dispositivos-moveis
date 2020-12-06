package br.unitins.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void next(View view) {
        // Naveganção entre telas por intent de forma implícita
        Intent intent = new Intent("br.unitins.intent.action.Tela");
        startActivity(intent);
    }


    public void conf(View view) {
        // Acessa as configurações do android através da intent
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);
    }

    public void open(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        startActivity(intent);
    }
}