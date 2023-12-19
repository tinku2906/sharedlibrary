def gitdownload(repo)
{
   git "https://github.com/intelliqittrainings/${repo}.git"
}
def build()
{
  sh 'mvn package'
}
def deploytamcat(jobname,ip,context)
{
    sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat9/webapps/${context}.war"
}
def testexec(jobname)
{
   sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}

