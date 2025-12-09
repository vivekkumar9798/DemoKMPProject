# TechViv Music App

🎵 A modern, cross-platform music streaming application built with Kotlin Multiplatform and Compose Multiplatform. Stream your favorite songs, create playlists, and discover new music - all in one place.

## � Screenshots

<div style="display: flex; flex-wrap: wrap; gap: 10px; margin: 20px 0;">
  <img src="https://file+.vscode-resource.vscode-cdn.net/Users/jai/Desktop/KMP/DemoKMPProject/screenshot_1.png" alt="Home Screen" width="200"/>
  <img src="https://file+.vscode-resource.vscode-cdn.net/Users/jai/Desktop/KMP/DemoKMPProject/screenshot_2.png" alt="Search Screen" width="200"/>
  <img src="https://file+.vscode-resource.vscode-cdn.net/Users/jai/Desktop/KMP/DemoKMPProject/screenshot_3.png" alt="Player Screen" width="200"/>
  <img src="https://file+.vscode-resource.vscode-cdn.net/Users/jai/Desktop/KMP/DemoKMPProject/screenshot_4.png" alt="Playlist View" width="200"/>
  <img src="https://file+.vscode-resource.vscode-cdn.net/Users/jai/Desktop/KMP/DemoKMPProject/screenshot_5.png" alt="Settings" width="200"/>
</div>

## �🚀 Features

- **Cross-Platform**: Single codebase for Android, iOS, Desktop, and Web
- **Modern UI**: Built with Jetpack Compose and Material 3 design
- **Offline Mode**: Listen to your favorite tracks without an internet connection
- **Personalized Recommendations**: Discover new music based on your listening habits
- **High-Quality Audio**: Stream music in high-quality audio format
- **Dark/Light Theme**: Choose your preferred theme

## 🏗️ Tech Stack

- **UI**: Compose Multiplatform
- **Backend**: Ktor Server
- **Networking**: Ktor Client
- **Dependency Injection**: Koin
- **Build System**: Gradle with Kotlin DSL
- **Multiplatform**: Kotlin Multiplatform Mobile (KMM)

## 📱 Supported Platforms

- Android 8.0+ (API 26+)
- iOS 14.0+
- Desktop (Windows, macOS, Linux)
- Web (WASM & JS)

## 🛠️ Project Structure

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

## 🚀 Getting Started

### Prerequisites

- JDK 17 or higher
- Android Studio Flamingo (2022.2.1) or later
- Xcode 14.1+ (for iOS development)
- Node.js 16+ (for web development)
- Kotlin 1.9.22
- Gradle 8.5+

### Clone the Repository

```bash
git clone <repository-url>
cd DemoKMPProject
```

## 🏃‍♂️ Running the App

### Android

```bash
# Build debug APK
./gradlew :composeApp:assembleDebug

# Install on connected device
./gradlew :composeApp:installDebug

# Run tests
./gradlew :composeApp:testDebugUnitTest
```

### iOS

1. Open `iosApp/iosApp.xcworkspace` in Xcode
2. Select your development team in the Signing & Capabilities tab
3. Build and run the app on a simulator or device

### Desktop (JVM)

```bash
# Run the application
./gradlew :composeApp:run

# Create a distributable package
./gradlew :composeApp:packageDistributionForCurrentOS
```

### Web

```bash
# Run development server (WASM target)
./gradlew :composeApp:wasmJsBrowserDevelopmentRun

# Build production bundle
./gradlew :composeApp:wasmJsBrowserProductionWebpack
```

### Server

```bash
# Run development server
./gradlew :server:run

# Build production JAR
./gradlew :server:shadowJar
```

## 🧪 Testing

Run all tests:
```bash
./gradlew test
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Built with ❤️ using Kotlin Multiplatform
- Powered by Compose Multiplatform
- Icons by [Material Design Icons](https://material.io/resources/icons/)

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [YouTrack](https://youtrack.jetbrains.com/newIssue?project=CMP).