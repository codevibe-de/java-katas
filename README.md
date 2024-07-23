# java-katas

## troubleshooting

#### "Test events were not received"

Problem: Tests are not executed in Intellij IDEA (using Gradle as the build system) with message "Test events were
not received"

Solution: Disable the delegation of text execution to Gradle, so that Intellij executes the tests itself (Intellij
Settings)
