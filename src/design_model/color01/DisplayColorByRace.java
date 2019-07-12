package design_model.color01;


public abstract class DisplayColorByRace implements DisplayColor {

    public static final boolean IF_DISPLAY = true;

    @Override
    public void displayColor() {
        if (IF_DISPLAY) {
            displayColorByRace();
        }
    }

    abstract void displayColorByRace();
}
