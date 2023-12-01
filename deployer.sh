VERSION=$(git rev-parse --short HEAD)
if [[ "${GITHUB_REF}" == "refs/heads/master" ]]; then
  echo "Deploying in prod env..."
  VERSION="$VERSION-RELEASE"
else
  echo "Deploying in dev env..."
  VERSION="$VERSION-SNAPSHOT"
fi


echo "Deploying version: $VERSION"

# Upload JAR to S3 (replace with your S3 upload command)
#aws s3 cp target/scala-2.12/test-scala-application.jar s3://your-s3-bucket/