package locators

import constructor.classes.LocatorElement
import constructor.classes.LocatorType

class PinCodeScreenLocators {

    val textEditPinCode = LocatorElement(
        androidLocatorType = LocatorType.ID,
        androidId = "ru.sportmaster.app.handh.dev:id/pinCodeEditText",

        iosLocatorType = LocatorType.IOS_ACCESSIBILITY_ID,
        androidAccessibilityId = "pinCodeEditText",
        iosXpath = "//XCUIElementTypeTextField[@name=\"pinCodeEditText\"]"
    )

}