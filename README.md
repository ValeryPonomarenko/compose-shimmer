# Shimmer
[![Release](https://jitpack.io/v/me.vponomarenko/compose-shimmer.svg)](https://jitpack.io/#me.vponomarenko/compose-shimmer)

Library provides an easy way to a add shimmer effect in Android Compose project.

<img height="480" src="https://raw.githubusercontent.com/ValeryPonomarenko/compose-shimmer/master/media/shimmer.gif">

# Installing
To download it from the jitpack, add these lines in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

And then add to the module's build.gradle

```gradle
implementation "me.vponomarenko:compose-shimmer:LATEST_VERSION"
```

LATEST_VERSION is **1.0.0**

# How to use

To add a shimmer effect to the layout, just use the `.shimmer()` modifier

```Kotlin
Column(
    modifier = Modifier
        .fillMaxSize()
        .shimmer()
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(
                color = Color(0xFFF3F3F3),
                shape = RoundedCornerShape(4.dp)
            )
    )
}
```
