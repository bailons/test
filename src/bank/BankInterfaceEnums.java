package bank;

/**
 * 银行接口枚举类
 */
public enum BankInterfaceEnums {

    BALANCE_QUERY("ZJW001", "余额查询"),
    DEPOSIT_QUERY("ZJW003", "保证金查询"),
    PAYROLL_QUERY("ZJW004", "查询工资单"),
    RESULT_NOTICE("ZJW005", "处理结果通知");

    private String code;
    private String value;

    BankInterfaceEnums(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

}
