import com.delbel.Presentation

plugins {
    id("com.android.application")
    id("com.delbel.android.library")
}

android {
    defaultConfig.applicationId = "com.delbel.droid.chart.testapp"

    buildFeatures.viewBinding = true
}

dependencies {
    implementation(Presentation.appCompat)
    implementation(Presentation.material)
}
