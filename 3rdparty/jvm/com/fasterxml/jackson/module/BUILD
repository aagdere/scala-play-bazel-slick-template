load("@io_bazel_rules_scala//scala:scala_import.bzl", "scala_import")
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



java_library(
    name = "jackson_module_scala_2_13",
    exports = [
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_annotations",
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_core",
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_databind",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//external:jar/com/fasterxml/jackson/module/jackson_module_scala_2_13",
        ":jackson_module_paranamer"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)


