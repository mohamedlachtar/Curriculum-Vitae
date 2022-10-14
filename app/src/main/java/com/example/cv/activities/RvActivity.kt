package com.example.cv.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cv.R
import com.example.cv.databinding.ActivityRvBinding
import com.example.cv.fragments.CompaniesFragment
import com.example.cv.fragments.EducationFragment
import com.example.cv.fragments.SkillsFragment

class RvActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRvBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(EducationFragment())

        binding.companiesButton .setOnClickListener{
            replaceFragment(CompaniesFragment())
        }

        binding.educationButton.setOnClickListener{
            replaceFragment(EducationFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val bundle = Bundle()
        fragment.arguments = bundle
        val fragmentManager =  supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}