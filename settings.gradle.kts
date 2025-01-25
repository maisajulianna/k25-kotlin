plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "kotlin"
findProject(":src:wk1:study-register")?.name = "study-register"
include("class")
include("study-register2")
