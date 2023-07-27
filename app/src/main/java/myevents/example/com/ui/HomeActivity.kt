package myevents.example.com.ui

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import myevents.example.com.R
import myevents.example.com.adapter.EventAdapter
import myevents.example.com.database.NoteDataBase
import myevents.example.com.databinding.ActivityHomeBinding
import myevents.example.com.models.EventViewModel
import myevents.example.com.models.Notes

class HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding
    private lateinit var database: NoteDataBase
    private lateinit var viewModel: EventViewModel
    private lateinit var adapter: EventAdapter
    private lateinit var notemodel: Notes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)


        initializeUi()

        homeBinding.fabAddNotes.setOnClickListener {
            startActivity(Intent(this, AddNotesActivity::class.java))
        }
    }

    private fun initializeUi() {
        homeBinding.rvEvents.setHasFixedSize(true)
        homeBinding.rvEvents.layoutManager = StaggeredGridLayoutManager(2,LinearLayout.VERTICAL)
        adapter = EventAdapter(this)
        homeBinding.rvEvents.adapter = adapter

        val getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == Activity.RESULT_OK){

            }

        }
    }
}
