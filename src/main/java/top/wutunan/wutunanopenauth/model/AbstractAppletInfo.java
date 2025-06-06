package top.wutunan.wutunanopenauth.model;

/**
 * 小程序信息
 */
public abstract class AbstractAppletInfo {


    /**
     * 小程序appId
     */
    private String appId;


    /**
     * 小程序密钥
     */
    private String appSecret;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
