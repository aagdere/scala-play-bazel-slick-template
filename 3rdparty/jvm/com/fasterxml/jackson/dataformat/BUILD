load("@io_bazel_rules_scala//scala:scala_import.bzl", "scala_import")
load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_binary", "scala_test")
java_library(
    name = "jackson_dataformat_cbor",
    exports = [
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_core",
        "//external:jar/com/fasterxml/jackson/dataformat/jackson_dataformat_cbor"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)


