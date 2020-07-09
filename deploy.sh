#!/bin/bash

ssh -i ${{ secrets.ID_RSA }} ec2-user@ec2-3-95-251-226.compute-1.amazonaws.com "rm -f /home/ec2-user/java/*.jar"
scp -i ${{ secrets.ID_RSA }} ./target/*.jar ec2-user@ec2-3-95-251-226.compute-1.amazonaws.com:/home/ec2-user/java/
ssh -i ${{ secrets.ID_RSA }} ec2-user@ec2-3-95-251-226.compute-1.amazonaws.com "nohub java -jar /home/ec2-user/java/*.jar"
