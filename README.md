# before to run the database change connection db parameter
    url: jdbc:postgresql://localhost:5433/dev_course_db
    username: andres
    password: password
# Also create Databases 
- dev_course_db
- qa_course_db
- prod_course_db

# You can see all services implemented on this swagger url
http://localhost:8080/swagger-ui/index.html