package locators

import constructor.classes.LocatorType
import constructor.classes.LocatorElement

class OnboardScreenLocators {
    val buttonExit = LocatorElement(
        androidLocatorType = LocatorType.ANDROID_XPATH,
        androidXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton",

        iosLocatorType = LocatorType.IOS_ACCESSIBILITY_ID,
        iosAccessibilityId = "closeButton",
        iosXpath = "//XCUIElementTypeButton[@name=\"closeButton\"]"
    )
}