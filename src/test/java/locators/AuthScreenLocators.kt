package locators

import constructor.classes.LocatorElement
import constructor.classes.LocatorType

class AuthScreenLocators {

    val buttonClose = LocatorElement(
        androidLocatorType = LocatorType.ANDROID_XPATH,
        androidXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageButton",

        iosLocatorType = LocatorType.IOS_XPATH,
        iosXpath = "//XCUIElementTypeButton[@name=\"closeButton\"]"
    )

    val textEditPhoneNumber = LocatorElement(
        androidLocatorType = LocatorType.ID,
        androidId = "ru.sportmaster.app.handh.dev:id/editTextPhone",

        iosLocatorType = LocatorType.IOS_XPATH,
        iosXpath = "//XCUIElementTypeOther[@name=\"editTextPhone\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField"
    )

    val buttonGetCode = LocatorElement(
        androidLocatorType = LocatorType.ID,
        androidId = "ru.sportmaster.app.handh.dev:id/buttonGetCode",

        iosLocatorType = LocatorType.IOS_ACCESSIBILITY_ID,
        iosAccessibilityId = "buttonGetCode",
        iosXpath = "//XCUIElementTypeButton[@name=\"buttonGetCode\"]"
    )
}