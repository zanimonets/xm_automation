plugins {
    id("java")
}

group = "org.xm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.23.1")
    implementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    implementation("org.slf4j:slf4j-api:2.0.13")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    implementation("org.aeonbits.owner:owner:1.0.12")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")

    testImplementation("org.testng:testng:7.7.1")
    testImplementation("io.rest-assured:rest-assured:5.3.0")
    testImplementation("org.assertj:assertj-core:3.26.3")

    implementation("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
    testImplementation("org.projectlombok:lombok:1.18.24")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.24")

    implementation("io.rest-assured:rest-assured:5.4.0")
    testImplementation("io.rest-assured:json-schema-validator:5.4.0")
    testImplementation("io.rest-assured:json-path:5.4.0")
}

tasks.register<Test>("apiTests") {
    useTestNG {
        suites("src/test/resources/test-suite-api.xml")
    }
    group = "verification"
    description = "Runs the API tests"
}

tasks.register<Test>("uiTests") {
    useTestNG {
        suites("src/test/resources/test-suite-ui.xml")
    }
    group = "verification"
    description = "Runs the UI tests"
}

tasks.test {
    useTestNG()
}

