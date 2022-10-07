package com.example.cv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.core.text.toSpannable
import com.google.android.material.slider.Slider
import com.google.android.material.snackbar.Snackbar

class SecondScreenActivity : AppCompatActivity() {

    lateinit var androidSlider: Slider
    lateinit var ios: Slider
    lateinit var flutter: Slider

    lateinit var arabic: CheckBox
    lateinit var french: CheckBox
    lateinit var english: CheckBox

    lateinit var music: CheckBox
    lateinit var sport: CheckBox
    lateinit var games: CheckBox

    var languages = ""
    var hobbies = ""

    lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        this.setTitle("Create your resume");

        androidSlider = findViewById<Slider>(R.id.androidSlider)
        ios = findViewById<Slider>(R.id.iosSlider)
        flutter = findViewById<Slider>(R.id.flutterSlider)

        arabic = findViewById<CheckBox>(R.id.checkBox)
        french = findViewById<CheckBox>(R.id.checkBox2)
        english = findViewById<CheckBox>(R.id.checkBox3)

        music = findViewById<CheckBox>(R.id.cbMusic)
        sport = findViewById<CheckBox>(R.id.cbSport)
        games = findViewById<CheckBox>(R.id.cbGames)

        submit = findViewById<CheckBox>(R.id.submitButton)

        val name:String = intent.getStringExtra("name").toString()
        val email:String = intent.getStringExtra("email").toString()
        val age:String = intent.getStringExtra("age").toString()
        val male:Boolean = intent.getBooleanExtra("gender",true)
        val image:String = intent.getStringExtra("image").toString()


        submit.setOnClickListener{

            if(arabic.isChecked) languages+= " Arabic"
            if(french.isChecked) languages+= " French"
            if(english.isChecked) languages+= " English"

            if(music.isChecked) hobbies+= " Music"
            if(sport.isChecked) hobbies+= " Sport"
            if(games.isChecked) hobbies+= " Games"

            val intent = Intent(this,Resume2Activity::class.java).apply {
                putExtra("name",name)
                putExtra("email",email)
                putExtra("age",age)
                putExtra("gender",male)
                putExtra("android",androidSlider.value.toString())
                putExtra("ios",ios.value.toString())
                putExtra("flutter",flutter.value.toString())
                putExtra("languages",languages)
                putExtra("hobbies",hobbies)
                putExtra("image",image)
            }
            startActivity(intent)
            finish()
        }

    }
}