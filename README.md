# TechViv Music App 🎵

[![Kotlin](https://img.shields.io/badge/Kotlin-Multiplatform-7F52FF?logo=kotlin)](https://kotlinlang.org/)
[![Compose](https://img.shields.io/badge/Compose-Multiplatform-4285F4?logo=jetpack-compose)](https://www.jetbrains.com/lp/compose-multiplatform/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

A modern, cross-platform music streaming application built with Kotlin Multiplatform and Compose Multiplatform. 
Stream your favorite songs, create playlists, and discover new music - all in one place.

## ✨ Features

- 🎧 **Cross-Platform** - Single codebase for Android, iOS, Desktop, and Web
- 🎨 **Modern UI** - Built with Jetpack Compose and Material 3 design
- 📱 **Responsive Design** - Optimized for all screen sizes and devices
- 🌙 **Dark/Light Theme** - Choose your preferred theme
- 🔍 **Smart Search** - Find your favorite tracks instantly
- 🎶 **High-Quality Audio** - Enjoy crystal clear sound quality
- 📱 **Offline Mode** - Listen without an internet connection
- 🔄 **Sync Across Devices** - Seamless experience across all your devices

## 📱 App Screenshots

<div align="center" style="background-color: #f5f5f5; padding: 20px; border-radius: 10px; margin: 20px 0;">
  <div style="display: flex; flex-wrap: wrap; justify-content: center; gap: 15px; margin: 0 auto; max-width: 900px;">
    <img src="https://raw.githubusercontent.com/vivekkumar9798/DemoKMPProject/main/IMG_0160.PNG" alt="Home Screen" style="width: 160px; border-radius: 12px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); transition: transform 0.3s ease;" onmouseover="this.style.transform='scale(1.05)'" onmouseout="this.style.transform='scale(1)'"/>
    <img src="https://raw.githubusercontent.com/vivekkumar9798/DemoKMPProject/main/IMG_0161.PNG" alt="Search Screen" style="width: 160px; border-radius: 12px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); transition: transform 0.3s ease;" onmouseover="this.style.transform='scale(1.05)'" onmouseout="this.style.transform='scale(1)'"/>
    <img src="https://raw.githubusercontent.com/vivekkumar9798/DemoKMPProject/main/IMG_0162.PNG" alt="Playlist View" style="width: 160px; border-radius: 12px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); transition: transform 0.3s ease;" onmouseover="this.style.transform='scale(1.05)'" onmouseout="this.style.transform='scale(1)'"/>
    <img src="https://raw.githubusercontent.com/vivekkumar9798/DemoKMPProject/main/IMG_0163.PNG" alt="Now Playing" style="width: 160px; border-radius: 12px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); transition: transform 0.3s ease;" onmouseover="this.style.transform='scale(1.05)'" onmouseout="this.style.transform='scale(1)'"/>
    <img src="https://raw.githubusercontent.com/vivekkumar9798/DemoKMPProject/main/IMG_0164.PNG" alt="Profile" style="width: 160px; border-radius: 12px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); transition: transform 0.3s ease;" onmouseover="this.style.transform='scale(1.05)'" onmouseout="this.style.transform='scale(1)'"/>
  </div>
  <p style="margin-top: 15px; color: #666; font-size: 0.9em;">✨ Hover over screenshots to zoom in</p>
</div>

## ✨ Features

- 🎧 **Cross-Platform** - Single codebase for Android, iOS, Desktop, and Web
- 🎨 **Modern UI** - Built with Jetpack Compose and Material 3 design
- 📱 **Responsive Design** - Optimized for all screen sizes and devices
- 🌙 **Dark/Light Theme** - Choose your preferred theme
- 🔍 **Smart Search** - Find your favorite tracks instantly
- 🎶 **High-Quality Audio** - Enjoy crystal clear sound quality
- 📱 **Offline Mode** - Listen without an internet connection
- 🔄 **Sync Across Devices** - Seamless experience across all your devices

## 🚀 Tech Stack

- **UI**: Compose Multiplatform
- **Backend**: Ktor Server
- **Networking**: Ktor Client
- **Dependency Injection**: Koin
- **Build System**: Gradle with Kotlin DSL
- **Multiplatform**: Kotlin Multiplatform Mobile (KMM)

## 📱 Supported Platforms

| Platform | Version |
|----------|---------|
| Android  | 8.0+ (API 26+) |
| iOS      | 14.0+ |
| Desktop  | Windows, macOS, Linux |
| Web      | Modern Browsers (WASM & JS) |

## 🏗️ Project Structure

```
.
├── composeApp/          # Shared Compose Multiplatform code
│   ├── src/
│   │   ├── commonMain/  # Shared Kotlin code for all platforms
│   │   ├── androidMain/ # Android-specific code
│   │   ├── iosMain/     # iOS-specific code
│   │   └── jvmMain/     # Desktop (JVM) specific code
│   └── build.gradle.kts # Compose app configuration
│
├── iosApp/              # iOS application entry point
│   └── iosApp/          # Xcode project and SwiftUI code
│
├── server/              # Ktor backend server
│   └── src/main/kotlin/
│
├── shared/              # Shared business logic
│   └── src/commonMain/  # Platform-agnostic business logic
│
├── build.gradle.kts     # Root project configuration
└── settings.gradle.kts  # Project structure definition
```
  ```

### Build and Run Server

To build and run the development version of the server, use the run configuration from the run widget
in your IDE’s toolbar or run it directly from the terminal:
- on macOS/Linux
  ```shell
  ./gradlew :server:run
  ```
- on Windows
  ```shell
  .\gradlew.bat :server:run
  ```

## 🧪 Testing

Run all tests:
```bash
./gradlew test
```

## 🤝 Contributing

We love contributions! Here's how you can help:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

Please read our [Contributing Guidelines](CONTRIBUTING.md) for more details.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Built with ❤️ using Kotlin Multiplatform
- Powered by [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- Icons by [Material Design Icons](https://material.io/resources/icons/)
- Special thanks to the Kotlin and Compose Multiplatform communities

## 📱 Show Your Support

Give a ⭐️ if this project helped you!

## 📬 Contact

- [GitHub Profile](https://github.com/vivekkumar9798)
- [Report an Issue](https://github.com/vivekkumar9798/DemoKMPProject/issues)

---

<div align="center">
  Made with ❤️ by Vivek Kumar
</div>