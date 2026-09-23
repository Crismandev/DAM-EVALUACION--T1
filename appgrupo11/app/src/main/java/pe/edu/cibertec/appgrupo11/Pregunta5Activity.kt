package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.selects.SelectInstance
import org.w3c.dom.Text
import java.text.NumberFormat
import java.util.Locale

class Pregunta5Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: pe.edu.cibertec.appgrupo11.databinding.ActivityPregunta5Binding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = pe.edu.cibertec.appgrupo11.databinding.ActivityPregunta5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == binding.btnCalcular.id) {
            val texto = binding.txtDecibelios.text.toString()
            val decibelios = texto.toIntOrNull() ?: 0
            
            if(decibelios <= 55){
                binding.txtResultado.text = "Nivel sonoro conforme a la ordenanza."
            } else{
                val exceso = decibelios - 55
                val sancion = 1200.0 + (180.0 * exceso)
                binding.txtResultado.text = """
                    Decibelios medidos: $decibelios
                    Exceso sonoro: $exceso
                    Monto de la sanción municipal: S/ ${String.format(Locale.US, "%.2f", sancion)}
                """.trimIndent()
            }
        }
    }
}
