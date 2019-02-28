package com.ismailhakkiaydin.seekbarcontrol;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSettings {

    private Context context;
    private SharedPreferences sp;

    public AppSettings(Context context, SharedPreferences sp) {
        this.context = context;
        this.sp = sp;
    }

    public void Serialize(int r, int g, int b){
        SharedPreferences.Editor edt = sp.edit();

        edt.putInt("R",r);
        edt.putInt("G",g);
        edt.putInt("B",b);

        edt.commit();

    }

    public void Deserialize(){
        ((MainActivity)context).Paint(sp.getInt("R",0), sp.getInt("G",0), sp.getInt("B",0));
    }

}
