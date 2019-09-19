package bank.vo;

import java.math.BigDecimal;

/**
 * 工资单明细VO
 **/
public class PayRollDetailVO {
    //序号
    private int seq;
    //卡号
    private String cardNumber;
    //户名
    private String cardName;
    //身份证号
    private String idCardNumber;
    //应发工资
    private BigDecimal salaryAmt;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public BigDecimal getSalaryAmt() {
        return salaryAmt;
    }

    public void setSalaryAmt(BigDecimal salaryAmt) {
        this.salaryAmt = salaryAmt;
    }

    @Override
    public String toString() {
        return "PayRollDetailVO{" +
                "seq=" + seq +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardName='" + cardName + '\'' +
                ", idCardNumber='" + idCardNumber + '\'' +
                ", salaryAmt=" + salaryAmt +
                '}';
    }
}
