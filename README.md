# Library Management System (Java CLI)
A simple command-line library managemnet system built in Java.
This project focuses on applying core OOP principles such as abstraction, inheritance and enums.
It allows users to create accounts, borrow and return library resources, and manage membership levels - all through the text based interface
---

## Features
User Management:
- Create free user accounts
- Login authentication (username & password)
- Change account password
- Upgrade to premium membership
- Downgrade to free tier

Membership System:
- Free Users:
1. Borrow up to 3 items
2. 10-day borrowing period
3. No access to e-books
- Premium Users:
1. Borrow up to 10 items
2. 30-day borrowing period
3. Access to e-books

Resource Management:
- View available resource by category (book, DVDs and E-books)
- Borrow resources (if available)
- Return borrowed resources
- Automatic due-date assignment
- Resource copy count tracking
---

## Project Structure
LibrarySystem/
├── src/  
│   └── com/  
│       └── mrLuhwani/  
│           └── librarySystem/  
│               ├── App.java  
│               │  
│               ├── userModel/  
│               │   └── UserModel.java  
│               │   └── Membershiplevel.java  
│               │   └── FreeUser.java  
│               │   └── PremiumUser.java  
│               │  
│               ├── resourceModel/  
│               │   └── ResourceModel.java  
│               │   └── Book.java  
│               │   └── Dvd.java  
│               │   └── Ebook.java  
│               │  
│               └── utilities/  
│                   └── UserUtilities.java  
│                   └── ResourceUtilities.java  

---

## Current Limitations
- No persistence yet as data is stored in memory
- No librarian/admin role implemented
- No input validation for emails and password strength
- Resources must be created in code
- CSV file rewrites fully after each update (simple & safe).  

---

## Future Improvements
- Persistence with CSV, or with SQL if learned
- Librarian/admin model
- Improving validation and security
- Unit testing
- Using build tools

## License
This project is solely for learning purposes and is open for modification and experimentation