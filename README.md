# PDFLex

## About

An interactive dashboard that allows Securian policy holders to seamlessly submit, edit and view their claims online.

Coded with Java on the Spring Boot framework and uses MongoDB for the database. See our frontend [here](https://github.com/PDFlex/pdflex-frontend)!

Created by Team Consonants: Ben, Jiya, Lana, Sarah, Vithu!

## How to Run Locally
1. Clone this repository onto your preferred IDE.
2. Set up your .env file. See the first "Note" below.
3. Set up your connection to our MongoDB. See the second "Note" below.
4. Navigate to flex > src > main > java > consonants.flex > FlexApplication
5. Run FlexApplication
   
The backend will now be hosted on http://localhost:8080/.

### Notes When Attempting to Run
- You require specific fields in your .env file, located in flex > src > main > resources
  - For Team Consonants members, go to our team Google Drive > Backend Files
  - Otherwise, please contact one of us directly to send this file to you!
- Your IP address must be whitelisted in the MongoDB
  - For Team Consonants members, log into cloud.mongodb.com, then go to Network Access > Add Current IP Address
  - Otherwise, please contact one of us directly with your IP address so we can whitelist you!
- Our application is running on Java Corretto 17.
