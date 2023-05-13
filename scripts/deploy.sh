#!/usr/bin/env bash

REPOSITORY=/home/ec2-user/uniA
cd $REPOSITORY

APP_NAME=uniA
JAR_NAME=$(ls $REPOSITORY/build/libs/ | grep '.jar' | tail -n 1)
JAR_PATH=$REPOSITORY/build/libs/$JAR_NAME

CURRENT_PID=$(pgrep -f $APP_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> 종료할 애플리케이션이 없습니다." >> $REPOSITORY/log.txt
else
  echo "> kill -15 $CURRENT_PID" >> $REPOSITORY/log.txt
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> Deploy - $JAR_PATH " >> $REPOSITORY/log.txt
nohup java -jar -Dspring.profiles.active=dev $JAR_PATH > $REPOSITORY/nohup.out 2>&1 &