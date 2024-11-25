# NetProgramming Project

This project demonstrates a simple DayTime server and client implementation in Java. The server listens for incoming connections on port 13 and responds with the current date and time. The client connects to the server and retrieves the date and time.

## Features

- **Concurrent DayTime Local Server**: Listens for connections on port 13 and responds with the current date and time.
- **DayTime Local Server**: Listens for connections on port 13 and responds with the current date and time.
- **DayTime Client for Local Server**: Connects to the DayTime Local Server to retrieve the date and time.
- **DayTime Client**: Connects to the DayTime Server to retrieve the date and time.

## Prerequisites

- Java Development Kit (JDK) 8 or higher

## Usage

### Running the Concurrent DayTime Local Server

1. Compile the `ConcurrentDayTimeLocalServer` class:

    ```sh
    javac gr/perisnik/daytime/ConcurrentDayTimeLocalServer.java
    ```

2. Run the `ConcurrentDayTimeLocalServer`:

    ```sh
    java gr.perisnik.daytime.ConcurrentDayTimeLocalServer
    ```

3. Compile the `DayTimeClientForLocalServer` class:

    ```sh
    javac gr/perisnik/daytime/DayTimeClientForLocalServer.java
    ```

2. Run the `DayTimeClientForLocalServer`:

    ```sh
    java gr.perisnik.daytime.DayTimeClientForLocalServer
    ```

### Running the DayTime Local Server

1. Compile the `DayTimeLocalServer` class:

    ```sh
    javac gr/perisnik/daytime/DayTimeLocalServer.java
    ```

2. Run the `DayTimeLocalServer`:

    ```sh
    java gr.perisnik.daytime.DayTimeLocalServer
    ```

3. Compile the `DayTimeClientForLocalServer` class:

    ```sh
    javac gr/perisnik/daytime/DayTimeClientForLocalServer.java
    ```

2. Run the `DayTimeClientForLocalServer`:

    ```sh
    java gr.perisnik.daytime.DayTimeClientForLocalServer
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
