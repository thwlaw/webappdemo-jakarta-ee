/*
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our samples at https://docs.gradle.org/7.3.3/samples
 */

plugins {
	java
	war
}


repositories {
	mavenCentral()
}


dependencies {
	compileOnly("jakarta.servlet:jakarta.servlet-api:5.0.0")
	compileOnly("jakarta.servlet.jsp:jakarta.servlet.jsp-api:3.0.0")
	compileOnly("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:2.0.0")
	compileOnly("org.apache.johnzon:johnzon-jsonb:1.2.16")
	compileOnly("org.apache.johnzon:johnzon-jaxrs:1.2.16")
	compileOnly("org.apache.johnzon:johnzon-mapper:1.2.16")
	compileOnly("jakarta.ejb:jakarta.ejb-api:4.0.0")
	implementation("jakarta.ws.rs:jakarta.ws.rs-api:3.0.0")
	implementation("org.hibernate:hibernate-core-jakarta:5.6.5.Final")
	implementation("mysql:mysql-connector-java:8.0.28")
}

