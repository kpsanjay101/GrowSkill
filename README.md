# # GrowSkill E-Learning Platform

## Overview

GrowSkill is an e-learning platform designed to provide online courses in Baking, Makeup, and Handicrafts. The platform allows users to enroll in paid live courses, conducted by specialized instructors. After payment, users can attend live classes on Zoom, access course recordings, and download certificates upon completion.

## Features

- Browse and enroll in courses
- Make secure online payments
- Attend live classes on Zoom
- Access course recordings
- Download course certificates

## Technologies Used

- Java
- Spring Boot
- Hibernate
- MySQL
- Thymeleaf (for web templates)
- Zoom API (for live classes)
## Project Structure

- `src/main/java/com/growskill`: Java source code
- `src/main/resources`: Configuration files and templates
- `src/test`: Unit tests
- `pom.xml`: Maven project configuration file

## Database Schema

- `course`: Information about courses
- `customer`: Customer details
- `instructor`: Details of specialized instructors
- `class_session`: Details of individual class sessions
- `payment`: Payment details for course enrollment

## How to Run

1. Clone the repository: `git clone https://github.com/yourusername/growskill.git`
2. Navigate to the project directory: `cd growskill`
3. Build the project: `mvn clean install`
4. Run the application: `java -jar target/growskill-1.0.0.jar`
5. Access the application in your browser: `http://localhost:8080`

## Contribution Guidelines

If you would like to contribute to GrowSkill, please follow these guidelines:

- Fork the repository
- Create a new branch: `git checkout -b feature/new-feature`
- Make your changes and commit: `git commit -m "Add new feature"`
- Push to the branch: `git push origin feature/new-feature`
- Submit a pull request

## License

This project is licensed under the [MIT License](LICENSE).

Happy learning with GrowSkill!
