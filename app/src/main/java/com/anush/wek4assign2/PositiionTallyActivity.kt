package com.anush.wek4assign2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PositiionTallyActivity : AppCompatActivity() {
    private lateinit var tvRankHolder: TextView
    private lateinit var tvSecondPosition: TextView
    private lateinit var tvThirdPosition: TextView
    private lateinit var tvFirstAndroid: TextView
    private lateinit var tvSecondAndroid: TextView
    private lateinit var tvThirdAndroid: TextView
    private var marksArrayList: ArrayList<MarksInfo>? = ArrayList()
    private var highestInAndroid:ArrayList<MarksInfo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_positiion_tally)

        tvRankHolder = findViewById(R.id.tvRankHolder)
        tvSecondPosition = findViewById(R.id.tvSecondPosition)
        tvThirdPosition = findViewById(R.id.tvThirdPosition)
        tvFirstAndroid = findViewById(R.id.tvFirstAndroid)
        tvSecondAndroid = findViewById(R.id.tvSecondAndroid)
        tvThirdAndroid = findViewById(R.id.tvThirdAndroid)
        marksArrayList = intent.getParcelableArrayListExtra("marksArrayList")
        marksArrayList?.sortBy { student -> student.percentage }
        marksArrayList?.reverse()
        for (i in marksArrayList?.indices!!){
            highestInAndroid.add(marksArrayList!![i])
        }
        highestInAndroid?.sortBy { student -> student.androidMarks }
        highestInAndroid?.reverse()

        tvRankHolder.text = "${marksArrayList!![0].studentName.toString()} with ${marksArrayList!![0].percentage.toString()}%"
        tvSecondPosition.text = "${marksArrayList!![1].studentName.toString()} with ${marksArrayList!![1].percentage.toString()}%"
        tvThirdPosition.text = "${marksArrayList!![2].studentName.toString()} with ${marksArrayList!![2].percentage.toString()}%"

        tvFirstAndroid.text = "${highestInAndroid[0].studentName.toString()} with ${highestInAndroid[0].androidMarks.toString()} marks"
        tvSecondAndroid.text = "${highestInAndroid[1].studentName.toString()} with ${highestInAndroid[1].androidMarks.toString()} marks"
        tvThirdAndroid.text = "${highestInAndroid[2].studentName.toString()} with ${highestInAndroid[2].androidMarks.toString()} marks"


    }
}