package com.bignerdranch.android.farnosv10

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
//обьявление переменых типа баттон и едит текст
private lateinit var   button: Button
private lateinit var   button2: Button
private lateinit var   editText: EditText
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //присваивание переменных
        editText=findViewById(R.id.editTextTextPassword);
        button= findViewById(R.id.buttonMain);
        button2= findViewById(R.id.start2);
        //создание экзпеляра класса haredPreferences
        val  preferens= getSharedPreferences("keypref", MODE_PRIVATE)
        // видимо не видимо
        if (preferens.contains("pinkod")) {
            button.visibility = View.INVISIBLE
            button2.visibility = View.VISIBLE
        }
        else {
            button.visibility = View.VISIBLE
            button2.visibility = View.INVISIBLE
        }
        val InputPinkod =""
        //обработчик нажатия кнопки
        button.setOnClickListener {
            //ПЕРВОЕ Входное значение пинкода
            val InputPinkod = editText.text.toString()
                val edit = preferens.edit()
                edit.putString("pinkod",InputPinkod)
                edit.apply()
            Log.d("Preferens",preferens.getString("pinkod",InputPinkod).toString())
            //если  preferens  содержит пикод

        }
        button2.setOnClickListener {
            //ВТОРОЕ Входное значение пинкода
                val GetPinkod = editText.text.toString()
                 if(GetPinkod==preferens.getString("pinkod", "ERROR!!!")) {
                     val intent = Intent(this, SecondActivity::class.java)
                     startActivity(intent)
                     val edit = preferens.edit()
                     edit.putString("pinkod",InputPinkod)
                     edit.apply()
                 }



        }

    }
}