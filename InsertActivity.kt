import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.monthlyyearlyfinance.R

class InsertActivity : AppCompatActivity() {

    lateinit var db: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        //建立資料庫
        db = sql(this).writableDatabase

        //綁定元件
        val date = findViewById<TextView>(R.id.date) //選擇的日期
        val btnClean = findViewById<Button>(R.id.btnClean) // 清除所有輸入
        val money = findViewById<EditText>(R.id.editTextText) // 金額
        val iinn = findViewById<Button>(R.id.iinn) // 收入按鈕
        val out = findViewById<Button>(R.id.out) // 支出按鈕
        var type = "in" // 預設類型為收入
        val clas = findViewById<EditText>(R.id.editTextText2) // 收入/支出類別
        val sub = findViewById<Button>(R.id.sub) //儲存

        val iback = findViewById<Button>(R.id.iback) //回主畫面

        //收入按鈕被點擊，切換成收入
        iinn.setOnClickListener{
            type="in"
        }
        //支出按鈕被點擊，切換成支出
        out.setOnClickListener{
            type="out"
        }

        //收主畫面傳來的日期
        date.text = intent.getStringExtra("data_key") ?: "No data"

        //插入一筆資料
        sub.setOnClickListener {
            try {
                //插入一筆紀錄於資料表
                db.execSQL(
                    "INSERT INTO data (date, clas, type, money) " +
                            "VALUES('${date.text}','${clas.text}','$type','${money.text}')"
                )
                showToast("成功寫入data資料庫以下資料:${date.text},class:${clas.text}," +
                        "money：${money.text},in or out：${type}")

            } catch (e: Exception) {
                e.printStackTrace()
                showToast("新增失敗:$e")
            }
        }

        //清除輸入欄
        btnClean.setOnClickListener{
            clas.text=null
            money.text=null
            type="in"
        }

        iback.setOnClickListener {
            finish()
        }

    }


    //建立 showToast 方法顯示 Toast 訊息
    private fun showToast(text: String) =
        Toast.makeText(this,text, Toast.LENGTH_LONG).show()
}
