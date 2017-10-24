package strathmore.edu.sqlitelab;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static strathmore.edu.sqlitelab.DatabaseContract.CREATE_CARMANUFACTURER_TABLE;
import static strathmore.edu.sqlitelab.DatabaseContract.CREATE_CONTACTS_TABLE;
import static strathmore.edu.sqlitelab.DatabaseContract.CREATE_PHONEMANUFACTURER_TABLE;
import static strathmore.edu.sqlitelab.DatabaseContract.KEY_BASECOUNTRY;
import static strathmore.edu.sqlitelab.DatabaseContract.KEY_CARNAME;
import static strathmore.edu.sqlitelab.DatabaseContract.KEY_ID;
import static strathmore.edu.sqlitelab.DatabaseContract.KEY_MADEIN;
import static strathmore.edu.sqlitelab.DatabaseContract.KEY_NAME;
import static strathmore.edu.sqlitelab.DatabaseContract.KEY_PHONENAME;
import static strathmore.edu.sqlitelab.DatabaseContract.KEY_PH_NO;
import static strathmore.edu.sqlitelab.DatabaseContract.TABLE_CARMANUFACTURER;
import static strathmore.edu.sqlitelab.DatabaseContract.TABLE_CONTACTS;
import static strathmore.edu.sqlitelab.DatabaseContract.TABLE_PHONEMANUFACTURER;

/**
 * Created by alvin on 19-Oct-17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // Static variables
    // Database version
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACTS_TABLE);
        db.execSQL(CREATE_PHONEMANUFACTURER_TABLE);
        db.execSQL(CREATE_CARMANUFACTURER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PHONEMANUFACTURER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARMANUFACTURER);

        //Create tables again
        onCreate(db);
    }


    // C O N T A C T S
    // Adding new contact
    public void addContact (Contacts contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        //Inserting row
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    // Getting single contact
    public Contacts getContact(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String [] { KEY_ID, KEY_NAME, KEY_PH_NO }, KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Contacts contact = new Contacts(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        // Return contact
        return contact;
    }

    //Getting all contacts
    public List<Contacts> getAllContacts() {
        List<Contacts> contactsList = new ArrayList<Contacts>();

        //Select all query
        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //Looping through all rows and adding to the list
        if (cursor.moveToFirst()) {
            do {
                Contacts contact = new Contacts();
//                Log.e("error", String.valueOf(cursor.getString(0)));
                contact.setID (Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                //Adding contact to list
                contactsList.add(contact);
            } while (cursor.moveToNext());
        }

        return contactsList;
    }

    //Getting contacts count
    public int getContactsCount(){
        String countQuery = "SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    //Updating single contact
    public int updateContact (Contacts contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        //Updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ? ", new String[] {String.valueOf(contact.getID())});
    }

    //Deleting single contact
    public void deleteContact (Contacts contact){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ? ", new String[] { String.valueOf(contact.getID())});
        db.close();
    }




    // P H O N E  M A N U F A C T U R E R
    // Adding new Phone Manufacturer
    public void addPhoneManufacturer (PhoneManufacturer phoneManufacturer){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PHONENAME, phoneManufacturer.getPhoneName());
        values.put(KEY_MADEIN, phoneManufacturer.getMadeIn());

        //Inserting row
        db.insert(TABLE_PHONEMANUFACTURER, null, values);
        db.close();
    }

    // Getting single Phone Manufacturer
    public PhoneManufacturer getPhoneManufacturer(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PHONEMANUFACTURER, new String [] { KEY_ID, KEY_PHONENAME, KEY_MADEIN }, KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        PhoneManufacturer phoneManufacturer = new PhoneManufacturer(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        // Return contact
        return phoneManufacturer;
    }

    //Getting all Phone Manufacturer
    public List<PhoneManufacturer> getAllPhoneManufacturers() {
        List<PhoneManufacturer> phoneManufacturerList = new ArrayList<PhoneManufacturer>();

        //Select all query
        String selectQuery = "SELECT * FROM " + TABLE_PHONEMANUFACTURER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //Looping through all rows and adding to the list
        if (cursor.moveToFirst()) {
            do {
                PhoneManufacturer phoneManufacturer = new PhoneManufacturer();
//                Log.e("error", String.valueOf(cursor.getString(0)));
                phoneManufacturer.setID (Integer.parseInt(cursor.getString(0)));
                phoneManufacturer.setPhoneName(cursor.getString(1));
                phoneManufacturer.setMadeIn(cursor.getString(2));
                //Adding contact to list
                phoneManufacturerList.add(phoneManufacturer);
            } while (cursor.moveToNext());
        }

        return phoneManufacturerList;
    }

    //Getting Phone Manufacturer count
    public int getPhoneManufacturerCount(){
        String countQuery = "SELECT * FROM " + TABLE_PHONEMANUFACTURER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    //Updating single Phone Manufacturer
    public int updatePhoneManufacturer (PhoneManufacturer phoneManufacturer){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PHONENAME, phoneManufacturer.getPhoneName());
        values.put(KEY_MADEIN, phoneManufacturer.getMadeIn());

        //Updating row
        return db.update(TABLE_PHONEMANUFACTURER, values, KEY_ID + " = ? ", new String[] {String.valueOf(phoneManufacturer.getID())});
    }

    //Deleting single Phone Manufacturer
    public void deletePhoneManufacturer (PhoneManufacturer phoneManufacturer){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PHONEMANUFACTURER, KEY_ID + " = ? ", new String[] { String.valueOf(phoneManufacturer.getID())});
        db.close();
    }




    // C A R  M A N U F A C T U R E R
    // Adding new Car Manufacturer
    public void addCarManufacturer (CarManufacturer carManufacturer){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CARNAME, carManufacturer.getCarName());
        values.put(KEY_BASECOUNTRY, carManufacturer.getBaseCountry());

        //Inserting row
        db.insert(TABLE_CARMANUFACTURER, null, values);
        db.close();
    }

    // Getting single Car Manufacturer
    public CarManufacturer getCarManufacturer(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CARMANUFACTURER, new String [] { KEY_ID, KEY_CARNAME, KEY_BASECOUNTRY }, KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        CarManufacturer carManufacturer = new CarManufacturer(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        // Return contact
        return carManufacturer;
    }

    //Getting all Car Manufacturer
    public List<CarManufacturer> getAllCarManufacturers() {
        List<CarManufacturer> carManufacturerList = new ArrayList<CarManufacturer>();

        //Select all query
        String selectQuery = "SELECT * FROM " + TABLE_CARMANUFACTURER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //Looping through all rows and adding to the list
        if (cursor.moveToFirst()) {
            do {
                CarManufacturer carManufacturer = new CarManufacturer();
//                Log.e("error", String.valueOf(cursor.getString(0)));
                carManufacturer.setID (Integer.parseInt(cursor.getString(0)));
                carManufacturer.setCarName(cursor.getString(1));
                carManufacturer.setBaseCountry(cursor.getString(2));
                //Adding contact to list
                carManufacturerList.add(carManufacturer);
            } while (cursor.moveToNext());
        }

        return carManufacturerList;
    }

    //Getting Car Manufacturer count
    public int getCarManufacturerCount(){
        String countQuery = "SELECT * FROM " + TABLE_CARMANUFACTURER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    //Updating single Car Manufacturer
    public int updateCarManufacturer (CarManufacturer carManufacturer){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CARNAME, carManufacturer.getCarName());
        values.put(KEY_BASECOUNTRY, carManufacturer.getBaseCountry());

        //Updating row
        return db.update(TABLE_CARMANUFACTURER, values, KEY_ID + " = ? ", new String[] {String.valueOf(carManufacturer.getID())});
    }

    //Deleting single Car Manufacturer
    public void deleteCarManufacturer (CarManufacturer carManufacturer){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CARMANUFACTURER, KEY_ID + " = ? ", new String[] { String.valueOf(carManufacturer.getID())});
        db.close();
    }

}



