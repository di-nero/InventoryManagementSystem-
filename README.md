Dinero Inventory Management System
Description
The Dinero Inventory Management System is a Spring Boot-based REST API that manages products, product categories, and stock transactions. It supports creating, updating, and deleting products, managing categories, tracking stock changes, and calculating total inventory value. All actions are logged and stored in a MySQL database.
Setup Instructions
1. Install the latest IntelliJ IDEA or Eclipse.
2. Clone the repository:
   git clone https://github.com/di-nero/InventoryManagementSystem-.git
3. Open the project in your IDE.
4. Configure the application.properties file:
   spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
5. Run the application.
6. Test the APIs with Postman.
Project Structure
Controller - Handles REST API endpoints
Service - Contains the business logic
Repository - Manages database operations using JPA
Entities - Represent tables (Product, Category, Transaction)
API Endpoints
Category Endpoints
POST /api/categories - Create Category
GET /api/category/{id} - Get Category by ID
DELETE /api/categories/{id} - Delete Category
Product Endpoints
POST /api/products - Create Product
PUT /api/products - Update Product
GET /api/products/low-stock - Get Low Stock Products
GET /api/products/value - Get Inventory Value
DELETE /api/products/{id} - Delete Product
Transaction Endpoints
POST /api/transactions - Add Transaction
GET /api/transactions/product/{productName} - Get Transactions by Product
Example Summary
Create Category - POST /api/categories
Get Product Value - GET /api/products/value
Get Low Stock - GET /api/products/low-stock
Create Transaction - POST /api/transactions
