load("@io_bazel_rules_scala//scala:scala_import.bzl", "scala_import")
load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_binary", "scala_test")
java_library(
    name = "jackson_module_parameter_names",
    exports = [
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_core",
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_databind",
        "//external:jar/com/fasterxml/jackson/module/jackson_module_parameter_names"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "jackson_module_paranamer",
    exports = [
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_databind",
        "//3rdparty/jvm/com/thoughtworks/paranamer:paranamer",
        "//external:jar/com/fasterxml/jackson/module/jackson_module_paranamer"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



scala_import(
    name = "jackson_module_scala",
    exports = [
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_annotations",
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_core",
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_databind",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        ":jackson_module_paranamer"
    ],
    jars = [
        "//external:jar/com/fasterxml/jackson/module/jackson_module_scala_2_12"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)


