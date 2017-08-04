docker service rm swarmdemo
docker service create  -p 5500:5000  --name swarmdemo  --limit-cpu=1 --replicas=3  anilskp/swarmdemo
