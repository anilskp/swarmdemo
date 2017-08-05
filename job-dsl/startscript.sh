docker service rm swarmdemo
docker service create  -p 5500:5000 --network swarmdemonet  --name swarmdemo  --limit-cpu=1 --replicas=5  anilskp/swarmdemo:latest
