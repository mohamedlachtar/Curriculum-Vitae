package com.example.cv

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var nameContainer: TextInputLayout
    lateinit var age: EditText
    lateinit var ageContainer: TextInputLayout
    lateinit var email: EditText
    lateinit var emailContainer: TextInputLayout
    lateinit var male: RadioButton
    lateinit var next: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setTitle("Create your resume");

        name = findViewById<EditText>(R.id.name)
        nameContainer = findViewById<TextInputLayout>(R.id.nameContainer)
        age = findViewById<EditText>(R.id.age)
        ageContainer = findViewById<TextInputLayout>(R.id.ageContainer)
        email = findViewById<EditText>(R.id.email)
        emailContainer = findViewById<TextInputLayout>(R.id.emailContainer)
        male = findViewById<RadioButton>(R.id.male)

        name.setOnFocusChangeListener{_,focused ->
            if(!focused)
                nameContainer.helperText = validName(name.text.toString())
        }
        email.setOnFocusChangeListener{_,focused ->
            if(!focused)
                emailContainer.helperText = validEmail(email.text.toString())
        }
        age.setOnFocusChangeListener{_,focused ->
            if(!focused)
                ageContainer.helperText = validAge(age.text.toString())
        }

        next = findViewById<Button>(R.id.nextButton)

        next.setOnClickListener {

            if(validName(name.text.toString())!=null || validEmail(email.text.toString()) != null ||
                validAge(age.text.toString()) != null)
                    return@setOnClickListener

                val intent = Intent(this,SecondScreenActivity::class.java).apply {
                    putExtra("name",name.text.toString())
                    putExtra("email",email.text.toString())
                    putExtra("age",age.text.toString())
                    putExtra("gender",male.isChecked)
                }
                startActivity(intent)

            }
        }


//    fun reset(){
//        name.text.clear()
//        age.text.clear()
//        email.text.clear()
//        male.isChecked = true
//
//        androidSlider.value= 0.toFloat()
//        ios.value= 0.toFloat()
//        flutter.value= 0.toFloat()
//    }

    private fun validName(name: String) : String? {
        if(name.isEmpty())
        {
            return "Type your full name!"
        }
        return null
    }
    private fun validEmail(email: String) : String? {
        if(email.isEmpty())
        {
            return "Type your email!"
        }
        if (!isValidEmail(email.toString())) {
//            val snack = Snackbar.make(it,"Type a valid email!", Snackbar.LENGTH_LONG)
//            snack.show()
            return "Type a valid email!"

        }
        return null
    }
    private fun validAge(age: String) : String? {
        if(age.isEmpty())
        {
            return "Type your age!"
        }
        return null
    }

    private fun isValidEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

}