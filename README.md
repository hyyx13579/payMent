# payMent 主流支付方式的流程
## 支付宝
1. 几个变量分析
PID:合作者身份ID（PID）是商户与支付宝签约后，商户获得的支付宝商户唯一识别码,可以登录官网查询。
APPID,APP SECRET,和支付宝密钥：是支付宝给我们生成好的，无法更改。
商户私钥rsa_private_key：openssl+PKCS8格式生成。
支付宝公钥rsa_public_key：把自己生成的上传网页，成功后可查询支付宝的公钥。
2. 代码中变量分析
首先签名逻辑建议放在服务端，这样私钥不回暴露在代码中
PARTNER：PID
SELLER：商户的收款账号
RSA_PRIVATE：商户私钥，pkcs8格式
3. 支付中需要注意的几点
在商户应用工程的AndroidManifest.xml文件里面添加声明：
`<activity
            android:name="com.alipay.sdk.app.H5PayActivity"
            android:configChanges="orientation|keyboardHidden|navigation"
            android:exported="false"
            android:screenOrientation="behind" >
</activity>
<activity
            android:name="com.alipay.sdk.auth.AuthActivity"
            android:configChanges="orientation|keyboardHidden|navigation"
            android:exported="false"
            android:screenOrientation="behind" >
 </activity>`
 权限声明
`<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />`
