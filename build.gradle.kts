plugins {
    id("java")
}

group = "ru.stepup"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("io.rest-assured:rest-assured:5.5.6")
    testImplementation("org.assertj:assertj-core:3.27.7")
}

tasks.test {
    useJUnitPlatform() //запускает все тесты в проекте
}

tasks.register<Test>("firstTask") {
    group = "autotests"
    description = "Запуск тестов с тегами: Parameter, Repeat"
    useJUnitPlatform{
        includeTags("Parameter","Repeat")
    }

    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}

tasks.register<Test>("secondTask") {
    group = "autotests"
    description = "Запускает тесты с тегом Smoke. Выводит сообщение после завершения всех тестов"
    useJUnitPlatform{
        includeTags("Smoke")
    }
    dependsOn("firstTask")
    doLast {
        println("Test run is over")
    }
}
defaultTasks("secondTask")
