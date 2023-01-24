import org.gradle.api.GradleException

/**
 * Get the version code from the number of commits.
 * Command: git rev-list --count HEAD
 */
fun getVersionCode(): Int {
    return execCommand("git rev-list --count HEAD")?.toInt()
        ?: throw GradleException("Unable to get version code. Make sure git is initialized.")
}

/**
 * Get the version name from the latest annotated tag.
 * Command: git describe
 */
fun getVersionName(): String {
    return execCommand("git describe")
        ?: throw GradleException(
            "Unable to get version name.\n" +
                    "Make sure you have at least one annotated tag and git is initialized.\n" +
                    "You can create an annotated tag with: git tag -a 0.1 -m \"0.1\""
        )
}

private fun execCommand(command: String): String? {
    val cmd = command.split(" ").toTypedArray()
    val process = ProcessBuilder(*cmd)
        .redirectOutput(ProcessBuilder.Redirect.PIPE)
        .start()
    return process.inputStream.bufferedReader().readLine()?.trim()
}
