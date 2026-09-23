package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo11.databinding.ActivityMainBinding
import pe.edu.cibertec.appgrupo11.databinding.ActivityPregunta3Binding

class Pregunta3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPregunta3Binding.inflate(layoutInflater)

        setContentView(binding.root)
        
       binding.btnCalcular.setOnClickListener(this)
    }


    fun calcularMultaBiblioteca() {
        // Usamos el ID exacto que aparece en tu XML: texDiasTranscurridos
        val inputDias = binding.texDiasTranscurridos.text.toString()

        // Validar que el campo no esté vacío
        if (inputDias.isEmpty()) {
            binding.txtResultado.text = "Por favor, ingrese los días de retraso."
            return
        }

        val diasRetraso = inputDias.toInt()

        if (diasRetraso <= 3) {
            binding.txtResultado.text = "Préstamo regularizado dentro de la prórroga."
        } else {
            val diasSujetosCobro = diasRetraso - 3
            val multa = 12.00 + (diasSujetosCobro * 3.50)
            val multaFormateada = String.format("S/ %.2f", multa)

            binding.txtResultado.text = """
                Días de demora: $diasRetraso
                Días sujetos a cobro: $diasSujetosCobro
                Multa administrativa a abonar: $multaFormateada
            """.trimIndent()
        }
    }
    override fun onClick(v: View?) {
        // Usamos 'v?.id' que es el parámetro correcto del método onClick
        when (v?.id) {
            R.id.btnCalcular -> calcularMultaBiblioteca()
        }
    }


}