package com.example.golfscore

import android.content.Context
import androidx.room.*

@Database(entities = arrayOf(Scorecard::class), version = 1)

abstract class MyDataBase : RoomDatabase() {

    abstract fun scorecardDao() : ScorecardDao
    companion object {

        private var instance: MyDataBase? = null

        fun getDatabase(context : Context): MyDataBase?{
            if(instance == null){
                synchronized(MyDataBase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyDataBase::class.java,
                        "MyDataBase"
                    ).allowMainThreadQueries().build()
                }
            }
            return instance
        }

    }
}