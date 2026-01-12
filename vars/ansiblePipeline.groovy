def call(Map config = [:]) {

    pipeline {
        agent any

        stages {

            stage('Clone Repository') {
                steps {
                    echo "Cloning repository..."
                    echo "Repo URL: ${config.REPO_URL}"
                }
            }

            stage('User Approval') {
                when {
                    expression { config.KEEP_APPROVAL_STAGE == true }
                }
                steps {
                    input message: "Do you want to proceed with deployment to ${config.ENVIRONMENT}?"
                }
            }

            stage('Info') {
                steps {
                    echo "Environment: ${config.ENVIRONMENT}"
                    echo "Code base path: ${config.CODE_BASE_PATH}"
                }
            }
        }
    }
}
