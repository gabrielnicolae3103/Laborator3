package lab03.eim.systems.cs.pub.phonedialer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PhoneActivity extends AppCompatActivity {

    String phoneNumber = "";
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editTextPhone);
    }

    public void onClick(View v) {
        Button button = (Button)v;
        switch (button.getText().toString()) {
            case "1":   {
                phoneNumber += '1';
                text.setText(phoneNumber);
                break;
            }
            case "2":   {
                phoneNumber += '2';
                text.setText(phoneNumber);
                break;
            }
            case "3":   {
                phoneNumber += '3';
                text.setText(phoneNumber);
                break;
            }
            case "4":   {
                phoneNumber += '4';
                text.setText(phoneNumber);
                break;
            }
            case "5":   {
                phoneNumber += '5';
                text.setText(phoneNumber);
                break;
            }
            case "6":   {
                phoneNumber += '6';
                text.setText(phoneNumber);
                break;
            }
            case "7":   {
                phoneNumber += '7';
                text.setText(phoneNumber);
                break;
            }
            case "8":   {
                phoneNumber += '8';
                text.setText(phoneNumber);
                break;
            }
            case "9":   {
                phoneNumber += '9';
                text.setText(phoneNumber);
                break;
            }
            case "0":   {
                phoneNumber += '0';
                text.setText(phoneNumber);
                break;
            }
            case "*":   {
                phoneNumber += '*';
                text.setText(phoneNumber);
                break;
            }
            case "#":   {
                phoneNumber += '#';
                text.setText(phoneNumber);
                break;
            }
            default:
        }
    }

    public void backspace(View v) {
        phoneNumber = phoneNumber.substring(0, phoneNumber.length() - 1);
        text.setText(phoneNumber);
    }

    public void call(View v) {
        if (ContextCompat.checkSelfPermission(PhoneActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    PhoneActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1);
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + text.getText().toString()));
            startActivity(intent);
        }
    }

    public void contact(View V) {
        if (phoneNumber.length() > 0) {
            Intent intent = new Intent("ro.pub.cs.systems.eim.lab04.contactsmanager.intent.action.MainActivity");
            intent.putExtra("ro.pub.cs.systems.eim.lab04.contactsmanager.PHONE_NUMBER_KEY", phoneNumber);
            startActivityForResult(intent, Constants.CONTACTS_MANAGER_REQUEST_CODE);
        } else {
            Toast.makeText(getApplication(), getResources().getString(R.string.phone_error), Toast.LENGTH_LONG).show();
        }
    }

    public class Input implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Button button = (Button)v;
            switch (button.getText().toString()) {
                case "1":   phoneNumber += '1';
                default:
            }
        }
    }

    public class Constants {
        public static final int CONTACTS_MANAGER_REQUEST_CODE = 0;
    }
}