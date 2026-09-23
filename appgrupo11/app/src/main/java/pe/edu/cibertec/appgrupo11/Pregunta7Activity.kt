package pe.edu.cibertec.appgrupo11

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo11.databinding.ActivityPregunta7Binding

class Pregunta7Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPregunta7Binding

    companion object {
        private const val DIAS_GRACIA = 2
        private const val CARGO_FIJO = 35.00
        private const val CARGO_POR_DIA = 20.00
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPregunta7Binding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.btncalcular.setOnClickListener(this)
        binding.btnvolverinicio.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.btncalcular -> calcularPenalidad()
            R.id.btnvolverinicio -> irInicio()
        }
    }

    fun irInicio() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun calcularPenalidad() {
        val diasRetraso = binding.etdiasretraso.text.toString().toInt()

        if (diasRetraso <= DIAS_GRACIA) {
            binding.tvresultado.text = "Devolución aceptada sin penalidad."
        } else {
            val excesoComputable = diasRetraso - DIAS_GRACIA
            val penalidadTotal = CARGO_FIJO + (CARGO_POR_DIA * excesoComputable)
            val penalidadFormateada = String.format("%.2f", penalidadTotal)

            binding.tvresultado.text = "Días de atraso: $diasRetraso\n" +
                                        "Exceso computable: $excesoComputable\n" +
                                        "Penalidad total: S/ $penalidadFormateada"
        }
    }
}