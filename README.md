# PDFLex

## About

An interactive dashboard that allows Securian policy holders to seamlessly submit, edit and view their claims online.

Coded with Java on the Spring Boot framework and uses MongoDB for the database. See our frontend [here](https://github.com/PDFlex/pdflex-frontend)!

Created by Team Consonants: Ben, Jiya, Lana, Sarah, Vithu!

## How to Run Locally
1. Download project (Green "Code" button > "Download ZIP")
2. Extract zip & open project in IDE
3. Navigate to flex > src > main > java > consonants.flex > view > FlexApplication
4. Run FlexApplication
   
The backend will now be hosted on http://localhost:8080/.

TODO: Provide information on how to access different parts of the database from different subdirectories on localhost8080.

### Notes When Attempting to Run
- You require specific fields in your .env file, located in flex > src > main > resources
  - For Team Consonants members, go to our team Google Drive > Backend Files
  - Otherwise, please contact one of us directly to send this file to you!
- Your IP address must be whitelisted in the MongoDB
  - For Team Consonants members, log into cloud.mongodb.com, then go to Network Access > Add Current IP Address
  - Otherwise, please contact one of us directly with your IP address so we can whitelist you!
