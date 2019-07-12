package design_model.color01;


public class DisplayAsianColor extends DisplayColorByRace{
    @Override
    void displayColorByRace() {
        String displayColor= String.format("我是[%s],我的肤色是[%s]","亚洲人","小麦色");
        System.out.println(displayColor);
    }
}
