package com.example.recycleview

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "AddItem Activity"
class AddItemActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additem)

        val herbalName = intent.getStringExtra("herbal_name")
        val herbalBname = intent.getStringExtra("herbal_bname")
        val herbalInfo = intent.getStringExtra("herbal_info")
        val plantphoto = intent.getIntExtra("herbal_image",0)

        val nameTextView: TextView = findViewById(R.id.tvnewname)
        val bnameTextView: TextView = findViewById(R.id.tvnewhname)
        val infoTextView: TextView = findViewById(R.id.tvplantinfo)
        val plantimageview: ImageView = findViewById(R.id.tvnewimage)

        nameTextView.text = "$herbalName"
        bnameTextView.text = "$herbalBname"
        infoTextView.text = "$herbalInfo"
        plantimageview.setImageResource(plantphoto)

        Log.i(TAG,"AddItem Activity Check")


    }
}