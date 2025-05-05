package top.wutunan.wutunanopenauth.constant;

public class WeChatApiConstant {


    /**
     * 获取微信 openid地址
     */
    public static final String WECHAT_API_URL_JSCODE2SESSION = "https://api.weixin.qq.com/sns/jscode2session";


    /**
     * 私有构造方法，防止实例化
     */
    private WeChatApiConstant() {
        throw new UnsupportedOperationException("工具类不允许实例化");
    }

}
