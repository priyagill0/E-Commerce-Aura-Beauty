# E-Commerce Website


## Installation

### Prerequisites:
- Node.js (v18+ recommended)  
- npm (comes with Node.js)  
- Java 17+ 
- Maven (for building the Spring Boot backend)
- PostgreSQL and PGAdmin (optional) for database.

### Backend Setup:
1. Navigate to the backend directory: `cd backend`
2. Build the project: `mvn clean install -DskipTests`
3. Run the Spring Boot server: `mvn spring-boot:run`
4. The backend should now be running on: http://localhost:8080

### Frontend Setup:
1. Open a new terminal window and navigate to the frontend folder: `cd frontend`
2. Install dependencies: `npm install`
3. Run the development server: `npm run dev`
4. The frontend should now be running on: http://localhost:3000

### Database Setup (Supabase):
- The project uses PostgreSQL as its database.
- The backend code is already integrated with the database using environment variables in `application.properties`.
- No additional setup is required to connect to the database. 
