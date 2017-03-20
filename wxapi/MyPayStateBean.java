package com.founder.cxzx.ihospital_patient_changchunzyy.wxapi;

/**
 * Created by hyyx on 2017/1/12.
 */

public class MyPayStateBean {
    public boolean isPay;

    public MyPayStateBean(boolean isPay) {
        this.isPay = isPay;
    }

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }
}
