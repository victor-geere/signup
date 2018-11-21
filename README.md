Signup Example
======================

**Getting Started**

1. Import `/client/signon.postman_collection.json` into PostMan
2. Run `java -jar deploy/signon-0.0.1-SNAPSHOT.jar` from the command line
3. A default user has been created in H2 as `username: user, password: asdf`
4. In PostMan

    4.1 use the `post login` endpoint to create a session token 
    
    4.1.1 the login uses **Basic Auth**
    
    4.1.2 the session token is returned as a header
    
    4.2 use the `put login` endpoint to add a new user
    
    4.2.1 the password is encrypted with BCrypt in the database  
    
    4.2.2 the user can be viewed with the `/api/users` endpoint
    
    4.2.3 the user can also be viewed in /h2 
    
    >web login `username: user, password: asdf`
     
    >db login `username: sa, password:''`
    
    4.3 the `post login` endpoint will now work with the newly created user as well
    
    4.4 a specific user can be viewed with `get user`
    
    > e.g. /api/user?username=user
    
    4.5 use `post logout` to invalidate the current session
