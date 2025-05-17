package top.wutunan.wutunanopenauth.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import top.wutunan.wutunanopenauth.OpenPlatformOpenId;
import top.wutunan.wutunanopenauth.constant.WeChatApiConstant;
import top.wutunan.wutunanopenauth.model.AbstractAppletInfo;

import java.util.HashMap;

public class WeChatPlatformImpl implements OpenPlatformOpenId {

    @Override
    public String getOpenId(String openCode, AbstractAppletInfo appletInfo) {

        String url = WeChatApiConstant.WECHAT_API_URL_JSCODE2SESSION;

        HashMap map = new HashMap();
        map.put("appid", appletInfo.getAppId());
        map.put("secret", appletInfo.getAppSecret());
        map.put("js_code", openCode);  // 临时授权码，前端传递过来的。
        map.put("grant_type", "authorization_code");

        // 微信平台发送请求
        String response = HttpUtil.post(url, map);

        // 解析响应的 json对象
        JSONObject json = JSONUtil.parseObj(response);

        // 获取openid。微信响应的对象中通过关键字获取openId属性。
        String openId = json.getStr("openid");
        if (openId == null || openId.length() == 0) {
            // 抛出异常
            throw new RuntimeException("临时登陆凭证错误");
        }

        return openId;
    }
}
