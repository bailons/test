package exception;

/***
 * 设备类型
 **/
public enum EqpDeviceTypeEnum {
    //尾箱柜
    TAILBOX("0"),
    //硬盘录像机
    DVR("1"),
    //摄像头
    CAMERA("2"),
    //报警主机
    ALARMHOST("3"),
    //报警探测器
    ALARMDETECTOR("4");

    private String code;
    EqpDeviceTypeEnum(String code){
        this.code=code;
    }
    public String getCode() {
        return code;
    }
}
