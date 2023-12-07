# Getting Started

```shell
cd ./docker
#도커 백그라운드 실행
docker compose up -d
# 도커 cli 실행하면서 -c (Enable cluster mode)
docker exec -it redis-test redis-cli -c
```