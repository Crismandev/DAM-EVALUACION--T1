package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.selects.SelectInstance
import org.w3c.dom.Text
import java.text.NumberFormat
import java.util.Locale

class Pregunta5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregunta5)
        val txtDecibelios = findViewById<EditText>(R.id.txtDecibelios)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        //• Si decibelios ≤ 55 dB: no se levanta acta de infracción acústica.
        //• Si decibelios > 55 dB: sanción = S/ 1,200.00 + S/ 180.00 por cada dB por encima del tope.
        //Requerimientos funcionales:
        //1.    Permitir ingresar los decibelios medidos (en dB) mediante un campo numérico.
        //2.    Si los decibelios son ≤ 55, mostrar: "Nivel sonoro conforme a la ordenanza."
        //3.    Si los decibelios son > 55, mostrar:
        //o Decibelios medidos
        //o Exceso sonoro (dB - 55)
        //o Monto de la sanción municipal
        //4.    El monto debe mostrarse en formato moneda: S/ 0.00 (2 decimales).
        btnCalcular.setOnClickListener {
            val decibelios = txtDecibelios.text.toString().toIntOrNull() ?: 0
            if(decibelios <= 55){
                txtResultado.text = "NIVEL SONORO CONFORME A LA ODENANZA"
            } else{
                val exceso = decibelios - 55
                val sancion = 1200.0 + (180.0 * exceso)
                val formatoMoneda = NumberFormat.getCurrencyInstance(Locale("es", "PE"))
                txtResultado.text = """
                    Decibelios medidos: $decibelios dB
                    Exceso sonoro: $exceso dB
                    Monto de la sancion municipal: ${formatoMoneda.format(sancion)}
                """.trimIndent()
            }

        }

    }
}
