package com.founder.cxzx.ihospital_patient_changchunzyy.wxapi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hyyx on 2017/1/10.
 */

public class WxPayBean {


    /**
     * code : 200
     * data : {"appid":"wxaf67330ccf5ac7a3","noncestr":"PUKWtjo56lGOGyi1","package":"Sign=WXPay","partnerid":"1413033602","prepayid":"wx201701111812202e68f897cc0417291944","timestamp":"1484129387","sign":"A9F0CEB4809B24AADACB6FD3BC65E25F","OrderNo":"2020LRSADLWQ"}
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
         * appid : wxaf67330ccf5ac7a3
         * noncestr : PUKWtjo56lGOGyi1
         * package : Sign=WXPay
         * partnerid : 1413033602
         * prepayid : wx201701111812202e68f897cc0417291944
         * timestamp : 1484129387
         * sign : A9F0CEB4809B24AADACB6FD3BC65E25F
         * OrderNo : 2020LRSADLWQ
         */

        private String appid;
        private String noncestr;
        @SerializedName("package")
        private String packageX;
        private String partnerid;
        private String prepayid;
        private String timestamp;
        private String sign;
        private String OrderNo;


        @Override
        public String toString() {
            return "BodyParts{" +
                    "appId='" + appid + '\'' +
                    ", partnerId='" + partnerid + '\'' +
                    ", prepayId='" + prepayid + '\'' +
                    ", nonceStr='" + noncestr + '\'' +
                    ", timeStamp='" + timestamp + '\'' +
                    ", packageX='" + packageX + '\'' +
                    ", sign='" + sign + '\'' +
                    '}';
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public void setOrderNo(String OrderNo) {
            this.OrderNo = OrderNo;
        }

        public String getAppid() {
            return appid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public String getPackageX() {
            return packageX;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public String getSign() {
            return sign;
        }

        public String getOrderNo() {
            return OrderNo;
        }
    }
}
