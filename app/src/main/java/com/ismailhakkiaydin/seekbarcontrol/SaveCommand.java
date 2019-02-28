package com.ismailhakkiaydin.seekbarcontrol;

public class SaveCommand extends Command {

    public SaveCommand(MenuReceiver mr){
        super(mr);
    }

    @Override
    public void Run(Object... args) {
        super.receiver.SaveAction(Integer.parseInt(args[0].toString()),
                Integer.parseInt(args[1].toString()),
                Integer.parseInt(args[2].toString()));
    }
}
