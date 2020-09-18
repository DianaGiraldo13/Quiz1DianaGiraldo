package co.diana.quiz1dianagiraldo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewQuiz;
    private TextView textViewNuevoregistro;
    private TextView textViewdescripcion;
    private EditText editTextNombre;
    private EditText editTextIdentificacion;
    private Button buttonContinuar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewQuiz = findViewById(R.id.textViewQuiz);
        textViewNuevoregistro = findViewById(R.id.textViewNuevoregistro);
        textViewdescripcion = findViewById(R.id.textViewdescripcion);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextIdentificacion = findViewById(R.id.editTextIdentificacion);
        buttonContinuar = findViewById(R.id.buttonContinuar);

        //String nombre = editTextNombre.getText().toString();
        //SharedPreferences preferences = getSharedPreferences("ejemplo",MODE_PRIVATE);
        //preferences.edit().putString("nombre",nombre).apply();



        buttonContinuar.setOnClickListener(
                (v)->{
                    Intent intent = new Intent(this,NexoEpidemiologico.class);
                    String nombre = editTextNombre.getText().toString();
                    String identificacion = editTextIdentificacion.getText().toString();
                    SharedPreferences preferences = getSharedPreferences("datos",MODE_PRIVATE);
                    if(!preferences.contains(identificacion)){
                        intent.putExtra("Nombre",nombre);
                        intent.putExtra("Identificacion",identificacion);
                        startActivity(intent);
                    }
                }
        );


    }
}