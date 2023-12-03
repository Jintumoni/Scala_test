echo $ENV

#VERSION=$(git log --oneline | wc -l)
#if [[ "${GITHUB_REF}" == "refs/heads/master" ]]; then
#  echo "Deploying in prod env..."
#  VERSION="$MAJOR.$MINOR.$VERSION-RELEASE"
#else
#  echo "Deploying in dev env..."
#  VERSION="$MAJOR.$MINOR.$VERSION-SNAPSHOT"
#fi
#
#JAR=$(basename path/to/artifacts/*.jar .jar)"-"$VERSION".jar"
#echo "JAR : $JAR"
#
## Upload JAR to S3
#echo "Uploading " $JAR " to " s3://jintu-demo-s3/$JAR
#aws s3 cp path/to/artifacts/*.jar s3://jintu-demo-s3/$JAR --region ap-south-1
#echo "hello-from-github-actions" | aws s3 cp - s3://jintu-demo-s3/your-file-name.txt --region ap-south-1
#echo "Successfully upload $JAR to S3"