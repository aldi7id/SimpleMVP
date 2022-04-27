package com.ajgroup.simplemvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ajgroup.simplemvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding:ActivityMainBinding
    private lateinit var presenter : MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainPresenterImp(this)

        binding.btnAdd.setOnClickListener {
            presenter.addData(binding.etFirstName.text.toString(), binding.etLastName.text.toString())
        }
        binding.btnShow.setOnClickListener {
            presenter.loadData()
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
    }

    override fun showData(data: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Data Student")
        builder.setMessage(data)

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(applicationContext,
                android.R.string.yes, Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(applicationContext,
                android.R.string.no, Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

    override fun clearField() {

    }
}