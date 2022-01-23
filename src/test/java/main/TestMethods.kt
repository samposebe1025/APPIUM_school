package main

import constructor.classes.LocatorElement
import constructor.classes.LocatorType
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.testng.AssertJUnit
import utils.PlatformTouchAction
import java.time.Duration
import java.util.concurrent.TimeUnit

open class TestMethods: BaseClass() {

    fun clickToElement(
        locator: LocatorElement,
        timeout: Long = 1
    ) {
        locator.getMobileElement(driver)?.click()
        TimeUnit.SECONDS.sleep(timeout)
    }

    fun inputTextInField(
        locator: LocatorElement,
        inputText: String,
        timeout: Long = 1
    ) {
        locator.getMobileElement(driver)?.sendKeys(inputText)
        TimeUnit.SECONDS.sleep(timeout)
    }

    fun swipeOnScreen(
        startCordX: Int,
        startCordY: Int,
        moveCordX: Int,
        moveCordY: Int
    ){
        driver?.let {
            PlatformTouchAction(it)
                .longPress(PointOption.point(startCordX, startCordY))
                .moveTo(PointOption.point(moveCordX, moveCordY))
                .release()
                .perform()
        }
    }

    fun tapByCoordinates(
        cordX: Int,
        cordY: Int,
        waitSeconds: Long = 1
    ) {
        driver?.let {
            PlatformTouchAction(it)
                .tap(PointOption.point(cordX, cordY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(waitSeconds)))
                .perform()
        }
    }

    fun checkTextInElement (
        locator: LocatorElement,
        text: String ,
        predProcText: ((String) -> String)? = null) {
        var elementAttribute = locator?.getMobileElement(driver)?.getAttribute("text")
        if (elementAttribute != null) {
            if (predProcText != null)
                elementAttribute =  predProcText(elementAttribute)
            AssertJUnit.assertEquals(elementAttribute, text)
        }
    }

    fun cleanField ( locator: LocatorElement) {
        locator.getMobileElement(driver)?.clear() // очищение поля
    }

    fun checkAvailableElement (locator: LocatorElement) {
        val enabled = locator.getMobileElement(driver)?.isEnabled
        if (enabled != null) {
            AssertJUnit.assertTrue(enabled)
        }
    }

}
