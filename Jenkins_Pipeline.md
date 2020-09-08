

## Links
- https://www.jenkins.io/doc/pipeline/steps/workflow-basic-steps/



## Pipeline Commands

```
# Recursively delete the current directory from the workspace
deleteDir()

# Change current directory
dir()

# Print Message
echo()

# Exit Program
error()

# Verify if file exists in workspace
fileExists()

# Send mail
mail(subject: body: bcc: cc: charset: from: mimeType: replyTo: to:)

# Current directory
pwd()

# Read file
readFile(file: encoding:)

# Stash files for later usage
stash(name: allowEmpty: excludes: includes: useDefaultExcludes:)

# Restore files previously stashed (Restores a set of files previously stashed into the current workspace)
unstash(name: )

# Set environment variables
withEnv()

# Write file to workspace
writeFile(file: text: encoding:)

# Archive artifacts
archive()


```

