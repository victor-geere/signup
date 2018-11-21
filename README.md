User Signup Project
======================

**Getting Started**

1. Clone or download the repository
    > https://github.com/victor-geere/signup.git
2. Import `/client/signon.postman_collection.json` into PostMan
3. Run `java -jar deploy/signon-0.0.1-SNAPSHOT.jar` from the command line
4. In PostMan

    4.1 use the `put users` bookmark to create a new user
    
    4.2 use the `post login` bookmark to login with **Basic Auth**
    
    >the session token is returned as a header
    
    4.3 the users can now be viewed with the `get users` bookmark
    
    4.5 use `post logout` to invalidate the current session

**API Contract**

PUT /api/users

request:

    {
        "username": "user",
        "phone": "21234123412",
        "password": "asdf"
    }
    
response:

    {
        "username": "user2",
        "phone": "21234123412",
        "password": "$2a$12$av.ifJUZITjORxMj.OvHDumNIOpstwtpVv05SQIppeBcgzTZccgPi"
    }    
    
GET /api/users

request cookie:

    SESSION : YzAwNjNlYTctMjQxNC00MTg1LThjMGYtMTVhMGRjZGFmZTE4

response:

    [
        {
            "sessionId": "c0063ea7-2414-4185-8c0f-15a0dcdafe18", <---This user is logged in
            "phone": "21234123412",
            "username": "user"
        },
        {
            "sessionId": null,
            "phone": "21234123412",
            "username": "user2"
        }
    ]    
    
POST /api/login 

request headers:

    Authorization : Basic dXNlcjphc2Rm
    
response cookie:

    SESSION : YzAwNjNlYTctMjQxNC00MTg1LThjMGYtMTVhMGRjZGFmZTE4

POST /api/logout

response:

    <empty>