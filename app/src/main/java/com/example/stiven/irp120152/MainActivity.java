package com.example.stiven.irp120152;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MainActivity extends Activity {

    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private SeekBar seekBar3;
    private SeekBar seekBar4;
    private SeekBar seekBar5;
    private ToggleButton toggleButton;
    private EditText editText;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView grados;

    private int vlrSeekBar1 = 0;
    private int vlrSeekBar2 = 0;
    private int vlrSeekBar3 = 0;
    private int vlrSeekBar4 = 0;
    private int vlrSeekBar5 = 0;

    /////Variables para la comunicacion////
    private TCPClient mTcpClient;
    public String SERVERIP;
    private String messaget;
    //////////////////////////////////////

    private int gmu;
    private int gma;
    private int gbr;
    private int gco;
    private int gho;


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
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        grados = (TextView) findViewById(R.id.textView6);


        seekBar1.setMax(100);
        seekBar2.setMax(100);
        seekBar3.setMax(100);
        seekBar4.setMax(100);
        seekBar5.setMax(100);


        toggleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    Editable s = editText.getText();
                    if (s.equals("")) {
                        textView.setText("No hay nada en la barra de dirección");
                    } else {
                        textView.setText("Conectado a: \n" + s);
                        new connectTask().execute("");
                        SERVERIP = s.toString();
                    }
                } else {
                    textView.setText("En espera");
                    try {
                        textView.setText(mTcpClient.stopClient());
                    } catch (Throwable e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    toggleButton.setBackgroundColor(Color.GREEN);
                    toggleButton.setText("desconectar");
                } else {
                    // The toggle is disabled
                    toggleButton.setBackgroundColor(Color.RED);
                    toggleButton.setText("conectar");
                }
            }
        });

        //Listener SeekBar 1
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                gco=progress;
                textView4.setText(String.valueOf(progress));
                mensaje();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        //Listener SeekBar 2
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                gbr=progress;
                textView2.setText(String.valueOf(progress));
                mensaje();
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
                gma=progress;
                textView3.setText(String.valueOf(progress));
                mensaje();
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
                gho=progress;
                textView5.setText(String.valueOf(progress));
                mensaje();
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
                gmu=progress;
                textView6.setText(String.valueOf(progress));
                mensaje();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void mensaje() {
        grados.setText(gmu+"°"+""+gma+"°"+""+gbr+"°"+gco+"°"+gho+"°");

        byte[] b = {(byte) 126,(byte) gmu, (byte) gma, (byte) gbr, (byte) gco, (byte) gho};
        String s=""; //s = new String(b);
        try {
            s = new String(b, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(s);
        try {
            System.out.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (mTcpClient != null) {
            mTcpClient.sendMessage(s);
            textView.setText(mTcpClient.conection());
        }
    }



    ///////////// Tarea en segundo plano////////////

    public class connectTask extends AsyncTask<String,String,TCPClient> {

        @Override
        protected TCPClient doInBackground(String... message) {

            //we create a TCPClient object and
            mTcpClient = new TCPClient(new TCPClient.OnMessageReceived() {
                @Override
                //here the messageReceived method is implemented
                public void messageReceived(String message) {
                    //this method calls the onProgressUpdate
                    publishProgress(message);
                }
            });
            mTcpClient.IP(SERVERIP);
            mTcpClient.run();
            return null;
        }
    }
    //////////////////////////////////////////////////////


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



    }
}
