package myevents.example.com.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import myevents.example.com.R
import myevents.example.com.database.NoteDataBase
import myevents.example.com.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding
    private lateinit var database: NoteDataBase
//    private lateinit var viewModel:

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        homeBinding.fabAddNotes.setOnClickListener {
            startActivity(Intent(this,AddNotesActivity::class.java))
        }
    }
}