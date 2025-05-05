# 🧪 SQL Exercise for QA Interviews

This exercise is designed to assess the candidate's ability to understand relationships between tables and write SQL queries that join related data.

## 🧩 Tables

<table>
<tr>
<td width="50%">

### Table: `users`

Contains information about the system's users.

| user_id | name       | email         |
| ------- | ---------- | ------------- |
| 1       | Ana Gómez  | ana@mail.com  |
| 2       | Juan Pérez | juan@mail.com |
| 3       | Luis Soto  | luis@mail.com |

</td>
<td width="50%">

### Table: `orders`

Contains the orders placed by users.

| order_id | user_id | product    | amount |
| -------- | ------- | ---------- | ------ |
| 101      | 1       | Keyboard   | 35.99  |
| 102      | 1       | Mouse      | 19.99  |
| 103      | 2       | Monitor    | 120.00 |
| 104      | 3       | Webcam     | 45.00  |
| 105      | 3       | Headphones | 50.00  |

</td>
</tr>
</table>

---

## 🧠 Exercise Statement

Using the `users` and `orders` tables, write an SQL query to display:

- The **user's name**
- Their **email**
- The **product** they purchased
- The **order amount**

## ✅ Expected Result

| name       | email         | product    | amount |
| ---------- | ------------- | ---------- | ------ |
| Ana Gómez  | ana@mail.com  | Keyboard   | 35.99  |
| Ana Gómez  | ana@mail.com  | Mouse      | 19.99  |
| Juan Pérez | juan@mail.com | Monitor    | 120.00 |
| Luis Soto  | luis@mail.com | Webcam     | 45.00  |
| Luis Soto  | luis@mail.com | Headphones | 50.00  |

---

## 🧠 Exercise Statement

Using the `users` and `orders` tables, write an SQL query to find **the user who placed the most orders**. The result should include:

- The **user's name**
- Their **email**
- The **total number of orders** they placed

Only one result should be returned — the user with the highest number of orders.

---

## ✅ Expected Result

| name      | email        | total_orders |
| --------- | ------------ | ------------ |
| Ana Gómez | ana@mail.com | 2            |
