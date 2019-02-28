package com.ismailhakkiaydin.seekbarcontrol;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuInflater;

public class MenuHelper {

    private Context context;
    private MenuInvoker mi;


    public MenuHelper(Context context, SharedPreferences sp) {
        this.context = context;
        mi = new MenuInvoker(new MenuReceiver(context, sp));

    }

    public boolean Build(Menu menu){
        MenuInflater mi = ((Activity) context).getMenuInflater();
        mi.inflate(R.menu.menu_main, menu);

        return true;
    }

    public boolean ItemSelect(int id, Object... args){
        mi.Invoke(id,args);

        return true;
    }

}
