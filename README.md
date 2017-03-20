# payMent 主流支付方式的流程
## 支付宝
1. 几个变量分析
  * PID:合作者身份ID（PID）是商户与支付宝签约后，商户获得的支付宝商户唯一识别码,可以登录官网查询。
  * APPID,APP SECRET,和支付宝密钥：是支付宝给我们生成好的，无法更改。
  * 商户私钥rsa_private_key：openssl+PKCS8格式生成。
  * 支付宝公钥rsa_public_key：把自己生成的上传网页，成功后可查询支付宝的公钥。
2. 代码中变量分析
  * ps:首先签名逻辑建议放在服务端，这样私钥不回暴露在代码中
  * PARTNER：PID
  * SELLER：商户的收款账号
  * RSA_PRIVATE：商户私钥，pkcs8格式
3. 支付中需要注意的几点
  * 在商户应用工程的AndroidManifest.xml文件里面添加声明：
``` javascript
<activity
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
 </activity> 
 ```
  * 权限声明
 ```
 <uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" /> 
```
*  请求订单接口返回的参数，保证与创建订单的方法要求的属性相互对应
OrderNo、Notify_url、Total_fee、Title、Body

## 微信
1. 签名与打包问题
*  接入微信支付，需要app签名打包后才可以调起
*  如果签名？ 签名：将APP打一个正式环境的包，然后在微信开放平台下载签名工具使用正确全包名进行打包（全包名gradle获取）
*  快捷的测试：在build.gradle文件中设置debug环境和relealse环境的签名相同就可以快捷支付，免签名，直接测试
```
signingConfigs {

        release {
            //.jks文件放在项目目录
            storeFile file("xxx.jks")
            storePassword "xxx"
            keyAlias "xxx.release"
            keyPassword "xxx"
        }
        debug {
            //.jks文件放在项目目录
            storeFile file("xxx.jks")
            storePassword "xxx"
            keyAlias "xxx.release"
            keyPassword "xxx"
        }
    }
 ```
 2. 在目录下添加wxapi的包名，在这个包名下必须要有WXPayEntryActivity这个Activity，支付成功后会显示此界面。
 3. 
