package sg.edu.rp.c346.myprofileapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.editTextName);
        etGPA = (EditText) findViewById(R.id.editTextGPA);

    }

    @Override
    protected void onPause() {
        super.onPause();

        //step 1a: Retrieve data input of the user
        String strName= etName.getText().toString();

        //step 1b: obtain an instance of the shared preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //step 1c: Obtain an instance of the shared preference editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Step 1d; Add the key vaulue pair
        prefEdit.putString("name",strName);

        //step ie: call commit() method to save the changes into the shared preference
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Step 2a: obtain an instance of the shared preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //step 2b: Retrieve the saved data with the key, greeting from the sharedPreferences object.
        String strName = prefs.getString("name","John");

        //step 2c
        etName.setText(strName);
    }
}
