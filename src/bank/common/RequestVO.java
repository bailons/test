package bank.common;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 银行报文体请求VO
 **/
public class RequestVO {

    //交易代码
    @XStreamAlias("TransCode")
    private String transCode;
    //交易日期
    @XStreamAlias("TranDate")
    private String tranDate;
    //交易时间
    @XStreamAlias("TranTime")
    private String tranTime;
    //请求流水号
    @XStreamAlias("fSeqno")
    private String fSeqno;
    //渠道号
    @XStreamAlias("Channel")
    private String channel;
    //渠道MAC
    @XStreamAlias("ChnnelPswd")
    private String chnnelPswd;

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranTime() {
        return tranTime;
    }

    public void setTranTime(String tranTime) {
        this.tranTime = tranTime;
    }

    public String getfSeqno() {
        return fSeqno;
    }

    public void setfSeqno(String fSeqno) {
        this.fSeqno = fSeqno;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChnnelPswd() {
        return chnnelPswd;
    }

    public void setChnnelPswd(String chnnelPswd) {
        this.chnnelPswd = chnnelPswd;
    }
}
