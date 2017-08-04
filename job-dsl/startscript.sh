docker service rm swarmdemo
docker service create  -p 5500:5000  --name swarmdemo --replicas=3 --detach anilskp/swarmdemo
