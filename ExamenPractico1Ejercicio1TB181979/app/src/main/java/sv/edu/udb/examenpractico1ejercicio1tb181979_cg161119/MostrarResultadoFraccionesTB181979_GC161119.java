package sv.edu.udb.examenpractico1ejercicio1tb181979_cg161119;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MostrarResultadoFraccionesTB181979_GC161119 extends AppCompatActivity {

    //SE DECLARAN LOS TEXTVIEW QUE MOSTRARÁN EL RESULTADO
    TextView numeradorResultadoSuma;
    TextView denominadorResultadoSuma;
    TextView numeradorResultadoResta;
    TextView denominadorResultadoResta;
    TextView numeradorResultadoMultiplicacion;
    TextView denominadorResultadoMultiplicacion;
    TextView numeradorResultadoDivision;
    TextView denominadorResultadoDivision;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_resultado_fracciones_tb181979);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //FUNCIÓN PARA RECIBIR DATOS DEL MAINACTIVITY
        recibirDatos();
    }

    private void recibirDatos(){
        //SE DECLARA LA VARIABLE QUE SERVIRÁ PARA LLAMAR LOS VALORES DEL MAIN ACTIVITY
        Bundle extras = getIntent().getExtras();
        //SE OBTIENE CADA UNO DE LOS VALORES DE LOS ACTIVITY
        int numeradorSuma = extras.getInt("numeradorSuma");
        int denominadorSuma = extras.getInt("denominadorSuma");
        int numeradorResta = extras.getInt("numeradorResta");
        int denominadorResta = extras.getInt("denominadorResta");
        int numeradorMultiplicacion = extras.getInt("numeradorMultiplicacion");
        int denominadorMultiplicacion = extras.getInt("denominadorMultiplicacion");
        int numeradorDivision = extras.getInt("numeradorDivision");
        int denominadorDivision = extras.getInt("denominadorDivision");

        ///////////////////SIMPLIFICANDO SUMA
        MCD(numeradorSuma,denominadorSuma);
        numeradorResultadoSuma=findViewById(R.id.numeradorResultadoSuma);
        denominadorResultadoSuma=findViewById(R.id.denominadorResultadoSuma);
        simplificar(numeradorSuma,denominadorSuma,numeradorResultadoSuma, denominadorResultadoSuma);
        ///////////////////SIMPLIFICANDO RESTA
        MCD(numeradorResta,denominadorResta);
        numeradorResultadoResta=findViewById(R.id.numeradorResultadoResta);
        denominadorResultadoResta=findViewById(R.id.denominadorResultadoResta);
        simplificar(numeradorResta,denominadorResta,numeradorResultadoResta, denominadorResultadoResta);
        ///////////////////SIMPLIFICANDO MULTIPLICACIÓN
        MCD(numeradorMultiplicacion,denominadorMultiplicacion);
        numeradorResultadoMultiplicacion=findViewById(R.id.numeradorResultadoMultiplicacion);
        denominadorResultadoMultiplicacion=findViewById(R.id.denominadorResultadoMultiplicacion);
        simplificar(numeradorMultiplicacion,denominadorMultiplicacion,numeradorResultadoMultiplicacion, denominadorResultadoMultiplicacion);
        ///////////////////SIMPLIFICANDO DIVISIÓN
        MCD(numeradorDivision,denominadorDivision);
        numeradorResultadoDivision=findViewById(R.id.numeradorResultadoDivision);
        denominadorResultadoDivision=findViewById(R.id.denominadorResultadoDivision);
        simplificar(numeradorDivision,denominadorDivision,numeradorResultadoDivision, denominadorResultadoDivision);
    }

    private int MCD(int numerador, int denominador){//Encontrar MCD para dividirlo por el resultado
        int maximo, minimo, resto;
        maximo = Math.max(numerador,denominador);
        minimo = Math.min(numerador,denominador);
        while(minimo!=0){
            resto=maximo%minimo;
            maximo=minimo;
            minimo=resto;
        }
        return maximo;
    }

    public void simplificar(int numerador, int denominador, TextView caja, TextView caja2){//Función para simplificar
        int res = MCD(numerador,denominador);
        numerador/=res;
        denominador/=res;
        caja.setText(String.valueOf(numerador));
        caja2.setText(String.valueOf(denominador));
    }

    //FUNCIÓN PARA VOLVER A LA VENTANA ANTERIOR
    public void Regresar(View v){
        onBackPressed();
    }
}