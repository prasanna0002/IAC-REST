#!/bin/bash

ssh -i id_rsa ec2-user@ec2-3-95-251-226.compute-1.amazonaws.com "rm -f /home/ec2-user/java/*.jar"
scp -i id_rsa ./target/*.jar ec2-user@ec2-3-95-251-226.compute-1.amazonaws.com:/home/ec2-user/java/
ssh -i id_rsa ec2-user@ec2-3-95-251-226.compute-1.amazonaws.com "nohub java -jar /home/ec2-user/java/*.jar"
