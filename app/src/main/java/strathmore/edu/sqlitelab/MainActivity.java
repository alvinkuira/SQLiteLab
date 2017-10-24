package strathmore.edu.sqlitelab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);


        // CONTACTS
        Log.d("Insert: ", "Inserting ...");
        db.addContact(new Contacts("Ravi", "9100000000"));
        db.addContact(new Contacts("Srinivas", "9199999999"));
        db.addContact(new Contacts("Tommy", "9522222222"));
        db.addContact(new Contacts("Karthik", "9533333333"));

        //Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contacts> contact = db.getAllContacts();

        for (Contacts cn : contact) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();

            //Writing contacts to log
            Log.d("Name: ", log);
        }


        // PHONE MANUFACTURER
        Log.d("Insert: ", "Inserting ...");
        db.addPhoneManufacturer(new PhoneManufacturer("Samsung", "South Korea"));
        db.addPhoneManufacturer(new PhoneManufacturer("Apple", "USA"));
        db.addPhoneManufacturer(new PhoneManufacturer("OnePlus ", "China"));
        db.addPhoneManufacturer(new PhoneManufacturer("HTC", "Taiwan"));

        //Reading all Phone Manufacturers
        Log.d("Reading: ", "Reading all phone manufacturers..");
        List<PhoneManufacturer> phoneManufacturers = db.getAllPhoneManufacturers();

        for (PhoneManufacturer cn : phoneManufacturers) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getPhoneName() + " ,Headquarters: " + cn.getMadeIn();

            //Writing phone manufacturers to log
            Log.d("Name: ", log);
        }


        // CAR MANUFACTURER
        Log.d("Insert: ", "Inserting ...");
        db.addCarManufacturer(new CarManufacturer("Porsche", "Germany"));
        db.addCarManufacturer(new CarManufacturer("Chevrolet", "USA"));
        db.addCarManufacturer(new CarManufacturer("Toyota", "Japan"));
        db.addCarManufacturer(new CarManufacturer("Renault", "France"));

        //Reading all Car Manufacturers
        Log.d("Reading: ", "Reading all car manufacturers..");
        List<CarManufacturer> carManufacturers = db.getAllCarManufacturers();

        for (CarManufacturer cn : carManufacturers) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getCarName() + " ,Base Country: " + cn.getBaseCountry();

            //Writing car manufacturers to log
            Log.d("Name: ", log);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
