package com.example.golfscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_past_record.*


class PastRecordActivity : AppCompatActivity() {
    //var vm : ViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_past_record)

      //  vm = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)).get(ViewModel::class.java)
       /* if(vm != null){
            val scores = vm?.scores.value
            val adapter = scores?.toList()?.let{
                ArrayAdapter<Scorecard>(this, android.R.layout.simple_list_item_1,
                it
                )
            }*/

        var layoutManager = LinearLayoutManager(this)
        var data = scoreData()
        var adapter = MyAdapter(data, this)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }


    fun scoreData() : ArrayList<Scorecard>{
        var list = ArrayList<Scorecard>(0)
        Thread{
            val db = MyDataBase.getDatabase(this)
            if( db!= null){
                val scores = db?.scorecardDao()?.getScorecards()
                for(score in scores){
                    list.add(score)
                }
            }
        }.start()
        return list
    }
}