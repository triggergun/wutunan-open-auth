# wutunan-open-auth









## 微信获取openId测试用例



### 用例1)

```java
package top.wutunan.web.controller;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wutunan.config.properties.WutunanOpenAuthWeChartProperties;
import top.wutunan.web.model.dto.request.WeChartRegisterAndLoginParam;
import top.wutunan.wutunanopenauth.impl.WeChatPlatformImpl;
import top.wutunan.wutunanopenauth.model.AbstractAppletInfo;
import top.wutunan.wutunanopenauth.model.WeChatAppletInfo;

import javax.validation.Valid;

/**
 * 微信用户前端控制器
 */
@RestController
@RequestMapping("/timeInfo")
@Validated
@Slf4j
public class WeChatUserController {
    @Resource
    private WutunanOpenAuthWeChartProperties wutunanOpenAuthWeChartProperties;
    /**
     * 微信用户注册和登录
     */
    @PostMapping("/wechat/user/registerAndLogin")
    public void registerAndLogin(@RequestBody @Valid WeChartRegisterAndLoginParam weChartRegisterAndLoginParam){
        String code = weChartRegisterAndLoginParam.getCode();
        AbstractAppletInfo weChatAppletInfo = new WeChatAppletInfo();
        weChatAppletInfo.setAppId(wutunanOpenAuthWeChartProperties.getAppId());
        weChatAppletInfo.setAppSecret(wutunanOpenAuthWeChartProperties.getAppSecret());
        // 获取微信平台实例
        WeChatPlatformImpl weChatPlatform = new WeChatPlatformImpl();
        String openId = weChatPlatform.getOpenId(code, weChatAppletInfo);
        log.info("openId:{}", openId);
    }
}
```



### 用例1测试结果

```
2025-05-17 12:08:30  INFO   openId:oAyGs7ZyGBUWfVxCCOFcVmQhFhTo
```

