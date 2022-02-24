package com.xosyen.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.xosyen.msgshareapp.Hobby
import com.xosyen.msgshareapp.databinding.ListItemBinding

class HobbiesAdapter(val context: Context, val hobbiesList: List<Hobby>): RecyclerView.Adapter<HobbiesAdapter.HobbiesHolder>() {
    inner class HobbiesHolder(val itemBinding: ListItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                Toast.makeText(context, currentHobby!!.title + " Clicked!", Toast.LENGTH_SHORT).show()
            }

            itemBinding.imgShare.setOnClickListener {
                val message: String = "My hobby is " + currentHobby!!.title

                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"

                context.startActivity(Intent.createChooser(intent, "Share to: "))
            }
        }

        fun setData(hobby: Hobby?, pos: Int) {
            itemBinding.txvTitle.text = hobby!!.title

            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbiesHolder {
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HobbiesHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: HobbiesHolder, position: Int) {
        val hobby: Hobby = hobbiesList[position]
        holder.setData(hobby, position)
    }

    override fun getItemCount(): Int {
        return hobbiesList.size
    }
}