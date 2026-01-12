def call(Map config = [:]) {

    pipeline {
        agent any

        stages {

            stage('Clone Repository') {
                steps {
                    echo "Cloning repository..."
                    git branch: 'main',
                        url: config.REPO_URL
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
