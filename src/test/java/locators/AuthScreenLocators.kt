package locators

import constructor.classes.LocatorElement
import constructor.classes.LocatorType

class AuthScreenLocators {

    val textEditPhoneNumber = LocatorElement(
        locatorType = LocatorType.ID,
        androidId = "ru.sportmaster.app.handh.dev:id/editTextPhone"
    )

    val buttonGetCode = LocatorElement(
        locatorType = LocatorType.ID,
        androidId = "ru.sportmaster.app.handh.dev:id/buttonGetCode"
    )
}