package bank;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 处理结果响应体
 */
@XStreamAlias("data")
public class PayResultResponseModel extends BankResponseCommonModel {
    public PayResultResponseModel() {
        super.transCode = BankInterfaceEnums.RESULT_NOTICE.getCode();
    }

}
