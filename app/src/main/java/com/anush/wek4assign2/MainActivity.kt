package com.anush.wek4assign2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var etStudentId : EditText
    lateinit var etStudentName : EditText
    lateinit var etAndroidMarks : EditText
    lateinit var etApiMarks : EditText
    lateinit var etIotMarks: EditText
    lateinit var btnAdd: Button
    private var count: Int = 0
    private val marksArrayList = ArrayList<MarksInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etStudentId = findViewById(R.id.etStudentId)
        etStudentName = findViewById(R.id.etStudentName)
        etAndroidMarks = findViewById(R.id.etAndroidMarks)
        etApiMarks = findViewById(R.id.etApiMarks)
        etIotMarks = findViewById(R.id.etIotMarks)
        btnAdd = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.btnAdd ->{
                if (isValid()){
                    count++
                    val androidMarks = etAndroidMarks.text.toString().toDouble()
                    val apiMarks = etApiMarks.text.toString().toDouble()
                    val iotMarks = etIotMarks.text.toString().toDouble()
                    val percentage = (androidMarks + apiMarks + iotMarks)/3

                    marksArrayList.add(MarksInfo(etStudentId.text.toString(),
                            etStudentName.text.toString(), androidMarks,apiMarks,iotMarks, percentage))
                    etStudentId.setText("")
                    etStudentName.setText("")
                    etAndroidMarks.setText("")
                    etApiMarks.setText("")
                    etIotMarks.setText("")

                    if (count == 3){
                        val intent = Intent(this, PositiionTallyActivity::class.java)
                        intent.putExtra("marksArrayList", marksArrayList)
                        startActivity(intent)
                        count = 0
                        marksArrayList.clear()
                    }
                }
            }
        }
    }
    private fun isValid() : Boolean{
        when{
            etStudentId.text.isEmpty() ->{
                etStudentId.error = "Field must not be empty"
                return false
            }
            etStudentName.text.isEmpty() ->{
                etStudentName.error = "Field must not be empty"
                return false
            }
            etAndroidMarks.text.isEmpty() ->{
                etAndroidMarks.error = "Field must not be empty"
                return false
            }
            etApiMarks.text.isEmpty() ->{
                etApiMarks.error = "Field must not be empty"
                return false
            }
            btnAdd.text.isEmpty() ->{
                btnAdd.error = "Field must not be empty"
                return false
            }
        }
        return true
    }
}