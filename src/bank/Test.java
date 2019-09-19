package bank;


import bank.common.MessageUtil;
import bank.vo.BalanceRequestVO;
import bank.vo.BalanceResponseVO;

public class Test {

    public static void main(String[] args) {
        //e筑云请求银行报文体
        EZY2Bank();
        //e筑云解析银行返回报文
        Bank2EZY();
    }


    public static void Bank2EZY(){
        String payResultStr = "<?xml version=\"1.0\" encoding=\"GB2312\"?>\n" + "<data>\n"
                + "  <TransCode>ZJW005</TransCode>\n" + "  <fSeqno>0122019061317411610000338</fSeqno>\n"
                + "  <ChnnelPswd>667c0a5azdceb7ef59bc849c5b27157ce3901d638b5fc03284f324fa267f74687</ChnnelPswd>\n"
                + "  <RetCode>00000</RetCode>\n" + "  <RetMsg>success</RetMsg>\n"
                + "  <AcctNo>817777701421000022</AcctNo>\n" + "  <BatNo>Z19061300027</BatNo>\n"
                + "  <StatNo>02</StatNo>\n" + "  <StatMsg>录入待授权</StatMsg>\n" + "  <PayDate/>\n"
                + "  <TotalCnt>1</TotalCnt>\n" + "  <SuccCnt>0</SuccCnt>\n" + "  <SuccAmt>0.00</SuccAmt>\n"
                + "  <TransNum>5</TransNum>\n" + "  <Info/>\n" + "  <NextNo>0</NextNo>\n" + "  <fld1/>\n"
                + "  <fld2/>\n" + "  <fld3/>\n" + "</data>";
        BalanceResponseVO balanceResponseVO = MessageUtil.xmlToBean(payResultStr,BalanceResponseVO.class);
        System.out.println(balanceResponseVO);

    }

    public static void EZY2Bank(){
        BalanceRequestVO balanceRequestVO = new BalanceRequestVO();
        /*请求头*/
        balanceRequestVO.setTransCode("ZJW001");
        balanceRequestVO.setTranDate("2019-04-12");
        balanceRequestVO.setTranTime("12:12:12");
        balanceRequestVO.setfSeqno("20190412000001");
        balanceRequestVO.setChannel("012");
        balanceRequestVO.setChnnelPswd("93023980384");
        /*请求体*/
        balanceRequestVO.setAcctNo("1102110232");
        balanceRequestVO.setPayAcctName("朱晓明");
        balanceRequestVO.setFld1("哈哈哈");
        balanceRequestVO.setFld2("heiheihei");
        balanceRequestVO.setFld3("");
        balanceRequestVO.setFld4("");
        balanceRequestVO.setFld5("");

        String requestData = MessageUtil.build(balanceRequestVO);
        System.out.println(requestData);
    }


}
