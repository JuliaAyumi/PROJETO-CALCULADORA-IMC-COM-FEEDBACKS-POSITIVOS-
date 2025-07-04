package com.example.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnChamaCalculadora=findViewById(R.id.btnChamaCalculadora);
        btnChamaCalculadora.setOnClickListener(view ->{
            Intent intent = new Intent(this, CalculoIMCActivity.class);

            startActivity(intent);
            finish();
        });

        Button btnFinaliza = findViewById(R.id.btnFinaliza);
        btnFinaliza.setOnClickListener(v -> finish());
    }
}