package locators

import constructor.classes.LocatorElement
import constructor.classes.LocatorType

class ProfileScreenLocators {

    val buttonEditProfile = LocatorElement(
        androidLocatorType = LocatorType.ID,
        androidId = "ru.sportmaster.app.handh.dev:id/buttonEditProfile",

        iosLocatorType = LocatorType.IOS_ACCESSIBILITY_ID,
        iosAccessibilityId = "profile_graph"
    )

}