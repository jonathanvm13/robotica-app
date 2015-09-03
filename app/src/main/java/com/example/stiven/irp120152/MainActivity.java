package com.example.stiven.irp120152;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private SeekBar seekBar3;
    private SeekBar seekBar4;
    private SeekBar seekBar5;
    private ToggleButton toggleButton;
    private EditText editText;
    private TextView textView;
    private int vlrSeekBar1 = 0;
    private int vlrSeekBar2 = 0;
    private int vlrSeekBar3 = 0;
    private int vlrSeekBar4 = 0;
    private int vlrSeekBar5 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar1 = (SeekBar) findViewById(R.id.seekBar);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
        seekBar5 = (SeekBar) findViewById(R.id.seekBar5);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);

        seekBar1.setMax(180);
        seekBar2.setMax(180);
        seekBar3.setMax(180);
        seekBar4.setMax(180);
        seekBar5.setMax(180);


        toggleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    String s = editText.getText();
                    if (s.equals("")) {
                        textView.setText("No hay nada en la barra de dirección");
                    } else {
                        textView.setText("Conectado a " + s);
                    }
                } else {
                    textView.setText("En espera");
                }
            }
        });

        //Listener SeekBar 1
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vlrSeekBar1 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                vlrSeekBar1 = progress;
            }
        });


        //Listener SeekBar 2
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vlrSeekBar2 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //Listener SeekBar 3
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vlrSeekBar3 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //Listener SeekBar 4
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vlrSeekBar4 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //Listener SeekBar 5
        seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vlrSeekBar5 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

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

    public void actualizarMensaje(){
        String mensaje = "SeekBar1 esta en " + vlrSeekBar1 + "\n" +
                "SeekBar2 esta en " + vlrSeekBar2 + "\n"
                "SeekBar3 esta en " + vlrSeekBar3 + "\n"
                "SeekBar4 esta en " + vlrSeekBar4 + "\n"
                "SeekBar5 esta en " + vlrSeekBar5 + "\n";


    }
}
