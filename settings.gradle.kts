plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "kotlinIntro2"
include("wk1")
include("src:wk1:study-register")
findProject(":src:wk1:study-register")?.name = "study-register"
include("src:study")
findProject(":src:study")?.name = "study"
include("study2")
