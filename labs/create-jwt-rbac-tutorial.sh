mvn io.quarkus:quarkus-maven-plugin:2.4.2.Final:create \
  -DprojectGroupId=at.htl \
  -DprojectArtifactId=security-jwt-rbac-tutorial \
  -DclassName="at.htl.ProfileResource" \
  -Dpath="/profile" \
  -Dextensions="resteasy-jsonb, smallrye-jwt"
