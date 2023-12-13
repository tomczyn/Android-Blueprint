# 📃 Android-Blueprint
Blueprint for new Android projects. You can use this as a starting point for new projects. Blueprint offers better and recommended configuration of the project and it's dependencies than templates from Android Studio.
This repo is heavily influenced by [NowInAndroid](https://github.com/android/nowinandroid). I found myself retyping all of this configurations for new projects, goal of this repo is to eliminate that and have those configurations ready to go.

### Preconfigured code
- Version catalog - file in `gradle` folder containing external dependencies. They can be accessed in the `build.gradle` files using `libs` field.
- Automatic app versioning based on git - number of commits as a version code, git describe as a version name.
- JUnit 5 for unit tests
- Convention plugins, `build-logic` module - holds configuration for gradle files for reusability.
- Hilt
- Jetpack Compose Navigation
- Ktlint
- JaCoCo

### Usage
Use `new_project.sh` script to change package and app name. This script also initializes new repository with `init` commit and a version tag 0.1 for the app versioning to work properly.<br />
Run below commands replacing `my.new.package` and `ApplicationName`.
```
git clone https://github.com/tomczyn/Android-Blueprint.git ApplicationName
cd ApplicationName
./new_project.sh my.new.package ApplicationName
```

##### Using Bitrise

If you're using Bitrise CI/CD, remember to change `Fetch tags` option in `Git Clone Repository` step. Otherwise versioning won't be working in workflows.<br /><br />
*Workflow > Git Clone Repository > Clone Config > Fetch tags > change from no to yes*

## License
MIT License

Copyright (c) 2023 Maciej Tomczyński

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
