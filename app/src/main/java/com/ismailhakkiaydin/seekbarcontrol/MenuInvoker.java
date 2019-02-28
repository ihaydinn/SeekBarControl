package com.ismailhakkiaydin.seekbarcontrol;

import java.util.HashMap;

public class MenuInvoker {

    private HashMap<Integer, Command> commands;
    private MenuReceiver mr;

    public MenuInvoker(MenuReceiver mr) {
        this.mr = mr;
        commands = new HashMap<Integer, Command>();
        commands.put(R.id.mnuSave, new SaveCommand(mr));
        commands.put(R.id.mnuLoad, new LoadCommand(mr));
        //commands.put(R.id.mnuHelp, new AboutCommand(mr));
    }

    public void Invoke(int id, Object... args){
        commands.get(id).Run(args);
    }

}
