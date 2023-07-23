package myevents.example.com.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import myevents.example.com.R
import myevents.example.com.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgOk.setOnClickListener {
            finish()
            Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
        }

        binding.imgBack.setOnClickListener {
            finish()
        }

    }
}