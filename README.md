Project - Simple Spring app using MySql and docker 

All commands to be executed from vehicles directory

Setup 

1) Docker must be installed and running state
2) Maven should installed and configured

### First time
  mvn package
  
  docker-compose up -build

### Start containers
 docker-compose start
 
### stop containers
 docker-compose stop



### Exposed URL 

1) URL: GET -  http://localhost:8088/app/vehicles 
    Get sample records from database    
    
### Sample Response 

`[
{
"id": "7533a0d3-d1a3-4f4b-97dd-454cdc651867",
"vehicleIdentityNumber": "Reg#6789",
"make": "Tesla",
"model": "Model S"
},
{
"id": "fc7789ff-4925-426d-9a80-7dc1bd1f1065",
"vehicleIdentityNumber": "Reg#1234",
"make": "Audi",
"model": "Q5"
}
]`
    
    
2) URL: POST - http://localhost:8088/app/vehicles
    Create a new vehicle
###  Request Body sample 
    {
        "id": "e78d336e-44e4-11eb-b378-0242ac130002",
        "vehicleIdentityNumber": "Reg#8579",
        "make": "Audi2",
        "model": "Q6"
    }

#Online UUID genrator https://www.uuidgenerator.net/version1
