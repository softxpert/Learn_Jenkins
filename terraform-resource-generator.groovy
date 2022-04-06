




//def generate() {

//    echo params.BUCKET
    
//}




pipeline {
    
    agent any
    
    parameters {
        //string(name: 'Greeting', defaultValue: 'Hello', description: 'How should I greet the world?')
        //choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        //booleanParam(name: 'executeTests', defaultValue: true, description: 'Bla')
        //validatingString(name: "IDENTIFIER", defaultValue: "", regex: /^[a-z][a-z0-9-]{5,31}$/, failedValidationMessage: 'Value entered does not match regular expression: ^[a-z][a-z0-9-]{5,31}$', description: "Name of Service, use dashes here if required!")
        
        validatingString(name: "IDENTIFIER", defaultValue: "", regex: /^[a-z][a-z0-9-]{5,31}$/, failedValidationMessage: 'Value entered does not match regular expression: ^[a-z][a-z0-9-]{5,31}$', description: "Name of Service, use dashes here if required!")
        booleanParam(name: 'BUCKET', defaultValue: false, description: 'Add bucket to module configuration')
        booleanParam(name: 'DATABASE', defaultValue: false, description: 'Add database to module configuration')
        booleanParam(name: 'SERVICE_ACCOUNT', defaultValue: false, description: 'Add serviceAccount to module configuration')
        booleanParam(name: 'COGNITO', defaultValue: false, description: 'Add cognito to module configuration')
        booleanParam(name: 'SQS', defaultValue: false, description: 'Add sqs to module configuration')
        booleanParam(name: 'SNS', defaultValue: false, description: 'Add sns to module configuration')
    }
    
    stages {
        stage('pre-condition-check') {
            steps {
                echo "pre-condition-check"
                //cleanWorkspace()
                //setEnvVars()
                //validateParameters()
            }
        }
        stage('build') {
            steps {
                echo "build"
                //setDisplayNameAndDescription()
                //setDescription()
                //generate()
            }
        }
    }
}
