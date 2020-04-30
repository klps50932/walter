package com.example.coyi.walter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coyi on 2017/12/18.
 */

// 資料功能類別
public class Test_Data {
    // 表格名稱
    public static final String TABLE_NAME = "test_data";

    // 編號表格欄位名稱，固定不變
    public static final String KEY_ID = "_id";
    public static final String LOGIN_COLUMN = "login";
    // 其它表格欄位名稱
    public static final String NAME_COLUMN = "name";
    public static final String WEIGHT_COLUMN = "weight";
    public static final String EXAMOUNT_COLUMN = "examount";
    public static final String MONEY_COLUMN = "money";
    public static final String WATERNOW_COLUMN = "waternow";
    public static final String WATERDAY_COLUMN = "waterday";
    public static final String WATERACCU_COLUMN = "wateraccu";
    public static final String WALKNOW_COLUMN = "walknow";
    public static final String WALKDAY_COLUMN = "walkday";
    public static final String GOOD1_COLUMN = "good1";
    public static final String GOOD2_COLUMN = "good2";
    public static final String GOOD3_COLUMN = "good3";
    public static final String GOOD4_COLUMN = "good4";
    public static final String GOOD5_COLUMN = "good5";
    public static final String GOOD6_COLUMN = "good6";
    public static final String GOOD7_COLUMN = "good7";
    public static final String GOOD8_COLUMN = "good8";
    public static final String EXPERIENCE_COLUMN = "experience";
    public static final String PET_COLUMN = "pet";
    public static final String ACH1_COLUMN = "ach1";
    public static final String ACHIEVEMENT1_COLUMN = "achievement1";
    public static final String ACH2_COLUMN = "ach2";


    // 使用上面宣告的變數建立表格的SQL指令
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    LOGIN_COLUMN + " INTEGER NOT NULL, " +
                    NAME_COLUMN + " TEXT ," +
                    WEIGHT_COLUMN + " INTEGER NOT NULL, " +
                    EXAMOUNT_COLUMN + " INTEGER NOT NULL," +
                    MONEY_COLUMN + " INTEGER NOT NULL," +
                    WATERNOW_COLUMN + " INTEGER NOT NULL," +
                    WATERDAY_COLUMN + " INTEGER NOT NULL," +
                    WATERACCU_COLUMN + " INTEGER NOT NULL," +
                    WALKNOW_COLUMN + " INTEGER NOT NULL," +
                    WALKDAY_COLUMN + " INTEGER NOT NULL," +
                    GOOD1_COLUMN + " INTEGER NOT NULL," +
                    GOOD2_COLUMN + " INTEGER NOT NULL," +
                    GOOD3_COLUMN + " INTEGER NOT NULL," +
                    GOOD4_COLUMN + " INTEGER NOT NULL," +
                    GOOD5_COLUMN + " INTEGER NOT NULL," +
                    GOOD6_COLUMN + " INTEGER NOT NULL," +
                    GOOD7_COLUMN + " INTEGER NOT NULL," +
                    GOOD8_COLUMN + " INTEGER NOT NULL," +
                    EXPERIENCE_COLUMN + " INTEGER NOT NULL," +
                    PET_COLUMN + " INTEGER NOT NULL," +
                    ACH1_COLUMN + " INTEGER NOT NULL," +
                    ACHIEVEMENT1_COLUMN + " INTEGER NOT NULL," +
                    ACH2_COLUMN + " INTEGER NOT NULL)";


    // 資料庫物件
    private SQLiteDatabase db;

    // 建構子，一般的應用都不需要修改
    public Test_Data(Context context){
        db = MyDBHelper.getDatabase(context);
    }

    // 關閉資料庫，一般的應用都不需要修改
    public void close() {
        db.close();
    }

    // 新增參數指定的物件
    public Item insert(Item item) {
        // 建立準備新增資料的ContentValues物件
        ContentValues cv = new ContentValues();
        // 加入ContentValues物件包裝的新增資料
        // 第一個參數是欄位名稱， 第二個參數是欄位的資料
        cv.put(LOGIN_COLUMN, item.getLogin());
        cv.put(NAME_COLUMN, item.getName());
        cv.put(WEIGHT_COLUMN, item.getWeight());
        cv.put(EXAMOUNT_COLUMN, item.getExamount());
        cv.put(MONEY_COLUMN, item.getMoney());
        cv.put(WATERNOW_COLUMN, item.getWaternow());
        cv.put(WATERDAY_COLUMN, item.getWaterday());
        cv.put(WATERACCU_COLUMN, item.getWateraccu());
        cv.put(WALKNOW_COLUMN, item.getWalknow());
        cv.put(WALKDAY_COLUMN, item.getWalkday());
        cv.put(GOOD1_COLUMN, item.getGood1());
        cv.put(GOOD2_COLUMN, item.getGood2());
        cv.put(GOOD3_COLUMN, item.getGood3());
        cv.put(GOOD4_COLUMN, item.getGood4());
        cv.put(GOOD5_COLUMN, item.getGood5());
        cv.put(GOOD6_COLUMN, item.getGood6());
        cv.put(GOOD7_COLUMN, item.getGood7());
        cv.put(GOOD8_COLUMN, item.getGood8());
        cv.put(EXPERIENCE_COLUMN, item.getExperience());
        cv.put(PET_COLUMN, item.getPet());
        cv.put(ACH1_COLUMN, item.getAch1());
        cv.put(ACHIEVEMENT1_COLUMN, item.getAchievement1());
        cv.put(ACH2_COLUMN, item.getAch2());

        // 新增一筆資料並取得編號
        // 第一個參數是表格名稱
        // 第二個參數是沒有指定欄位值的預設值
        // 第三個參數是包裝新增資料的ContentValues物件
        long id = db.insert(TABLE_NAME, null, cv);

        // 設定編號
        item.setId(id);
        // 回傳結果
        return item;
    }

    // 修改參數指定的物件
    public boolean update(Item item) {
        // 建立準備修改資料的ContentValues物件
        ContentValues cv = new ContentValues();

        // 加入ContentValues物件包裝的修改資料
        // 第一個參數是欄位名稱， 第二個參數是欄位的資料
        cv.put(LOGIN_COLUMN, item.getLogin());
        cv.put(NAME_COLUMN, item.getName());
        cv.put(WEIGHT_COLUMN, item.getWeight());
        cv.put(EXAMOUNT_COLUMN, item.getExamount());
        cv.put(MONEY_COLUMN, item.getMoney());
        cv.put(WATERNOW_COLUMN, item.getWaternow());
        cv.put(WATERDAY_COLUMN, item.getWaterday());
        cv.put(WATERACCU_COLUMN, item.getWateraccu());
        cv.put(WALKNOW_COLUMN, item.getWalknow());
        cv.put(WALKDAY_COLUMN, item.getWalkday());
        cv.put(GOOD1_COLUMN, item.getGood1());
        cv.put(GOOD2_COLUMN, item.getGood2());
        cv.put(GOOD3_COLUMN, item.getGood3());
        cv.put(GOOD4_COLUMN, item.getGood4());
        cv.put(GOOD5_COLUMN, item.getGood5());
        cv.put(GOOD6_COLUMN, item.getGood6());
        cv.put(GOOD7_COLUMN, item.getGood7());
        cv.put(GOOD8_COLUMN, item.getGood8());
        cv.put(EXPERIENCE_COLUMN, item.getExperience());
        cv.put(PET_COLUMN, item.getPet());
        cv.put(ACH1_COLUMN, item.getAch1());
        cv.put(ACHIEVEMENT1_COLUMN, item.getAchievement1());
        cv.put(ACH2_COLUMN, item.getAch2());

        // 設定修改資料的條件為編號
        // 格式為「欄位名稱＝資料」
        String where = KEY_ID + "=" + item.getId();

        // 執行修改資料並回傳修改的資料數量是否成功
        return db.update(TABLE_NAME, cv, where, null) > 0;
    }

    // 刪除參數指定編號的資料
    public boolean delete(long id){
        // 設定條件為編號，格式為「欄位名稱=資料」
        String where = KEY_ID + "=" + id;
        // 刪除指定編號資料並回傳刪除是否成功
        return db.delete(TABLE_NAME, where , null) > 0;
    }

    // 讀取所有記事資料
    public List<Item> getAll() {
        List<Item> result = new ArrayList<Item>();
        //游標指向該資料表
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null, null);
        //將所有資料轉成Item並添加進List
        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }
        //關閉游標
        cursor.close();
        return result;
    }

    // 取得指定編號的資料物件
    public Item get(long id) {
        // 準備回傳結果用的物件
        Item item = null;
        // 使用編號為查詢條件
        String where = KEY_ID + "=" + id;
        // 執行查詢
        Cursor result = db.query(TABLE_NAME, null, where, null, null, null, null, null);

        // 如果有查詢結果
        if (result.moveToFirst()) {
            // 讀取包裝一筆資料的物件
            item = getRecord(result);
        }

        // 關閉Cursor物件
        result.close();
        // 回傳結果
        return item;
    }

    // 把游標Cursor取得的資料轉換成目前的資料包裝為物件
    public Item getRecord(Cursor cursor) {
        // 準備回傳結果用的物件
        Item result = new Item();
        result.setId(cursor.getLong(0));
        result.setLogin(cursor.getLong(1));
        result.setName(cursor.getString(2));
        result.setWeight(cursor.getLong(3));
        result.setExamount(cursor.getLong(4));
        result.setMoney(cursor.getLong(5));
        result.setWaternow(cursor.getLong(6));
        result.setWaterday(cursor.getLong(7));
        result.setWateraccu(cursor.getLong(8));
        result.setWalknow(cursor.getLong(9));
        result.setWalkday(cursor.getLong(10));
        result.setGood1(cursor.getLong(11));
        result.setGood2(cursor.getLong(12));
        result.setGood3(cursor.getLong(13));
        result.setGood4(cursor.getLong(14));
        result.setGood5(cursor.getLong(15));
        result.setGood6(cursor.getLong(16));
        result.setGood7(cursor.getLong(17));
        result.setGood8(cursor.getLong(18));
        result.setExperience(cursor.getLong(19));
        result.setPet(cursor.getLong(20));
        result.setAch1(cursor.getLong(21));
        result.setAchievement1(cursor.getLong(22));
        result.setAch2(cursor.getLong(23));
        return result;
    }



    // 取得資料數量
    public int getCount() {
        int result = 0;
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);

        if (cursor.moveToNext()) {
            result = cursor.getInt(0);
        }

        return result;
    }

    // 建立範例資料
    public void sample() {
        Item item = new Item(0,0,"Name",55,1,0,0,0,
                0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0);
        insert(item);
    }
}
