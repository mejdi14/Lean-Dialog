<h1 align="center">Welcome to Lean Dialog Library 👋</h1>

<p align="center">
  <a href="https://github.com/frinyvonnick/gitmoji-changelog">
    <img src="https://img.shields.io/badge/API-15%2B-blue.svg?style=flat" alt="gitmoji-changelog">
  </a>  <a href="https://github.com/frinyvonnick/gitmoji-changelog">
    <img src="https://jitpack.io/v/mejdi14/AndroidColorPicker.svg" alt="gitmoji-changelog">
  </a>
  </a>
	<a href="https://github.com/kefranabg/readme-md-generator/blob/master/LICENSE">
    <img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-yellow.svg" target="_blank" />
  </a>
  <a href="https://codecov.io/gh/kefranabg/readme-md-generator">
    <img src="https://codecov.io/gh/kefranabg/readme-md-generator/branch/master/graph/badge.svg" />
  </a>
</p>

## ✨ Demo
<p align="center">
<img src="https://github.com/mejdi14/Lean-Dialog/blob/main/app/images/image.png" height="400" width="550" >
	</p>
	
	
## :art:Design inspiration
many thanks goes to [Sergey](https://dribbble.com/churumovsergey) for the beautiful design and animation




## Installation

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
``` 
## :hammer:Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
    implementation 'com.github.mejdi14:Lean-Dialog:0.0.1'
}
```


## :fire:How to use

``` java
 val showDialog = remember { mutableStateOf(false) }


                    val alphaAnimation by animateFloatAsState(
                        targetValue = if (showDialog.value) 1f else 0f, label = ""
                    )

                    val offsetAnimation by animateDpAsState(
                        targetValue = if (showDialog.value) 0.dp else (DialogAnimation.BottomToCenter.value).dp,
                        animationSpec = spring(stiffness = Spring.StiffnessVeryLow), label = ""
                    )

                    Button(onClick = { showDialog.value = true }) {
                        Text("Show Dialog")
                    }

                    if (showDialog.value) {
                        LeanOverlay(showDialog, offsetAnimation, alphaAnimation, modifier = Modifier.width(300.dp)
                            .height(200.dp), dismissOnClickOutside = true){
                            BodyContentExample()
                        }
                    }
```

Animation direction
-----

``` java
    DialogAnimation.TopToCenter
    DialogAnimation.BottomToCenter
    DialogAnimation.LeftToRight
    DialogAnimation.RightToLeft
    DialogAnimation.NONE
```

BorderLineCanvasParams
-----

``` java
    val color: Color = Color.White,
    val topLeft: Offset = Offset.Zero,
    val cornerRadius: CornerRadius = CornerRadius(10f, 10f),
    val strokeWidth: Float = 2f
```
MainCardParams
-----

``` java
    val backgroundColor: Color = Color.White,
    val roundedCornerShape: RoundedCornerShape = RoundedCornerShape(10.dp),
    val rotationAngle : Float = -4f
```


## 🤝 Contributing

Contributions, issues and feature requests are welcome.<br />
Feel free to check [issues page] if you want to contribute.<br />


## Author

👤 **Mejdi Hafiane**

- profile: [@MejdiHafiane](https://twitter.com/mejdi141)

## Show your support

Please ⭐️ this repository if this project helped you!
