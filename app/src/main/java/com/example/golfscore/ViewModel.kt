package com.example.golfscore

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ViewModel(app:Application) : AndroidViewModel(app) {

    var scores : MutableLiveData<List<Scorecard>>
    init{
        scores = MutableLiveData()

        getScores()


    }

    fun getScores(){
        val db = MyDataBase.getDatabase(getApplication())
        if(db != null){
            val list = db.scorecardDao().getScorecards()
            scores.value = list
        }
    }
}