package com.xosyen.msgshareapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.xosyen.msgshareapp.databinding.ActivitySecondBinding
import com.xosyen.msgshareapp.showToast

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bundle: Bundle? = intent.extras
        val msg = bundle!!.getString("user_message")

        showToast(msg.toString())

        binding.txtUserMessage.text = msg
    }
}