load("@io_bazel_rules_scala//scala:scala_import.bzl", "scala_import")
java_library(
    name = "akka_actor_2_13",
    exports = [
        "//3rdparty/jvm/com/typesafe:config",
        "//3rdparty/jvm/org/scala_lang/modules:scala_java8_compat_2_13",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//external:jar/com/typesafe/akka/akka_actor_2_13"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "akka_actor_typed_2_13",
    exports = [
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//3rdparty/jvm/org/slf4j:slf4j_api",
        "//external:jar/com/typesafe/akka/akka_actor_typed_2_13",
        ":akka_actor_2_13",
        ":akka_slf4j_2_13"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



scala_import(
    name = "akka_http",
    exports = [
        "//3rdparty/jvm/org/scala_lang:scala_library",
        ":akka_http_core_2_13"
    ],
    jars = [
        "//external:jar/com/typesafe/akka/akka_http_2_13"
    ],
    visibility = [
        "//visibility:public"
    ]
)



java_library(
    name = "akka_http_core_2_13",
    exports = [
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//external:jar/com/typesafe/akka/akka_http_core_2_13",
        ":akka_parsing_2_13"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "akka_parsing_2_13",
    exports = [
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//external:jar/com/typesafe/akka/akka_parsing_2_13"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "akka_protobuf_v3_2_13",
    exports = [
        "//external:jar/com/typesafe/akka/akka_protobuf_v3_2_13"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "akka_serialization_jackson_2_13",
    exports = [
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_annotations",
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_core",
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_databind",
        "//3rdparty/jvm/com/fasterxml/jackson/dataformat:jackson_dataformat_cbor",
        "//3rdparty/jvm/com/fasterxml/jackson/datatype:jackson_datatype_jdk8",
        "//3rdparty/jvm/com/fasterxml/jackson/datatype:jackson_datatype_jsr310",
        "//3rdparty/jvm/com/fasterxml/jackson/module:jackson_module_parameter_names",
        "//3rdparty/jvm/com/fasterxml/jackson/module:jackson_module_scala_2_13",
        "//3rdparty/jvm/org/lz4:lz4_java",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//external:jar/com/typesafe/akka/akka_serialization_jackson_2_13",
        ":akka_actor_2_13"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "akka_slf4j_2_13",
    exports = [
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//3rdparty/jvm/org/slf4j:slf4j_api",
        "//external:jar/com/typesafe/akka/akka_slf4j_2_13",
        ":akka_actor_2_13"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "akka_stream_2_13",
    exports = [
        "//3rdparty/jvm/com/typesafe:ssl_config_core_2_13",
        "//3rdparty/jvm/org/reactivestreams:reactive_streams",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//external:jar/com/typesafe/akka/akka_stream_2_13",
        ":akka_actor_2_13",
        ":akka_protobuf_v3_2_13"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)


