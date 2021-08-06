## 和缓视频医生Android SDK接入文档 3.1.0.08031427

#### 一、 Android工程引入和缓视频医生SDK

##### 1. 在project的build.gradle文件中增加mavenCentral仓库的引用，如果已经引用可忽略这一步骤，引入方式如下：

```
allprojects {
    repositories {
        mavenCentral()
        ...
    }
}

```

##### 2. 在需要接入和缓视频医生SDK的moudle中的build.gradle文件中引入和缓视频医生SDK，引用方式如下：

```
implementation 'com.hh-medic.android.sdk:hh_doctor:3.1.0.08031427'
```

##### 3. 第三方引用
注:这些库必须添加到引用当中
```
    implementation 'com.google.code.gson:gson:2.8.0'
    implementation 'com.squareup.okhttp3:okhttp:3.12.1'
    implementation "com.tencent.liteav:LiteAVSDK_TRTC:8.2.9809"
```

#### 二、 使用和缓视频医生SDK

##### 1. 初始化SDK（初始化方法需要在使用SDK其他部分之前做就可以）

```java
HHSDKOptions options = new HHSDKOptions("sdkProductId",true,new GlideImageLoader());
HHDoctor.init(context,options);
```

HHSDKOptions参数说明：

| 参数定义 | 说明 |
| --- | --- |
|sdkProductId|由和缓分配的标识产品的ID|
|isDevelop|是否测试环境|
|imageEngine|辅助SDK内部用到图片资源的图片加载引擎|

HHDoctor.init 参数说明

| 参数定义 | 说明 |
| --- | --- |
|context|上下文|
|options|初始化必备参数|


其中GldieImageLoader是实现和缓视频SDK中HHImageEngine用来实现部分SDK图片的加载引擎，实现示例使用了Glide加载方式如下：
```java
public class GlideImageLoader implements HHImageEngine {
    @Override
    public void loadImage(Context context, int placeHolder, String url, ImageView imageView) {
        Glide.with(context).load(url).apply(new RequestOptions()).placeholder(placeHolder).into(imageView);
    }
}
```

##### 2. 登录和缓视频医生SDK

```java
HHDoctor.login(context, "userToken", new HHLoginListener() {
    @Override
    public void onSuccess() {
                
    }

    @Override
    public void onError(String s) {

    } 
});
```

HHDoctor.login参数说明

| 参数定义 | 说明 |
| --- | --- |
|context|上下文|
|userToken|和缓用户唯一标识|
|loginListener|登录状态回调|

##### 3. 登出和缓视频医生SDK（切换账号或登出账号的时候调用）

```java
HHDoctor.logOut(context);
```

| 参数定义 | 说明 |
| --- | --- |
|context|上下文|


##### 4. 是否登录和缓视频医生SDK

```java
HHDoctor.isLoggedIn(context)
```
| 参数定义 | 说明 |
| --- | --- |
|context|上下文|

##### 5. 设置呼叫附加参数

```java
HHDoctor.setCallExtension("ext");
```

| 参数定义 | 说明 |
| --- | --- |
|ext|呼叫附加参数|

##### 6. 呼叫视频医生

```java
HHDoctor.call(context, "userToken", new HHCallListener() {
    @Override
    public void onStart(String s) {
        
    }
    
    @Override
    public void onFinish(long l) {
    
    }
    
    @Override
    public void onCallSuccess() {
    
    }
    
    @Override
    public void onFail(int i) {
    
    }
    
    @Override
    public void onCancel() {
    
        }
});
```

参数说明：

| 参数定义 | 说明 |
| --- | --- |
|context|上下文|
|userToken|请传咨询人信息，例如给本人看就传本人的userToken，给家庭成员看就传家庭成员userToken|
|callListener|呼叫状态回调|


##### 7. 获取病历详情地址

```java
HHDoctor.getMedicDetailUrl("medicId","userToken","patientUserToken");
```

参数说明：

| 参数定义 | 说明 |
| --- | --- |
|medicId|病历id|
|userToken|登录帐号userToken|
|patientUserToken|真实患者userToken|

