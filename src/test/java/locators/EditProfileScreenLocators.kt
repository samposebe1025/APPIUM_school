package locators

import constructor.classes.LocatorElement
import constructor.classes.LocatorType

class EditProfileScreenLocators {

    val buttonLogout = LocatorElement(
        locatorType = LocatorType.TEXT,
        androidId = "ru.sportmaster.app.handh.dev:id/buttonLogout",
        text = "Выйти из профиля"
    )

}