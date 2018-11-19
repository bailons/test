package notifyAllTestPC;

/**
 * @ClassName PCData
 * @Description 容器数据模型
 * @Author leibailong
 * @Date 2018/10/31 31 14:52
 * @Version 1.0
 **/
public class PCData {
    private String data;
    public PCData(String d) {
        data = d;
    }
    public String getData(){
      return data;
    }
    public void setPCData(String data){
        this.data=data;
    }
    @Override
    public String toString(){
        return "data:"+data;
    }
}
