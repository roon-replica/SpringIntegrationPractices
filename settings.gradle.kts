rootProject.name = "SpringIntegrationPractices"

val projectNames = listOf("basic")

projectNames.forEach { projectName ->
    val projectDir = File(rootDir, projectName)
    include(":$projectName")
    projectDir.listFiles()?.forEach { dir ->
        if (!dir.name.startsWith('.')) {
            include(":${dir.name}")
            project(":${dir.name}").projectDir = File(projectDir.absolutePath, dir.name)
        }
    }
}
