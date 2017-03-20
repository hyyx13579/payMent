package com.founder.cxzx.ihospital_patient_changchunzyy.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.founder.cxzx.ihospital_patient_changchunzyy.Common.Constant;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_wxpay_entry);
        api = WXAPIFactory.createWXAPI(this, Constant.APP_ID);
        api.handleIntent(getIntent(), this);

    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {

        Log.e("WXPayEntryActivity", "baseResp.errCode:" + baseResp.errCode);
        switch (baseResp.errCode) {
            case 0://支付成功
                EventBus.getDefault().post(new MyPayStateBean(true));
                Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
                break;
            case -1: //表示支付失败
                EventBus.getDefault().post(new MyPayStateBean(false));
                Toast.makeText(this, "支付失败", Toast.LENGTH_SHORT).show();
                break;
            case -2: //表示取消支付
                EventBus.getDefault().post(new MyPayStateBean(false));
                Toast.makeText(this, "支付取消", Toast.LENGTH_SHORT).show();
                break;
        }
        finish();
    }

}



