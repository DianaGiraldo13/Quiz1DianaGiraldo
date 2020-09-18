package co.diana.quiz1dianagiraldo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

public class EncuestasHechas extends AppCompatActivity {

    private TextView textViewQuiz3;
    private TextView textViewEncuestas;
    private TextView textView2Personas;
    private Button buttonRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuestas_hechas);

        textViewQuiz3 = findViewById(R.id.textViewQuiz3);
        textViewEncuestas = findViewById(R.id.textViewEncuestas);
        textView2Personas = findViewById(R.id.textView2Personas);
        buttonRegistrar = findViewById(R.id.buttonRegistrar);

        //SharedPreferences preferences = getSharedPreferences("ejemplo",MODE_PRIVATE);
        //String nombre = preferences.getString("nombre","No_user");
        //textView2Personas.setText(nombre);
        //textView2Personas.setText("Nombre");
        store();
        show();


        buttonRegistrar.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this,MainActivity.class);
                    startActivity(i);
                }
        );

    }

    public void show(){
        SharedPreferences preferences = getSharedPreferences("datos",MODE_PRIVATE);
        String print="";
        Map<String, ?> allEntries = preferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            String[] data=entry.getValue().toString().split(",");
            print+=data[0] + " "+data[1]+"\n";
        }
        //System.out.println(print);
        textView2Personas.setText(print);
    }

    public void store(){
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("Nombre");
        String identificacion = intent.getStringExtra("Identificacion");
        int score = intent.getIntExtra("ScoreSintomas",0);
       if(nombre!=null && identificacion!=null){
           SharedPreferences preferences = getSharedPreferences("datos",MODE_PRIVATE);
           preferences.edit().putString(identificacion,nombre+","+score).apply();
       }
    }
}