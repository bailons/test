package bank;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 查询/下载工资单响应体
 */
@XStreamAlias("data")
public class QueryPayRollResponseModel extends BankResponseCommonModel {
    //账号
    @XStreamAlias("AcctNo")
    private String acctNo;
    //批次号
    @XStreamAlias("BatNo")
    private String batNo;
    //项目名称
    @XStreamAlias("ProName")
    private String proName;
    //班组名称
    @XStreamAlias("GrpName")
    private String grpName;
    //总笔数
    @XStreamAlias("TotalCnt")
    private String totalCnt;
    //总金额
    @XStreamAlias("TotalAmt")
    private String totalAmt;
    //文件路径
    @XStreamAlias("FilePath")
    private String filePath;
    //文件名称
    @XStreamAlias("FileName")
    private String fileName;

    //备用字段
    @XStreamAlias("Fld1")
    private String fld1;
    //备用字段
    @XStreamAlias("Fld2")
    private String fld2;
    //备用字段
    @XStreamAlias("Fld3")
    private String fld3;
    //备用字段4
    @XStreamAlias("Fld4")
    private String fld4;
    //备用字段5
    @XStreamAlias("Fld5")
    private String fld5;

    public QueryPayRollResponseModel() {
        super.transCode = BankInterfaceEnums.PAYROLL_QUERY.getCode();
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getBatNo() {
        return batNo;
    }

    public void setBatNo(String batNo) {
        this.batNo = batNo;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }

    public String getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(String totalCnt) {
        this.totalCnt = totalCnt;
    }

    public String getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    @Override
    public String toString() {
        return "QueryPayRollResponseModel{" +
                "acctNo='" + acctNo + '\'' +
                ", batNo='" + batNo + '\'' +
                ", proName='" + proName + '\'' +
                ", grpName='" + grpName + '\'' +
                ", totalCnt='" + totalCnt + '\'' +
                ", totalAmt='" + totalAmt + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fld1='" + fld1 + '\'' +
                ", fld2='" + fld2 + '\'' +
                ", fld3='" + fld3 + '\'' +
                ", fld4='" + fld4 + '\'' +
                ", fld5='" + fld5 + '\'' +
                '}';
    }
}
