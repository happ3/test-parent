package baidu;

import java.io.Serializable;

/**
 * Created by lhp on 2017/3/29.
 */
public class BaiFuBaoResultBase implements Serializable{
    private String ret;
    private String msg;
    private String content;
    private String token;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
