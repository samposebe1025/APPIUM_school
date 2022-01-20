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
import java.net.URL
import java.util.concurrent.TimeUnit

class BaseClass {

    inner class PlatformTouchAction(performs: PerformsTouchActions)
        :TouchAction<PlatformTouchAction>(performs)

    private var driver: AppiumDriver<MobileElement>? = null

    private val platform: PlatformAndrIOS = PlatformAndrIOS.Android(
        "Android",
        "7.0",
        "Pixel 5 API 24",
        false,
        "7200",
        "ru.sportmaster.app.handh.dev",
        "ru.sportmaster.app.presentation.start.StartActivity",
        "/Users/headhandh/Downloads/sportmaster-4.0.13.5605_dev_beta.apk"
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

    @Test
    fun testOne(){
        TimeUnit.SECONDS.sleep(3)//timeout for start

        var screenResult = true
        //~~~ SPLASH
        screenResult = splash()
        if (screenResult) {
            println("Success SPLASH")
        } else {
            println("Error SPLASH")
            return
        }
        TimeUnit.SECONDS.sleep(3)
        //~~~ ENTER
        screenResult = enter()
        if (screenResult) {
            println("Success ENTER")
        } else {
            println("Error ENTER")
            return
        }
        TimeUnit.SECONDS.sleep(3)
        //~~~ PIN CODE
        screenResult = pinCode()
        if (screenResult) {
            println("Success PIN CODE")
        } else {
            println("Error PIN CODE")
            return
        }
        TimeUnit.SECONDS.sleep(5)
        //~~~ CITY
        screenResult = city()
        if (screenResult) {
            println("Success CITY")
        } else {
            println("Error CITY")
            return
        }
        TimeUnit.SECONDS.sleep(3)
        //~~~ GO PROFILE
        screenResult = goProfile()
        if (screenResult) {
            println("Success GO PROFILE")
        } else {
            println("Error GO PROFILE")
            return
        }
        TimeUnit.SECONDS.sleep(3)
    }

    //~~~ SPLASH
    private fun splash(): Boolean{
        var result = false
        println("~~~ SPLASH START ~~~")
        println("close splash")
        val button = driver?.find("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton",null)
        if (button != null)
        {
            result = true
            button.click()
        }
        TimeUnit.SECONDS.sleep(4)
        println("~~~ SPLASH END ~~~")
        return result
    }

    //~~~ ENTER
    private fun enter(): Boolean{
        println("~~~ ENTER START ~~~")
        println("enter telephone number")
        val editText = driver?.find( "ru.sportmaster.app.handh.dev:id/editTextPhone",null)
        if (editText != null)
        {
            editText.sendKeys("9999999973")
        } else {
            println("~~~ ENTER END ~~~")
            return false
        }

        TimeUnit.SECONDS.sleep(1)

        println("press button")
        val button = driver?.find( "ru.sportmaster.app.handh.dev:id/buttonGetCode",null)
        return if (button != null) {
            button.click()
            println("~~~ ENTER END ~~~")
            true
        } else {
            println("~~~ ENTER END ~~~")
            false
        }
    }

    //~~~ PIN CODE
    private fun pinCode(): Boolean{
        println("~~~ PIN CODE START ~~~")
        println("enter pin code")
        val editText = driver?.find( "ru.sportmaster.app.handh.dev:id/pinCodeEditText",null)
        if (editText != null)
        {
            editText.sendKeys("1111")
            println("~~~ PIN CODE END ~~~")
            return true
        } else {
            println("~~~ PIN CODE END ~~~")
            return false
        }
    }

    //~~~ CITY
    private fun city(): Boolean{
        println("~~~ CITY START ~~~")
        println("click deny")
        val button = driver?.find( "com.android.packageinstaller:id/permission_deny_button",null)
        if (button != null)
        {
            button.click()
        } else {
            println("~~~ CITY END ~~~")
            return false
        }

        TimeUnit.SECONDS.sleep(1)

        PlatformTouchAction(driver as AppiumDriver)
            .tap( PointOption.point(200, 300))
            .perform()

        TimeUnit.SECONDS.sleep(1)

        println("press first city")
        val textRecycler = driver?.find( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ViewFlipper/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]",null)
        return if (textRecycler != null) {
            textRecycler.click()
            println("~~~ CITY END ~~~")
            true
        } else {
            println("~~~ CITY END ~~~")
            false
        }
    }

    //~~~ GO PROFILE
    private fun goProfile(): Boolean{
        var result = false
        println("~~~ GO PROFILE START ~~~")
        println("push profile")
        val button = driver?.find("ru.sportmaster.app.handh.dev:id/profile_graph",null)
        if (button != null)
        {
            result = true
            button.click()
        }
        TimeUnit.SECONDS.sleep(4)
        println("~~~ GO PROFILE END ~~~")
        return result
    }
}
