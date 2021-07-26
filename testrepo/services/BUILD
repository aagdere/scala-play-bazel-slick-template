load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_test")
load("@rules_intellij_generate//:def.bzl", "intellij_module")

scala_library(
    name = "services",
    srcs = ["src/main/scala/com/armeneum/testrepo/SlickTestRepository.scala"],
    visibility = ["//visibility:public"],
    deps = ["//testrepo/api"],
)

scala_test(
    name = "tests",
    srcs = ["src/test/scala/com/armeneum/testrepo/SlickTestRepositorySpec.scala"],
    visibility = ["//visibility:public"],
    deps = [":services"],
)

intellij_module(
    name = "testrepo_services_iml",
    iml_type = "scala-simple",
    visibility = ["//visibility:public"],
)
