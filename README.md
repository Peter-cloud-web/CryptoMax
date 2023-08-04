# CINEMAX MOVIE APP
Android application utilizing the Kotlin programming language. This application seamlessly integrates with the renowned  [COINCAP_API](https://docs.coincap.io/) , which allows users to explore and discover a
wide range of cryptocurrency exchanges including an extensive listing with current market prices.

## Table Of Content

- [CRYPTOMAX PHOTOS](#cryptomax-photos)
    - [Table Of Content](#table-of-content)
    - [Architecture](#architecture)
    - [Tech Stack](#tech-stack)
        - [Libraries](#libraries)
    - [Screenshots](#screenshots)


## Architecture

The app is built on MVVM architecture

## Tech Stack

### Libraries

__UI__

- [Hilt](https://dagger.dev/hilt/) - Dependency Injection framework
- [Coil](https://coil-kt.github.io/coil/) - Load images from network source.
- [Jetpack Navigation](https://developer.android.com/guide/navigation) - Navigations from one fragment to another.

__Data__

- [KTOR Client](https://ktor.io/docs/create-client.html)
- [KotlinX Serialization](https://github.com/Kotlin/kotlinx.serialization) - Serialization/Desirialization of JSON response from network.


