package com.example.monthlyyearlyfinance

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val choose_btn = findViewById<Button>(R.id.choose_btn)
        choose_btn.setOnClickListener {
            showYearMonthPickerDialog(choose_btn)  // 將按鈕傳遞到 dialog
        }

        val monthBtn = findViewById<Button>(R.id.month_btn)
        monthBtn.setOnClickListener {
            // 創建 Intent 用來跳轉到 MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)  // 啟動新頁面
        }
        val yearBtn = findViewById<Button>(R.id.year_btn)
        yearBtn.setOnClickListener {
            // 創建 Intent 用來跳轉到 MainActivity2
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)  // 啟動新頁面
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showYearMonthPickerDialog(choose_btn: Button) {
        val dialog = Dialog(this)
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.dialog_year_month_picker, null)
        dialog.setContentView(view)

        val yearPicker = view.findViewById<NumberPicker>(R.id.year_picker)
        val monthPicker = view.findViewById<NumberPicker>(R.id.month_picker)
        val confirmButton = view.findViewById<Button>(R.id.confirm_button)

        // 設置年份範圍，例如從 1900 年到當前年份
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        yearPicker.minValue = 1900
        yearPicker.maxValue = currentYear
        yearPicker.value = currentYear

        // 設置月份範圍 1-12
        monthPicker.minValue = 1
        monthPicker.maxValue = 12
        monthPicker.value = Calendar.getInstance().get(Calendar.MONTH) + 1

        // 確認按鈕點擊事件
        confirmButton.setOnClickListener {
            val selectedYear = yearPicker.value
            val selectedMonth = monthPicker.value
            showToast("你選擇的是：${selectedYear}年 ${selectedMonth}月")

            // 更新按鈕的文字為選擇的年和月
            choose_btn.text = "${selectedYear}年 ${selectedMonth}月"

            dialog.dismiss()
        }

        dialog.show()
    }

    // 使用預設Toast顯示文字訊息
    private fun showToast(text: String) =
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}
