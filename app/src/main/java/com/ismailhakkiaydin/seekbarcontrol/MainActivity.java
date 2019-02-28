package com.ismailhakkiaydin.seekbarcontrol;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private SharedPreferences.Editor edt;
    private LinearLayout pnlTest;
    private SeekBar sbRed, sbGreen, sbBlue;
    private TextView txtRGB, txtHEX;
    private MenuHelper menuHelper;
    private int k,m,y;

    private void init(){
        sp = this.getSharedPreferences("Renk Ayarları", Context.MODE_PRIVATE);
        pnlTest = findViewById(R.id.pnlTest);

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);

        txtRGB = findViewById(R.id.txtRGB);
        txtHEX = findViewById(R.id.txtHEX);

        menuHelper = new MenuHelper(this, sp);

    }

    private void sbRed_Changed(){
        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                k = seekBar.getProgress();
                Paint();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void sbGreen_Changed(){
        sbGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                y = seekBar.getProgress();
                Paint();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    private void sbBlue_Changed(){
        sbBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                m = seekBar.getProgress();
                Paint();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void registerHandlers(){
        sbRed_Changed();
        sbGreen_Changed();
        sbBlue_Changed();
    }

    public void Paint(){
        pnlTest.setBackgroundColor(Color.rgb(k,y,m));

        txtRGB.setText(String.format("R: %d G: %d B: %d ",k,y,m));
        txtHEX.setText(String.format("#%X%X%X",k,y,m));

        sbRed.setProgress(k);
        sbGreen.setProgress(y);
        sbBlue.setProgress(m);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);
        return menuHelper.ItemSelect(item.getItemId(),k,y,m);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return menuHelper.Build(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        registerHandlers();
        Reload();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppSettings as = new AppSettings(this, sp);
        as.Serialize(k,y,m);
    }

    private void Reload(){
        AppSettings as = new AppSettings(this,sp);
        as.Deserialize();
    }

    public void Paint(int r, int g, int b) {
        pnlTest.setBackgroundColor(Color.rgb(k,y,m));

        txtRGB.setText(String.format("R: %d G: %d B: %d ",k,y,m));
        txtHEX.setText(String.format("#%X%X%X",k,y,m));

        sbRed.setProgress(k);
        sbGreen.setProgress(y);
        sbBlue.setProgress(m);
    }
}
