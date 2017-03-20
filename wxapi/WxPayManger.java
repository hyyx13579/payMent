package com.founder.cxzx.ihospital_patient_changchunzyy.wxapi;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.founder.cxzx.ihospital_patient_changchunzyy.Common.Constant;
import com.founder.cxzx.ihospital_patient_changchunzyy.Common.Json;
import com.founder.cxzx.ihospital_patient_changchunzyy.Common.WebClient;
import com.founder.cxzx.ihospital_patient_changchunzyy.customView.AlphaLoadingDialog;
import com.founder.cxzx.ihospital_patient_changchunzyy.homeApplication.HomeApplications;
import com.founder.cxzx.ihospital_patient_changchunzyy.rule.AjaxDao;
import com.founder.cxzx.ihospital_patient_changchunzyy.wxapi.WxPayBean;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

/**
 * Created by hyyx on 2017/1/12.
 */

public class WxPayManger {

    private IWXAPI mWxApi;
    private Context context;

    public WxPayManger(Context context) {
        mWxApi = WXAPIFactory.createWXAPI(context, Constant.APP_ID);
        mWxApi.registerApp(Constant.APP_ID);
        this.context = context;
    }

    /**
     * @param trade_id   订单号
     * @param order_Type 订单类型
     */
    public void gotoWxPay(String trade_id, String order_Type) {
        final AlphaLoadingDialog alphaLoadingDialog = new AlphaLoadingDialog(context);
        alphaLoadingDialog.showLoadingDialog(HomeApplications.dialogWidth, HomeApplications.dialogHeight);
        String token = HomeApplications.getApplication().getToken();
        String user_id = HomeApplications.getApplication().getPatient().getData().getUser_id();
        AjaxDao.toWxPay(token, user_id, trade_id, order_Type, WxPayBean.class, new WebClient.AjaxDaoCallback<WxPayBean>() {

            @Override
            public void onSuccess(WxPayBean result) {
                alphaLoadingDialog.cancelLoadingDialog();
                Toast.makeText(context, "请求微信支付订单成功", Toast.LENGTH_SHORT).show();
                if (result == null || result.getData() == null) {
                    return;
                }
                sendWxPay(context, result);

            }

            @Override
            public void onDataFailure(Json json) {
                alphaLoadingDialog.cancelLoadingDialog();
                Toast.makeText(context, "请求微信支付订单失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Json json) {
                alphaLoadingDialog.cancelLoadingDialog();
                Toast.makeText(context, "请求微信支付订单失败", Toast.LENGTH_SHORT).show();

            }
        });


    }


    public void sendWxPay(Context context, WxPayBean wxPayBean) {
        if (mWxApi.isWXAppInstalled() && mWxApi.isWXAppSupportAPI()) {
            WxPayBean.DataBean data = wxPayBean.getData();
            PayReq payReq = new PayReq();
            payReq.appId = Constant.APP_ID;
            payReq.partnerId = data.getPartnerid();
            payReq.prepayId = data.getPrepayid();
            payReq.packageValue = data.getPackageX();
            payReq.nonceStr = data.getNoncestr();
            payReq.timeStamp = data.getTimestamp();
            payReq.sign = data.getSign();
            // payReq.extData = "app data";
            Log.e("Wx_pay", data.toString());
            Log.e("Wx_pay", "checkArgs=" + payReq.checkArgs());
            mWxApi.sendReq(payReq);

        } else {
            Toast.makeText(context, "请安装微信", Toast.LENGTH_SHORT).show();

        }


    }


}
