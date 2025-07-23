# A-to-be App

## Requirements:
- Android Studio Meerkat Feature Drop | 2024.3.2 Patch 1
- Git 2.X.X

## Install:
run: ```git clone git@github.com:kayevo/a_to_be_app.git``` to install the project in the local machine.

## Build:
run: ```./gradlew assembleDebug``` in root directory to build the project.

## Execute:
run: ```./gradlew installDebug``` in root directory to install the app in your emulator or connected device.

## Run unit tests:
run: ```./gradlew testDebugUnitTest``` in root directory to run all the unit tests.

## Implemented features:
- Feature 4, form validation.
- Get products the first 30 products from API.
- Saved the information if the products was persisted locally.

## Libraries used:
- Jetpack compose: create UI.
- Navigation: navigate between screens.
- Koin: add dependency injection.
- Coroutines: create Flows and asynchronous operations.
- JUnit: unit tests.
- Retrofit: communicate with APIs.
- Gson: serialize and deserialize Json objects.

## Technical decisions:
- Clean architecture with the classes: View -> ViewModel -> UseCase -> Repository -> DataSource. Layers: view, domain, data.
- At feature 1, local listing with pagination, the size 194 of the list dont justify the use of pagination in this scenario where the data need to be persisted once.
- At feature 3, product details, I wont implement the entire feature because, conceptually, is a repetition of the main list. I decided to focus my time other features with a height quality standards.
- At feature 4, form validation, I will implement just name and email fields, because conceptually all the fields are a repetition of the first two fields.
- Notion with the steps for the development: https://www.notion.so/Atobe-234605ed54a28034af27d20bc79279f5
 