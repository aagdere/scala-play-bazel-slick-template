# Build file

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_binary")
load("@io_bazel_rules_play_routes//play-routes:play-routes.bzl", "play_routes")
load("@rules_intellij_generate//:def.bzl", "intellij_module")

play_routes(
    name = "play-routes",
    srcs = ["conf/routes"] + glob(["conf/*.routes"]),
    generate_reverse_router = True,
    include_play_imports = True,
    routes_imports = [],
    visibility = ["//visibility:public"],
)

scala_binary(
    name = "backend-server",
    srcs = glob(["app/**/*.scala"]) + [":play-routes"],
    classpath_resources = ["conf/application.conf"],
    jvm_flags = [
        "-Dhttp.port=9000",
        "-Dapplication.name=backend-server",
    ],
    main_class = "play.core.server.ProdServerStart",
    resources = ["conf/logback.xml"] + glob(["conf/resources/**/*"]),
    visibility = ["//visibility:public"],
    deps = [
        "//3rdparty/jvm/com/typesafe/play",
        "//3rdparty/jvm/com/typesafe/play:filters_helpers",
        "//3rdparty/jvm/com/typesafe/play:play_akka_http_server",
        "//3rdparty/jvm/com/typesafe/play:play_guice",
        "//3rdparty/jvm/com/typesafe/play:play_logback",
        "//3rdparty/jvm/com/typesafe/play:routes_compiler",
        "//bazeltest",
        "//external:jar/com/google/inject/guice",
        "//external:jar/javax/inject/javax_inject",
    ],
)

intellij_module(
    name = "backend-server_iml",
    iml_type = "scala-server",
    visibility = ["//visibility:public"],
)
