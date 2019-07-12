package design_model.color02;


public class DisplayOccidentColor extends DisplayColorByRace {
    @Override
    void displayColorByRace() {
        String displayColor= String.format("我是[%s],我的肤色是[%s]","欧美人","白色");
        System.out.println(displayColor);
    }
}
