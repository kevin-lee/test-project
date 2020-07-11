import Dependencies._

ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.13.3"
ThisBuild / version      := "0.1.0"

lazy val GitHubUsername = "Kevin-Lee"
lazy val GitHubRepoName = "test-project"

lazy val root = (project in file("."))
  .enablePlugins(DevOopsGitReleasePlugin, GitHubPagesPlugin)
  .settings(
    name := GitHubRepoName,
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % "7.3.1",
      "org.typelevel" %% "cats-core" % "2.1.1",
      "io.kevinlee" %% "just-fp" % "1.3.5"
    ),
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full),
    gitHubPagesOrgName := GitHubUsername,
    gitHubPagesRepoName := GitHubRepoName,
    gitHubPagesSiteDir := baseDirectory.value / s"website/build/$GitHubRepoName"
  )
