# 📃 Android-Blueprint
Blueprint for new Android projects. You can use this as a starting point for new projects. Blueprint offers better and recommended configuration of the project and it's dependencies than templates from Android Studio.
This repo is heavily influenced by [NowInAndroid](https://github.com/android/nowinandroid). I found myself retyping all of this configurations for the new projects, goal of this repo is to eliminate that and have those configurations ready to go for new projects.

### Preconfigured code
- Version catalog - file in `gradle` folder containing external dependencies. They can be accessed in the `build.gradle` files using `libs` field.
- Automatic app versioning based on git - number of commits as a version code, git describe as a version name.
- JUnit 5 for unit tests
- Convention plugins, `build-logic` module - holds configuration for gradle files for reusability.
- Hilt
- Jetpack Compose Navigation
- Ktlint
- JaCoCo

