package top.wutunan.wutunanopenauth;


import top.wutunan.wutunanopenauth.model.AbstractAppletInfo;

/**
 * @author wutunan
 * @create 2018-07-03 15:04
 * @description 获取各个平台的用户对应的openId串
 */
public interface OpenPlatformOpenId {


    /**
     * 获取各个平台的用户对应的openId串。
     * @param openCode 临时授权码
     * @return openId串
     */
    String getOpenId(String openCode, AbstractAppletInfo appletInfo);
}
