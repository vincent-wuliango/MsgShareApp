package com.xosyen.msgshareapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.xosyen.msgshareapp.adapters.HobbiesAdapter
import com.xosyen.msgshareapp.models.Supplier
import com.xosyen.msgshareapp.databinding.ActivityHobbiesBinding

class HobbiesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHobbiesBinding

    companion object {
        val TAG: String = HobbiesActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHobbiesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager

        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        binding.recyclerView.adapter = adapter
    }
}
