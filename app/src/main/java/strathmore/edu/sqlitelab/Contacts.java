package strathmore.edu.sqlitelab;

/**
 * Created by alvin on 19-Oct-17.
 */

public class Contacts {

    // Private variables
    int _id;
    String _name;
    String _phone_number;

    // Empty constructor
    public Contacts(){

    }

    // Constructor
    public Contacts (int id, String name, String _phone_number){
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
    }

    // Constructor
    public Contacts (String name, String _phone_number){
        this._name = name;
        this._phone_number = _phone_number;
    }

    public int getID() {
        return this._id;
    }

    public void setID( int _id)
    {
        this._id = _id;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getPhoneNumber() {
        return this._phone_number;
    }

    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }
}
