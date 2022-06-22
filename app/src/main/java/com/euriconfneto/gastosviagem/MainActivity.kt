package com.euriconfneto.gastosviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.euriconfneto.gastosviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_calculate){
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString().toFloatOrNull() != null
                && binding.editPrice.text.toString().toFloatOrNull() != null
                && binding.editAutonomy.text.toString().toFloatOrNull() != null
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate(){
        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val total = (distance * price) / autonomy
            binding.textTotalValor.text = "R$ ${"%.2f".format(total)}"
        } else {
            Toast.makeText(this, "Insira um valor valido", Toast.LENGTH_LONG)
        }
    }
}