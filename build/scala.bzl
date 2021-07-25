load("@io_bazel_rules_scala//scala:scala_toolchain.bzl", "scala_toolchain")

def setup_toolchain(name = "setup_toolchain"):
    scala_toolchain(
        name = "scala_toolchain_impl",
        unused_dependency_checker_mode = "off",
        dependency_mode = "transitive",
        visibility = ["//visibility:public"],
        strict_deps_mode = "off",
    )

    native.toolchain(
        name = "scala_toolchain",
        toolchain_type = "@io_bazel_rules_scala//scala:toolchain_type",
        toolchain = "scala_toolchain_impl",
        visibility = ["//visibility:public"],
    )
