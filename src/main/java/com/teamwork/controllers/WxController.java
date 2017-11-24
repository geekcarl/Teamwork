package com.teamwork.controllers;

import com.teamwork.common.AuthUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by geekCarl on 2017/11/25.
 */
@RestController
@RequestMapping("/wx")
public class WxController {

    @RequestMapping(value = "/login")
    public String login() throws UnsupportedEncodingException {
        String backUrl = "http://3e1f35c9.ngrok.io/callBack";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtil.APPID+
                "&redirect_uri=" + URLEncoder.encode(backUrl,"UTF-8")+
                "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        return "redirect:" + url;
    }
}
