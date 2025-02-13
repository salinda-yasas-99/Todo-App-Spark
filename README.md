# Task Manager Application

This is a simple Task Manager application built with Spring Boot. The application allows users to manage tasks with basic CRUD functionality, including the ability to create, update, deactivate (soft delete), and delete tasks.

## Features
- **Create Task**: Add new tasks with title, description, and status.
- **Read Tasks**: View all tasks or a specific task by ID.
- **Update Task**: Update task details.
- **Delete Task**: Mark task as delete.

## Prerequisites

Before you run this project, ensure you have the following installed on your local machine:

- [Java 17 or higher](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/) (for dependency management and building)
- An IDE such as [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/)

## Getting Started

### 1. Clone the Repository

Clone the project repository to your local machine:

git clone https://github.com/yourusername/task-manager.git


### 2. Go to edit configurations and add your mongo db uri to environment variables

MONGO_DB_URI=mongodb://localhost:27017/todo-db

![image](https://github.com/user-attachments/assets/089f5dbc-ac28-4261-8d1e-b4f16c35f2ff)


### 3. Add launch browser setting to launch swagger API documentation on Run. 
http://localhost:8080/swagger-ui/index.html
![image](https://github.com/user-attachments/assets/e668b701-e2ae-4db3-aad4-05231156ea55)

