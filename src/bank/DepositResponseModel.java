package bank;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.math.BigDecimal;

/**
 * 保证金查询响应体
 */
@XStreamAlias("data")
public class DepositResponseModel extends BankResponseCommonModel {

    //账号
    @XStreamAlias("AcctNo")
    private String acctNo;
    //圈存金额以分为单位
    @XStreamAlias("CtrlBalance")
    private BigDecimal ctrlBalance;
    //圈存状态
    @XStreamAlias("Status")
    private String status;
    //响应备用字段1
    @XStreamAlias("Fld1")
    private String fld1;
    ////响应备用字段2
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

    public BigDecimal getCtrlBalance() {
        return ctrlBalance;
    }

    public void setCtrlBalance(BigDecimal ctrlBalance) {
        this.ctrlBalance = ctrlBalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
