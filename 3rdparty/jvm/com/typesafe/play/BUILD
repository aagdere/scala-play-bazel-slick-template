load("@io_bazel_rules_scala//scala:scala_import.bzl", "scala_import")
java_library(
    name = "build_link",
    exports = [
        "//external:jar/com/typesafe/play/build_link",
        ":play_exceptions"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



scala_import(
    name = "filters_helpers",
    exports = [
        "//3rdparty/jvm/org/scala_lang:scala_library",
        ":play"
    ],
    jars = [
        "//external:jar/com/typesafe/play/filters_helpers_2_13"
    ],
    visibility = [
        "//visibility:public"
    ]
)



scala_import(
    name = "play",
    exports = [
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_annotations",
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_core",
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_databind",
        "//3rdparty/jvm/com/fasterxml/jackson/datatype:jackson_datatype_jdk8",
        "//3rdparty/jvm/com/fasterxml/jackson/datatype:jackson_datatype_jsr310",
        "//3rdparty/jvm/com/google/guava:guava",
        "//3rdparty/jvm/com/typesafe/akka:akka_actor_2_13",
        "//3rdparty/jvm/com/typesafe/akka:akka_actor_typed_2_13",
        "//3rdparty/jvm/com/typesafe/akka:akka_serialization_jackson_2_13",
        "//3rdparty/jvm/com/typesafe/akka:akka_slf4j_2_13",
        "//3rdparty/jvm/com/typesafe:ssl_config_core_2_13",
        "//3rdparty/jvm/io/jsonwebtoken:jjwt",
        "//3rdparty/jvm/jakarta/transaction:jakarta_transaction_api",
        "//3rdparty/jvm/jakarta/xml/bind:jakarta_xml_bind_api",
        "//3rdparty/jvm/javax/inject:javax_inject",
        "//3rdparty/jvm/org/scala_lang/modules:scala_java8_compat_2_13",
        "//3rdparty/jvm/org/scala_lang/modules:scala_parser_combinators_2_13",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//3rdparty/jvm/org/slf4j:jcl_over_slf4j",
        "//3rdparty/jvm/org/slf4j:jul_to_slf4j",
        "//3rdparty/jvm/org/slf4j:slf4j_api",
        ":build_link",
        ":play_json_2_13",
        ":play_streams_2_13",
        ":twirl_api_2_13"
    ],
    jars = [
        "//external:jar/com/typesafe/play/play_2_13"
    ],
    visibility = [
        "//visibility:public"
    ]
)



scala_import(
    name = "play_akka_http_server",
    exports = [
        "//3rdparty/jvm/com/typesafe/akka:akka_http_core_2_13",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        ":play_server",
        ":play_streams_2_13"
    ],
    jars = [
        "//external:jar/com/typesafe/play/play_akka_http_server_2_13"
    ],
    visibility = [
        "//visibility:public"
    ]
)



java_library(
    name = "play_exceptions",
    exports = [
        "//external:jar/com/typesafe/play/play_exceptions"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "play_functional_2_13",
    exports = [
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//external:jar/com/typesafe/play/play_functional_2_13"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



scala_import(
    name = "play_guice",
    exports = [
        "//3rdparty/jvm/com/google/inject/extensions:guice_assistedinject",
        "//3rdparty/jvm/com/google/inject:guice",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        ":play"
    ],
    jars = [
        "//external:jar/com/typesafe/play/play_guice_2_13"
    ],
    visibility = [
        "//visibility:public"
    ]
)



java_library(
    name = "play_json_2_13",
    exports = [
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_annotations",
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_core",
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_databind",
        "//3rdparty/jvm/com/fasterxml/jackson/datatype:jackson_datatype_jdk8",
        "//3rdparty/jvm/com/fasterxml/jackson/datatype:jackson_datatype_jsr310",
        "//3rdparty/jvm/joda_time:joda_time",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//3rdparty/jvm/org/scala_lang:scala_reflect",
        "//external:jar/com/typesafe/play/play_json_2_13",
        ":play_functional_2_13"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



scala_import(
    name = "play_logback",
    exports = [
        "//3rdparty/jvm/ch/qos/logback:logback_classic",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        ":play"
    ],
    jars = [
        "//external:jar/com/typesafe/play/play_logback_2_13"
    ],
    visibility = [
        "//visibility:public"
    ]
)



scala_import(
    name = "play_server",
    exports = [
        "//3rdparty/jvm/org/scala_lang:scala_library",
        ":play"
    ],
    jars = [
        "//external:jar/com/typesafe/play/play_server_2_13"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "play_streams_2_13",
    exports = [
        "//3rdparty/jvm/com/typesafe/akka:akka_stream_2_13",
        "//3rdparty/jvm/org/reactivestreams:reactive_streams",
        "//3rdparty/jvm/org/scala_lang/modules:scala_java8_compat_2_13",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//external:jar/com/typesafe/play/play_streams_2_13"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



scala_import(
    name = "routes_compiler",
    exports = [
        "//3rdparty/jvm/org/scala_lang/modules:scala_parser_combinators_2_13",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        ":twirl_api_2_13"
    ],
    jars = [
        "//external:jar/com/typesafe/play/routes_compiler_2_13"
    ],
    visibility = [
        "//visibility:public"
    ]
)



java_library(
    name = "twirl_api_2_13",
    exports = [
        "//3rdparty/jvm/org/scala_lang/modules:scala_xml_2_13",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//external:jar/com/typesafe/play/twirl_api_2_13"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)


