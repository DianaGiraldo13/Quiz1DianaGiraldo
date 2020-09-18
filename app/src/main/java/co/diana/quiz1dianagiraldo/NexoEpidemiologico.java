package co.diana.quiz1dianagiraldo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class NexoEpidemiologico extends AppCompatActivity {

    private TextView textViewQuiz1;
    private TextView textViewNexo;
    private TextView textViewElige;
    private CheckBox checkBoxEstuve;
    private CheckBox checkBox2Hice;
    private CheckBox checkBox3Hice;
    private CheckBox checkBox4Soy;
    private CheckBox checkBox5Ninguna;
    private Button buttonContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexo_epidemiologico);
        textViewQuiz1 = findViewById(R.id.textViewQuiz1);
        textViewNexo = findViewById(R.id.textViewNexo);
        textViewElige = findViewById(R.id.textViewElige);
        checkBoxEstuve = findViewById(R.id.checkBoxEstuve);
        checkBox2Hice = findViewById(R.id.checkBox2Hice);
        checkBox3Hice = findViewById(R.id.checkBox3Hice);
        checkBox4Soy = findViewById(R.id.checkBox4Soy);
        checkBox5Ninguna = findViewById(R.id.checkBox5Ninguna);
        buttonContinuar = findViewById(R.id.buttonContinuar);
        checkBoxes();

        buttonContinuar.setOnClickListener(
                (v)->{
                    int score=getScore();
                    Intent intent = getIntent();
                    String nombre=intent.getStringExtra("Nombre");
                    String identificacion=intent.getStringExtra("Identificacion");
                    Intent i = new Intent(this,Sintomas.class);
                    i.putExtra("NexoScore",score);
                    i.putExtra("Nombre",nombre);
                    i.putExtra("Identificacion",identificacion);
                    startActivity(i);
                }
        );

        checkBoxEstuve.setOnClickListener(
                (v)->{
                    checkBoxes();
                }
        );
        checkBox2Hice.setOnClickListener(
                (v)->{
                    checkBoxes();
                }
        );
        checkBox3Hice.setOnClickListener(
                (v)->{
                    checkBoxes();
                }
        );
        checkBox4Soy.setOnClickListener(
                (v)->{
                    checkBoxes();
                }
        );
        checkBox5Ninguna.setOnClickListener(
                (v)->{
                    checkBoxes();
                }
        );



    }

    public int getScore(){
        int score=0;
        if(checkBoxEstuve.isChecked()){
            score+=3;
        }
        if(checkBox2Hice.isChecked()){
            score+=3;
        }
        if(checkBox3Hice.isChecked()){
            score+=3;
        }
        if(checkBox4Soy.isChecked()){
            score+=3;
        }

        return score;
    }

    public void checkBoxes(){
        if(checkBoxEstuve.isChecked() || checkBox2Hice.isChecked() || checkBox3Hice.isChecked() || checkBox4Soy.isChecked() || checkBox5Ninguna.isChecked()){
            buttonContinuar.setEnabled(true);
        }
        else{
            buttonContinuar.setEnabled(false);
        }

    }
}