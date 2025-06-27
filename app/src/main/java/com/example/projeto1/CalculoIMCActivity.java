package com.example.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class CalculoIMCActivity extends AppCompatActivity {

    EditText campoPeso;
    EditText campoAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculo_imc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        campoAltura = findViewById(R.id.editTextAltura);
        campoPeso = findViewById(R.id.editTextPeso);

        Button btnCalcula = findViewById(R.id.btnCalcula);
        btnCalcula.setOnClickListener(this::calcularImc);

        Button btnCloseCalculo = findViewById(R.id.btnCloseCalculo);
        btnCloseCalculo.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        Button btnLimpaTexto = findViewById(R.id.btnLimpaTexto);
        btnLimpaTexto.setOnClickListener(this::limparTexto);
    }

    //Metodo para limpar os campos de texto
    public void limparTexto(View view){
        campoPeso.setText("");
        campoAltura.setText("");
    }

    // Metodo para Calcular IMC:
    public void calcularImc(View view){
        String peso = campoPeso.getText().toString();
        String altura = campoAltura.getText().toString();

        //Valida se os campos estão preenchidos
        boolean camposInvalidos = false;

        if (peso.isEmpty()) {
            campoPeso.setError("Informe o peso");
            camposInvalidos = true;
        }

        if (altura.isEmpty()) {
            campoAltura.setError("Informe a altura");
            camposInvalidos = true;
        }

        if (camposInvalidos) {
            return;
        }

        // Converter os dados para Numerico e Calcular IMC:
        Double numPeso = Double.parseDouble(peso);
        Double numAltura = Double.parseDouble(altura);
        Double numImc = numPeso / (numAltura*numAltura);

        //classificacaor o IMC (de acordo com o padrão da OMS):
        String classificacao="----";
        String motivacao="--";
        if(numImc<18.5){
            classificacao="Abaixo do peso ideal";
            motivacao="Cada passo rumo ao equilíbrio é uma vitória. Cuide-se com carinho e paciência — seu corpo merece o melhor!";

            Intent intent = new Intent(this, AbaixoDoPesoActivity.class);

            DecimalFormat df = new DecimalFormat("##.##");
            String imc = df.format(numImc);

            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            intent.putExtra("imc", imc);
            intent.putExtra("classificacao", classificacao);
            intent.putExtra("motivacao", motivacao);

            startActivity(intent);
            finish();

        }else if(numImc>=18.5 && numImc<25){
            classificacao="Peso ideal atingido";
            motivacao="Parabéns! Seu corpo está em equilíbrio. Continue com hábitos saudáveis e lembre-se: bem-estar é um caminho contínuo!";
            Intent intent = new Intent(this, PesoNormalActivity.class);

            DecimalFormat df = new DecimalFormat("##.##");
            String imc = df.format(numImc);

            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            intent.putExtra("imc", imc);
            intent.putExtra("classificacao", classificacao);
            intent.putExtra("motivacao", motivacao);

            startActivity(intent);
            finish();

        }else if(numImc>=25 && numImc<30){
            classificacao="Sobrepeso - Acima do peso ideal";
            motivacao="Você está no controle da sua jornada. Pequenas mudanças diárias fazem uma grande diferença ao longo do tempo!";

            Intent intent = new Intent(this, SobrepesoActivity.class);

            DecimalFormat df = new DecimalFormat("##.##");
            String imc = df.format(numImc);

            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            intent.putExtra("imc", imc);
            intent.putExtra("classificacao", classificacao);
            intent.putExtra("motivacao", motivacao);

            startActivity(intent);
            finish();

        }else if(numImc>=30 && numImc<35){
            classificacao="Nível de obesidade grau 1";
            motivacao="A coragem de começar é o primeiro passo para grandes conquistas. Seu progresso começa com você!";
            Intent intent = new Intent(this, Obesidade1Activity.class);

            DecimalFormat df = new DecimalFormat("##.##");
            String imc = df.format(numImc);

            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            intent.putExtra("imc", imc);
            intent.putExtra("classificacao", classificacao);
            intent.putExtra("motivacao", motivacao);

            startActivity(intent);
            finish();

        }else if(numImc>=35 && numImc<40){
            classificacao="Nível de obesidade grau 2";
            motivacao="Cada dia é uma nova chance de cuidar de si. Com foco e apoio, todo caminho pode ser transformado!";

            Intent intent = new Intent(this, Obesidade2Activity.class);

            DecimalFormat df = new DecimalFormat("##.##");
            String imc = df.format(numImc);

            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            intent.putExtra("imc", imc);
            intent.putExtra("classificacao", classificacao);
            intent.putExtra("motivacao", motivacao);

            startActivity(intent);
            finish();

        }else if(numImc>=40){
            classificacao="Nível de obesidade grau 3";
            motivacao="Você é muito mais do que um número. Com determinação, amor próprio e apoio, tudo é possível!";

            //alterar activity de destino para a nova que será criada
            Intent intent = new Intent(this, Obesidade3Activity.class);

            DecimalFormat df = new DecimalFormat("##.##");
            String imc = df.format(numImc);

            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            intent.putExtra("imc", imc);
            intent.putExtra("classificacao", classificacao);
            intent.putExtra("motivacao", motivacao);

            startActivity(intent);
            finish();
        }
    }
}