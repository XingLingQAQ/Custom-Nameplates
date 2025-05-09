pluginManagement {
    repositories {
        maven(https://repo1.maven.org/)
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
rootProject.name = "CustomNameplates"
include(":api")
include(":backend")
include(":platforms:bukkit")
include(":platforms:bukkit:compatibility")
//include(":platforms:sponge")
