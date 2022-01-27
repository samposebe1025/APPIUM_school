package locators

import constructor.classes.LocatorElement
import constructor.classes.LocatorType

class GeoPermissionScreenLocators {

    val buttonDeny = LocatorElement(
        androidLocatorType = LocatorType.ID,
        androidId = "com.android.packageinstaller:id/permission_deny_button",

        iosLocatorType = LocatorType.IOS_XPATH,
        iosXpath = "//XCUIElementTypeButton[@name=\"Don’t Allow\"]"
    )

    val buttonDontAllow = LocatorElement(
        iosLocatorType = LocatorType.IOS_XPATH,
        iosXpath = "//XCUIElementTypeButton[@name=\"Don’t Allow\"]"
    )

}