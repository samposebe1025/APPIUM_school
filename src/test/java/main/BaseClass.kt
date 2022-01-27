package main

import io.appium.java_client.*
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.touch.TapOptions
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.html5.Location
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.*
import utils.appPath
import java.net.URL
import java.util.concurrent.TimeUnit

data class DriverParams(
    val paramPlatformName: String,
    val paramPlatformVersion: String,
    val paramDeviceName: String,
    val paramUDID: String,
    val timeout: String,
    val paramTimeToDelay: Long)

var driverParams = DriverParams(
    paramPlatformName = "",
    paramPlatformVersion = "",
    paramDeviceName = "",
    paramUDID = "",
    timeout = "",
    paramTimeToDelay = 0)

lateinit var driver: AppiumDriver<MobileElement>

open class BaseClass {



    private fun initDriver() {
        val url = URL("http://127.0.0.1:4723/wd/hub")

        val caps = DesiredCapabilities()

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, driverParams.paramPlatformName) //название платформы
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, driverParams.paramPlatformVersion) // версия ОС
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, driverParams.paramDeviceName) // имя устройства
        caps.setCapability(MobileCapabilityType.NO_RESET,true) //не сбрасывать приложение в 0 при новом запуске
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, driverParams.timeout)
        caps.setCapability(MobileCapabilityType.UDID, driverParams.paramUDID)

        when(driverParams.paramPlatformName){
            "Android" -> {
                caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "ru.sportmaster.app.handh.dev")
                caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "ru.sportmaster.app.presentation.start.StartActivity")
                caps.setCapability(MobileCapabilityType.APP, appPath.fullAppLocalPathAndroid)
                driver = AndroidDriver(url, caps) // установка драйвера и приложения на Android device
            }
            "iOS" -> {
                caps.setCapability(MobileCapabilityType.APP, appPath.fullLocalAppLocalPathIOS)
                driver = IOSDriver(url, caps) //установка dрайвера для iOS
            }
        }

//        val location = Location(55.052146, 82.920077, 1.0)
//        driver?.setLocation(location)
        driver?.manage()?.timeouts()?.implicitlyWait( driverParams.paramTimeToDelay, TimeUnit.SECONDS)

    }

    private fun closeAppDriver(){
        when (driverParams.paramPlatformName){
            "Android" -> {
                driver?.closeApp()
            }
            "iOS" -> {
                val a = (driverParams.paramPlatformVersion)
                    .replaceAfter(".","")
                    .replace(".","")
                val c = a.toInt()
                if ( c >= 15){
                    driver?.resetApp()
                } else {
                    driver?.closeApp()
                }
            }
        }
    }
    @BeforeSuite
    @Parameters (
    value = [
        "paramPlatformName",
        "paramPlatformVersion",
        "paramDeviceName",
        "paramUDID",
        "timeout",
        "paramTimeToDelay"
    ])
    fun setupDriver(
        paramPlatformName: String,
        paramPlatformVersion: String,
        paramDeviceName: String,
        paramUDID: String,
        timeout: String,
        paramTimeToDelay: Long,

    ){
        driverParams = DriverParams(
            paramPlatformName,
            paramPlatformVersion,
            paramDeviceName,
            paramUDID,
            timeout,
            paramTimeToDelay)

        initDriver()

        if ( GeneralTestFunc().firstOn() )
            closeAppDriver()
        //есть ли онбординг
            // если есть надо пройти до главного экрана минуя авторизацию закрыть приложение
//        driver?.closeApp()
//        //ios 15
//        driver?.resetApp()
    }

    @BeforeClass
    fun beforeClass(){
        // заново инициализировать драйвер
        initDriver()
        // закрыть приложение
        closeAppDriver()
    }

    @BeforeMethod
    fun beforeMethod(){
        //запустить приложение
        driver?.launchApp()
        TimeUnit.SECONDS.sleep(5)
    }

    @AfterMethod
    fun afterMethod(){
        // закрыть приложение
        closeAppDriver()
        //ios 15
        //driver?.resetApp()
    }

    @AfterClass
    fun afterClass(){
// закрыть сессию драйвера
        driver?.quit()
    }

    @AfterSuite
    fun end(){
        driver?.quit()
    }


}
