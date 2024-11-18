import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class sql(
    context: Context,
    name: String = database,
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = ver
) : SQLiteOpenHelper(context, name, factory, version) {
    companion object {
        private const val database = "data" //資料庫名稱
        private const val ver = 2 //資料庫版本
    }

    override fun onCreate(db: SQLiteDatabase) {
        //建立data 資料表，表內有 date, class, type, money 欄位，分別存日期、類別(食物、交通、娛樂等)、類型(收入/支出 )、金額
        db.execSQL("CREATE TABLE data(id INTEGER PRIMARY KEY AUTOINCREMENT, date text not null, clas text not null, type text not null, money text not null)")
    }

    override fun onUpgrade(
        db: SQLiteDatabase, oldVersion: Int,
        newVersion: Int
    ) {
        //升級資料庫版本時，刪除舊資料表，並重新執行 onCreate()，建立新資料表
        db.execSQL("DROP TABLE IF EXISTS data")
        onCreate(db)
    }

    /**
     * 獲取支出或收入總金額
     * @param type 收入或支出的類型 ("收入" 或 "支出")
     * @return 總金額 (Double)
     * jiapei 修改
     */
    fun getTotalAmount(type: String): Double {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT SUM(money) FROM data WHERE type = ?", arrayOf(type))
        var totalAmount = 0.0
        if (cursor.moveToFirst()) {
            totalAmount = cursor.getDouble(0) // 取得總金額
        }
        cursor.close()
        return totalAmount
    }

    /**
     * 獲取記錄筆數
     * @param type 收入或支出的類型 ("收入" 或 "支出")
     * @return 記錄的筆數 (Int)
     * jiapei修改
     */
    fun getRecordCount(type: String): Int {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT COUNT(*) FROM data WHERE type = ?", arrayOf(type))
        var count = 0
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0) // 取得記錄筆數
        }
        cursor.close()
        return count
    }
}
