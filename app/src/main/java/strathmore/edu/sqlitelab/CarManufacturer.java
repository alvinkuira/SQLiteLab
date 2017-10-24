package strathmore.edu.sqlitelab;

/**
 * Created by alvin on 23-Oct-17.
 */

public class CarManufacturer {
    int ID;
    String _carName;
    String _baseCountry;

    public CarManufacturer(){}

    public CarManufacturer(int id, String carName, String baseCountry){
        this.ID = id;
        this._carName = carName;
        this._baseCountry = baseCountry;
    }

    public CarManufacturer(String carName, String baseCountry){
        this._carName = carName;
        this._baseCountry = baseCountry;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCarName() {
        return this._carName;
    }

    public void setCarName(String carName) {
        this._carName = carName;
    }

    public String getBaseCountry() {
        return this._baseCountry;
    }

    public void setBaseCountry(String baseCountry) {
        this._baseCountry = baseCountry;
    }
}
