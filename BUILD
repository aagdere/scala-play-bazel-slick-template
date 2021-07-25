package(default_visibility = ["//:__subpackages__"])

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_binary")
load("@rules_intellij_generate//:def.bzl", "intellij_module")
load("@rules_intellij_generate//:def.bzl", "intellij_project")
load("@io_bazel_rules_scala//scala:scala_toolchain.bzl", "scala_toolchain")
load("@io_bazel_rules_scala//scala:providers.bzl", "declare_deps_provider")

scala_binary(
    name = "App",
    main_class = "bazeltest.Main",
    deps = [
        "//bazeltest",
    ],
)

exports_files(["iml_types.xml"])

filegroup(
    name = "automatically_placed_intellij_project_files",
    srcs = glob(["intellij_project_files/**/*.xml"]),
)

intellij_module(
    name = "iml",
    iml_type = "root",
    module_name_override = "template",
    visibility = ["//visibility:public"],
)

intellij_project(
    name = "intellij",
    testonly = True,
    iml_types_file = "//:iml_types.xml",
    modules = [
        "//:iml",
        "//backend-server:backend-server_iml",
        "//bazeltest:bazeltest_iml",
        "//othermodule:othermodule_iml",
    ],
    project_root_filegroup = "//:automatically_placed_intellij_project_files",
    project_root_filegroup_ignore_prefix = "intellij_project_files",
    test_lib_label_matchlist = ['{"label_name":"bazeltest"}'],
    deps = [
        "//backend-server",
        "//bazeltest:tests",
        "//othermodule:tests",
    ],
)

scala_toolchain(
    name = "my_toolchain_impl",
    dep_providers = [
        ":my_scala_compile_classpath_provider",
        ":my_scala_library_classpath_provider",
        ":my_scala_macro_classpath_provider",
        ":my_scala_xml_provider",
        ":my_parser_combinators_provider",
    ],
    dependency_mode = "transitive",
    dependency_tracking_method = "ast",
    scalacopts = ["-Ywarn-unused"],
    strict_deps_mode = "error",
    unused_dependency_checker_mode = "error",
    visibility = ["//visibility:public"],
)

toolchain(
    name = "my_scala_toolchain",
    toolchain = "my_toolchain_impl",
    toolchain_type = "@io_bazel_rules_scala//scala:toolchain_type",
    visibility = ["//visibility:public"],
)

declare_deps_provider(
    name = "my_scala_compile_classpath_provider",
    deps_id = "scala_compile_classpath",
    visibility = ["//visibility:public"],
    deps = [
        "@io_bazel_rules_scala_scala_compiler",
        "@io_bazel_rules_scala_scala_library",
        "@io_bazel_rules_scala_scala_reflect",
    ],
)

declare_deps_provider(
    name = "my_scala_library_classpath_provider",
    deps_id = "scala_library_classpath",
    deps = [
        "@io_bazel_rules_scala_scala_library",
        "@io_bazel_rules_scala_scala_reflect",
    ],
)

declare_deps_provider(
    name = "my_scala_macro_classpath_provider",
    deps_id = "scala_macro_classpath",
    deps = [
        "@io_bazel_rules_scala_scala_library",
        "@io_bazel_rules_scala_scala_reflect",
    ],
)

declare_deps_provider(
    name = "my_scala_xml_provider",
    deps_id = "scala_xml",
    deps = ["@io_bazel_rules_scala_scala_xml"],
)

declare_deps_provider(
    name = "my_parser_combinators_provider",
    deps_id = "parser_combinators",
    deps = ["@io_bazel_rules_scala_scala_parser_combinators"],
)
