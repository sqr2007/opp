package com.example.dalili

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultTitle: TextView = findViewById(R.id.resultTitle)
        val resultText: TextView = findViewById(R.id.resultText)
        val backButton: Button = findViewById(R.id.backButton)

        // فرضاً أننا حصلنا على التخصص المناسب من تحليل الأسئلة
        val specializationResult = "تخصصك هو: هندسة الكمبيوتر"

        resultText.text = "نتيجة التحليل: $specializationResult"

        // العودة إلى الشاشة السابقة عند الضغط على زر الرجوع
        backButton.setOnClickListener {
            finish() // إغلاق هذه الشاشة والعودة إلى الشاشة السابقة
        }
    }
}
