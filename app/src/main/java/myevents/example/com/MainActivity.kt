package myevents.example.com

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import myevents.example.com.databinding.ActivityMainBinding
import myevents.example.com.ui.HomeActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.splashImg.alpha = 0f
        binding.splashImg.animate().setDuration(1500).alpha(1f).withEndAction{
            startActivity(Intent(this,HomeActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }



    }
}