









pipeline {
    
    agent any
    
    parameters {
        //string(name: 'Greeting', defaultValue: 'Hello', description: 'How should I greet the world?')
        //choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        //booleanParam(name: 'executeTests', defaultValue: true, description: 'Bla')
        validatingString(name: "IDENTIFIER", defaultValue: "", regex: /^[a-z][a-z0-9-]{5,31}$/, failedValidationMessage: 'Value entered does not match regular expression: ^[a-z][a-z0-9-]{5,31}$', description: "Name of Service, use dashes here if required!")
    }
    
    stages {
        stage('Setup') {
            steps {
                echo "Setup"
            }
        }
    }   
}
