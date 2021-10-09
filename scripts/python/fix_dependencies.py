from config import *

# (old, new, filename)
replacements = [
    {
        "old": "//@io_bazel_rules_scala_scala_xml:io_bazel_rules_scala_scala_xml\"",
        "new": "@io_bazel_rules_scala_scala_xml//:io_bazel_rules_scala_scala_xml",
        "filename": f"{repo}/3rdparty/jvm/org/scala_lang/modules/BUILD"
    },
    {
        "old": "//@io_bazel_rules_scala_scala_xml:io_bazel_rules_scala_scala_xml\"",
        "new": "@io_bazel_rules_scala_scala_xml//:io_bazel_rules_scala_scala_xml",
        "filename": f"{repo}/3rdparty/target_file.bzl"
    },
]

for replacement in replacements:
    old = replacement["old"]
    new = replacement["new"]
    filename = replacement["filename"]

    #read input file
    fin = open(filename, "rt")

    #read file contents to string
    data = fin.read()

    #replace all occurrences of the required string
    data = data.replace(old, new)

    #close the input file
    fin.close()

    #open the input file in write mode
    fin = open(filename, "wt")

    #overrite the input file with the resulting data
    fin.write(data)

    #close the file
    fin.close()
