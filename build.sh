#!/bin/sh
if [ "$1" = "build" ];then
    mkdir /home/changsheng/project/project79622/project
    cp -a /home/changsheng/project/project79622/server/. /home/changsheng/project/project79622/project/
    cd /home/changsheng/project/project79622/project
    rm -rf /home/changsheng/project/project79622/server
    echo "执行成功"
fi
