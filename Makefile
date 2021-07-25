build-deps: ## Creates 3rdparty dependencies
	./scripts/build_dependencies

.PHONY: build
build: ## Builds code
	bazel build //...

intellij: ## Creates intellij files from project structure
	bazel build :intellij
	python2 ./bazel-bin/install_intellij_files_script

run: ## Run the backend server at localhost:9000
	bazel run //backend-server

clean-intellij: ## Deletes all intellij files
	# Deleting intellij files
	find . | grep .idea/ | grep -v misc | xargs rm -rf
	find . | grep -e ".iml$$" | xargs rm -rf
	rm .rig_sha1

clean: ## Deletes intellij and bazel output files
	make clean-bazel
	make clean-intellij

clean-bazel: ## Deletes bazel output files
	# Deleting bazel files
	rm -rf ./bazel-*

clean-3rdparty: ## Deletes 3rdparty dependency folder
	# Deleting third party libraries
	rm -rf ./3rdparty

new-target-template: ## Creates template bazel module
	python ./scripts/python/new-target-template.py