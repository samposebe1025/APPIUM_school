package main

import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

sealed class PlatformAndrIOS {
    abstract fun getCaps(): DesiredCapabilities
    class Android(
        private val platformName: String = "Android",
        private val platformVersion: String = "7.0",
        private val deviceName: String = "Pixel 5 API 24",
        private val noReset: Boolean = false,
        private val newCommandTimeout: String = "7200",
        private val appPackage: String = "ru.sportmaster.app.handh.dev",
        private val appActivity: String = "ru.sportmaster.app.presentation.start.StartActivity",
        private val app: String = "/Users/headhandh/Downloads/sportmaster-4.0.13.5605_dev_beta.apk"
    ): PlatformAndrIOS(){
        override fun getCaps(): DesiredCapabilities {
            val caps = DesiredCapabilities()
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName)
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion)
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName)
            caps.setCapability(MobileCapabilityType.NO_RESET, noReset)
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, newCommandTimeout)
            //caps.setCapability(MobileCapabilityType.UDID,"")
            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage)
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity)
            caps.setCapability(MobileCapabilityType.APP, app)
            return caps
        }
    }
    class IOS(
        private val platformName: String = "Android",
        private val platformVersion: String = "7.0",
        private val deviceName: String = "Pixel 5 API 24",
        private val noReset: Boolean = false,
        private val newCommandTimeout: String = "7200",
        private val appPackage: String = "ru.sportmaster.app.handh.dev",
        private val appActivity: String = "ru.sportmaster.app.presentation.start.StartActivity",
        private val app: String = "/Users/headhandh/Downloads/sportmaster-4.0.13.5605_dev_beta.apk"

    ): PlatformAndrIOS(){
        override fun getCaps(): DesiredCapabilities {
            TODO("Not yet implemented")
        }
    }
}