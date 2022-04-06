

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


def setEnvVars() {
  echo "setEnvVars" 
}

def getParameters() {
    return [
        getIdentifierParameter(),
        //getBucketParameter(),
        //getDatabaseParameter(),
        //getServiceAccountParameter(),
        //getCognitoParameter(),
        //getSqsParameter(),
        //getSnsParameter(),

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
