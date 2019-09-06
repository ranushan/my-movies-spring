pipeline {
    agent any
    post { 
	always { 
            cleanWs()
        }
    }
    stages {
	stage('Sonar Analyse') {
	    steps{
	    	echo 'Analyse'
	    }
	}
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
	stage('Package') {
            steps {
                echo 'Package..'
		sh 'mvn clean package'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
		junit '**/target/surefire-reports/TEST-*.xml'
		archiveArtifacts 'target/*.jar'
            }
        }
    }
}