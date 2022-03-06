package sv.edu.udb.examenpractico1ejercicio1tb181979_cg161119;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView numeradorUno;
    private TextView denominadorUno;
    private TextView numeradorDos;
    private TextView denominadorDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numeradorUno=findViewById(R.id.numeradorUno);
        denominadorUno=findViewById(R.id.denominadorUno);
        numeradorDos=findViewById(R.id.numeradorDos);
        denominadorDos=findViewById(R.id.denominadorDos);
    }

    public void calcular(View tv){//FUNCIÓN QUE EL BOTÓN MANDA A LLAMAR
        int numeradorA, denominadorA, numeradorB, denominadorB;//VARIABLES PARA VALORES DE ,LOS TEXTVIEW
        if(String.valueOf(numeradorUno.getText()).isEmpty() || String.valueOf(denominadorUno.getText()).isEmpty() || String.valueOf(numeradorDos.getText()).isEmpty() || String.valueOf(denominadorDos.getText()).isEmpty()){
            //VALIDACIÓN PARA CAMPOS VACÍOS, SI EL CAMPO ES VACÍO SE MUESTRA ESTE MENSAJE
            Toast.makeText(this,"No puede haber campos vacíos", Toast.LENGTH_LONG).show();
        }else{
            //SI EL CAMPO NO ES VACÍO LAS VARIABLES TOMAN LOS VALORES DE LOS TEXTVIEW
            numeradorA = Integer.parseInt(String.valueOf(numeradorUno.getText()));
            denominadorA = Integer.parseInt(String.valueOf(denominadorUno.getText()));
            numeradorB = Integer.parseInt(String.valueOf(numeradorDos.getText()));
            denominadorB = Integer.parseInt(String.valueOf(denominadorDos.getText()));
            if(denominadorA==0 || denominadorB==0){
                //SE VALIDA QUE LOS DENOMINADORES NO SEAN CERO
                Toast.makeText(this,"El denominador no puede ser cero", Toast.LENGTH_LONG).show();
            }else{
                //SE RESUELVE LA SUMA DE FRACCIONES
                int numeradorSuma = (numeradorA*denominadorB)+(denominadorA*numeradorB);
                int denominadorSuma = denominadorA*denominadorB;
                //SE RESUELVE LA RESTA DE FRACCIONES
                int numeradorResta = (numeradorA*denominadorB)-(denominadorA*numeradorB);
                int denominadorResta = denominadorA*denominadorB;
                //SE RESUELVE LA MULTIPLICACIÓN DE FRACCIONES
                int numeradorMultiplicacion = numeradorA*numeradorB;
                int denominadorMultiplicacion = denominadorA*denominadorB;
                //SE RESUELVE LA DIVISIÓN DE FRACCIONES
                int numeradorDivision = numeradorA*denominadorB;
                int denominadorDivision = denominadorA*numeradorB;
                //SE CREA LA VARIABLE intent PARA PASAR DATOS AL OTRO ACTIVITY
                Intent intent = new Intent(MainActivity.this, MostrarResultadoFraccionesTB181979_GC161119.class);
                //SE ALMACENAN LOS VALORES PARA QUE SEAN ENVIADOS AL OTRO ACTIVITY
                intent.putExtra("numeradorSuma",numeradorSuma);
                intent.putExtra("denominadorSuma",denominadorSuma);
                intent.putExtra("numeradorResta",numeradorResta);
                intent.putExtra("denominadorResta",denominadorResta);
                intent.putExtra("numeradorMultiplicacion",numeradorMultiplicacion);
                intent.putExtra("denominadorMultiplicacion",denominadorMultiplicacion);
                intent.putExtra("numeradorDivision",numeradorDivision);
                intent.putExtra("denominadorDivision",denominadorDivision);
                //SE ABRE EL SIGUIENTE ACTIVITY Y SE ENVÍAN LOS VALORES
                startActivity(intent);
            }
        }
    }
}