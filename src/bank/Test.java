package bank;

import bank.common.FileUtil;
import bank.common.MessageUtil;
import bank.vo.BalanceRequestVO;
import bank.vo.BalanceResponseVO;
import bank.vo.PayRollDetailVO;

import javax.management.relation.RoleUnresolved;
import java.io.*;
import java.math.BigDecimal;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Test {

    private static final String FILE_DIC = "D:/";
    private final static SimpleDateFormat SELECTFORMAT = new SimpleDateFormat("yyyy-MM-dd HH%");
    private final static SimpleDateFormat FILE_PATH = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat FILEF_NAME = new SimpleDateFormat("yyyyMMddHHss");
    private static final String SEQ = "|";

    public static void main(String[] args){
        //e筑云请求银行报文体
        //EZY2Bank();
        /*//e筑云解析银行返回报文
        Bank2EZY();*/

        //写文件
        //writeFile();

        //解析文件
        /*List<String[]> data = FileUtil.readTxt("D:/20190919/201909191847.txt");
        List<PayRollDetailVO> payRollDetailVOS = new LinkedList<>();
        PayRollDetailVO PayRollDetailVO;
        if (data != null && data.size() > 1) {
            for (String[] strs : data) {
                PayRollDetailVO = new PayRollDetailVO();
                PayRollDetailVO.setSeq(Integer.parseInt(strs[0]));
                PayRollDetailVO.setCardNumber(strs[1]);
                PayRollDetailVO.setCardName(strs[2]);
                PayRollDetailVO.setIdCardNumber(strs[3]);
                PayRollDetailVO.setSalaryAmt(new BigDecimal(strs[4]));
                payRollDetailVOS.add(PayRollDetailVO);
            }
            for(PayRollDetailVO rollDetailVO:payRollDetailVOS){
                System.out.println(rollDetailVO.toString());
            }
        }*/
        int x=0;
        try {
            x = test2(20);
            System.out.println("继续执行==================>"+x);
        }catch (Exception e){
            System.out.println("exception===>"+e.getMessage());;
        }finally {
            System.out.println("sadfsadfasdfadsf");
        }

        /*int x = test1(0);
        System.out.println("继续执行==================>");*/

        //System.out.println(test2(5));

        //System.out.println(new Integer(1).toString().equals("1"));

        /*System.out.println(new Integer(1).equals(new Integer(1)));*/

        /*try {
            //创建Socket对象
            Socket socket=new Socket("192.168.0.165",9900);

            //根据输入输出流和服务端连接
            OutputStream outputStream=socket.getOutputStream();
            //获取一个输出流，向服务端发送信息
            PrintWriter printWriter=new PrintWriter(outputStream);
            printWriter.print(rquestTest());
            printWriter.flush();
            socket.shutdownOutput();//关闭输出流

            //获取一个输入流，接收服务端的信息
            InputStream inputStream=socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            //包装成字符流，提高效率
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            //缓冲区
            String info="";
            String temp=null;//临时变量
            while((temp=bufferedReader.readLine())!=null){
                info+=temp;
                System.out.println("客户端接收服务端发送信息："+info);
            }

            //关闭相对应的资源
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    public static String rquestTest(){
        QueryPayRollRequestModel request = new QueryPayRollRequestModel();
        request.setAcctNo("84534542342342334");
        request.setBatNo("Z19092700000");
        request.setTransCode("ZJW004");
        //组装xml
        String requestData = MessageUtil.buildMessage(request, "ZJW004");
        System.out.println("request from bank===>"+requestData);
        return requestData;
    }

    public static int test2(int x){
        int i=0;
        try {
            i = 10 % x;
        }catch (Exception e){
            i = 555555;
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("test2====="+i);
        return i;

    }

    public static int test1(int x) throws Exception{
        int i= 10/x;
        return i;
    }

    public static void writeFile() throws Exception {

        Date date = new Date();
        String filePath = createfiles(date);
        //写内容  序号|卡号| 户名 |身份证号|应发工资|
        StringBuffer context = new StringBuffer();
        context.append(1);
        context.append(SEQ);
        context.append("523423345345");
        context.append(SEQ);
        context.append("张三");
        context.append(SEQ);
        context.append("534254234234342333");
        context.append(SEQ);
        context.append(23234.32);
        context.append(SEQ);
        context.append("\n");

        context.append(2);
        context.append(SEQ);
        context.append("623423345345");
        context.append(SEQ);
        context.append("李四");
        context.append(SEQ);
        context.append("634254234234342333");
        context.append(SEQ);
        context.append(21234.32);
        context.append(SEQ);
        context.append("\n");

        context.append(3);
        context.append(SEQ);
        context.append("723423345345");
        context.append(SEQ);
        context.append("王五");
        context.append(SEQ);
        context.append("734254234234342333");
        context.append(SEQ);
        context.append(11234.32);
        context.append(SEQ);
        context.append("\n");

        String fileName = filePath + FILEF_NAME.format(new Date()) + ".txt";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("创建文件成功===>" + fileName);
        }

        //写入文件
        FileUtil.writeFile(file, context);
        System.out.println("文件写入成功===>" + fileName);
    }


    private static String createfiles(Date date) {
        //1.创建当天日期文件夹
        String dictoryName = FILE_PATH.format(date);
        String datePath = FILE_DIC + dictoryName + "/";
        File datefile = new File(datePath);
        if (!datefile.exists()) datefile.mkdir();
        return datePath;
    }

    public static void Bank2EZY() {
        String payResultStr = "<?xml version=\"1.0\" encoding=\"GB2312\"?>\n" + "<data>\n"
                + "  <TransCode>ZJW005</TransCode>\n" + "  <fSeqno>0122019061317411610000338</fSeqno>\n"
                + "  <ChnnelPswd>667c0a5azdceb7ef59bc849c5b27157ce3901d638b5fc03284f324fa267f74687</ChnnelPswd>\n"
                + "  <RetCode>00000</RetCode>\n" + "  <RetMsg>success</RetMsg>\n"
                + "  <AcctNo>817777701421000022</AcctNo>\n" + "  <BatNo>Z19061300027</BatNo>\n"
                + "  <StatNo>02</StatNo>\n" + "  <StatMsg>录入待授权</StatMsg>\n" + "  <PayDate/>\n"
                + "  <TotalCnt>1</TotalCnt>\n" + "  <SuccCnt>0</SuccCnt>\n" + "  <SuccAmt>0.00</SuccAmt>\n"
                + "  <TransNum>5</TransNum>\n" + "  <Info/>\n" + "  <NextNo>0</NextNo>\n" + "  <fld1/>\n"
                + "  <fld2/>\n" + "  <fld3/>\n" + "</data>";
        BalanceResponseVO balanceResponseVO = MessageUtil.xmlToBean(payResultStr, BalanceResponseVO.class);
        System.out.println(balanceResponseVO);

    }

    public static void EZY2Bank() {
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

        String requestData = MessageUtil.buildMessage(balanceRequestVO,balanceRequestVO.getTransCode());
        System.out.println(requestData);

        String aaaa = requestData.substring(requestData.indexOf("0ZJW")+1,requestData.indexOf("0ZJW")+7);
        System.out.println(aaaa);
    }


}
