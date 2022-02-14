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
	implementation("org.apache.tomcat:tomcat-servlet-api:10.0.16")
	implementation("org.apache.tomcat:tomcat-jasper:10.0.16")
	//implementation("org.apache.tomee:apache-tomee:9.0.0-M")
	implementation("org.hibernate:hibernate-core-jakarta:5.6.5.Final")
	implementation("mysql:mysql-connector-java:8.0.28")
}

