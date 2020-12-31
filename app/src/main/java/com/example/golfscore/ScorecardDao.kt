package com.example.golfscore

import androidx.room.*

@Dao

interface ScorecardDao {
    @Insert
    fun insertData(vararg scores : Scorecard)

    @Query("SELECT * FROM scorecard")
    fun getScorecards() : List<Scorecard>

    @Update
    fun update(scorecard : Scorecard)
}