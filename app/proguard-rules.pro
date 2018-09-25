# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile



##---------------Begin: Custom Entity ----------
-keep class com.guo.projectg.bean.** { *; }
##---------------End:   Custom  ----------


##>>---------------------------  Gson  --------------------------------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-dontwarn sun.misc.**
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

##---------------------------  Gson  --------------------------------<<


##>>---------------------------  OKHttp  --------------------------------
# JSR 305 annotations are for embedding nullability information.
-dontwarn javax.annotation.**
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn org.conscrypt.**
# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# Animal Sniffer compileOnly dependency to ensure APIs are compatible with older versions of Java.
-dontwarn org.codehaus.mojo.animal_sniffer.*

# OkHttp platform used only on JVM and when Conscrypt dependency is available.
-dontwarn okhttp3.internal.platform.ConscryptPlatform
##---------------------------  OKHttp  --------------------------------<<


##>>---------------------------  Retrofit  --------------------------------
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Exceptions
##---------------------------  Retrofit  --------------------------------<<


##>>---------------------------  GreenDao  --------------------------------
-keepclassmembers class * extends org.greenrobot.greendao.AbstractDao {
public static java.lang.String TABLENAME;
}
-keep class **$Properties
-keep class de.greenrobot.dao.** {*;}
# If you do not use SQLCipher:
-dontwarn org.greenrobot.greendao.database.**
##---------------------------  GreenDao  --------------------------------<<


##>>---------------------------  BadgeView  --------------------------------
-keep q.rorbin.badgeview.** {*;}
##---------------------------  BadgeView  --------------------------------<<

##>>---------------------------  Glide  --------------------------------
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}


##---------------------------  Glide  --------------------------------<<


##>>---------------------------  banner  --------------------------------
# banner 的混淆代码
-keep class com.youth.banner.** {
    *;
 }
##---------------------------  banner  --------------------------------<<


##>>---------------------------  JPUSH  --------------------------------
-dontoptimize
-dontpreverify
-keepattributes  EnclosingMethod,Signature
-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }

-dontwarn cn.jiguang.**
-keep class cn.jiguang.** { *; }

 -keepclassmembers class ** {
     public void onEvent*(**);
 }

#========================gson================================
-dontwarn com.google.**
-keep class com.google.gson.** {*;}

#========================protobuf================================
-keep class com.google.protobuf.** {*;}

#========================support=================================
-dontwarn cn.jmessage.support.**
-keep class cn.jmessage.support.**{*;}
##---------------------------  banner  --------------------------------<<

#========================JMRTC================================
-dontwarn cn.jiguang.jmrtc.**
-keep class cn.jiguang.jmrtc.api.** {*;}

#========================Agora================================
-dontwarn io.agora.rtc.**
-keep class io.agora.rtc.** {*;}