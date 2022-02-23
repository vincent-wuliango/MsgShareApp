package com.xosyen.msgshareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.xosyen.msgshareapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnShowToast.setOnClickListener {
            Log.i("MainActivity", "Button was clicked!")
            Toast.makeText(this, "Button was clicked!", Toast.LENGTH_SHORT).show()
        }

        binding.btnSendMsgToNextActivity.setOnClickListener {
            val message: String = binding.etUserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("user_message", message)

            startActivity(intent)
        }

        binding.btnShareToOtherApps.setOnClickListener {
            val message: String = binding.etUserMessage.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to: "))

        }
    }
}