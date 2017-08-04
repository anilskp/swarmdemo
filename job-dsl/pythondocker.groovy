job('PythonFlask Docker example') {
    scm {
        git('git://github.com/anilskp/demoapp.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('anil.shafeeque@gmail.com')
        }
    }

    steps {
        dockerBuildAndPublish {
            repositoryName('anilskp/demoapp2')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
      shell(readFileFromWorkspace('job-dsl/deploycontainer.txt'))
    }
}
