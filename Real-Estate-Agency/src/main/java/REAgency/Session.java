package REAgency;

import REAgency.Entity.Manager;

public class Session {
    public static final Session INSTANCE = new Session();
    private Manager manager;

    public void start(Manager manager){
        this.manager = manager;
    }

    public Manager getManager(){
        return this.manager;
    }

    public void finish(){
        this.manager = null;
    }
}