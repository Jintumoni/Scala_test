VERSION=$(git log --oneline | wc -l)
if [[ "${GITHUB_REF}" == "refs/heads/master" ]]; then
  echo "Deploying in prod env..."
  VERSION="$MAJOR.$MINOR.$VERSION-RELEASE"
else
  echo "Deploying in dev env..."
  VERSION="$MAJOR.$MINOR.$VERSION-SNAPSHOT"
fi

JAR=$(basename target/scala-2.11/*.jar .jar)"."$VERSION".jar"
echo "JAR : $JAR"

# Upload JAR to S3
echo "Uploading " $JAR " to " s3://jintu-demo-s3/$JAR
aws s3 cp target/scala-2.11/*.jar s3://jintu-demo-s3/$JAR
echo "Successfully upload $JAR to S3"