# Trackforce Mobile Challenge

## Architecture Overview

This project follows a Clean Architecture approach structured in three main layers:

1. **Presentation Layer:**

    * Contains the ViewModel and UI models used for displaying data.
    * Responsible for exposing data to the UI and handling user interaction.
    * UI models are mapped specifically to avoid leaking domain or data layer details into the presentation.

2. **Domain Layer:**

    * Contains core business logic and defines use cases.
    * We implemented a **single UseCase** to encapsulate the repository interaction and expose a simplified API to the Presentation Layer.
    * Domain models are declared here, agnostic of data sources.

3. **Data Layer:**

    * Manages data sources (local Room database and remote OpenWeather API).
    * Implements the Repository pattern (Structural Pattern) to abstract the data access.
    * Utilizes a Strategy Pattern (Behavioral Pattern) to switch between Remote and Local data sources depending on network availability.
    * Contains Mappers (Structural Pattern) to transform DTOs and Entities into Domain Models and vice versa.

## Design Patterns Used

* **Repository Pattern (Structural):**
  Centralized data handling, abstracting away data sources (remote/local).

* **Strategy Pattern (Behavioral):**
  Dynamically chooses between RemoteSourceStrategy and LocalSourceStrategy.

* **Mapper Pattern (Structural):**
  Used for converting data models across Data, Domain, and Presentation layers.

* **Singleton (Creational):**
  Used for configuring Network Services ensuring a single shared instance across the app.

* **Adapter (Structural - Android Convention):**
  Applied in RecyclerView implementations for UI lists.

## Offline Capabilities

* On app launch, weather data is fetched from the remote API and cached locally.
* If offline, the app displays the last fetched data.
* Local database acts as a fallback mechanism when network requests fail.

## Future Improvements

* **Model Structuring:**
  Currently, some data is stored as JSON strings for simplicity. A more robust approach would involve normalizing and structuring these models to allow efficient queries.

* **Database Cleanup:**
  Implement strategies to clear outdated or duplicate data from the database to maintain performance and avoid unnecessary storage consumption.

## AI Involvement in Development

AI tools provided significant support throughout the project. They assisted in:

* Validating architectural decisions.
* Refining naming conventions and documentation.
* Generating code scaffolding, especially for repetitive tasks like DTOs and Mappers.
* Drafting README documentation and providing technical clarifications.

The AI assistance streamlined decision-making and helped maintain focus during critical stages, especially under time constraints.

## Technical Stack

* Java 11 (selected for compatibility and stability within Android environments).
* MVVM architecture.
* Hilt for Dependency Injection.
* Room Database for local storage.
* Retrofit & OkHttp for network operations.
* RxJava3 for asynchronous operations.
* JUnit & Mockito for Unit Testing.

---

**Note:** Installation and running instructions will be provided in the submission email with the repository link.
