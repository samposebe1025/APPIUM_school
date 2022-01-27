package locators

import constructor.classes.LocatorElement
import constructor.classes.LocatorType

class CityScreenLocators {

    val recyclerFirstElement = LocatorElement(
        androidLocatorType = LocatorType.ANDROID_XPATH,
        androidXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ViewFlipper/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]",

        iosLocatorType = LocatorType.IOS_XPATH,
        iosXpath = "//XCUIElementTypeApplication[@name=\"sportmaster\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther"
    )

}