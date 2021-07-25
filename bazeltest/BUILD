load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_test")
load("@rules_intellij_generate//:def.bzl", "intellij_module")

scala_library(
    name = "bazeltest",
    srcs = ["src/main/scala/bazeltest/Main.scala"],
    visibility = ["//visibility:public"],
    deps = [
        "//3rdparty/jvm/joda_time",
        "//othermodule",
    ],
)

scala_test(
    name = "tests",
    srcs = ["src/test/scala/bazeltest/MainSpec.scala"],
    visibility = ["//visibility:public"],
    deps = [":bazeltest"],
)

intellij_module(
    name = "bazeltest_iml",
    iml_type = "scala-simple",
    visibility = ["//visibility:public"],
)
