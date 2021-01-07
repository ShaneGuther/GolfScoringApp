package com.example.golfscore

import android.content.Context
import android.graphics.Color
import android.graphics.Color.parseColor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.record.view.*

class MyAdapter(val data : ArrayList<Scorecard>, var context: Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.record, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.tv_courseEntry.text = data[position].courseName
        holder.itemView.tv_parEntry.text = data[position].par.toString()
        holder.itemView.tv_scoreEntry.text = data[position].score.toString()
        val teeColor = data[position].tees

        if(teeColor.equals("Black")){
            holder.itemView.tv_teeEntry.setBackgroundColor(Color.BLACK)
        }else if(teeColor.equals("Blue")){
            holder.itemView.tv_teeEntry.setBackgroundColor(parseColor("#2172ff"))
        }else if(teeColor.equals("White")){
            holder.itemView.tv_teeEntry.setBackgroundColor(Color.WHITE)
        }else if(teeColor.equals("Red")){
            holder.itemView.tv_teeEntry.setBackgroundColor(parseColor("#F10404"))
        }

    }


}