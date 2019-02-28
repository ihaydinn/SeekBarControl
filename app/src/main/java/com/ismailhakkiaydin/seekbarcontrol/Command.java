package com.ismailhakkiaydin.seekbarcontrol;

public abstract class Command {

    protected MenuReceiver receiver;

    protected Command(MenuReceiver receiver){
        this.receiver = receiver;
    }

    public abstract void Run(Object... args);

}
