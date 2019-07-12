package design_model.color01;


public class DisplayAfricanColor extends DisplayColorByRace{
    @Override
    void displayColorByRace() {
        String displayColor= String.format("我是[%s],我的肤色是[%s]","非洲人","黑色");
        System.out.println(displayColor);
    }
}
