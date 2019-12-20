package enums;

/**
 * 授权下发状态
 */
public enum AuthStatusEnum {

    INITIAL(0, "初始"),
    ISSUED(1, "已下发"),
    REMOVED(2,"已移除"),;
    private int code;
    private String name;

    AuthStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 通过编号获取名称
     */
    public static String getNameByCode(int code) {
        for (AuthStatusEnum iCardTypeEnum : AuthStatusEnum.values()) {
            if (iCardTypeEnum.getCode() == code) {
                return iCardTypeEnum.getName();
            }
        }
        return null;
    }

    /**
     * 通过名称获取编号
     */
    public static int getCodeByName(String name) {
        for (AuthStatusEnum iCardTypeEnum : AuthStatusEnum.values()) {
            if (iCardTypeEnum.getName().equals(name)) {
                return iCardTypeEnum.getCode();
            }
        }
        return 0;
    }
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


}
