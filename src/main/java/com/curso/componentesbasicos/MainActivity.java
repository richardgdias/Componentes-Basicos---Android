package com.curso.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado1, textResultado2, textResultado3, textResultado4, textResultado5;
    private EditText editNome;
    private TextInputEditText textInputEditEmail;
    private CheckBox checkPreto, checkVermelho;
    private RadioButton radioMasculino, radioFeminino;
    private RadioGroup opcaoSexo;
    private Switch switchSenha;
    private ToggleButton toggleSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado1 = findViewById(R.id.textResultado1);
        textResultado2 = findViewById(R.id.textResultado2);
        textResultado3 = findViewById(R.id.textResultado3);
        textResultado4 = findViewById(R.id.textResultado4);
        textResultado5 = findViewById(R.id.textResultado5);
        editNome = findViewById(R.id.editNome);
        textInputEditEmail = findViewById(R.id.textInputEditEmail);
        checkPreto = findViewById(R.id.checkPreto);
        checkVermelho = findViewById(R.id.checkVermelho);
        //radioMasculino = findViewById(R.id.radioMasculino);
        //radioFeminino = findViewById(R.id.radioFeminino);
        opcaoSexo = findViewById(R.id.opcaoSexo);
        switchSenha = findViewById(R.id.switchSenha);
        toggleSenha = findViewById(R.id.toggleSenha);

        configurarRadioButton();
        configurarSwitch();
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
              /*  String sexo = "";
                if (radioMasculino.isChecked()){
                    sexo = "" + (radioMasculino.getText());
                }
                if (radioFeminino.isChecked()){
                    sexo = "" + (radioFeminino.getText());
                }
                textResultado3.setText("Sexo: " + sexo);
               */
            }
        });
    }

    public void configurarSwitch(){
        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textResultado4.setText("Switch ligado");
                }
                else {
                    textResultado4.setText("Switch desligado");
                }
            }
        });
    }

    public void configurarToggle(){
        if (toggleSenha.isChecked()){
            textResultado5.setText("Toggle ligado");
        }
        else {
            textResultado5.setText("Toggle desligado");
        }
    }

    public void botaoAplicar(View view){
        configurartextView();
        configurarCheckCor();
        configurarToggle();

        // criando uma imagem
        ImageView imagem = new ImageView(getApplicationContext());
        imagem.setImageResource(android.R.drawable.star_big_off); // imagem do programa

        TextView texto = new TextView(getApplicationContext());
        texto.setBackgroundResource(R.color.colorAccent);
        texto.setText("Olá toast");

        //configurar o Toast customizado
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(imagem); // pegando a imagem que criei ou o textView
        toast.show();

        //configurando o Toast "Mensagem na tela quando realizar uma ação"
        //Toast.makeText(getApplicationContext(), "Ação realizada com sucesso", Toast.LENGTH_LONG).show();
    }
}
