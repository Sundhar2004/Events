package myevents.example.com.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import myevents.example.com.databinding.ActivityHomeBinding
import myevents.example.com.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    /** Object - 19/07/2023*/
    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        /** clickListener for button - 19/07/2023 **/
        loginBinding.btnSubmit.setOnClickListener {
            validation()
        }
    }

    /** text field validation - 19/07/2023 **/
    private fun validation() {
        val email = loginBinding.tvEmail.text.toString()
        val password = loginBinding.tvPassword.text.toString()

        if (email.isNullOrEmpty() && password.isNullOrEmpty()){
            Toast.makeText(this,"Please enter valid credentials",Toast.LENGTH_SHORT).show()
        }else if (email.isNullOrEmpty() && password.isNotEmpty()){
            Toast.makeText(this,"Please enter valid email",Toast.LENGTH_SHORT).show()
        }else if (password.isNullOrEmpty() && email.isNotEmpty()){
            Toast.makeText(this,"Please enter valid password",Toast.LENGTH_SHORT).show()
        }else{
            startActivity(Intent(this,HomeActivity::class.java))
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
            loginBinding.tvEmail.setText("")
            loginBinding.tvPassword.setText("")
        }

    }
}