package com.example.dastan.kafedraapp.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;


/**
 * Created by Dastan on 13.05.2016.
 */
public class DataHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "mydatabase.db";
    public static final String TABLE = "NotePad";
    public static final String EDIT_COLUMN = "edit";
    public static final String EDIT_ID_MERO_COLUMN = "edit_id_mero";

    public static final String TABLE_DATE = "date_last";
    public static final String DATE_COLUMN = "date";

    public static final String TABLE_IZBRANNOE = "Izbrannoe";
    public static final String CATEGORY_COLUMN = "category";
    public static final String DESCRIPTION_COLUMN = "description";
    public static final String EMAIL_COLUMN = "email";
    public static final String EXTRA_PHONE_COLUMN = "extra_phone_number";
    public static final String NAME_COLUMN = "name";
    public static final String TITLE_COLUMN = "title";
    public static final String PHONE_NUMBER_COLUMN = "phone_number";
    public static final String PHOTO_URL_COLUMN = "photo_url";
    public static final String PRICE_COLUMN = "price";
    public static final String SURNAME_COLUMN = "surname";
    public static final String REGION_COLUMN = "region";


    public static final String VIDEO_URL_COLUMN = "video_url";
    public static final String ID_JSON_COLUMN = "id_json";

    public static final String IMAGE1_COLUMN = "image1";
    public static final String IMAGE2_COLUMN = "image2";
    public static final String IMAGE3_COLUMN = "image3";
    public static final String IMAGE4_COLUMN = "image4";
    public static final String IMAGE5_COLUMN = "image5";


    public static final String TABLE_MEROPRIYATIE = "Persons";
    public static final String NAME_MEROPRIYATIE = "name";
    public static final String ICON_MEROPRIYATIE = "icon";
    public static final String CALENDAR_MERO = "calendar";
    public static final String ID_COLUMN = "_id";
    public static final String AGE_COLUMN = "age";
    public static final String IMAGE_COLUMN = "image";

    public static final String TABLE_MERO_IZBR = "Mero_Izbr";
    public static final String ID_IZBR_COLUMN = "id_izbr";
    public static final String ID_MERO_COLUMN = "id_mero";
    public static final String STATUS_COLUMN = "status";
    public static final String UCHAST_ID_MERO_COLUMN = "uchast_id_mero";

    public static final String TABLE_UCHAST = "Uchast";
    public static final String UCHAST_NUMBER_COLUMN = "number_uchast";
    public static final String ID_MERO_UCHAST = "id_uchast";
    public static final String ID_MERO_UCHAST_CHOOSE = "id_uchast_choose";
    public static final String UCHAST_NAME_COLUMN = "name_uchast";


    public static final String TABLE_AVTOR = "Avtor";
    public static final String NAME_AVTOR_COLUMN = "name_avtor";
    public static final String PASSWORD_COLUMN = "password";
    public static final String EMAIL_AVTOR_COLUMN = "email_avtor";
    public static final String EXTRA_PHONE_AVTOR_COLUMN = "extra_phone_avtor_number";
    public static final String PHONE_NUMBER_AVTOR_COLUMN = "phone_number_avtor";
    public static final String AVATAR_COLUMN = "avatar";
    public static final String AVATAR_2_COLUMN = "avatar2";
    public static final String SURNAME_AVTOR_COLUMN = "surname_avtor";
    public static final String USERNAME_AVTOR_COLUMN = "username_avtor";
    public static final String RESOURSE_URI = "resource_uri";
    public static final String ID_AVTOR = "id_avtor";


    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE + "(" +
                BaseColumns._ID + " integer primary key autoincrement," +
                EDIT_ID_MERO_COLUMN + " integer," +
                EDIT_COLUMN + " text);");
        db.execSQL("create table " + TABLE_IZBRANNOE + "(" +
                BaseColumns._ID + " integer primary key autoincrement," +
                ID_JSON_COLUMN + " integer," +
                CATEGORY_COLUMN + " text," +
                DESCRIPTION_COLUMN + " text," +
                EMAIL_COLUMN + " text," +
                EXTRA_PHONE_COLUMN + " text," +
                NAME_COLUMN + " text," +
                PHONE_NUMBER_COLUMN + " text," +
                PHOTO_URL_COLUMN + " text," +

                TITLE_COLUMN + " text," +
                REGION_COLUMN + " text," +

                IMAGE1_COLUMN + " text," +
                IMAGE2_COLUMN + " text," +
                IMAGE3_COLUMN + " text," +
                IMAGE4_COLUMN + " text," +
                IMAGE5_COLUMN + " text," +
                AVATAR_COLUMN + " text," +

                PRICE_COLUMN + " text," +
                SURNAME_COLUMN + " text," +
                VIDEO_URL_COLUMN + " text);");

        db.execSQL("create table " + TABLE_MEROPRIYATIE + "(" +
                BaseColumns._ID + " integer primary key autoincrement," +
                NAME_MEROPRIYATIE + " text not null," +
                ICON_MEROPRIYATIE + " text not null," +
                CALENDAR_MERO + " text not null," +
                AGE_COLUMN + " integer);");

        db.execSQL("create table " + TABLE_MERO_IZBR + "(" +
                BaseColumns._ID + " integer primary key autoincrement," +
                ID_MERO_COLUMN + " integer," +
                STATUS_COLUMN + " integer," +
                ID_IZBR_COLUMN + " integer);");

        db.execSQL("create table " + TABLE_UCHAST + "(" +
                BaseColumns._ID + " integer primary key autoincrement," +
                UCHAST_ID_MERO_COLUMN + " integer," +
                ID_MERO_UCHAST + " integer," +
                ID_MERO_UCHAST_CHOOSE + " integer," +
                UCHAST_NAME_COLUMN + " text," +
                UCHAST_NUMBER_COLUMN + " text);");
        db.execSQL("create table " + TABLE_DATE + "(" +
                DATE_COLUMN + " integer);");


        db.execSQL("create table " + TABLE_AVTOR + "(" +
                BaseColumns._ID + " integer primary key autoincrement," +
                ID_AVTOR + " integer," +
                NAME_AVTOR_COLUMN + " text," +
                PASSWORD_COLUMN + " text," +
                EMAIL_AVTOR_COLUMN + " text," +
                PHONE_NUMBER_AVTOR_COLUMN + " text," +
                EXTRA_PHONE_AVTOR_COLUMN + " text," +
                AVATAR_COLUMN + " text," +
                AVATAR_2_COLUMN + " text," +
                SURNAME_AVTOR_COLUMN + " text," +
                USERNAME_AVTOR_COLUMN + " text," +
                REGION_COLUMN + " text," +
                RESOURSE_URI + " text);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getAllData(long id) {
        return getReadableDatabase().query(TABLE, null, " edit_id_mero = ? ", new String[]{String.valueOf(id)}, null, null, null);
    }

    public void editTextToNotePad(String edit, long id) {
        ContentValues values = new ContentValues();

        values.put(EDIT_COLUMN, edit);
        values.put(EDIT_ID_MERO_COLUMN, id);
        getWritableDatabase().insert(TABLE, null, values);

    }

    public Cursor getData() {
        return getReadableDatabase().query(TABLE,
                null, null, null,
                null, null, null);
    }

    public String getDataDate() {
        Cursor cursor = getReadableDatabase().query(TABLE_DATE,
                null, null, null,
                null, null, null);
        if (cursor.getCount() > 0 && cursor != null) {
            cursor.moveToFirst();
            return cursor.getString(cursor.getColumnIndex(DATE_COLUMN));
        } else return "";

    }

    public void addDate(String date) {
        ContentValues values = new ContentValues();

        values.put(DATE_COLUMN, date);

        getWritableDatabase().insert(TABLE_DATE, null, values);

    }


    public void deleteDate() {
        getWritableDatabase().delete(TABLE_DATE, null, null);
    }


    public void deleteAvtor() {
        getWritableDatabase().delete(TABLE_AVTOR, null, null);
    }


    public Cursor getDataUchast() {
        return getReadableDatabase().query(TABLE_UCHAST,
                null, null, null,
                null, null, null);
    }

    public Cursor getDataUchastById(long id) {
        return getReadableDatabase().query(TABLE_UCHAST, null, " id_uchast = ? ", new String[]{String.valueOf(id)}, null, null, null);
    }



    public void addUchast2(String name, String number, long idMero) {
        ContentValues values = new ContentValues();

        values.put(ID_MERO_UCHAST, idMero);
        values.put(UCHAST_NAME_COLUMN, name);
        try {
            values.put(UCHAST_NUMBER_COLUMN, number);
        } catch (Exception e) {

        }
        getWritableDatabase().insert(TABLE_UCHAST, null, values);
    }

    public void readDataUchast() {


        Cursor cursor = getReadableDatabase().query(TABLE_UCHAST,
                null, null, null,
                null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(ID_MERO_UCHAST_CHOOSE));

//
                Log.e("TAG", " name = " + name);

            }
        }
        if (cursor != null) cursor.close();
    }


    public Cursor getDataMeroIzbrById(long id) {
        return getReadableDatabase().query(TABLE_MERO_IZBR,
                null, ID_MERO_COLUMN + " = " + id, null,
                null, null, null);
    }

    public Cursor getDataByIdMeroIzbr(long id) {
        return getReadableDatabase().query(TABLE_MERO_IZBR, null, " _id = ? ", new String[]{String.valueOf(id)}, null, null, null);

    }

    public void deleteMeroIzbr(long id) {
        getWritableDatabase().delete(TABLE_MERO_IZBR, BaseColumns._ID + " = " + id, null);
    }

    public void addMeroIzbr(int mero, int izbr) {
        ContentValues values = new ContentValues();

        values.put(ID_IZBR_COLUMN, izbr);
        values.put(ID_MERO_COLUMN, mero);


        getWritableDatabase().insert(TABLE_MERO_IZBR, null, values);


    }

    public void updateStatus(long id, int status1) {
        ContentValues values = new ContentValues();

        values.put(STATUS_COLUMN, status1);
        getWritableDatabase().update(TABLE_MERO_IZBR, values, BaseColumns._ID + " = " + id, null);

        //


    }


    public Cursor getMeroIzbrByIdMero(long id) {
        return getReadableDatabase().query(TABLE_MERO_IZBR, null, " id_mero = ? ", new String[]{String.valueOf(id)}, null, null, null);

    }


    public Cursor getDataIzbrannoe() {
        return getReadableDatabase().query(DataHelper.TABLE_IZBRANNOE,
                null, null, null,
                null, null, null);
    }


    public Cursor getDataById(long id) {
        return getReadableDatabase().query(TABLE, null, " _id = ? ", new String[]{String.valueOf(id)}, null, null, null);

    }


    public Cursor getDataByIdAvtor() {
        return getReadableDatabase().query(TABLE_AVTOR, null, null, null, null, null, null);

    }


    public Cursor getDataByIdIzbrannoe(long id) {
        return getReadableDatabase().query(TABLE_IZBRANNOE, null, " id_json = ? ", new String[]{String.valueOf(id)}, null, null, null);

    }

    public boolean getStatusIzbrannoe(long id) {
        Cursor cursor = getReadableDatabase().query(TABLE_IZBRANNOE, null, ID_JSON_COLUMN + " = " + id, null, null, null, null);
        Log.e("TAGgetCOUNT", cursor.getCount() + "");

        if (cursor.getCount() < 1) {

            return false;
        } else return true;
    }

    public int getIDIzbrannoe(long id) {
        Cursor cursor = getReadableDatabase().query(TABLE_IZBRANNOE, null, ID_JSON_COLUMN + " = " + id, null, null, null, null);
        Log.e("TAGgetCOUNT", cursor.getCount() + "");

        if (cursor.getCount() < 1) {

            return -1;
        } else {
            cursor.moveToFirst();
            return cursor.getInt(cursor.getColumnIndex(ID_JSON_COLUMN));
        }
    }

    public boolean getStatusUchast(int id, long idMero) {
        String idM;
        Cursor cursor = getReadableDatabase().query(TABLE_UCHAST, null, ID_MERO_UCHAST_CHOOSE + " = " + id, null, null, null, null);

        Log.e("TAGgetCOUNT", cursor.getCount() + "");

        if (cursor.getCount() < 1) {

            return false;
        } else {
            boolean bool = false;
            while (cursor.moveToNext()) {
                idM = cursor.getString(cursor.getColumnIndex(ID_MERO_UCHAST));
                if (idM.equals(String.valueOf(idMero))) bool = true;

            }
            return bool;
        }


    }

    public void readData() {

        Cursor cursor = getReadableDatabase().query(TABLE_UCHAST,
                null, null, null,
                null, null, null);
        Log.e("TAG_READ", " name = ");

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(UCHAST_NAME_COLUMN));
                String number = cursor.getString(cursor.getColumnIndex(UCHAST_NUMBER_COLUMN));
                int id = cursor.getInt(cursor.getColumnIndex(ID_MERO_UCHAST));

//
                Log.e("TAG", " name = " + name + " number" + number + " id" + id);

            }
        }
        if (cursor != null) cursor.close();
    }


    public void delete(long id) {
        getWritableDatabase().delete(TABLE, BaseColumns._ID + " = " + id, null);
    }

    public void deleteMero(long id) {
        getWritableDatabase().delete(TABLE_MEROPRIYATIE, BaseColumns._ID + " = " + id, null);
    }

    public void update(long id, String edit) {
        ContentValues values = new ContentValues();

        values.put(EDIT_COLUMN, edit);
        getWritableDatabase().update(TABLE, values, BaseColumns._ID + " = " + id, null);

        //


    }


    public void updateMero(String name, String calendar, String icon, long id) {
        ContentValues values = new ContentValues();
        values.put(NAME_MEROPRIYATIE, name);
        values.put(CALENDAR_MERO, calendar);
        values.put(ICON_MEROPRIYATIE, icon);
        //  values.put(IMAGE_COLUMN, image);
        getWritableDatabase().update(TABLE_MEROPRIYATIE, values, BaseColumns._ID + " = " + id, null);

    }


    public void deleteUchast(long id) {
        getWritableDatabase().delete(TABLE_UCHAST, BaseColumns._ID + " = " + id, null);
    }

    public void deleteUchastByChooseId(long id, long idMero) {
        Cursor cursor = getDataUchastById(idMero);
        getWritableDatabase().delete(TABLE_UCHAST, ID_MERO_UCHAST + " = " + id, null);
    }

    public void deleteIzbrannoe(long id) {
        getWritableDatabase().delete(TABLE_IZBRANNOE, ID_JSON_COLUMN + " = " + id, null);
    }




    public Cursor getAllDataIzbrannoe() {
        return getReadableDatabase().query(TABLE_IZBRANNOE,
                null, null, null,
                null, null, null);
    }

    public Cursor getAllDataAvtor() {
        return getReadableDatabase().query(TABLE_AVTOR,
                null, null, null,
                null, null, null);
    }

    public void readDataIzbrannoe() {

        Cursor cursor = getReadableDatabase().query(TABLE_IZBRANNOE,
                null, null, null,
                null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(ID_JSON_COLUMN));

                Log.e("TAG", " name = " + name);

            }
        }
        if (cursor != null) cursor.close();
    }

    public void readDataMeroIzbrannoe() {

        Cursor cursor = getReadableDatabase().query(TABLE_MERO_IZBR,
                null, null, null,
                null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(ID_IZBR_COLUMN));

//
                Log.e("TAG", " name = " + name);

            }
        }
        if (cursor != null) cursor.close();
    }


    public Cursor getAllDataMerpriyatie() {
        return getReadableDatabase().query(TABLE_MEROPRIYATIE,
                null, null, null,
                null, null, null);
    }

    public void addPersonMerpriyatie(String name, String calendar, int icon) {
        ContentValues values = new ContentValues();
        values.put(NAME_MEROPRIYATIE, name);
        values.put(CALENDAR_MERO, calendar);
        values.put(ICON_MEROPRIYATIE, icon);
        getWritableDatabase().insert(TABLE_MEROPRIYATIE, null, values);

    }

    public Cursor getDataMerpriyatie() {
        return getReadableDatabase().query(TABLE_MEROPRIYATIE,
                null, null, null,
                null, null, null);
    }

    public Cursor getDataByIdMerpriyatie(String name) {
        return getReadableDatabase().query(DataHelper.TABLE_MEROPRIYATIE, null, " name = ? ", new String[]{String.valueOf(name)}, null, null, null);
    }


    public void readDataMerpriyatie() {
        Cursor cursor = getReadableDatabase().query(TABLE_MEROPRIYATIE,
                null, null, null,
                null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(NAME_MEROPRIYATIE));
                String calendar = cursor.getString(cursor.getColumnIndex(CALENDAR_MERO));
                int icon = cursor.getInt(cursor.getColumnIndex(ICON_MEROPRIYATIE));
                int age = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID));
//
                Log.e("TAG", " name = " + name + " calendar = " + calendar + " age = " + age + " icon" + icon);

            }
        }
        if (cursor != null) cursor.close();
    }


    public void deleteMerpriyatie(long id) {
        getWritableDatabase().delete(TABLE_MEROPRIYATIE, BaseColumns._ID + " = " + id, null);
    }

    public void updateMerpriyatie(String name, String calendar, int age, long id, int icon) {
        ContentValues values = new ContentValues();
        values.put(NAME_MEROPRIYATIE, name);
        values.put(CALENDAR_MERO, name);
        values.put(AGE_COLUMN, age);
        values.put(ICON_MEROPRIYATIE, icon);
        getWritableDatabase().update(TABLE_MEROPRIYATIE, values, BaseColumns._ID + " = " + id, null);

    }

    public Cursor query() {
        String orderBy = "age";
        return getReadableDatabase().query(TABLE_MEROPRIYATIE,
                null, null, null,
                null, null, orderBy);
    }

    public void insertAvtor(int id, String nametext, String passwordtext, String emailtext, String username, String surname, String phone, String extraphone, String resuorse, String avatar, String avatar2, String region) {

        ContentValues values = new ContentValues();

        values.put(ID_AVTOR, id);
        values.put(NAME_AVTOR_COLUMN, nametext);
        values.put(PASSWORD_COLUMN, passwordtext);
        values.put(EMAIL_AVTOR_COLUMN, emailtext);
        values.put(USERNAME_AVTOR_COLUMN, username);
        values.put(SURNAME_AVTOR_COLUMN, surname);
        values.put(PHONE_NUMBER_AVTOR_COLUMN, phone);
        values.put(EXTRA_PHONE_AVTOR_COLUMN, extraphone);
        values.put(RESOURSE_URI, resuorse);
        values.put(AVATAR_COLUMN, avatar);
        values.put(AVATAR_2_COLUMN, avatar2);
        values.put(REGION_COLUMN, region);

        getWritableDatabase().insert(TABLE_AVTOR, null, values);

    }




    public void readDataAvtor() {

    }


}