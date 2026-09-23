package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo11.databinding.ActivityPregunta6Binding

class Pregunta6Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        if (view?.id == binding.btnCalcular.id) {

            val horasTexto = binding.etHoras.text.toString()

            if (horasTexto.isEmpty()) {
                binding.etHoras.error =
                    getString(R.string.pregunta6_error_horas)
                return
            }

            val horas = horasTexto.toInt()

            if (horas < 0) {
                binding.etHoras.error =
                    getString(R.string.pregunta6_error_horas_negativas)
                return
            }

            if (horas <= 40) {
                binding.tvResultado.text =
                    getString(R.string.pregunta6_consumo_cubierto)
            } else {
                val horasExcedentes = horas - 40

                val facturacion = 300.00 + (85.00 * horasExcedentes)

                binding.tvResultado.text =
                    getString(
                        R.string.pregunta6_horas_totales,
                        horas
                    ) +
                            "\n" +
                            getString(
                                R.string.pregunta6_horas_excedentes,
                                horasExcedentes
                            ) +
                            "\n" +
                            getString(
                                R.string.pregunta6_facturacion,
                                facturacion
                            )
            }
        }
    }
}