# Build file

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_binary")
load("@io_bazel_rules_play_routes//play-routes:play-routes.bzl", "play_routes")
load("@rules_intellij_generate//:def.bzl", "intellij_module")

play_routes(
    name = "route_sources",
    srcs = ["conf/routes"] + glob(["conf/*.routes"]),
    generate_reverse_router = True,
    include_play_imports = True,
    routes_imports = [],
    visibility = ["//visibility:public"],
)

scala_binary(
    name = "backend-server",
    srcs = glob(["app/**/*.scala"]) + [":route_sources"],
    classpath_resources = ["conf/application.conf"],
    jvm_flags = [
        "-Dhttp.port=9000",
        "-Dapplication.name=backend-server",
    ],
    main_class = "play.core.server.ProdServerStart",
    resources = ["conf/logback.xml"] + glob(["conf/resources/**/*"]),
    scalacopts = ["-Xasync"],
    visibility = ["//visibility:public"],
    deps = [
        "//3rdparty/jvm/com/typesafe/play",
        "//3rdparty/jvm/com/typesafe/play:filters_helpers",
        "//3rdparty/jvm/com/typesafe/play:play_akka_http_server",
        "//3rdparty/jvm/com/typesafe/play:play_logback",
        "//3rdparty/jvm/com/typesafe/play:routes_compiler",
        "//3rdparty/jvm/com/typesafe/slick:slick_hikaricp",
        "//3rdparty/jvm/joda_time",
        "//3rdparty/jvm/org/postgresql",
        "//3rdparty/jvm/org/scala_lang/modules:scala_async",
        "//bazeltest",
        "//external:jar/com/google/inject/guice",
        "//external:jar/javax/inject/javax_inject",
        "//testrepo/services",
    ],
)

intellij_module(
    name = "backend-server_iml",
    iml_type = "scala-server",
    visibility = ["//visibility:public"],
)
