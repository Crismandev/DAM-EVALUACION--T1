package pe.edu.cibertec.appgrupo11

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        findViewById<Button>(R.id.btnPregunta1).setOnClickListener {
            startActivity(Intent(this, Pregunta1Activity::class.java))
        }
        
        findViewById<Button>(R.id.btnPregunta2).setOnClickListener {
            startActivity(Intent(this, Pregunta2Activity::class.java))
        }

        findViewById<Button>(R.id.btnPregunta7).setOnClickListener {
            startActivity(Intent(this, Pregunta7Activity::class.java))
        }
    }
}