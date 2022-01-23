package locators

import constructor.classes.LocatorElement
import constructor.classes.LocatorType

class GeoPermissionScreenLocators {

    val buttonDeny = LocatorElement(
        locatorType = LocatorType.ID,
        androidId = "com.android.packageinstaller:id/permission_deny_button"
    )

}