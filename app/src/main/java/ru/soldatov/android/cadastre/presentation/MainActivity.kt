package ru.soldatov.android.cadastre.presentation

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.soldatov.android.cadastre.CadastreApp
import ru.soldatov.android.cadastre.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private val component by lazy {
        (application as CadastreApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.tv)
        tv.setOnClickListener {
            viewModel.refresh()
        }
//        viewModel.newsList.observe(this) {
//            Log.d("MainActivity", "${it.size}")
//        }
        viewModel.definitionsList.observe(this) {
            Log.d("MainActivity", "${it.size}")
        }
    }
}