import com.sksamuel.scapegoat.sbt.ScapegoatSbtPlugin.autoImport._
import sbtsonar.SonarPlugin.autoImport.sonarProperties

name := "vasar-commons"
organization := "com.capitalone.vasar"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  ("com.capitalone.sdp" %% "sdp-sdk-scala" % "5.6.3")
    .exclude("com.fasterxml.jackson.core", "jackson-databind")
    .exclude("com.fasterxml.jackson.core", "jackson-core")
    .exclude("com.google.guava", "guava")
    .exclude("io.netty", "netty-all")
    .exclude("org.apache.commons", "commons-compress")
    .exclude("org.bouncycastle", "bcprov-jdk15on"),
  "com.capitalone.sdp" %% "stream-poc-sink-deserializer" % "20210824-420edad",
  "com.capitalone.sdp" %% "stream-poc-common" % "20210824-420edad",
  "com.capitalone.sdp" %% "stream-poc-sink-kafka-deserializer" % "20210824-420edad",
  "org.bouncycastle" % "bcprov-jdk15on" % "1.64",
  "com.typesafe" % "config" % "1.3.2",
  "org.slf4j" % "slf4j-api" % "1.7.25",
  "com.sksamuel.avro4s" %% "avro4s-core" % "3.0.4",
  "org.http4s" %% "http4s-dsl" % "0.18.26",
  "org.http4s" %% "http4s-blaze-server" % "0.18.26",
  "org.http4s" %% "http4s-blaze-client" % "0.18.26",
  "org.http4s" %% "http4s-circe" % "0.18.26",
  ("com.amazonaws" % "aws-java-sdk-s3" % "1.11.444")
    .exclude("com.fasterxml.jackson.core", "jackson-databind")
    .exclude("com.fasterxml.jackson.core", "jackson-core")
    .exclude("commons-codec", "commons-codec"),
  ("com.amazonaws" % "aws-java-sdk-sqs" % "1.11.444")
    .exclude("com.fasterxml.jackson.core", "jackson-databind")
    .exclude("com.fasterxml.jackson.core", "jackson-core")
    .exclude("commons-codec", "commons-codec"),
  ("com.amazonaws" % "aws-java-sdk-kinesisvideo" % "1.11.700")
    .exclude("com.fasterxml.jackson.core", "jackson-databind")
    .exclude("com.fasterxml.jackson.core", "jackson-core")
    .exclude("com.google.guava", "guava")
    .exclude("io.netty", "netty-codec")
    .exclude("commons-codec", "commons-codec")
    .exclude("com.fasterxml.jackson.dataformat", "jackson-dataformat-cbor"),
  ("com.amazonaws" % "amazon-kinesis-video-streams-parser-library" % "1.0.15")
    .exclude("com.fasterxml.jackson.core", "jackson-databind")
    .exclude("com.fasterxml.jackson.core", "jackson-core")
    .exclude("com.google.guava", "guava")
    .exclude("commons-codec", "commons-codec"),
  ("com.amazonaws" % "aws-java-sdk-kms" % "1.11.1034")
    .exclude("com.fasterxml.jackson.dataformat", "jackson-dataformat-cbor"),
  "org.json4s" %% "json4s-core" % "3.6.7",
  ("org.json4s" %% "json4s-jackson" % "3.6.7")
    .exclude("com.fasterxml.jackson.core", "jackson-databind")
    .exclude("com.fasterxml.jackson.core", "jackson-core"),
  "org.json4s" %% "json4s-ext" % "3.6.7",
  "com.google.guava" % "guava" % "32.1.2-jre",
  "com.datadoghq" % "java-dogstatsd-client" % "2.6.1",
  "org.scalaj" %% "scalaj-http" % "2.3.0",
  "org.postgresql" % "postgresql" % "42.3.3",
  "hikari-cp" % "hikari-cp" % "1.7.3",
  "io.grpc" % "grpc-netty-shaded" % scalapb.compiler.Version.grpcJavaVersion,
  ("com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion)
    .exclude("com.google.guava", "guava"),
  ("com.capitalone.fs" % "secret-sauce" % "1.1.12")
    .exclude("com.fasterxml.jackson.core", "jackson-databind")
    .exclude("commons-codec", "commons-codec"),
  "javax.mail" % "mail" % "1.4.7",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.13.2",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.13.4",
  "org.apache.logging.log4j" % "log4j-api" % "2.17.1",
  "org.apache.logging.log4j" % "log4j-core" % "2.17.1",
  "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.17.1",
  "io.netty" % "netty-all" % "4.1.77.Final",
  "io.netty" % "netty-codec" % "4.1.71.Final",
  "commons-codec" % "commons-codec" % "1.15",
  "junit" % "junit" % "4.12" % "test",
  "io.github.embeddedkafka" %% "embedded-kafka" % "2.3.1" % "test",
  ("io.github.embeddedkafka" %% "embedded-kafka-schema-registry" % "5.3.1" % "test")
    .exclude("com.fasterxml.jackson.core", "jackson-databind")
    .exclude("com.fasterxml.jackson.core", "jackson-core"),
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.scalamock" %% "scalamock" % "4.1.0" % "test",
  ("com.github.tomakehurst" % "wiremock-jre8" % "2.25.1" % "test")
    .exclude("com.fasterxml.jackson.core", "jackson-databind")
    .exclude("com.fasterxml.jackson.core", "jackson-core")
    .exclude("org.eclipse.jetty.http2", "http2-common"),
  "org.eclipse.jetty.http2" % "http2-common" % "9.4.26.v20200117" % "test",
  "org.jvnet.mock-javamail" % "mock-javamail" % "1.9" % "test"
)

//Adding blanket exclusions for dependencies that are not being identified by WhiteSource's compositional scan
excludeDependencies ++= Seq(
  ExclusionRule("log4j", "log4j"),
  ExclusionRule("org.slf4j", "slf4j-log4j12")
)

// Required for Eratocode third party library scans - creates copy of dependencies within local project directory
retrieveManaged := true

parallelExecution in Test := false

updateOptions := updateOptions.value.withGigahorse(false)

publishTo := Some("Artifactory Realm" at "https://artifactory.cloud.capitalone.com/artifactory/maven-internalfacing")
// The Artifactory username and password environment vars here need to match https://github.cloud.capitalone.com/bogie/jenkins-pipeline-library/blob/master/vars/publishArtifacts.groovy#L140-L141
credentials += Credentials("Artifactory Realm", "artifactory.cloud.capitalone.com", sys.env.getOrElse("ARTIFACTORY_CREDS_USR", "USER"), sys.env.getOrElse("ARTIFACTORY_CREDS_PSW", "PASSWORD"))

coverageEnabled in(Test, compile) := true
coverageMinimum := 75
coverageFailOnMinimum := false
scapegoatVersion in ThisBuild := "1.3.2"

sonarProperties := Map(
  "sonar.projectName" -> "vasar-commons",
  "sonar.projectKey" -> "vasar-commons",
  "sonar.host.url" -> "https://sonar.cloud.capitalone.com",
  "sonar.sources" -> "src/main/scala",
  "sonar.sourceEncoding" -> "UTF-8",
  "sonar.scoverage.reportPath" -> "target/scala-2.12/scoverage-report/scoverage.xml",
  "sonar.scala.scapegoat.reportPath" -> "target/scala-2.12/scapegoat-report/scapegoat.xml"
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}