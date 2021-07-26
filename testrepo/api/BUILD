load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_test")
load("@rules_intellij_generate//:def.bzl", "intellij_module")

scala_library(
    name = "api",
    srcs = ["src/main/scala/com/armeneum/testrepo/TestRepository.scala"],
    visibility = ["//visibility:public"],
    deps = ["//testrepo/models"],
)

intellij_module(
    name = "testrepo_api_iml",
    iml_type = "scala-simple",
    visibility = ["//visibility:public"],
)
