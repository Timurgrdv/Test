package develop.timurgrdv.ru.test;


import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MyApp";

    TextView etPin, tvEnter, tvDelete;

    // задаем привильный PIN
    private static String Pin = "4321";

    public static void setInputPin(String inputPin, boolean isDelete) {
        if (isDelete == true) {
            InputPin = inputPin;
        } else if (InputPin.length() < 4) {
            InputPin += inputPin;
        }
    }


    public static String getInputPin() {
        return InputPin;
    }

    private static String InputPin = "";

    // метод получает правильный пин(который мы задали)
    public String getPin() {
        String Pin = Main.Pin;
        return Pin;
    }


    // метод удаляет последний символ в строке и возвращает строку
    private String removeLastChar(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0, s.length() - 1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // создаем массив кнопок
        TextView[] buttonArr = {
                (TextView) findViewById(R.id.btn0),
                (TextView) findViewById(R.id.btn1),
                (TextView) findViewById(R.id.btn2),
                (TextView) findViewById(R.id.btn3),
                (TextView) findViewById(R.id.btn4),
                (TextView) findViewById(R.id.btn5),
                (TextView) findViewById(R.id.btn6),
                (TextView) findViewById(R.id.btn7),
                (TextView) findViewById(R.id.btn8),
                (TextView) findViewById(R.id.btn9)};

        // назначаем каждой кнопке(цифре) слушатель
        for (TextView button : buttonArr) {
            button.setOnClickListener(this);
        }

        tvDelete = (TextView) findViewById(R.id.tvDelete);
        tvEnter = (TextView) findViewById(R.id.tvEnter);
        etPin = (TextView) findViewById(R.id.etPin);

        View.OnTouchListener OnTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (v.getId()) {
                    case R.id.tvEnter:
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            tvEnter.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_Cl_Btn));
                            return true;
                        } else if (event.getAction() == MotionEvent.ACTION_UP) {
                            tvEnter.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_textBtn));
                            if (getInputPin().equals(getPin())) {
                                Intent intent = new Intent(getApplicationContext(), Welcome.class);
                                intent.putExtra("pin", getInputPin());
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Incorrect Pin! Try again!", Toast.LENGTH_SHORT).show();
                            }
                            return true;
                        }
                        break;
                    case R.id.tvDelete:
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            // меняем цвет кнопки DELETE при нажатии
                            tvDelete.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_Cl_Btn));
                            return true;
                        } else if (event.getAction() == MotionEvent.ACTION_UP) {
                            tvDelete.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_textBtn));
                            // удаляем из введенного PIN'a последний символ
                            setInputPin(removeLastChar(getInputPin()), true);
                            // удаляем последнюю "*" в поле TextView
                            etPin.setText(removeLastChar(etPin.getText().toString()));
                            return true;
                        }
                        break;
                }
                return false;
            }

        };

        tvDelete.setOnTouchListener(OnTouchListener);
        tvEnter.setOnTouchListener(OnTouchListener);
    }


    @Override
    public void onClick(View v) {
        if (etPin.length() <= 4) {
            switch (v.getId()) {
                case R.id.btn0:
                    setInputPin("0", false);
                    Log.d(TAG, getInputPin());
                    etPin.setText(etPin.getText() + "*");
                    break;
                case R.id.btn1:
                    setInputPin("1", false);
                    Log.d(TAG, getInputPin());
                    etPin.setText(etPin.getText() + "*");
                    break;
                case R.id.btn2:
                    setInputPin("2", false);
                    etPin.setText(etPin.getText() + "*");
                    break;
                case R.id.btn3:
                    setInputPin("3", false);
                    etPin.setText(etPin.getText() + "*");
                    break;
                case R.id.btn4:
                    setInputPin("4", false);
                    etPin.setText(etPin.getText() + "*");
                    break;
                case R.id.btn5:
                    setInputPin("5", false);
                    etPin.setText(etPin.getText() + "*");
                    break;
                case R.id.btn6:
                    setInputPin("6", false);
                    etPin.setText(etPin.getText() + "*");
                    break;
                case R.id.btn7:
                    setInputPin("7", false);
                    etPin.setText(etPin.getText() + "*");
                    break;
                case R.id.btn8:
                    setInputPin("8", false);
                    etPin.setText(etPin.getText() + "*");
                    break;
                case R.id.btn9:
                    setInputPin("9", false);
                    etPin.setText(etPin.getText() + "*");
                    break;

            }


            Log.d(TAG, getInputPin());


        }
    }
}