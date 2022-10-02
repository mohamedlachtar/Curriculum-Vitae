package com.example.cv

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.slider.Slider

class ResumeScreenActivity : AppCompatActivity() {

    lateinit var textView: TextView
    var gender = "Male"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_screen)
        this.setTitle("Your resume");

        val name:String = intent.getStringExtra("name").toString()
        val email:String = intent.getStringExtra("email").toString()
        val age:String = intent.getStringExtra("age").toString()
        val male:Boolean = intent.getBooleanExtra("gender",true)
        if(!male) gender = "Female"

        val androidSkill:String = intent.getStringExtra("android").toString()
        val ios:String = intent.getStringExtra("ios").toString()
        val flutter:String = intent.getStringExtra("flutter").toString()
        val languages:String = intent.getStringExtra("languages").toString()
        val hobbies:String = intent.getStringExtra("hobbies").toString()



        textView = findViewById<TextView>(R.id.textView)

        textView.text = "Name: $name \nEmail: $email \nAge: $age \nGender: $gender \nAndroidSkill: $androidSkill \n" +
                "IosSkill: $ios \n" + "FlutterSkill: $flutter \nLanguages: $languages \nHobbies: $hobbies"
    }
}