package locators

import constructor.classes.LocatorElement
import constructor.classes.LocatorType

class EditProfileScreenLocators {

    val buttonLogout = LocatorElement(
        androidLocatorType = LocatorType.TEXT,
        androidId = "ru.sportmaster.app.handh.dev:id/buttonLogout",
        text = "Выйти из профиля",

        iosLocatorType = LocatorType.IOS_ACCESSIBILITY_ID,
        iosAccessibilityId = "buttonLogout"
    )

}