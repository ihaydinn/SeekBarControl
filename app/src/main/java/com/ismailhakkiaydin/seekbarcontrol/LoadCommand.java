package com.ismailhakkiaydin.seekbarcontrol;

public class LoadCommand extends Command {

    public LoadCommand(MenuReceiver mr){

        super(mr);

    }

    @Override
    public void Run(Object... args) {
        super.receiver.LoadAction();
    }
}
