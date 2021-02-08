package com.curso.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado1, textResultado2, textResultado3;
    private EditText editNome;
    private TextInputEditText textInputEditEmail;
    private CheckBox checkPreto, checkVermelho;
    private RadioButton radioMasculino, radioFeminino;
    private RadioGroup opcaoSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado1 = findViewById(R.id.textResultado1);
        textResultado2 = findViewById(R.id.textResultado2);
        textResultado3 = findViewById(R.id.textResultado3);
        editNome = findViewById(R.id.editNome);
        textInputEditEmail = findViewById(R.id.textInputEditEmail);
        checkPreto = findViewById(R.id.checkPreto);
        checkVermelho = findViewById(R.id.checkVermelho);
        //radioMasculino = findViewById(R.id.radioMasculino);
        //radioFeminino = findViewById(R.id.radioFeminino);
        opcaoSexo = findViewById(R.id.opcaoSexo);

        configurarRadioButton();
    }

    public void configurartextView(){
        textResultado1.setText("Nome: " + editNome.getText() + " Email: " + textInputEditEmail.getText());
    }

    public void configurarCheckCor(){
        String cor = "";
        if (checkPreto.isChecked()){
            cor = "" + (checkPreto.getText());
        }
        if (checkVermelho.isChecked()){
            cor = cor + checkVermelho.getText();
        }
        textResultado2.setText("Cor: " + cor);
    }

    public void configurarRadioButton() {

        opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioMasculino) {
                    textResultado3.setText("Masculino");
                } else if (checkedId == R.id.radioFeminino) {
                    textResultado3.setText("Feminino");
                }
            }
        });
    }


      /*  String sexo = "";
        if (radioMasculino.isChecked()){
            sexo = "" + (radioMasculino.getText());
        }
        if (radioFeminino.isChecked()){
            sexo = "" + (radioFeminino.getText());
        }
        textResultado3.setText("Sexo: " + sexo);
       */

    public void botaoAplicar(View view){
        configurartextView();
        configurarCheckCor();
    }
}
