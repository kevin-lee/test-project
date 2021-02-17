import Dependencies._

ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.13.3"
ThisBuild / version      := "0.1.2"

//ThisBuild / logLevel := Level.Debug


lazy val GitHubUsername = "Kevin-Lee"
lazy val GitHubRepoName = "test-project"

lazy val root = (project in file("."))
  .enablePlugins(DevOopsGitHubReleasePlugin, DevOopsScalaPlugin, GitHubPagesPlugin)
  .settings(
    name := GitHubRepoName,
    //scalacOptions := Seq("-Xfatal-warnings"),
//    wartremoverErrors ++= Warts.all,
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % "7.3.1",
      "org.typelevel" %% "cats-core" % "2.3.1",
      "io.kevinlee" %% "just-fp" % "1.3.5"
    ),
    useAggressiveScalacOptions := true,
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.2" cross CrossVersion.full),
//    devOopsLogLevel := "debug",
    devOopsGitTagFrom := "some-branch",
    gitHubPagesOrgName := GitHubUsername,
    gitHubPagesRepoName := GitHubRepoName,
    gitHubPagesSiteDir := baseDirectory.value / "website/build"
  )
