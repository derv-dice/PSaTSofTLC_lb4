package com.example.lab_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Label
        val labelResult: TextView = findViewById(R.id.label_result)

        // TextView
        val textA: TextView = findViewById(R.id.text_a)
        val textB: TextView = findViewById(R.id.text_b)

        // Кнопки
        val btnAdd: Button = findViewById(R.id.btn_add)
        val btnSub: Button = findViewById(R.id.btn_sub)
        val btnMult: Button = findViewById(R.id.btn_mult)
        val btnDiv: Button = findViewById(R.id.btn_div)
        val btnClear: Button = findViewById(R.id.btn_clear)

        // Функции _________________________________________________________________________________
        // Проверка заполненности A и B перед выполнением действия
        fun check(): Boolean {
            if (textA.text.toString().toFloatOrNull() == null || textB.text.toString().toFloatOrNull() == null) {
                Toast.makeText(applicationContext, "Недопустимое значение A [${textA.text}] или B [${textB.text}]", Toast.LENGTH_SHORT).show()
                return false
            }

            return true
        }

        // Сложение
        fun add() {
            if (!check()) {
                return
            }

            labelResult.setText("${(textA.text.toString().toFloat() + textB.text.toString().toFloat())}").toString()
        }

        // Вычитание
        fun sub() {
            if (!check()) {
                return
            }

            labelResult.setText("${(textA.text.toString().toFloat() - textB.text.toString().toFloat())}").toString()
        }

        // Умножение
        fun mult() {
            if (!check()) {
                return
            }

            labelResult.setText("${(textA.text.toString().toFloat() * textB.text.toString().toFloat())}").toString()
        }

        // Деление
        fun div() {
            if (!check()) {
                return
            }

            labelResult.setText("${(textA.text.toString().toFloat() / textB.text.toString().toFloat())}").toString()
        }

        // Очистка
        fun clear() {
            labelResult.setText("0.0").toString()
            textA.setText("").toString()
            textB.setText("").toString()
        }

        // Обработчики _____________________________________________________________________________
        btnAdd.setOnClickListener {
            add()
        }

        btnSub.setOnClickListener {
            sub()
        }

        btnDiv.setOnClickListener {
            div()
        }

        btnMult.setOnClickListener {
            mult()
        }

        btnClear.setOnClickListener {
            clear()
        }
    }
}