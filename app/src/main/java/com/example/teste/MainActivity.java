package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.ColetaAlcool);
        editPrecoGasolina = findViewById(R.id.ColetaGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    @SuppressLint("SetTextI18n")
    public void calcularPreco (View view) {

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean CamposValidados = validarCampos(precoAlcool, precoGasolina);

        if (CamposValidados) {
            double valorAlcool = Double.parseDouble(precoAlcool);
            double valorGasolina = Double.parseDouble(precoGasolina);
            double resultado = valorGasolina / valorAlcool;

            if(resultado >= 0.7) {
                textResultado.setText("Melhor utilizar Gasolina");
            }else {
                textResultado.setText("Melhor utilizar Álcool");
            }
        }else {
            textResultado.setText("Preencha os preços primeiro");
        }
    }

    public Boolean validarCampos (String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if ((pAlcool) == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    }

}
