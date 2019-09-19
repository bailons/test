package vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 余额查询[ZJW001]请求体
 **/
@XStreamAlias("data")
public class BalanceRequestVO extends RequestVO {

    //账号
    @XStreamAlias("AcctNo")
    private String acctNo;
    //付款人户名
    @XStreamAlias("PayAcctName")
    private String payAcctName;
    //备用字段1
    @XStreamAlias("Fld1")
    private String fld1;
    //备用字段2
    @XStreamAlias("Fld2")
    private String fld2;
    //备用字段3
    @XStreamAlias("Fld3")
    private String fld3;
    //备用字段4
    @XStreamAlias("Fld4")
    private String fld4;
    //备用字段5
    @XStreamAlias("Fld5")
    private String fld5;

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getPayAcctName() {
        return payAcctName;
    }

    public void setPayAcctName(String payAcctName) {
        this.payAcctName = payAcctName;
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
