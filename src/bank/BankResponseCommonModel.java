package bank;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 响应通用头
 */
public class BankResponseCommonModel {

    //交易代码
    @XStreamAlias("TransCode")
    protected String transCode;
    //请求交易流水号
    @XStreamAlias("fSeqno")
    private String fSeqno;
    //渠道MAC
    @XStreamAlias("ChnnelPswd")
    private String chnnelPswd;
    //成功标志
    @XStreamAlias("RetCode")
    private String retCode;
    //返回信息
    @XStreamAlias("RetMsg")
    private String retMsg;

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public String getfSeqno() {
        return fSeqno;
    }

    public void setfSeqno(String fSeqno) {
        this.fSeqno = fSeqno;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getChnnelPswd() {
        return chnnelPswd;
    }

    public void setChnnelPswd(String chnnelPswd) {
        this.chnnelPswd = chnnelPswd;
    }

    @Override
    public String toString() {
        return "BankResponseCommonModel{" +
                "transCode='" + transCode + '\'' +
                ", fSeqno='" + fSeqno + '\'' +
                ", chnnelPswd='" + chnnelPswd + '\'' +
                ", retCode='" + retCode + '\'' +
                ", retMsg='" + retMsg + '\'' +
                '}';
    }

}
