import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.13"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    jacoco
}

group = "com.cyber"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

jacoco {
    toolVersion = "0.8.7"
    reportsDirectory.set(layout.buildDirectory.dir("jacocoReports"))
}

val excludePackages: Iterable<String> = listOf(
    "**/com/cyber/contentmanagerservice/application/config/**",
    "**/com/cyber/contentmanagerservice/domain/entities/**"
)

extra["excludePackages"] = excludePackages

tasks.jacocoTestReport {
    reports {
        xml.required.set(false)
        csv.required.set(false)
        html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
    }

    classDirectories.setFrom(
        sourceSets.main.get().output.asFileTree.matching {
            exclude(excludePackages)
        }
    )
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                minimum = 0.6.toBigDecimal()
            }
        }
    }

    classDirectories.setFrom(
        sourceSets.main.get().output.asFileTree.matching {
            exclude(excludePackages)
        }
    )

    mustRunAfter(tasks["jacocoTestReport"])
}

dependencies {

    // Kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Web
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.12")

    // Database
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("com.ninja-squad:springmockk:3.1.1")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
