# Store API

## Overview

This project provides a basic API for a store management system, developed in a Spring Boot environment. The API facilitates CRUD operations for managing users, products, and sales. Although Swagger UI documentation is not available at the moment, the endpoints are described below.

## Endpoints

### Users

#### List Users
- **Endpoint:** `GET /api/users`
- **Description:** Retrieves a list of all users.

#### Get User by ID
- **Endpoint:** `GET /api/users/{id}`
- **Description:** Retrieves a specific user by their ID.

#### Create User
- **Endpoint:** `POST /api/users`
- **Description:** Creates a new user.

#### Update User
- **Endpoint:** `PUT /api/users/{id}`
- **Description:** Updates an existing user by their ID.

#### Delete User
- **Endpoint:** `DELETE /api/users/{id}`
- **Description:** Deletes a specific user by their ID.

### Products

#### List Products
- **Endpoint:** `GET /api/products`
- **Description:** Retrieves a list of all products.

#### Get Product by ID
- **Endpoint:** `GET /api/products/{id}`
- **Description:** Retrieves a specific product by its ID.

#### Create Product
- **Endpoint:** `POST /api/products`
- **Description:** Creates a new product.

#### Update Product
- **Endpoint:** `PUT /api/products/{id}`
- **Description:** Updates an existing product by its ID.

#### Delete Product
- **Endpoint:** `DELETE /api/products/{id}`
- **Description:** Deletes a specific product by its ID.

### Sales

#### List Sales
- **Endpoint:** `GET /api/sales`
- **Description:** Retrieves a list of all sales.

#### Get Sale by ID
- **Endpoint:** `GET /api/sales/{id}`
- **Description:** Retrieves a specific sale by its ID.

#### Create Sale
- **Endpoint:** `POST /api/sales`
- **Description:** Creates a new sale.

#### Update Sale
- **Endpoint:** `PUT /api/sales/{id}`
- **Description:** Updates an existing sale by its ID.

#### Delete Sale
- **Endpoint:** `DELETE /api/sales/{id}`
- **Description:** Deletes a specific sale by its ID.

### Additional Endpoints

#### Filter Sales by Customer Name
- **Endpoint:** `GET /api/sales/customer`
- **Description:** Lists sales filtered by part of the customer's name.
- **Query Parameter:** `name` (Partial name of the customer)

#### Filter Sales by Employee Name
- **Endpoint:** `GET /api/sales/employee`
- **Description:** Lists sales filtered by part of the employee's name.
- **Query Parameter:** `name` (Partial name of the employee)

#### Top 10 Products by Price
- **Endpoint:** `GET /api/products/top10`
- **Description:** Lists the 10 most expensive products.

#### Customers Aged 18-35
- **Endpoint:** `GET /api/customers/age-range`
- **Description:** Lists customers aged between 18 and 35 years.

#### Top 10 Sales by Total Amount
- **Endpoint:** `GET /api/sales/top10`
- **Description:** Lists the 10 sales with the highest total amounts.
