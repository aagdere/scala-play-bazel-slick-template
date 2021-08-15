load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_test")
load("@rules_intellij_generate//:def.bzl", "intellij_module")

scala_library(
    name = "db",
    srcs = ["src/main/scala/com/armeneum/db/SlickPgPostgresProfile.scala"],
    visibility = ["//visibility:public"],
    deps = [
        "//3rdparty/jvm/com/github/tminglei:slick_pg",
    ],
)

intellij_module(
    name = "db_iml",
    iml_type = "scala-simple",
    visibility = ["//visibility:public"],
)
