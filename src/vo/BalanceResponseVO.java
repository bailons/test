package vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.math.BigDecimal;

/**
 * 余额查询[ZJW001]响应体
 **/
@XStreamAlias("data")
public class BalanceResponseVO extends ResponseVO {
    //账号
    @XStreamAlias("AcctNo")
    private String acctNo;
    //付款人户名
    @XStreamAlias("AcctName")
    private String acctName;
    //账户状态0-正常及部分冻结,2-全部冻结,3-结清,7-单向冻结
    @XStreamAlias("AccStat")
    private String accStat;
    //账户余额 以分为单位
    @XStreamAlias("Balance")
    private BigDecimal balance;
    //账户可用余额
    @XStreamAlias("UseBalance")
    private BigDecimal useBalance;
    //账号种类
    @XStreamAlias("AccType")
    private String accType;
    //响应备用字段1
    @XStreamAlias("Fld1")
    private String fld1;
    //响应备用字段2
    @XStreamAlias("Fld2")
    private String fld2;
    //响应备用字段3
    @XStreamAlias("Fld3")
    private String fld3;
    //响应备用字段4
    @XStreamAlias("Fld4")
    private String fld4;
    //响应备用字段5
    @XStreamAlias("Fld5")
    private String fld5;

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getAccStat() {
        return accStat;
    }

    public void setAccStat(String accStat) {
        this.accStat = accStat;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getUseBalance() {
        return useBalance;
    }

    public void setUseBalance(BigDecimal useBalance) {
        this.useBalance = useBalance;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getFld1() {
        return fld1;
    }

    public void setFld1(String fld1) {
        this.fld1 = fld1;
    }

    public String getFld2() {
        return fld2;
    }

    public void setFld2(String fld2) {
        this.fld2 = fld2;
    }

    public String getFld3() {
        return fld3;
    }

    public void setFld3(String fld3) {
        this.fld3 = fld3;
    }

    public String getFld4() {
        return fld4;
    }

    public void setFld4(String fld4) {
        this.fld4 = fld4;
    }

    public String getFld5() {
        return fld5;
    }

    public void setFld5(String fld5) {
        this.fld5 = fld5;
    }
}
