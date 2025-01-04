
def gitDownload(repo)
{
     git "https://github.com/IntelliqDevops/${repo}.git"

}

def buildArtifact()
{  
    sh 'mvn package'

}

def tomcatDeploy(jobname,ip,context)
{
   sh "scp /var/lib/jenkins/workspace/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat10/webapps/${context}.war"
}

def executeSelenium(jobname)
{
    sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"

}

