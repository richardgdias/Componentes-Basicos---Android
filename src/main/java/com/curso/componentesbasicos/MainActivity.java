package com.curso.componentesbasicos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado1, textResultado2, textResultado3, textResultado4, textResultado5, textResultado6;
    private EditText editNome;
    private TextInputEditText textInputEditEmail;
    private CheckBox checkPreto, checkVermelho;
    private RadioButton radioMasculino, radioFeminino;
    private RadioGroup opcaoSexo;
    private Switch switchSenha;
    private ToggleButton toggleSenha;
    private ProgressBar progressBarHorizontal, progressBarCircular;
    private int progresso = 0;
    private SeekBar seekBarEscala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado1 = findViewById(R.id.textResultado1);
        textResultado2 = findViewById(R.id.textResultado2);
        textResultado3 = findViewById(R.id.textResultado3);
        textResultado4 = findViewById(R.id.textResultado4);
        textResultado5 = findViewById(R.id.textResultado5);
        textResultado6 = findViewById(R.id.textResultado6);
        editNome = findViewById(R.id.editNome);
        textInputEditEmail = findViewById(R.id.textInputEditEmail);
        checkPreto = findViewById(R.id.checkPreto);
        checkVermelho = findViewById(R.id.checkVermelho);
        //radioMasculino = findViewById(R.id.radioMasculino);
        //radioFeminino = findViewById(R.id.radioFeminino);
        opcaoSexo = findViewById(R.id.opcaoSexo);
        switchSenha = findViewById(R.id.switchSenha);
        toggleSenha = findViewById(R.id.toggleSenha);
        progressBarCircular = findViewById(R.id.progressBarCircular);
        progressBarCircular.setVisibility(View.GONE); // ele some da tela
        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        seekBarEscala = findViewById(R.id.seekBarEscala);

        //Mudar em tempo real SeekBar
        seekBarEscala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override // clica arrasta e muda o marcador
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textResultado6.setText("Progresso: " + progress + " / " + seekBar.getMax());
            }

            @Override // clica em cima do marcador
            public void onStartTrackingTouch(SeekBar seekBar) {
                //textResultado6.setText("onStartTrackingTouch");
            }

            @Override // quando solta o marcador
            public void onStopTrackingTouch(SeekBar seekBar) {
                //textResultado6.setText("onStopTrackingTouch");
            }
        });

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

        /////////////////////////////////////////////////////////////////////

        //AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Titulo");
        dialog.setMessage("Mensagem");

        dialog.setCancelable(false); // permitir o cancelamento "clicar fora das opcoes" ou false "escolher uma das opçoes"
        dialog.setIcon(android.R.drawable.ic_btn_speak_now); // configurar icone

        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Ação realizada ao clicar no Sim", Toast.LENGTH_LONG).show();
            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Ação realizada ao clicar no Não", Toast.LENGTH_LONG).show();
            }
        });

        dialog.create();
        dialog.show();

        /////////////////////////////////////////////////////////////////////

        // TOAST
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

    public void carregarProgressBar(View view){

        this.progresso = this.progresso + 1; // quando clicar no botao vai incrementar
        progressBarHorizontal.setProgress(this.progresso);

        progressBarCircular.setVisibility(View.VISIBLE); // aparece na tela
        if (progresso == 10){
            progressBarCircular.setVisibility(View.GONE); // esconder na tela novamente
        }
    }

        public void recuperarProgresso(View view){
            textResultado6.setText("Escolhido: " + seekBarEscala.getProgress());
        }

}
