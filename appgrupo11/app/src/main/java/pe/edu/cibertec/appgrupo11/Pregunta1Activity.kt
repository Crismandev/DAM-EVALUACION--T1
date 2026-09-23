package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo11.databinding.ActivityPregunta1Binding
import java.util.Locale

class Pregunta1Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCalcular -> calcularPenalidad()
        }
    }

    private fun calcularPenalidad() {
        val texto = binding.etDiasRetraso.text.toString()

        if (texto.isBlank()) {
            Toast.makeText(this, "Ingresa los días de retraso", Toast.LENGTH_SHORT).show()
            return
        }

        val dias = texto.toInt()

        if (dias <= 5) {
            binding.tvResultado.text = "Entrega dentro de la tolerancia contractual."
        } else {
            val diasComputables = dias - 5
            val penalidad = 500.0 + (150.0 * diasComputables)

            binding.tvResultado.text = "Días de retraso: $dias\n" +
                    "Días computables para penalidad: $diasComputables\n" +
                    "Descuento o penalidad resultante: S/ ${String.format(Locale.US, "%.2f", penalidad)}"
        }
    }
}