pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url 'https://maven.aliyun.com/repository/gradle-plugin' }
    }
}
rootProject.name = "CustomNameplates"
include(":api")
include(":backend")
include(":platforms:bukkit")
include(":platforms:bukkit:compatibility")
//include(":platforms:sponge")
