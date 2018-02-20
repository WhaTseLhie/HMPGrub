package com.example.jayvee.hmpgrub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class HMPGrubDatabase extends SQLiteOpenHelper {

    static String DATABASE = "db_hmpgrub";
    static String TBL_CUSTOMER = "tbl_customer";
    static String TBL_LOGGED_IN_CUSTOMER = "tbl_logged_in_customer";

    public HMPGrubDatabase(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        String sql = "CREATE TABLE " +TBL_CUSTOMER+ "(customer_id integer primary key autoincrement, customer_fname varchar(20), customer_lname varchar(20), customer_gender varchar(7), customer_bday varchar(20), customer_email varchar(50), customer_contact varchar(11), customer_username varchar(50), customer_password varchar(50), cust_state varchar(20))";
        arg0.execSQL(sql);
        String sql1 = "CREATE TABLE " +TBL_LOGGED_IN_CUSTOMER+ "(customer_id integer primary key autoincrement, customer_fname varchar(20), customer_lname varchar(20), customer_gender varchar(7), customer_bday varchar(20), customer_email varchar(50), customer_contact varchar(11), customer_username varchar(50), customer_password varchar(50), cust_state varchar(20))";
        arg0.execSQL(sql1);
    }

    public long addCustomer(String customer_fname, String customer_lname, String customer_gender, String customer_bday, String customer_email, String customer_contact, String customer_username, String customer_password, String cust_state) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = 0;
        ContentValues cv = new ContentValues();

        cv.put("customer_fname", customer_fname);
        cv.put("customer_lname", customer_lname);
        cv.put("customer_gender", customer_gender);
        cv.put("customer_bday", customer_bday);
        cv.put("customer_email", customer_email);
        cv.put("customer_contact", customer_contact);
        cv.put("customer_username", customer_username);
        cv.put("customer_password", customer_password);
        cv.put("cust_state", cust_state);

        result = db.insert(TBL_CUSTOMER, null, cv);

        db.close();
        return result;
    }

    public ArrayList<Customer> getAllCustomer() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Customer> list = new ArrayList<>();
        Cursor c = db.query(TBL_CUSTOMER, null, null, null, null, null, "customer_id");
        list.clear();

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            String customer_id = c.getString(c.getColumnIndex("customer_id"));
            String customer_fname = c.getString(c.getColumnIndex("customer_fname"));
            String customer_lname = c.getString(c.getColumnIndex("customer_lname"));
            String customer_gender = c.getString(c.getColumnIndex("customer_gender"));
            String customer_bday = c.getString(c.getColumnIndex("customer_bday"));
            String customer_email = c.getString(c.getColumnIndex("customer_email"));
            String customer_contact = c.getString(c.getColumnIndex("customer_contact"));
            String customer_username = c.getString(c.getColumnIndex("customer_username"));
            String customer_password = c.getString(c.getColumnIndex("customer_password"));
            String cust_state = c.getString(c.getColumnIndex("cust_state"));

            list.add(new Customer(customer_id, customer_fname, customer_lname, customer_gender, customer_bday, customer_email, customer_contact, customer_username, customer_password, cust_state));
        }

        c.close();
        db.close();
        return list;
    }

    public void deleteAllCustomer() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_CUSTOMER, null, null);

        db.close();
    }

    ////////////////////////////////////////////////
    public long addLoggedInCustomer(String customer_fname, String customer_lname, String customer_gender, String customer_bday, String customer_email, String customer_contact, String customer_username, String customer_password, String cust_state) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = 0;
        ContentValues cv = new ContentValues();

            cv.put("customer_fname", customer_fname);
            cv.put("customer_lname", customer_lname);
            cv.put("customer_gender", customer_gender);
            cv.put("customer_bday", customer_bday);
            cv.put("customer_email", customer_email);
            cv.put("customer_contact", customer_contact);
            cv.put("customer_username", customer_username);
            cv.put("customer_password", customer_password);
            cv.put("cust_state", cust_state);

        result = db.insert(TBL_LOGGED_IN_CUSTOMER, null, cv);

        db.close();
        return result;
    }

    public ArrayList<Customer> getAllLoggedInCustomer() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Customer> list = new ArrayList<>();
        Cursor c = db.query(TBL_LOGGED_IN_CUSTOMER, null, null, null, null, null, "customer_id");
        list.clear();

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            String customer_id = c.getString(c.getColumnIndex("customer_id"));
            String customer_fname = c.getString(c.getColumnIndex("customer_fname"));
            String customer_lname = c.getString(c.getColumnIndex("customer_lname"));
            String customer_gender = c.getString(c.getColumnIndex("customer_gender"));
            String customer_bday = c.getString(c.getColumnIndex("customer_bday"));
            String customer_email = c.getString(c.getColumnIndex("customer_email"));
            String customer_contact = c.getString(c.getColumnIndex("customer_contact"));
            String customer_username = c.getString(c.getColumnIndex("customer_username"));
            String customer_password = c.getString(c.getColumnIndex("customer_password"));
            String cust_state = c.getString(c.getColumnIndex("cust_state"));

            list.add(new Customer(customer_id, customer_fname, customer_lname, customer_gender, customer_bday, customer_email, customer_contact, customer_username, customer_password, cust_state));
        }

        c.close();
        db.close();
        return list;
    }

    public void deleteAllLoggedInCustomer() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_LOGGED_IN_CUSTOMER, null, null);

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        arg0.execSQL("DROP IF TABLE EXISTS " +TBL_CUSTOMER);
        arg0.execSQL("DROP IF TABLE EXISTS " +TBL_LOGGED_IN_CUSTOMER);
        onCreate(arg0);
    }
}
