package constructor.classes

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver


enum class LocatorType{
    ID,
    ACCESSIBILITY_ID,
    XPATH,
    TEXT
}

class LocatorElement(
    val locatorType: LocatorType = LocatorType.ID,
    val androidAccessibilityId: String = "",
    val androidId: String = "",
    val androidXpath: String = "",
    val text: String = ""
){
    fun getMobileElement(driver: AppiumDriver<MobileElement>?): MobileElement? {
        return when (locatorType) {
            LocatorType.ID -> {
                driver?.findElementById(androidId)
            }
            LocatorType.ACCESSIBILITY_ID -> {
                driver?.findElementByAccessibilityId(androidAccessibilityId)
            }
            LocatorType.XPATH -> {
                driver?.findElementByXPath(androidXpath)
            }
            LocatorType.TEXT -> {
                (driver as AndroidDriver<MobileElement>).findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                            +".scrollIntoView(new UiSelector().textMatches(\"$text\").instance(0))"
                )
            }
        }
    }

}

val ex = LocatorElement(
    locatorType = LocatorType.ID,
    androidAccessibilityId = "",
    androidId = "",
    androidXpath = "",
    text = ""
)
