package com.example.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Obesidade3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle=getIntent().getExtras();

        String peso=bundle.getString("peso");
        String altura=bundle.getString("altura");
        String classificacao=bundle.getString("classificacao");
        String imc=bundle.getString("imc");
        String motivacao=bundle.getString("motivacao");

        String exibe = "Peso: " + peso + "kg \n" +
                "Altura: " + altura + "m \n" +
                "IMC: " + imc + "kg/m² \n" +
                "\n" + classificacao + "\n" +
                "\n" + motivacao;

        TextView textResultadoObesidade3=findViewById(R.id.textResultadoObesidade3);
        textResultadoObesidade3.setText(exibe);

        Button btnBackObesidade3 =findViewById(R.id.btnBackObesidade3);
        btnBackObesidade3.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}