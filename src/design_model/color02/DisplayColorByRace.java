package design_model.color02;


public abstract class DisplayColorByRace implements DisplayColor {

    @Override
    public void display() {
       if(ifDisplay()) {
           displayColorByRace();
       }
    }

    abstract void displayColorByRace();

    public boolean ifDisplay(){
        return true;
    }

}
