package com.example.golfscore

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_new_score.*


class NewScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_score)

        val tees = resources.getStringArray(R.array.teeColors)

        val spinner = findViewById<Spinner>(R.id.spnr_tees)
            if(spinner != null){
                val adapter = ArrayAdapter(this,
                    android.R.layout.simple_spinner_item, tees)
                spinner.adapter = adapter

                spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        if(tees[position].toString() == "Black"){
                            //spinner.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.black))
                            tv_color.setBackgroundColor(Color.BLACK)
                        }else if(tees[position].toString() == "Blue"){
                            //spinner.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.blue))
                            tv_color.setBackgroundColor(Color.parseColor("#2172ff"))
                        }else if(tees[position].toString() == "White"){
                            //spinner.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
                            tv_color.setBackgroundColor(Color.WHITE)
                        }else if(tees[position].toString() == "Red"){
                            //spinner.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.red))
                            tv_color.setBackgroundColor(Color.parseColor("#F10404"))
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }

            }
    }
    fun addScore(view : View){
        if(et_CourseName.text.isNotEmpty() && et_par.text.isNotEmpty() && et_score.text.isNotEmpty() && et_yardage.text.isNotEmpty()) {

            //id as primary key is not properly set up yet, plan to use incremental id for each new record
            var scorecard = Scorecard(
                3,
                et_CourseName.text.toString(),
                et_par.text.toString().toInt(),
                et_score.text.toString().toInt(),
                spnr_tees.selectedItem.toString(),
                et_yardage.text.toString().toInt()
            )

            val db = MyDataBase.getDatabase(this)
            Thread {
                if (db != null) {
                    db.scorecardDao().insertData(scorecard)
                }
            }.start()
        }else{
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_LONG).show()
    }
    }
}