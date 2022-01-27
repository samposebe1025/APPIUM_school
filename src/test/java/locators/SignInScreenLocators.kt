package locators

import constructor.classes.LocatorElement
import constructor.classes.LocatorType

class SignInScreenLocators {

    val buttonSignIn = LocatorElement(
        androidLocatorType = LocatorType.ID,
        androidId = "ru.sportmaster.app.handh.dev:id/buttonSignIn",

        iosLocatorType = LocatorType.IOS_ACCESSIBILITY_ID,
        iosAccessibilityId = "buttonSignIn"
    )

}