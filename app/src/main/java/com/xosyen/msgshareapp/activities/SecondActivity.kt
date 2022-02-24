package com.xosyen.msgshareapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.xosyen.msgshareapp.Constants
import com.xosyen.msgshareapp.databinding.ActivitySecondBinding
import com.xosyen.msgshareapp.showToast

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    companion object {
        val TAG: String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            val msg = bundle!!.getString(Constants.USER_MSG_KEY)
            showToast(msg.toString())
            binding.txtUserMessage.text = msg
        }
    }
}