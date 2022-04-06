









pipeline {
    
    agent any
    
    parameters {
        string(name: 'Greeting', defaultValue: 'Hello', description: 'How should I greet the world?')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue; true, description: '')
    }
    
    stages {
        stage('Setup') {
            steps {
                echo "Setup"
            }
        }
    }   
}
