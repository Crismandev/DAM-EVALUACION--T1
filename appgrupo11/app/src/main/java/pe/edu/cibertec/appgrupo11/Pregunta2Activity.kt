package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo11.databinding.ActivityPregunta2Binding
import java.util.Locale

class Pregunta2Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPregunta2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // setContentView(R.layout.activity_pregunta2)
        binding = ActivityPregunta2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        binding.p2BtnCalcular.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.p2_btn_calcular -> calcularMerma()
        }
    }

    fun calcularDescuento(exceso: Int): Double {
        return 100.0 + 28.0 * exceso
    }

    fun calcularResultadoMerma(prendas: Int): String {
        return when {
            prendas <= 10 -> "Nivel de merma dentro del margen admisible."

            else -> {
                val exceso = prendas - 10
                val descuento = calcularDescuento(exceso)
                val descuentoFormateado = String.format( Locale.US, "%.2f", descuento )

                "Fallas registradas: $prendas\n" + "Exceso de prendas defectuosas: $exceso\n" + "Descuento total por reposición: S/ $descuentoFormateado"
            }
        }
    }

    fun calcularMerma() {
        val prendas = binding.p2EtPrendas.text.toString().trim().toIntOrNull()

        if (prendas == null || prendas < 0) {
            binding.p2InputPrendas.error = "Ingresa una cantidad entera de 0 o más."
            binding.p2TvResultado.text = ""
            return
        }

        binding.p2InputPrendas.error = null

        val resultado = calcularResultadoMerma(prendas)
        binding.p2TvResultado.text = resultado
    }
}