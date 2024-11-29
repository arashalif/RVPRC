
# RVPRC

This Android application project focuses on implementing a two-page UI based on the provided design mockups. The goal is to achieve pixel-perfect accuracy while adhering to Android's best practices and ensuring a smooth and responsive user experience. The application is developed using modern Android tools and clean architecture principles, with a modularized structure.






## Screenshots


<p align="center">
  <img src="https://github.com/arashalif/RVPRC/blob/main/screen_shot/Screenshot_20241130_013658_RVPRC.jpg" width="24%" alt="App Screenshot">
  <img src="https://github.com/arashalif/RVPRC/blob/main/screen_shot/Screenshot_20241130_013705_RVPRC.jpg" width="24%" alt="App Screenshot">
  <img src="https://github.com/arashalif/RVPRC/blob/main/screen_shot/Screenshot_20241130_013713_RVPRC.jpg" width="24%" alt="App Screenshot">
  <img src="https://github.com/arashalif/RVPRC/blob/main/screen_shot/Screenshot_20241130_013722_RVPRC.jpg" width="24%" alt="App Screenshot">
</p>

## APK Download

You can download the APK file directly from the project to test the application:

[Download APK](https://github.com/arashalif/RVPRC/blob/main/apk/RVPRC.apk)

> Ensure you have enabled **"Install unknown apps"** on your device to install the APK.


## Why I Solved The Problem In This Particular Way

### Repository Design Pattern and Separating presentation Layer

In this project, I chose to implement the repository design pattern and separate the domain layer for several reasons:

1. **Separation of Concerns**: By separating concerns into different layers, such as the data, domain, and presentation layers, the codebase becomes more modular and easier to maintain. Each layer has its own responsibilities and can be developed, tested, and modified independently.

2. **Abstraction of Data Sources**: The repository acts as an abstraction layer that shields the domain layer from the details of data retrieval and storage. It provides a clean API for accessing data, regardless of the underlying data sources, such as local databases, network services, or in-memory caches.

3. **Decoupling from Implementation Details**: With the repository pattern, the presentation layer depends only on abstractions defined by interfaces, rather than concrete implementations of data sources. This decoupling allows for easier substitution of data sources and facilitates testing by enabling the use of mock objects.

4. **Promotion of Testability**: Separating the domain layer and using the repository pattern promotes testability. The business logic encapsulated in the use cases can be unit-tested independently of the data sources, leading to more reliable and maintainable tests.

5. **Flexibility and Scalability**: Adopting the repository pattern provides flexibility and scalability to the application. New data sources can be added or existing ones replaced without modifying the domain layer, as long as they adhere to the repository interfaces. This makes it easier to adapt the application to changing requirements or integrate with different backend systems.

### Why I Decided to Use Modular Architecture

In this project, adopting a modular architecture was a deliberate choice to achieve scalability, maintainability, and better collaboration among components. Here are the reasons:

1. **Clear Separation of Concerns**: Modular architecture allows each module to have a clearly defined responsibility. For instance:
- Feature modules (e.g., video details, editing) handle specific UI and user interactions.
- Core modules manage shared resources like utilities, networking, and base classes.
This separation ensures a clean boundary between features and shared components, reducing dependencies and enhancing readability.

2. **Scalability**: As the application grows, modular architecture makes it easier to add or update features without affecting other parts of the system. Each module can be developed, tested, and deployed independently, supporting rapid iteration and evolution.

3. **Improved Build Performance**: Modularization helps optimize build times, especially in large projects, by enabling incremental builds. Changes in one module don’t require rebuilding the entire application, resulting in faster feedback during development.

4. **Reusability**: Modules encapsulate logic and components that can be reused across the project or even in other applications. For example, the networking layer or UI components can be easily plugged into new features or projects without duplication.

5. **Future-Proofing**: With a modular design, the application is more adaptable to future changes. For instance, replacing a database or upgrading the UI framework (e.g., from XML layouts to Jetpack Compose) can be done with minimal impact on other modules.

Overall, writing use cases facilitates the implementation of clean architecture principles, promotes separation of concerns, and enhances the maintainability and testability of the application.
## Tools Used
- Jetpack Compose: A modern toolkit for building native Android UI.
- AndroidX Core KTX: Kotlin extensions for core Android libraries.
- AndroidX Lifecycle: Extensions for ViewModel and LiveData.
- Hilt: Dependency injection library for Android.
- Retrofit: A type-safe HTTP client for Android and Java.
- OkHttp: An HTTP client for Android and Java applications.
- Navigation Component: A library for handling navigation between destinations.
- JUnit: A unit testing framework for Java.
- Mockito: A mocking framework for unit tests in Java.
- Coroutines: A library for asynchronous programming in Kotlin.
- Kotlinx Serialization: Library for JSON serialization and deserialization.
- AndroidX Core Testing: Library for testing LiveData and other architecture components.
- Jetpack Compose Testing: Libraries for testing Jetpack Compose UI.
- Espresso: A testing framework for UI tests in Android.
- AndroidX Test Ext: Extensions for writing Android tests.
