package develop.timurgrdv.ru.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView tvPin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);


        tvPin = (TextView) findViewById(R.id.tvPin);

        Intent intent = getIntent();

        String Pin = intent.getStringExtra("pin");
        tvPin.setText("Your PIN is correct! PIN: " + Pin);


    }
}
