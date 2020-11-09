package br.unitins.back_stack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button botao;
    TextView texto;
    TextView textoFrag;
    int numero = 0;
    Fragment fragment;
    FragmentManager fm;
    FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        MainFragment mf = (MainFragment) fm.findFragmentById(R.id.main_layout);
        botao = findViewById(R.id.btn_incrementar);
        texto = findViewById(R.id.txt_contagem);
    }

    @Override
    public void onBackPressed() {
        numero -= 1;
        fm.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                texto.setText("Número de fragmentos criados: " + Integer.toString(numero));
            }
        });
        super.onBackPressed();
    }

    public void incrementar(View view) {
        if (numero < 15) {
            numero += 1;
            Integer n = numero;
            texto.setText("Número de fragmentos criados: " + n.toString());

            MainFragment mainFragment = new MainFragment();
            Bundle numero = new Bundle();
            numero.putInt("numero", n);
            mainFragment.setArguments(numero);

            addFragment();
        } else {
            Toast.makeText(this, "O limite foi atingido", Toast.LENGTH_SHORT).show();
        }

    }

    private void addFragment(){

        fragment = new MainFragment();

        ft = fm.beginTransaction();
        ft.add(R.id.main_layout,fragment,"demofragment");
        ft.addToBackStack(null);
        ft.commit();
    }
}