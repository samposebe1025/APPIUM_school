package main

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import java.net.URL
import java.util.concurrent.TimeUnit

class BaseClass {

    lateinit var driver: AppiumDriver<MobileElement>

    @BeforeSuite
    fun setupDriver(){
        val url = URL("http://127.0.0.1:4723/wd/hub")
        val caps = DesiredCapabilities()

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android")
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0")
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 5 API 24")
        caps.setCapability(MobileCapabilityType.NO_RESET,false)
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"7200")
        //caps.setCapability(MobileCapabilityType.UDID,"")

        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"ru.sportmaster.app.handh.dev")
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"ru.sportmaster.app.presentation.start.StartActivity")
        caps.setCapability(MobileCapabilityType.APP,"/Users/headhandh/Downloads/sportmaster-4.0.13.5605_dev_beta.apk")

        driver = AndroidDriver(url,caps)

        driver.manage().timeouts().implicitlyWait( 7, TimeUnit.SECONDS)
    }


    @AfterSuite
    fun end(){
        driver.quit()
    }

    @Test
    fun testOne(){
        TimeUnit.SECONDS.sleep(3)
        try {
            driver.findElement(MobileBy.xpath("/ierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton"))
                .click()
            TimeUnit.SECONDS.sleep(4)
            driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/editTextPhone")).sendKeys("23456")
            TimeUnit.SECONDS.sleep(4)
            driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/buttonGetCode")).click()
            TimeUnit.SECONDS.sleep(8)
        }catch(e:org.openqa.selenium.NoSuchElementException){
            println("AAAAaAAAAA")
            println(e.toString())
            println("AAAAaAAAAA")
        }
    }
}