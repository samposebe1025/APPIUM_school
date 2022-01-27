package constructor.classes

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver


enum class LocatorType{
    ID,
    ANDROID_ACCESSIBILITY_ID,
    ANDROID_XPATH,
    IOS_XPATH,
    IOS_ACCESSIBILITY_ID,
    TEXT
}

class LocatorElement(
    val androidLocatorType: LocatorType = LocatorType.ID,
    val androidAccessibilityId: String = "",
    val androidId: String = "",
    val androidXpath: String = "",
    val iosLocatorType: LocatorType = LocatorType.IOS_XPATH,
    val iosXpath: String = "",
    val iosAccessibilityId: String = "",
    val text: String = ""
){
    fun getMobileElement(driver: AppiumDriver<MobileElement>?): MobileElement?{
        return when (driver){
            is AndroidDriver -> {
                getMobileElementAndroid(driver)
            }
            is IOSDriver -> {
                getMobileElementIOS(driver)
            }
            else -> null
        }
    }

    private fun getMobileElementAndroid(driver: AppiumDriver<MobileElement>?): MobileElement? {
        try {
            return when (androidLocatorType) {
                LocatorType.ID -> {
                    driver?.findElementById(androidId)
                }
                LocatorType.ANDROID_ACCESSIBILITY_ID -> {
                    driver?.findElementByAccessibilityId(androidAccessibilityId)
                }
                LocatorType.ANDROID_XPATH -> {
                    driver?.findElementByXPath(androidXpath)
                }
                LocatorType.TEXT -> {
                    (driver as AndroidDriver<MobileElement>).findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                                + ".scrollIntoView(new UiSelector().textMatches(\"$text\").instance(0))"
                    )
                }
                else -> null
            }
        } catch (exp: org.openqa.selenium.NoSuchElementException){
            return null
        }
    }

    private fun getMobileElementIOS(driver: AppiumDriver<MobileElement>?): MobileElement? {
        try{
            return when (iosLocatorType) {
                LocatorType.IOS_ACCESSIBILITY_ID -> {
                    driver?.findElementByAccessibilityId(iosAccessibilityId)
                }
                LocatorType.IOS_XPATH -> {
                    driver?.findElementByXPath(iosXpath)
                }
                else -> null
            }
        } catch (exp: org.openqa.selenium.NoSuchElementException){
            return null
        }
    }
}
