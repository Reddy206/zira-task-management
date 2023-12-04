# zira-task-management

curl --location 'localhost:9091/api/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username":"mahesh_reddy",
    "email":"mreddy@tekion.com"
}'

curl --location 'localhost:9091/api/users'

curl --location 'localhost:9091/api/users/65656dd4b777486ad5a884e5/tasks'

curl --location 'localhost:9091/api/tasks' \
--header 'Content-Type: application/json' \
--data '{
    "taskName":"Create Citus Connector",
    "description":"create a validate and getData functionality for mysql connector",
    "taskType":"FEATURE",
    "status":"TO_DO",
    "dueDate":"2023-11-25"
}'

curl --location 'localhost:9091/api/sprints' \
--header 'Content-Type: application/json' \
--data '{
    "sprintName":"Sprint 2",
    "startDate":"2023-11-28T23:59:59",
    "endDate":"2023-12-28T23:59:59",
    "taskIds":[
        
    ]
}'

curl --location 'localhost:9091/api/sprints'

curl --location 'localhost:9091/api/tasks'

curl --location --request POST 'localhost:9091/api/sprints/65656d67b777486ad5a884e0/tasks/6565b9385bbe1d4cb494f83b'

curl --location 'localhost:9091/api/tasks/65656d83b777486ad5a884e1'

curl --location 'localhost:9091/api/sprints/65656d67b777486ad5a884e0'

curl --location 'localhost:9091/api/tasks/assigned/65656dd4b777486ad5a884e5'

curl --location 'localhost:9091/api/sprints/65656d67b777486ad5a884e0/tasks'

curl --location 'localhost:9091/api/tasks/status?taskStatus=DONE'

curl --location --request POST 'localhost:9091/api/tasks/6565b9385bbe1d4cb494f83b/assign/65656dd4b777486ad5a884e5'

curl --location 'localhost:9091/api/users/65656dd4b777486ad5a884e5/tasks'

curl --location --request PUT 'localhost:9091/api/tasks/6565afa9b35485002e8e286c/change-status' \
--header 'Content-Type: application/json' \
--data '{
    "newStatus": "DONE"
}'

curl --location 'localhost:9091/api/tasks/delayed'