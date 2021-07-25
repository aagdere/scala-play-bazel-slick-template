load("@io_bazel_rules_scala//scala:scala_import.bzl", "scala_import")
load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_binary", "scala_test")
java_library(
    name = "guice_assistedinject",
    exports = [
        "//3rdparty/jvm/com/google/inject:guice",
        "//external:jar/com/google/inject/extensions/guice_assistedinject"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)


