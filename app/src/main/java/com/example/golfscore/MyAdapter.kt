package com.example.golfscore

import android.content.Context
import android.graphics.Color
import android.graphics.Color.parseColor
import android.text.Html

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
        holder.itemView.tv_yards.text = String.format(" %s %s", data[position].yardage.toString(),  " yards")
        val teeColor = data[position].tees

        if(teeColor.equals("Black")){
            //holder.itemView.tv_teeEntry.setBackgroundColor(Color.BLACK)
            holder.itemView.tv_teeEntry.setBackgroundResource(R.drawable.tee_color_black)
        }else if(teeColor.equals("Blue")){
            //holder.itemView.tv_teeEntry.setBackgroundColor(parseColor("#2172ff"))
            holder.itemView.tv_teeEntry.setBackgroundResource(R.drawable.tee_color_blue)
        }else if(teeColor.equals("White")){
            //holder.itemView.tv_teeEntry.setBackgroundColor(Color.WHITE)
            holder.itemView.tv_teeEntry.setBackgroundResource(R.drawable.tee_color_white)
        }else if(teeColor.equals("Red")){
            //holder.itemView.tv_teeEntry.setBackgroundColor(parseColor("#F10404"))
            holder.itemView.tv_teeEntry.setBackgroundResource(R.drawable.tee_color_red)
        }

    }


}