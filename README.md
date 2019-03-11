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


<b>After clone make the docker build:</b>
sudo docker build -t greeting .

After build run it:

sudo docker run -e PORT=8085 greeting
sudo docker run -e PORT=8084 greeting
