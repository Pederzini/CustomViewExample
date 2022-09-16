package br.com.victor.customviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import br.com.victor.customviews.databinding.ActivityMainBinding
import br.com.victor.customviews.databinding.CustomElementBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateView()
    }

    private fun updateView() {
        with(binding.customElement) {
            setTitle("Novo título")
            setSubtitle("Novo subtítulo")
            setDescription("Nova descrição")
            setNumberOfButtons(1)
            setButtonOneText("Botão 1")
        }
    }
}


