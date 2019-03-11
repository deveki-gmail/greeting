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


<b>After clone make the docker build:</b><br>
sudo docker build -t greeting .

<b>After build run it with below mention run commands:</b>

sudo docker run -p 8085:8085 -e PORT=8085 greeting
<br>
sudo docker run -p 8084:8084 -e PORT=8084 greeting
