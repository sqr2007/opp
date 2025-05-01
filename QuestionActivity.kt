package com.daleeli.specialtyapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class QuestionActivity : AppCompatActivity() {

    private val questions = listOf(
        "هل تحب حل المسائل الرياضية؟",
        "هل تفضل الأعمال اليدوية؟",
        "هل تحب مساعدة الآخرين نفسيًا أو اجتماعيًا؟",
        "هل تهتم بالتقنية والبرمجة؟",
        "هل تحب الكتابة والتحليل؟"
    )

    private val answers = mutableListOf<Boolean>()
    private var currentIndex = 0

    private lateinit var questionText: TextView
    private lateinit var yesButton: Button
    private lateinit var noButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        questionText = findViewById(R.id.question_text)
        yesButton = findViewById(R.id.yes_button)
        noButton = findViewById(R.id.no_button)

        showQuestion()

        yesButton.setOnClickListener {
            answers.add(true)
            nextQuestion()
        }

        noButton.setOnClickListener {
            answers.add(false)
            nextQuestion()
        }
    }

    private fun showQuestion() {
        if (currentIndex < questions.size) {
            questionText.text = questions[currentIndex]
        }
    }

    private fun nextQuestion() {
        currentIndex++
        if (currentIndex < questions.size) {
            showQuestion()
        } else {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("answers", answers.toBooleanArray())
            startActivity(intent)
            finish()
        }
    }
}
