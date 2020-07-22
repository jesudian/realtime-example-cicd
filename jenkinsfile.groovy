Pipleline {
      agent any
      tools {
               jdk "java-1.8"
	     } 
	   Stages {
	           stage ('SCM checkout') {
		    steps {
		            git url:'https://github.com/jesudian/realtime-example-cicd.git'
			    }
			}
		   stage ('archiving artifacts') {
		    steps {
		            archiveArtifacts '**/*.html'
			    }
			 }
		   stage ('transfer artifacts') {
		   steps {
		           sshPublisher (Publishers:[sshPublisherDesc(Configname:'webserver',transfers:[sshTransfer(excludes:'',execCommand: '',execTimeout:1200000,flatten=true,makeEmptyDirs:false,useWorkspaceInPromotion:false,verbose:true)])
			   }
			 }
			}
	 }
