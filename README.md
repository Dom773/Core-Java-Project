# Core-Java-Project
## Hotel Management System
# Project Objectives:
# 1. Room Management:
The system allows the hotel administrator to manage the rooms effectively. This includes adding new rooms with different characteristics such as AC/non-AC, comfort level, size, rent, and status (available or booked).

# 2. Customer Check-In:
The project enables efficient check-in procedures by recording customer details like name, address, phone number, booking ID, and payment details, assigning them to a room, and updating the room’s status.

# 3. Customer Check-Out:
The system handles the check-out process, calculating the total bill based on the number of days stayed and the rent of the room, deducting the advance payment, and updating the room status to available.

# 4. Room Availability Search:
The system provides the ability to search for rooms based on their availability, helping the staff and customers find available rooms easily.

# 5. Customer Search:
A function to search for customers who have checked into the hotel, enabling staff to quickly find customer details based on their names.

# 6. Guest Summary Report:
The system provides a summary report of all currently checked-in guests, detailing their room number, name, and phone number for easy reference.

## Project Description:
The Hotel Management System is designed to streamline the operations of a hotel by automating room allocation, customer check-in, check-out processes, and providing detailed reporting. The system is built in Java and uses Object-Oriented Programming principles, creating classes like Room and Customer to encapsulate the relevant properties and methods.

## Key Functionalities:
# 1. Manage Rooms:
The administrator can add rooms to the system by specifying room details such as whether it is AC/non-AC, its comfort level, size, and the daily rent. Each room is assigned a unique room number, and its status is updated based on availability or booking.

# 2. Check-In Room:
When a customer checks in, their details are entered into the system, and the room is marked as booked. The system takes in customer details such as their name, phone number, and booking dates. This ensures the room cannot be assigned to another customer until it becomes available again.

# 3. Check-Out Room:
At the time of check-out, the system calculates the total bill based on the number of days stayed and the daily rent of the room. It deducts any advance payment made and shows the final amount to be paid. The room status is updated to available once the check-out process is complete.

# 4. Available Rooms:
This feature lists all the rooms that are currently available for booking, helping the staff quickly allocate rooms to new customers.

# 5. Search Customer:
Staff can search for customers who are currently staying in the hotel by their name. This is useful for quickly retrieving customer information.

# 6. Guest Summary Report:
The system provides a quick report of all currently checked-in guests, showing their names, room numbers, and contact details. This report helps in managing the hotel operations efficiently.

## Classes and Structure:
# Customer Class:
Contains fields for storing customer details like name, address, phone number, booking ID, and payment details.

# Room Class:
Manages room-related data like room number, type (AC/non-AC), comfort level, size, rent, and status (booked or available). It also contains methods for adding rooms, searching for rooms, and displaying room details.

# HotelMgmt Class:
Extends the Room class and manages higher-level operations such as customer check-in, check-out, searching for customers, and generating reports.

## Technologies Used:
Java: The entire application is built using Java, utilizing Object-Oriented Programming (OOP) principles.
Scanner: Used to take user input from the console.
## How It Works:
The system runs in a loop, displaying a menu of options like managing rooms, checking in/out, searching for customers, and displaying available rooms.
Based on the user’s choice, the corresponding operation is executed.
The system maintains an array of Room objects where each room is identified by its unique room number.
Each room can be searched, booked, or freed up based on the user's actions.
## Conclusion:
This Hotel Management System project simplifies hotel operations by automating the key tasks of room allocation, customer check-in/out, and reporting. It provides a structured approach to handling customer and room data, ensuring smooth management of hotel operations.








