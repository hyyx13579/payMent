package com.founder.cxzx.ihospital_patient_changchunzyy.wxapi;

/**
 * Created by hyyx on 2017/1/11.
 */

public class WxPayStateBean {


    /**
     * code : 200
     * data : {"STATUS":"TBC","msg":"支付结果尚未确认"}
     * msg : 操作成功
     */

    private String code;
    private DataBean data;
    private String msg;

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public DataBean getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public static class DataBean {
        /**
         * STATUS : TBC
         * msg : 支付结果尚未确认
         */

        private String STATUS;
        private String msg;

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public String getMsg() {
            return msg;
        }
    }
}
