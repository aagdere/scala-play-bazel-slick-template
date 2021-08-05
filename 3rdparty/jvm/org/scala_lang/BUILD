load("@io_bazel_rules_scala//scala:scala_import.bzl", "scala_import")
java_library(
    name = "scala_compiler",
    exports = [
        "//3rdparty/jvm/net/java/dev/jna:jna",
        "//3rdparty/jvm/org/jline:jline",
        "//external:jar/org/scala_lang/scala_compiler",
        ":scala_library",
        ":scala_reflect"
    ],
    visibility = [
        "//visibility:public"
    ]
)



java_library(
    name = "scala_library",
    exports = [
        "//external:jar/org/scala_lang/scala_library"
    ],
    visibility = [
        "//visibility:public"
    ]
)



java_library(
    name = "scala_reflect",
    exports = [
        "//external:jar/org/scala_lang/scala_reflect",
        ":scala_library"
    ],
    visibility = [
        "//visibility:public"
    ]
)


