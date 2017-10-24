package strathmore.edu.sqlitelab;

/**
 * Created by alvin on 23-Oct-17.
 */

public class PhoneManufacturer {
    int ID;
    String _phoneName;
    String _madeIn;

    public PhoneManufacturer(){}

    public PhoneManufacturer(int id, String phoneName, String madeIn){
        this.ID = id;
        this._phoneName = phoneName;
        this._madeIn = madeIn;
    }

    public PhoneManufacturer(String phoneName, String madeIn){
        this._phoneName = phoneName;
        this._madeIn = madeIn;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPhoneName() {
        return this._phoneName;
    }

    public void setPhoneName(String phoneName) {
        this._phoneName = phoneName;
    }

    public String getMadeIn() {
        return this._madeIn;
    }

    public void setMadeIn(String madeIn) {
        this._madeIn = madeIn;
    }
}
