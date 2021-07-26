repo = "/home/aris/Development/scala-play-bazel-template"

import os

def generateScalaTest(moduleName, targetName):
    test = ""
    if targetName not in ["api", "models"]:
        test = \
f"""
scala_test(
    name = "tests",
    srcs = ["src/test/scala/com/armeneum/{moduleName}/DeleteMe{targetName.capitalize()}Spec.scala"],
    visibility = ["//visibility:public"],
    deps = [":{targetName}"],
)
"""
    return test

def generateBuildFileContent(moduleName, targetName):
    dep = "[]"
    if targetName == "api":
        dep = f"[\"//{moduleName}/models\"]"
    elif targetName == "services":
        dep = f"[\"//{moduleName}/api\"]"
    return \
f"""load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_test")
load("@rules_intellij_generate//:def.bzl", "intellij_module")

scala_library(
    name = "{targetName}",
    srcs = ["src/main/scala/com/armeneum/{moduleName}/DeleteMe{targetName.capitalize()}.scala"],
    visibility = ["//visibility:public"],
    deps = {dep},
)
{generateScalaTest(moduleName, targetName)}
intellij_module(
    name = "{moduleName}_{targetName}_iml",
    iml_type = "scala-simple",
    visibility = ["//visibility:public"],
)
"""

def generateTempScalaFile(moduleName):
    return \
f"""package {moduleName}

object DeleteMeAfterRunningMakeIntellij
"""

def main():
    module = input("Enter new module name:\n").lower()
    defaultTargetListString = "models;api;services"
    targetListString = input(f"Enter semi-colon (;) delimited target list (default: {defaultTargetListString}):\n").strip(";").lower()
    if targetListString == "":
        targetListString = defaultTargetListString
    targetList = targetListString.split(";")
    currentWorkingDirectory = os.getcwd()
    modulePath = f"{currentWorkingDirectory}/{module}"
    for target in targetList:
        targetPath = f"{modulePath}/{target}"
        mainPackagePath = f"{targetPath}/src/main/scala/com/armeneum/{module}"
        os.makedirs(mainPackagePath)
        file = open(f"{mainPackagePath}/DeleteMe{target.capitalize()}.scala", "w")
        file.write(generateTempScalaFile(module))
        file.close()
        if target not in ["models", "api"]:
            testPackagePath = f"{targetPath}/src/test/scala/com/armeneum/{module}"
            os.makedirs(testPackagePath)
            file = open(f"{testPackagePath}/DeleteMe{target.capitalize()}Spec.scala", "w")
            file.write(generateTempScalaFile(module))
            file.close()
        file = open(f"{targetPath}/BUILD", "w")
        file.write(generateBuildFileContent(module, target))
        file.close()

main()