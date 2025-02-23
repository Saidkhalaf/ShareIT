plugins {
    java
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "org.example"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

springBoot {
    mainClass.set("be.kdg.Main")
}

configurations {
    create("cucumberRuntime") {
        extendsFrom(configurations["testImplementation"])
    }
}

tasks.register<JavaExec>("cucumber") {
    dependsOn(tasks.assemble, tasks.compileTestJava)
    mainClass.set("io.cucumber.core.cli.Main")
    classpath = configurations["cucumberRuntime"] +
            sourceSets["main"].output +
            sourceSets["test"].output
    args = listOf(
        "--plugin", "pretty",
        "--glue", "be.kdg.Main",
        "src/test/resources"
    )
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation(platform("org.junit:junit-bom:5.9.3"))
    testImplementation(platform("io.cucumber:cucumber-bom:7.14.0"))
    testImplementation("org.junit.platform:junit-platform-suite")
    testImplementation("io.cucumber:cucumber-java")
    testImplementation("io.cucumber:cucumber-junit")
    testImplementation("io.cucumber:cucumber-junit-platform-engine")
    testImplementation("io.cucumber:cucumber-spring")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter")
    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}

tasks.test {
    useJUnitPlatform()
    jvmArgs("-XX:+EnableDynamicAgentLoading") // vermijdt een aantal warnings voor Java 21
    systemProperty("cucumber.junit-platform.naming-strategy", "long") // maakt rapporten leesbaarder
}