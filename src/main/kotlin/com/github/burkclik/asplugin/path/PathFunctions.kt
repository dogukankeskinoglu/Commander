package com.github.burkclik.asplugin.path

fun getFullPathTerminalCommand(absolutePath: String, functionName: String): String {
    return listOf(
        getGradlePath(),
        getUIPath(),
        convertToReference(absolutePath, functionName),
        getAppRegionPath()
    ).joinToString(" ")
}

fun getGradlePath(): String {
    return "./gradlew ui-test:regression-tests:connectedDebugAndroidTest"
}

fun getUIPath(): String {
    return "-Pcom.trendyol.regressiontests=true -Pcom.trendyol.includeuitests=true"
}

fun getAppRegionPath(): String {
    return "-Pcom.trendyol.appregion=Turkey"
}

fun convertToReference(absolutePath: String, functionName: String): String {
    val reference = "com" + absolutePath
        .replace('/', '.')
        .substringAfter(".com")
        .substringBefore(".kt")
        .plus("#${functionName}")
    return "-Pandroid.testInstrumentationRunnerArguments.class=$reference"
}