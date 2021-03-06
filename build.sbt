sbtPlugin              := true

name                   := "sbt-jflex"

organization           := "de.sciss"

version                := "0.3.0"

scalaVersion in Global := "2.10.3"

sbtVersion   in Global := "0.13.0"

scalacOptions          := Seq("-deprecation", "-unchecked", "-feature")

description            := "An sbt plugin that generates code based on a JFlex specification"

homepage               := Some(url("https://github.com/Sciss/" + name.value))

licenses               := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

// ---- publishing ----

publishMavenStyle := true

publishTo :=
  Some(if (version.value endsWith "-SNAPSHOT")
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
  )

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := { val n = name.value
<scm>
  <url>git@github.com:Sciss/{n}.git</url>
  <connection>scm:git:git@github.com:Sciss/{n}.git</connection>
</scm>
<developers>
  <developer>
    <id>stefri</id>
    <name>Steffen Fritzsche</name>
    <url>http://scriptroom.de/</url>
  </developer>
  <developer>
    <id>sciss</id>
    <name>Hanns Holger Rutz</name>
    <url>http://www.sciss.de</url>
  </developer>
</developers>
}

// ---- ls.implicit.ly ----

seq(lsSettings :_*)

(LsKeys.tags   in LsKeys.lsync) := Seq("sbt", "plugin", "jflex", "lexer")

(LsKeys.ghUser in LsKeys.lsync) := Some("Sciss")

(LsKeys.ghRepo in LsKeys.lsync) := Some(name.value)

