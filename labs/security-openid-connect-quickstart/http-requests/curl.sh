export access_token=$( \
    curl --insecure -X POST http://localhost:8180/realms/quarkus/protocol/openid-connect/token \
    --user frontend:secret \
    -H 'content-type: application/x-www-form-urlencoded' \
    -d 'username=alice&password=alice&grant_type=password' | jq --raw-output '.access_token' \
 )

curl -v -X GET \
  http://localhost:8080/api/users/me \
  -H "Authorization: Bearer "$access_token

curl -v -X GET \
   http://localhost:8080/api/admin \
   -H "Authorization: Bearer "$access_token

