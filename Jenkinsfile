pipeline {
    agent any

    tools {
        maven 'MVN'
        jdk   'JAVA'
    }

    /* ---------------------------
       🔹 Jenkins Job Parameters
       --------------------------- */
    parameters {
        choice(name: 'ENV_NAME', choices: ['QA', 'STAGE', 'UAT'], description: 'Select Environment')
        choice(name: 'BROWSER', choices: ['chrome', 'edge'], description: 'Choose Browser')
        choice(name: 'SUITE', choices: ['smoke', 'regression'], description: 'Select Test Suite')
        string(name: 'RUN_BY', defaultValue: 'Jeevan Gowda', description: 'Who triggered the build?')
    }

    environment {
        GIT_REPO    = "https://github.com/Jeevan-LP/In4Suite_Expenses.git"
        GIT_BRANCH  = "main"

        // EMAIL VARIABLES
        MAIL_FROM   = "jeevanpgowda27@gmail.com"
        MAIL_TO     = "jeevanpgowda27@gmail.com, jeevangowda016@gmail.com"

        // Extent Report Custom Values
        Execution_Environment = "${params.ENV_NAME}"
        Browser               = "${params.BROWSER}"
        Triggered_By          = "${params.RUN_BY}"
    }

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '10'))
        ansiColor('xterm')
    }

    stages {

        /* ---------------------------------------------------------
           Stage 1: Checkout Code
        --------------------------------------------------------- */
        stage('Checkout Code From Git Hub') {
            steps {
                echo "Checking out source code from GitHub ${GIT_REPO} >>> branch ${GIT_BRANCH}"
                git branch: "${GIT_BRANCH}",
                    credentialsId: 'git-creds',
                    url: "${GIT_REPO}"
            }
        }

        /* ---------------------------------------------------------
           Stage 2: Build Framework
        --------------------------------------------------------- */
        stage('Build Framework') {
            steps {
                echo "Building framework....."
                bat "mvn clean install -DskipTests"
            }
        }

        /* ---------------------------------------------------------
           Stage 3: Execute TestNG
        --------------------------------------------------------- */
        stage('Run TestNG Tests') {
            steps {
                echo "Running TestNG suite: ${params.SUITE}....."
                bat "mvn test -DsuiteXmlFile=testng.xml"
            }
        }

        /* ---------------------------------------------------------
           Stage 4: Publish Extent Report (UPDATED)
        --------------------------------------------------------- */
        stage('Publish Extent Report') {
            steps {
                echo "Publishing Extent Report....."

                // Archive Extent HTML reports from the correct folder
                archiveArtifacts artifacts: "Results/Reports/*.html", allowEmptyArchive: false

                // Publish Extent report on Jenkins dashboard
                publishHTML(target: [
                    reportDir: 'Results/Reports',
                    reportFiles: '*.html',
                    reportName: 'Extent Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true
                ])
            }
        }

        /* ---------------------------------------------------------
           Stage 5: Archive Test Artifacts
        --------------------------------------------------------- */
        stage('Archive Test Artifacts') {
            steps {
                echo "Archiving test reports..."
                junit allowEmptyResults: true, testResults: "target/surefire-reports/*.xml"
                archiveArtifacts artifacts: "target/**/*.*", allowEmptyArchive: true
            }
        }
    }

    /* ---------------------------------------------------------
       POST ACTIONS (EMAIL)
    --------------------------------------------------------- */
    post {

        success {
    echo "✔ Build Successful....."
    emailext(
        from: "${MAIL_FROM}",
        to: "${MAIL_TO}",
        subject: "BUILD SUCCESS – ${env.JOB_NAME} #${env.BUILD_NUMBER}",
        mimeType: 'text/html',
        body: """
            <b><h2 style="color:green;">In4 Suite Automation Build - SUCCESS</h2></b><br>
            Hello Team,<br><br>

            The latest automation build has been executed. Please find the build summary below:<br><br>

            <b> Project :</b> ${env.JOB_NAME}<br>
            <b> Environment :</b> ${Execution_Environment}<br>
            <b> Browser :</b> ${Browser}<br>
            <b> Triggered By :</b> ${Triggered_By}<br>
            <b> Test Suite :</b> ${params.SUITE}<br>
            <b> Build Status :</b> <b>${currentBuild.currentResult}</b><br>
            <b> Build URL :</b> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a><br>
            <b> Extent Report :</b> <a href="${env.BUILD_URL}Extent_Report/">Click here</a><br><br>

            <h3><strong>Build Console Log Details Summary</strong></h3>
            <pre>${BUILD_LOG}</pre>

            Regards,<br>
            <b>Jeevan L P<br>
            Software Test Engineer</b>
        """,
        attachmentsPattern: "Results/Reports/*.html",   // << ADD THIS
        attachLog: true                                  // << ADD THIS
    )
}

failure {
    echo "❌ Build Failed....."
    emailext(
        from: "${MAIL_FROM}",
        to: "${MAIL_TO}",
        subject: "BUILD FAILED – ${env.JOB_NAME} #${env.BUILD_NUMBER}",
        mimeType: 'text/html',
        body: """
            <b><h2 style="color:red;">In4 Suite Automation Build - FAILED</h2></b><br>
            Hello Team,<br><br>

            The latest automation build has failed. Please find the build summary below:<br><br>

            <b> Project :</b> ${env.JOB_NAME}<br>
            <b> Environment :</b> ${Execution_Environment}<br>
            <b> Browser :</b> ${Browser}<br>
            <b> Triggered By :</b> ${Triggered_By}<br>
            <b> Test Suite :</b> ${params.SUITE}<br>
            <b> Build Status :</b> <b>${currentBuild.currentResult}</b><br>
            <b> Build URL :</b> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a><br>
            <b> Extent Report :</b> <a href="${env.BUILD_URL}Extent_Report/">Click here</a><br><br>

            <h3><strong>Build Console Log Details Summary</strong></h3>
            <pre>${BUILD_LOG}</pre>

            Regards,<br>
            <b>Jeevan L P<br>
            Software Test Engineer</b>
        """,
        attachmentsPattern: "Results/Reports/*.html",   // << ADD THIS
        attachLog: true                                  // << ADD THIS
    )
}

        always {
            echo "Cleaning the workspace....."
            cleanWs()
        }
    }
}