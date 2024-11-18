import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.monthlyyearlyfinance.R
import java.util.Calendar


class MainActivity_h : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val choose = findViewById<Button>(R.id.choose_btn) //選擇日期按鈕
        val button2 = findViewById<Button>(R.id.button2) //開始記帳按鈕
        val button3 = findViewById<Button>(R.id.button3) //記帳內容按鈕

        choose.setOnClickListener {
            // 取得當前日期
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)  // 月份是從0開始的，1月是0
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // 創建 DatePickerDialog
            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay  ->
                    choose.text="${selectedYear}/ ${selectedMonth + 1}/ ${selectedDay}" //選擇日期按鈕改為選定日期
                },
                year, month, day
            )

            // 顯示 DatePickerDialog
            datePickerDialog.show()

        }

        //前往記帳頁面
        button2.setOnClickListener {
            val intent = Intent(this, InsertActivity::class.java)
            intent.putExtra("data_key", choose.text.toString()) // 將選定日期傳給下個頁面
            startActivity(intent)
        }

        //前往記帳內容
        button3.setOnClickListener {
            startActivity(Intent(this,Result::class.java))
        }
    }

}
