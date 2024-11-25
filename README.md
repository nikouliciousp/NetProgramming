# NetProgramming Project

This project demonstrates a simple DayTime server and client implementation in Java. The server listens for incoming connections on port 13 and responds with the current date and time. The client connects to the server and retrieves the date and time.

## Features

- **DayTime Server**: Listens for connections on port 13 and responds with the current date and time.
- **DayTime Client**: Connects to the DayTime server to retrieve the date and time.

## Prerequisites

- Java Development Kit (JDK) 8 or higher

## Usage

### Running the DayTime Server

1. Compile the `DayTimeServer` class:

    ```sh
    javac gr/perisnik/daytime/DayTimeServer.java
    ```

2. Run the `DayTimeServer`:

    ```sh
    java gr.perisnik.daytime.DayTimeLocalServer
    ```

### Running the DayTime Client

1. Compile the `DayTimeClient` class:

    ```sh
    javac gr/perisnik/daytime/DayTimeClient.java
    ```

2. Run the `DayTimeClient`:

    ```sh
    java gr.perisnik.daytime.DayTimeClient
    ```

## Author

- **Peris Nik**
