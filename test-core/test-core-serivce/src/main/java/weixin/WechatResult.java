package weixin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WechatResult extends WechatBase implements Serializable {

    public WechatResult() {
    }

    public WechatResult(String returnCode) {
        setReturn_code(returnCode);
    }

    public WechatResult(String returnCode, String returnMsg) {
        setReturn_code(returnCode);
        setReturn_msg(returnMsg);
    }
}