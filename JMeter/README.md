# JMeter API Testing – Books API

This project contains API testing for the Books API hosted at [node-express-api-books](https://github.com/AnuMI4/node-express-api-books) using Apache JMeter.

## Project Overview

- API Type: REST
- Base URL: http://localhost:3000/
- Tool Used: Apache JMeter

## Test Coverage

The following HTTP methods were tested:

- GET /books – List all books
- POST /books – Add a new book
- PUT /books/{id} – Update a book completely
- PATCH /books/{id} – Update a book partially
- DELETE /books/{id} – Delete a book

## Folder Contents

| File / Folder        | Description                               |
|----------------------|-------------------------------------------|
| `Requests.jmx`       | JMeter test plan                          |
| `screenshots/`       | Screenshots showing test execution        |
| `books-data`         | CSV file                                  |
| `README.md`          | Project overview and instructions         |

## How to Run

1. Clone this repository or download the folder.
2. Open Apache JMeter.
3. Load the `Requests.jmx` file.
4. Start the local server (ensure `localhost:3000` is running).
5. Click the green Start button in JMeter to run the test plan.

## Notes

- Ensure the server from [AnuMI4/node-express-api-books](https://github.com/AnuMI4/node-express-api-books) is running locally.


## Author

- Bakhtawar Pirzada
- QA Intern

