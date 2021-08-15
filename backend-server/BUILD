# Build file

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_binary", "scala_test")
load("@io_bazel_rules_play_routes//play-routes:play-routes.bzl", "play_routes")
load("@rules_intellij_generate//:def.bzl", "intellij_module")

play_routes(
    name = "route_sources",
    srcs = ["src/main/resources/routes"] + glob(["src/main/resources/*.routes"]),
    generate_reverse_router = True,
    include_play_imports = True,
    routes_imports = [],
    visibility = ["//visibility:public"],
)

scala_binary(
    name = "backend-server",
    srcs = glob(["src/main/scala/**/*.scala"]) + [":route_sources"],
    classpath_resources = ["src/main/resources/application.conf"],
    jvm_flags = [
        "-Dhttp.port=9000",
        "-Dapplication.name=backend-server",
    ],
    main_class = "play.core.server.ProdServerStart",
    resources = ["src/main/resources/logback.xml"],
    scalacopts = [
        "-Xasync",
        #        "-Ymacro-debug-verbose",
    ],
    visibility = ["//visibility:public"],
    deps = [
        "//3rdparty/jvm/com/typesafe/play:filters_helpers",
        "//3rdparty/jvm/com/typesafe/play:play_akka_http_server",
        "//3rdparty/jvm/com/typesafe/play:play_logback",
        "//3rdparty/jvm/com/typesafe/play:play_server",
        "//3rdparty/jvm/org/scala_lang:scala_reflect",
        #        "//3rdparty/jvm/com/typesafe/play:routes_compiler",
        "//3rdparty/jvm/com/typesafe/slick:slick_hikaricp",
        "//3rdparty/jvm/org/postgresql",
        "//3rdparty/jvm/org/scala_lang/modules:scala_async",
        "//testrepo/services",
    ],
)

scala_test(
    name = "tests",
    srcs = ["src/test/scala/com/armeneum/models/JsonFormattersSpec.scala"],
    resources = ["src/main/resources/application.conf"],  # use main for now
    visibility = ["//visibility:public"],
    deps = [
        ":backend-server",
    ],
)

intellij_module(
    name = "backend-server_iml",
    iml_type = "scala-simple",
    visibility = ["//visibility:public"],
)
