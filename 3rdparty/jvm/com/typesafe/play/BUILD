load("@io_bazel_rules_scala//scala:scala_import.bzl", "scala_import")
load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_binary", "scala_test")
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
        "//external:jar/com/typesafe/play/filters_helpers_2_12"
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
        "//3rdparty/jvm/com/typesafe/akka:akka_actor",
        "//3rdparty/jvm/com/typesafe/akka:akka_actor_typed",
        "//3rdparty/jvm/com/typesafe/akka:akka_serialization_jackson",
        "//3rdparty/jvm/com/typesafe/akka:akka_slf4j",
        "//3rdparty/jvm/com/typesafe:ssl_config_core",
        "//3rdparty/jvm/io/jsonwebtoken:jjwt",
        "//3rdparty/jvm/jakarta/transaction:jakarta_transaction_api",
        "//3rdparty/jvm/jakarta/xml/bind:jakarta_xml_bind_api",
        "//3rdparty/jvm/javax/inject:javax_inject",
        "//3rdparty/jvm/org/scala_lang/modules:scala_java8_compat",
        "//3rdparty/jvm/org/scala_lang/modules:scala_parser_combinators",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//3rdparty/jvm/org/slf4j:jcl_over_slf4j",
        "//3rdparty/jvm/org/slf4j:jul_to_slf4j",
        "//3rdparty/jvm/org/slf4j:slf4j_api",
        ":build_link",
        ":play_json",
        ":play_streams",
        ":twirl_api"
    ],
    jars = [
        "//external:jar/com/typesafe/play/play_2_12"
    ],
    visibility = [
        "//visibility:public"
    ]
)



scala_import(
    name = "play_akka_http_server",
    exports = [
        "//3rdparty/jvm/com/typesafe/akka:akka_http_core",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        ":play_server",
        ":play_streams"
    ],
    jars = [
        "//external:jar/com/typesafe/play/play_akka_http_server_2_12"
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



scala_import(
    name = "play_functional",
    exports = [
        "//3rdparty/jvm/org/scala_lang:scala_library"
    ],
    jars = [
        "//external:jar/com/typesafe/play/play_functional_2_12"
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
        "//external:jar/com/typesafe/play/play_guice_2_12"
    ],
    visibility = [
        "//visibility:public"
    ]
)



scala_import(
    name = "play_json",
    exports = [
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_annotations",
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_core",
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_databind",
        "//3rdparty/jvm/com/fasterxml/jackson/datatype:jackson_datatype_jdk8",
        "//3rdparty/jvm/com/fasterxml/jackson/datatype:jackson_datatype_jsr310",
        "//3rdparty/jvm/joda_time:joda_time",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        "//3rdparty/jvm/org/scala_lang:scala_reflect",
        ":play_functional"
    ],
    jars = [
        "//external:jar/com/typesafe/play/play_json_2_12"
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
        "//external:jar/com/typesafe/play/play_logback_2_12"
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
        "//external:jar/com/typesafe/play/play_server_2_12"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



scala_import(
    name = "play_streams",
    exports = [
        "//3rdparty/jvm/com/typesafe/akka:akka_stream",
        "//3rdparty/jvm/org/reactivestreams:reactive_streams",
        "//3rdparty/jvm/org/scala_lang/modules:scala_java8_compat",
        "//3rdparty/jvm/org/scala_lang:scala_library"
    ],
    jars = [
        "//external:jar/com/typesafe/play/play_streams_2_12"
    ],
    visibility = [
        "//visibility:public"
    ]
)



scala_import(
    name = "routes_compiler",
    exports = [
        "//3rdparty/jvm/org/scala_lang/modules:scala_parser_combinators",
        "//3rdparty/jvm/org/scala_lang:scala_library",
        ":twirl_api"
    ],
    jars = [
        "//external:jar/com/typesafe/play/routes_compiler_2_12"
    ],
    visibility = [
        "//visibility:public"
    ]
)



scala_import(
    name = "twirl_api",
    exports = [
        "//3rdparty/jvm/org/scala_lang/modules:scala_xml",
        "//3rdparty/jvm/org/scala_lang:scala_library"
    ],
    jars = [
        "//external:jar/com/typesafe/play/twirl_api_2_12"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)


