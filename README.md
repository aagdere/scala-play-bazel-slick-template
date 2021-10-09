# scala-play-bazel-slick-template
Template to get a Scala Play project up using Bazel as a build tool and Slick as an ORM.

### Initial Setup (Ubuntu)
#### Installations
- Install bazel
	- https://docs.bazel.build/versions/main/install-ubuntu.html#install-on-ubuntu
- Install JDK 11 and point JAVA_HOME to that.
	- https://docs.bazel.build/versions/main/install-ubuntu.html#step-3-install-a-jdk-optional
- Optional: Install Intellij (recommended)
	- https://www.jetbrains.com/help/idea/installation-guide.html#standalone
- Clone the bazel-deps git repo in the same parent directory as this one (<this_repo>/..)
	- `git clone git@github.com:johnynek/bazel-deps.git`
- Clone the rules_intellij_generate repo in the same directory as the step before
	- `git clone git@github.com:sconover/rules_intellij_generate.git`
- Install PostgreSQL if you don't have it. I am using version 12.8 but it will probably work with others too.
  	- Go into the psql shell and set a password for your user
  		- Ex: `ALTER USER aris PASSWORD 'admin';`
	- Update the PSQL config in `src/main/resources/application.conf` to connect to your local psql.
#### Post-install
- Build
	- `make build`
- Run DB migrations
  	- `make run-migrations`
- Optional: Generate Intellij files
	- `make intellij`
	- You will likely need to reopen your project in intellij after generating
- Run server
	- `make run`
- Test out the server
	- Take a look at `bazel-scala-play-bazel-slick-template/backend-server/src/main/resources/routes` to see what routes are available.