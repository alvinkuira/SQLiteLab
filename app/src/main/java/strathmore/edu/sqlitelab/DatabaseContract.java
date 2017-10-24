package strathmore.edu.sqlitelab;

/**
 * Created by alvin on 23-Oct-17.
 */

public class DatabaseContract {
    //Common column(s)
    public static final String KEY_ID = "ID";


    //CONTACTS
    public static String TABLE_CONTACTS = "contacts";
    public static final String KEY_NAME  ="name";
    public static final String KEY_PH_NO = "phone_number";

    public static String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID +
            " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_PH_NO + " TEXT" + ")";

    //PHONE MANUFACTURER
    public static String TABLE_PHONEMANUFACTURER = "phoneManufacturer";
    public static final String KEY_PHONENAME  ="phoneName";
    public static final String KEY_MADEIN = "madeIn";

    public static String CREATE_PHONEMANUFACTURER_TABLE = "CREATE TABLE " + TABLE_PHONEMANUFACTURER + "(" + KEY_ID +
            " INTEGER PRIMARY KEY," + KEY_PHONENAME + " TEXT," + KEY_MADEIN + " TEXT" + ")";

    //CAR MANUFACTURER
    public static String TABLE_CARMANUFACTURER = "carManufacturer";
    public static final String KEY_CARNAME  ="carName";
    public static final String KEY_BASECOUNTRY = "baseCountry";

    public static String CREATE_CARMANUFACTURER_TABLE = "CREATE TABLE " + TABLE_CARMANUFACTURER + "(" + KEY_ID +
            " INTEGER PRIMARY KEY," + KEY_CARNAME + " TEXT," + KEY_BASECOUNTRY + " TEXT" + ")";
}
