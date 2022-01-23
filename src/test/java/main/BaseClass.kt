package main

import io.appium.java_client.*
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.touch.TapOptions
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import utils.appPath
import java.net.URL
import java.util.concurrent.TimeUnit

open class BaseClass {

    var driver: AppiumDriver<MobileElement>? = null

    private val platform: PlatformAndrIOS = PlatformAndrIOS.Android(
        "Android",
        "7.0",
        "Pixel 5 API 24",
        false,
        "3000",
        "ru.sportmaster.app.handh.dev",
        "ru.sportmaster.app.presentation.start.StartActivity",
        appPath.fullAppLocalPathAndroid//"/Users/headhandh/Downloads/sportmaster-4.0.13.5605_dev_beta.apk"
    )

    @BeforeSuite
    fun setupDriver(){
        val url = URL("http://127.0.0.1:4723/wd/hub")
        val caps = platform.getCaps()
        when (platform){
            is PlatformAndrIOS.Android -> {
                driver = AndroidDriver(url,caps)
            }
            is PlatformAndrIOS.IOS -> {
                //TODO
            }
        }

        driver?.manage()?.timeouts()?.implicitlyWait( 7, TimeUnit.SECONDS)
    }

    @AfterSuite
    fun end(){
        driver?.quit()
    }


}
