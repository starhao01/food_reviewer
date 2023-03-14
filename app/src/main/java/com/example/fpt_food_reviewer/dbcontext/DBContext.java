package com.example.fpt_food_reviewer.dbcontext;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.fpt_food_reviewer.model.Users;

public class DBContext extends SQLiteOpenHelper {
    //Ten database
    private static final String DATABASE_NAME = "restaurant_reviews.db";
    //Version database
    private static final int DATABASE_VERSION = 1;
    //Table: USERS

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_IS_ADMIN = "is_admin";
    //Table: RESTAURANT
    public static final String TABLE_RESTAURANTS = "restaurants";
    public static final String COLUMN_RESTAURANT_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_WEBSITE = "website";
    public static final String COLUMN_DESCRIPTION = "description";
    //Table: Review
    public static final String TABLE_REVIEWS = "reviews";
    public static final String COLUMN_REVIEW_ID = "id";
    public static final String COLUMN_RESTAURANT_ID_REF = "restaurant_id";
    public static final String COLUMN_USER_ID_REF = "user_id";
    public static final String COLUMN_REVIEWS_ID_REF = "Reviews_id";
    public static final String COLUMN_COMMENT = "comment";
    public static final String COLUMN_DATE_CREATED = "date_created";
    //Table: Review_details
    public static final String TABLE_REVIEWS_DETAILS = "reviews_details";
    public static final String COLUMN_REVIEW_DETAILS_ID = "id";
    public static final String COLUMN_SATISFACTION_LEVEL = "satisfaction_level";
    public static final String COLUMN_SERVICE_SPEED = "service_speed";
    public static final String COLUMN_FOOD_QUALITY = "food_quality";
    public static final String COLUMN_AMBIANCE = "ambiance";
    public static final String COLUMN_VALUE_FOR_MONEY = "value_for_money";
    public static final String COLUMN_CLEANLINESS = "cleanliness";
    public static final String COLUMN_REVIEW_ID_REF = "review_id";


    public DBContext(@Nullable Context context) {
        super(context, null, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE USER
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_USERNAME + " TEXT NOT NULL UNIQUE,"
                + COLUMN_PASSWORD + " TEXT NOT NULL,"
                + COLUMN_IS_ADMIN + " INTEGER NOT NULL DEFAULT 0"
                + ")";
        db.execSQL(CREATE_USERS_TABLE);
        //CREATE TABLE RESTAURANT
        String CREATE_RESTAURANTS_TABLE = "CREATE TABLE " + TABLE_RESTAURANTS + "("
                + COLUMN_RESTAURANT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT NOT NULL UNIQUE,"
                + COLUMN_ADDRESS + " TEXT,"
                + COLUMN_PHONE_NUMBER + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT"
                + ")";
        db.execSQL(CREATE_RESTAURANTS_TABLE);
        //CREATE TABLE REVIEW
        String CREATE_REVIEWS_TABLE = "CREATE TABLE " + TABLE_REVIEWS + "("
                + COLUMN_REVIEW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_RESTAURANT_ID_REF + " INTEGER NOT NULL,"
                + COLUMN_USER_ID_REF + " INTEGER NOT NULL,"
                + COLUMN_REVIEWS_ID_REF + " INTEGER NOT NULL,"
                + COLUMN_COMMENT + " TEXT,"
                + COLUMN_DATE_CREATED + " DATETIME DEFAULT CURRENT_TIMESTAMP,"
                + "FOREIGN KEY(" + COLUMN_RESTAURANT_ID_REF + ") REFERENCES " + TABLE_RESTAURANTS + "(" + COLUMN_RESTAURANT_ID + "),"
                + "FOREIGN KEY(" + COLUMN_USER_ID_REF + ") REFERENCES " + TABLE_USERS + "(" + COLUMN_USER_ID + ")"
                + ")";
        db.execSQL(CREATE_REVIEWS_TABLE);
        //CREATE TABLE REVIEW_DETAILS
        String CREATE_REVIEWS_DETAILS_TABLE = "CREATE TABLE " + TABLE_REVIEWS_DETAILS + "("
                + COLUMN_REVIEW_DETAILS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SATISFACTION_LEVEL + " INTEGER NOT NULL,"
                + COLUMN_SERVICE_SPEED + " INTEGER NOT NULL,"
                + COLUMN_FOOD_QUALITY + " INTEGER NOT NULL,"
                + COLUMN_AMBIANCE + " INTEGER NOT NULL,"
                + COLUMN_VALUE_FOR_MONEY + " INTEGER NOT NULL,"
                + COLUMN_CLEANLINESS + " INTEGER NOT NULL,"
                + COLUMN_REVIEW_ID_REF + " INTEGER NOT NULL,"
                + "FOREIGN KEY(" + COLUMN_REVIEW_ID_REF + ") REFERENCES " + TABLE_REVIEWS + "(" + COLUMN_REVIEW_ID + ")"
                + ")";
        db.execSQL(CREATE_REVIEWS_DETAILS_TABLE);
        //Fake Data
        insertAdminUser(db);
    }

    public void insertNewRestaurant(String name, String andress,String phone,String description){
        String sql = "INSERT INTO restaurants(name,andress,phone,description) VALUES (?,?)";
        getWritableDatabase().execSQL(sql, new Object[]{name,andress,phone,description});
    }
    public Cursor selectAllUsers(){
        String sql = "select * from users";
        return getReadableDatabase().rawQuery(sql,new String[]{});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REVIEWS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REVIEWS_DETAILS);
        onCreate(db);
    }

    private void insertAdminUser(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put("username", "admin");
        values.put("password", "admin");
        values.put("is_admin", 1);
        db.insert("users", null, values);
    }

    public boolean login(String username, String password) {
        boolean result = false;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", new String[]{username, password});
        if (cursor.moveToFirst()) {
            result = true;
        }
        cursor.close();
        db.close(); // Close the database object
        return result;
    }

}
