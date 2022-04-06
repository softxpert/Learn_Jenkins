

IDENTIFIER = "${params.IDENTIFIER}".trim()




/**
 * Adds a string parameter
 *
 * @return array
 */
def getIdentifierParameter() {
    setEnvVars()
    return [$class: 'ValidatingStringParameterDefinition',
            //defaultValue: 'ed4-helloworld',
            description: """
<b>Name of Service, use dashes here if required!</b>
""" ,
            regex: '^[a-z][a-z0-9-]{5,31}$',
            name: 'IDENTIFIER'
    ]
}

def getSqsParameter() {
    return [$class: 'BooleanParameterDefinition',
            description: """
<b>Add sqs & sns to module configuration</b>
""" ,
            name: 'SQS'
    ]
}





def setEnvVars() {
  echo "setEnvVars" 
}

def getParameters() {
    return [
        getSqsParameter()
        

    ]
}


node {
  
  properties([
    parameters(
      getParameters()
    )
  ])
  
  stage('pre-condition-check') {
    echo "pre-condition-check"
  }
  
  stage('build') {
    echo "build"
  }
}
