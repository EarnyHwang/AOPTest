# the AOP exec twice in org.springframework.boot 3.1.12 test



## Getting started

1. Navigate to the `backend` folder in the terminal.
2. Run the project by entering `./gradlew bootRun`.
3. Use Postman to send a GET request to `"http://localhost:8080/test"`.
4. You can see debug messages in the terminal, the `afterReturn2` function is executed twice.
5. Change `"org.springframework.boot"` to another version (3.1.11 or above 3.2.1) in `build.gradle`, you will notice the `afterReturn2` function is executed only once.
