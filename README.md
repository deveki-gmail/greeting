# greeting
# How to use this application.
curl -X POST \
  http://localhost:8080/hi/ \
  -H 'Content-Type: application/json' \
  -d '{
	"name":"deveki",
	"lang":"en"
}'



curl -X GET \
  http://localhost:8080/hi/deveki
