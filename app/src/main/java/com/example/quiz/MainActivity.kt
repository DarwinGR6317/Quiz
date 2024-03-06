package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import com.example.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    // lateinit var myLayout:Coordinator
    private var _binding: ActivityMainBinding? = null
    private val bindingv get() = _binding!!


    private lateinit var question:TextView
    private lateinit var btn_true: Button
    private lateinit var btn_false: Button

    private val questionBank = listOf(
        Question(R.string.question_txt, true),
        Question(R.string.question_java, true),
        Question(R.string.question_html, false),
        Question(R.string.question_main, true),
        Question(R.string.question_alac, false)
    )
    // private fun checkAnswer(userAnswer: Boolean)
    //private var correctCount = 0
    //private var incorrectCount = 0
    private var currentIndex =0
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // val btnTrue: Button =findViewById(R.id.btn_true)
        //val btnFalse: Button=findViewById(R.id.btn_false)
        binding.btnTrue.setOnClickListener {
            checkAnswer(true)
        }

        binding.btnFalse.setOnClickListener {
            checkAnswer(false)
        }
        binding.button3.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            //   val questionTextResId = questionBank[currentIndex].textResId
            //  binding.question.setText(questionTextResId)
            updateQuestion()
        }
        updateQuestion()
    }
    private fun updateQuestion(){
        val questionTextResId = questionBank[currentIndex].textResId
        binding.question.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }

}