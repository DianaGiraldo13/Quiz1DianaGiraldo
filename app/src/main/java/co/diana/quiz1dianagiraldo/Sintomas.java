package co.diana.quiz1dianagiraldo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Sintomas extends AppCompatActivity {

    private TextView textViewQuiz2;
    private TextView textViewSintomas;
    private TextView textView2Elige;
    private CheckBox checkBoxFiebre;
    private CheckBox checkBoxDolor;
    private CheckBox checkBoxCongestion;
    private CheckBox checkBoxTos;
    private CheckBox checkBoxFatiga;
    private CheckBox checkBoxDificultad;
    private CheckBox checkBoxNinguno;
    private Button buttonFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        textViewQuiz2 = findViewById(R.id.textViewQuiz2);
        textViewSintomas = findViewById(R.id.textViewSintomas);
        textView2Elige = findViewById(R.id.textView2Elige);
        checkBoxFiebre = findViewById(R.id.checkBoxFiebre);
        checkBoxDolor = findViewById(R.id.checkBoxDolor);
        checkBoxCongestion = findViewById(R.id.checkBoxCongestion);
        checkBoxTos = findViewById(R.id.checkBoxTos);
        checkBoxFatiga = findViewById(R.id.checkBoxFatiga);
        checkBoxDificultad = findViewById(R.id.checkBoxDificultad);
        checkBoxNinguno = findViewById(R.id.checkBoxNinguno);
        buttonFinalizar = findViewById(R.id.buttonFinalizar);
        checkBoxes();

        buttonFinalizar.setOnClickListener(
                (v)->{
                        Intent intent = getIntent();
                        String nombre=intent.getStringExtra("Nombre");
                        String identificacion=intent.getStringExtra("Identificacion");
                        int scoreNexo=intent.getIntExtra("NexoScore",0);
                        Intent i = new Intent(this,EncuestasHechas.class);
                        int scoreSintomas=getScore()+scoreNexo;
                        i.putExtra("ScoreSintomas",scoreSintomas);
                        i.putExtra("Nombre",nombre);
                        i.putExtra("Identificacion",identificacion);
                        startActivity(i);

                }
        );

        checkBoxFiebre.setOnClickListener(
                (v)->{
                    checkBoxes();
                }
        );
        checkBoxDolor.setOnClickListener(
                (v)->{
                    checkBoxes();
                }
        );
        checkBoxCongestion.setOnClickListener(
                (v)->{
                    checkBoxes();
                }
        );
        checkBoxTos.setOnClickListener(
                (v)->{
                    checkBoxes();
                }
        );
        checkBoxFatiga.setOnClickListener(
                (v)->{
                    checkBoxes();
                }
        );
        checkBoxDificultad.setOnClickListener(
                (v)->{
                    checkBoxes();
                }
        );
        checkBoxNinguno.setOnClickListener(
                (v)->{
                    checkBoxes();
                }
        );
    }

    public int getScore(){
        int score=0;
        if(checkBoxFiebre.isChecked()){
            score+=4;
        }
        if(checkBoxDolor.isChecked()){
            score+=4;
        }
        if(checkBoxCongestion.isChecked()){
            score+=4;
        }
        if(checkBoxTos.isChecked()){
            score+=4;
        }
        if(checkBoxFatiga.isChecked()){
            score+=4;
        }
        if(checkBoxDificultad.isChecked()){
            score+=4;
        }

        return score;
    }

    public void checkBoxes(){
        if(checkBoxFiebre.isChecked() || checkBoxDolor.isChecked() || checkBoxCongestion.isChecked() || checkBoxTos.isChecked() || checkBoxFatiga.isChecked()|| checkBoxDificultad.isChecked()|| checkBoxNinguno.isChecked()){
            buttonFinalizar.setEnabled(true);
        }
        else{
            buttonFinalizar.setEnabled(false);
        }
    }
}