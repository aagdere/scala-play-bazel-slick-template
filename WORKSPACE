# WORKSPACE
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

skylib_version = "1.0.3"

http_archive(
    name = "bazel_skylib",
    sha256 = "1c531376ac7e5a180e0237938a2536de0c54d93f5c278634818e0efc952dd56c",
    type = "tar.gz",
    url = "https://mirror.bazel.build/github.com/bazelbuild/bazel-skylib/releases/download/{}/bazel-skylib-{}.tar.gz".format(skylib_version, skylib_version),
)

rules_scala_version = "5df8033f752be64fbe2cedfd1bdbad56e2033b15"

http_archive(
    name = "io_bazel_rules_scala",
    sha256 = "b7fa29db72408a972e6b6685d1bc17465b3108b620cb56d9b1700cf6f70f624a",
    strip_prefix = "rules_scala-%s" % rules_scala_version,
    type = "zip",
    url = "https://github.com/bazelbuild/rules_scala/archive/%s.zip" % rules_scala_version,
)

# Stores Scala version and other configuration
# 2.12 is a default version, other versions can be use by passing them explicitly:
load("@io_bazel_rules_scala//:scala_config.bzl", "scala_config")

scala_config(scala_version = "2.13.6")

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_repositories")

scala_repositories()

register_toolchains("//build:scala_toolchain")

# optional: setup ScalaTest toolchain and dependencies
load("@io_bazel_rules_scala//testing:scalatest.bzl", "scalatest_repositories", "scalatest_toolchain")

scalatest_repositories()

scalatest_toolchain()

load("//3rdparty:workspace.bzl", "maven_dependencies")

maven_dependencies()

load("//3rdparty:target_file.bzl", "build_external_workspace")

build_external_workspace(name = "third_party")

# IntelliJ generator
local_repository(
    name = "rules_intellij_generate",
    path = "../rules_intellij_generate/rules",
)

# update version as needed
rules_play_routes_version = "bfaca5f186f2c3b989c80fd00f37a53b84406b3d"

http_archive(
    name = "io_bazel_rules_play_routes",
    sha256 = "b0ae17af402e88da31fa41b16a6cf1d8eea53d693dd6b4c0c219d421078a2af5",
    strip_prefix = "rules_play_routes-{}".format(rules_play_routes_version),
    type = "zip",
    url = "https://github.com/lucidsoftware/rules_play_routes/archive/{}.zip".format(rules_play_routes_version),
)

RULES_JVM_EXTERNAL_TAG = "2.9"

http_archive(
    name = "rules_jvm_external",
    sha256 = "e5b97a31a3e8feed91636f42e19b11c49487b85e5de2f387c999ea14d77c7f45",
    strip_prefix = "rules_jvm_external-{}".format(RULES_JVM_EXTERNAL_TAG),
    type = "zip",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/{}.zip".format(RULES_JVM_EXTERNAL_TAG),
)

load("@io_bazel_rules_play_routes//:workspace.bzl", "play_routes_repositories")

play_routes_repositories("2.7")

load("@play_routes//:defs.bzl", play_routes_pinned_maven_install = "pinned_maven_install")

play_routes_pinned_maven_install()

bind(
    name = "default-play-routes-compiler-cli",
    actual = "@io_bazel_rules_play_routes//default-compiler-clis:scala_2_12_play_2_7",
)
