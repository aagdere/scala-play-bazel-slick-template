load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_test")
load("@rules_intellij_generate//:def.bzl", "intellij_module")

scala_library(
    name = "models",
    srcs = ["src/main/scala/com/armeneum/testrepo/package.scala"],
    visibility = ["//visibility:public"],
    deps = [],
)

intellij_module(
    name = "testrepo_models_iml",
    iml_type = "scala-simple",
    visibility = ["//visibility:public"],
)
