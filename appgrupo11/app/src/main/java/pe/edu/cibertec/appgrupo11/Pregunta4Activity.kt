package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo11.databinding.Pregunta4ActivityBinding
import java.util.Locale

class Pregunta4Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: Pregunta4ActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Pregunta4ActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        if (view?.id == binding.btnCalcular.id) {

            val textoMonto = binding.etSobregiro.text.toString()

            if (textoMonto.isEmpty()) {
                binding.etSobregiro.error = "Ingrese el monto del sobregiro"
                return
            }

            val sobregiro = textoMonto.toDouble()
            val limite = 5000.00

            if (sobregiro <= limite) {

                binding.tvResultado.text =
                    "Sobregiro protegido por línea preferente."

            } else {

                val exceso = sobregiro - limite

                val comision = 150.00 + (exceso * 0.03)

                binding.tvResultado.text = String.format(
                    Locale.US,
                    "Sobregiro solicitado: S/ %.2f\n\n" +
                            "Exceso del límite: S/ %.2f\n\n" +
                            "Comisión total aplicada: S/ %.2f",
                    sobregiro,
                    exceso,
                    comision
                )
            }
        }
    }
}