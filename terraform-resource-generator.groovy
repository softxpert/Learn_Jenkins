











pipeline {
    
    agent any
    
    parameters {
        string(name: 'VERSION', defaultValue: '', description: '')
        //choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        //booleanParam(name: 'executeTests', defaultValue; true, description: '')
    }
    
    stages {
        stage('Setup') {
            echo "Setup"
        }
    }   
}
