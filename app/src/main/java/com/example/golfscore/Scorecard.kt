package com.example.golfscore

import androidx.room.*


@Entity

data class Scorecard (
    @PrimaryKey var id : Int,
    @ColumnInfo(name = "course_name") var courseName : String,
    @ColumnInfo(name = "par") var par : Int,
    @ColumnInfo(name = "score") var score : Int,
    @ColumnInfo(name = "tees") var tees : String,
    @ColumnInfo(name = "yardage") var yardage : Int
)