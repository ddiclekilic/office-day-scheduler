# Office Day Scheduler

***Port : localhost:8090***

#### AUTH

- Login 
    - /auth/login        : ***POST***
```
    {  
    "email":"example@gmail.com",
    "password":"pass"
    }
```
- Refresh Token
    - /auth/refresh      : ***POST***

#### USER

- User List
    - /user         : ***GET***
   
- Get User By ID
    - /user/{id}         : ***GET***
    
- Add User
    - /user         : ***POST*** 
    
- Update User
    - /user         : ***PUT***
    
- Delete User
    - /user/{id}         : ***DELETE*** 
    
#### DEPARTMENT

- Department List
    - /department             : ***GET***
    
- Get Department by ID
    - /department/{id}        : ***GET***
    
- Add Department
    - /department             : ***POST***
    
- Update Department
    - /department        : ***PUT***
    
- Delete Department
    - /department/{id}        : ***DELETE***

#### ROLE

- Role List
    - /role         : ***GET***
    
- Get Role By ID
    - /role/{id}         : ***GET***
    
- Add Role
    - /role         : ***POST*** 
    
- Update Role
    - /role        : ***PUT***
    
- Delete Role
    - /role/{id}         : ***DELETE***
    
#### ZONE

- Zone List
    - /zone         : ***GET***
    
- Get Zone By ID
    - /zone/{id}         : ***GET***
    
- Add Zone
    - /zone         : ***POST*** 
    
- Update Zone
    - /zone         : ***PUT***
    
- Delete Zone
    - /zone/{id}         : ***DELETE***
    
#### SCHEDULE

- Schedule List
    - /schedule         : ***GET***
    
- Get Schedule By ID
    - /schedule/{id}         : ***GET***
    
- Add Schedule
    - /schedule         : ***POST*** 
    
- Update Schedule
    - /schedule         : ***PUT***
    
- Delete Schedule
    - /schedule/{id}         : ***DELETE***    
    
#### OUT OF OFFICE DAY

- Out of Office Day List
    - /outofofficeday         : ***GET***
    
- Get Out of Office Day By ID
    - /outofofficeday/{id}         : ***GET***
    
- Add Out of Office Day
    - /outofofficeday         : ***POST*** 
    
- Update Out of Office Day
    - /outofofficeday         : ***PUT***
    
- Delete Out of Office Day
    - /outofofficeday/{id}         : ***DELETE***  

#### CALENDAR

- Calendar List
    - /calendar         : ***GET***
    
- Get Calendar By ID
    - /calendar/{id}         : ***GET***
    
- Add Calendar
    - /calendar         : ***POST*** 
    
- Update Calendar
    - /calendar         : ***PUT***
    
- Delete Calendar
    - /calendar/{id}         : ***DELETE*** 