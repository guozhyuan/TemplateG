package com.psychological.cxks.wxapi;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import com.psychological.cxks.Constant;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

/**
 * Author : guozhaoyuan
 * Date   : 2017/5/22
 */

public class WXSDKHelper {
    private static WXSDKHelper helper;
    private IWXAPI api;
    private static final String APP_ID = Constant.WXAPP_ID;

    public static WXSDKHelper getInstance() {
        if (helper == null) {
            helper = new WXSDKHelper();
        }
        return helper;
    }

    public void init(Context context) {
        api = WXAPIFactory.createWXAPI(context, APP_ID);
        api.registerApp(APP_ID);
    }

    public IWXAPI getApi() {
        return api;
    }


    public void sendAuthReq() {
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "none";
        api.sendReq(req);
    }


    public void wxPay(String str) throws JSONException {
        /*
            "prepay_id":1 //对应app下单中的prepayId
		    "partnerId":1, //对应app下单中的partnerId
		    "package":1, //对应app下单中的package
		    "nonce_str":1, //对应app下单中的nonceStr
		    "sign":1, //对应app下单中的sign
		    "timeStamp":1, //对应app下单中的timeStamp
         */
        JSONObject json = new JSONObject(str);
        PayReq req = new PayReq();
        req.appId = APP_ID;
        req.partnerId = json.optString("partnerId");
        req.prepayId = json.optString("prepay_id");
        req.nonceStr = json.optString("nonce_str");
        req.timeStamp = json.optString("timeStamp");
        req.packageValue = json.optString("package");
        req.sign = json.optString("sign");
        api.sendReq(req);
    }

    public void launchWeChat() {
        api.openWXApp();
    }
}
