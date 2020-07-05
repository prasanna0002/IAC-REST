#!/bin/bash
TASK_FAMILY= "maven"
SERVICE_NAME= "maven"
NEW_DOCKER_IMAGE="prasanna002/maven:${GITHUB_RUN_NUMBER}"
CLUSTER_NAME= "Terraform_Docker_Batch_112d5611-fb75-38bd-8843-bbc001e83301"
OLD_TASK_DEF=$(aws ecs describe-task-definition --task-definition $TASK_FAMILY --output json)
NEW_TASK_DEF=$(echo $OLD_TASK_DEF | jq --arg NDI $NEW_DOCKER_IMAGE '.taskDefinition.containerDefinitions[0].image=$NDI')
FINAL_TASK=$(echo $NEW_TASK_DEF | jq '.taskDefinition|{family: .family, volumes: .volumes, containerDefinitions: .containerDefinitions}')
aws ecs register-task-definition --family $TASK_FAMILY --cli-input-json "$(echo $FINAL_TASK)"
aws ecs update-service --service $SERVICE_NAME --task-definition $TASK_FAMILY --cluster $CLUSTER_NAME
