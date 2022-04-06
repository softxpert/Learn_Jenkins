
/**
 * Parameters Section
 */
IDENTIFIER      = "${params.IDENTIFIER}".trim()
BUCKET          = "${params.BUCKET}".trim()
DATABASE        = "${params.DATABASE}".trim()
SERVICE_ACCOUNT = "${params.SERVICE_ACCOUNT}".trim()
COGNITO         = "${params.COGNITO}".trim()
SQS             = "${params.SQS}".trim()
SNS             = "${params.SNS}".trim()



def generate() {
    
    PARAMETERS = "-i $IDENTIFIER"
    
    echo $PARAMETERS
//
//    if (BUCKET.equals("true")) {
//        PARAMETERS += " -b"
//    }
//
//    if (DATABASE.equals("true")) {
//        PARAMETERS += " -d"
//    }
//
//    if (SERVICE_ACCOUNT.equals("true")) {
//        PARAMETERS += " -s"
//    }
//
//    if (COGNITO.equals("true")) {
//        PARAMETERS += " -c"
//    }
//
//    if (SQS.equals("true")) {
//        PARAMETERS += " -q"
//    }

//    if (SNS.equals("true")) {
//        PARAMETERS += " -n"
//    }
}




pipeline {
    agent any
    
    parameters {
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
                generate()
            }
        }
    }
}
