# ThePost

ThePost is a template for creating cross-platform applications using Kotlin Multiplatform (KMP). It provides a basic file structure and includes tools and libraries for efficient development, such as a version catalog for dependencies, a Shared MVI (Model-View-Intent) architecture with Kotlin Flows and Coroutines, Kermit logger, Ktor HTTP client, Koin dependency injection, and SQLDelight for database integration.

# Screen Shoots
<div align="center">
   <a target="_blank" rel="noopener noreferrer" href="">
     <img src="https://github.com/thefaisalurrehman/Post-App/assets/77713815/a89ef8b2-a498-4d95-836b-aac027d86b82" width="330" style="max-width: 100%;"></a>
 &nbsp;

  <a target="_blank" rel="noopener noreferrer" href="">
     <img src="https://github.com/thefaisalurrehman/Post-App/assets/77713815/d01306b0-3ecd-4ee8-955c-d2491a063a57" width="330" style="max-width: 100%;"></a>
  </div>
  <br>
  <hr>
  <br>


## Project Structure

The project is organized into the following directories:

- `commonMain`: Shared code for all platforms.
- `androidMain`: Android-specific code.
- `iosMain`: iOS-specific code.
- `shared`: Common code used across platforms.

## Managing Dependencies

A version catalog is used to manage dependencies, making it easy to maintain and update libraries.

## Shared MVI View Model

ThePost follows the MVI architecture pattern for managing UI state. It includes a shared ViewModel using Kotlin Flows and Coroutines to handle business logic and UI updates efficiently across platforms.

## Logging with Kermit

Kermit is used for logging, offering configurable logging levels to help debug your application.

## Network Requests with Ktor

Ktor is used for making network requests. It provides a flexible and asynchronous way to perform HTTP operations on all platforms.

## Dependency Injection with Koin

Koin is used for dependency injection, making it easy to manage and inject dependencies in your KMP project.

## Database Operations with SQLDelight

SQLDelight is integrated for database operations. It provides type-safe database queries and helps maintain a consistent data layer across platforms.

## Getting Started

To use this template, follow these steps:

1. Clone this repository.
2. Open the project in your preferred Kotlin IDE.
3. Customize the project to fit your application's needs.
4. Use the shared code in your platform-specific projects to create your app.

## Contributing

Feel free to contribute to this project or use it as a starting point for your Kotlin Multiplatform project. If you have any questions or need assistance, please open an issue in this repository.

Happy coding! 🚀
