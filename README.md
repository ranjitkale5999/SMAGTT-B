# SMAGTT-B
Share Market Analysis Greate Time Trader

# Admin

REGISTER;-
POST;- http://localhost:8084/auth/register

{
  "email": "rkadmin@gmail.com",
  "name": "Admin",
  "password": "pass@123",
  "city": "Pune",
  "role": "ADMIN"
}

LOGIN
POST;- http://localhost:8084/auth/login
body = raw = json 
{
     "email": "rkadmin@gmail.com", 
     "password": "pass@123"
}

OUTPUT;-
{
    "statusCode": 200,
    "message": "Successfully Logged In",
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJya2FkbWluQGdtYWlsLmNvbSIsImlhdCI6MTc0MjgzNzg2NSwiZXhwIjoxNzQyOTI0MjY1fQ.oscyyaNWxrLkuACRHKvj35yEOCVF76CFVnFzRUL6BR8",
    "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJya2FkbWluQGdtYWlsLmNvbSIsImlhdCI6MTc0MjgzNzg2NSwiZXhwIjoxNzQyOTI0MjY1fQ.oscyyaNWxrLkuACRHKvj35yEOCVF76CFVnFzRUL6BR8",
    "expirationTime": "24Hrs",
    "role": "ADMIN"
}

# login


REGISTER;-
POST;- http://localhost:8084/auth/register
body = raw = json 
{
  "email": "rkuser@gmail.com",
  "name": "ranjit",
  "password": "pass@123",
  "city": "Pune",
  "role": "USER"
}

LOGIN;-
POST;- http://localhost:8084/auth/login
{
     "email": "rkuser@gmail.com", 
     "password": "pass@123"
 }

GET ALL USER user and admin
http://localhost:8084/admin/get-all-users
