package locators

import constructor.classes.LocatorElement
import constructor.classes.LocatorType

class TabBarScreenLocators {

    val buttonProfile = LocatorElement(
        androidLocatorType = LocatorType.ID,
        androidId = "ru.sportmaster.app.handh.dev:id/profile_graph",

        iosLocatorType = LocatorType.IOS_XPATH,
        iosXpath = "//XCUIElementTypeButton[@name=\"profile_graph\"]"

    )

}