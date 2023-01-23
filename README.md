<h1 align="center">Toggle-Tab </h1></br>

<p align="center">
:toggle-tab: Toggle Tab
</p>
</br>


### Gradle
Add the dependency below to your **module**'s `build.gradle` file:

```gradle
dependencies {
    implementation "com.github.ocetin00:ToggleTab:1.0.0"
}
```


</details>

## How to Use

### Create Balloon with Kotlin
We can create an instance of the Balloon with the `Balloon.Builder` class.

```kotlin
val balloon = Balloon.Builder(context)
  .setWidthRatio(1.0f)
  .setHeight(BalloonSizeSpec.WRAP)
  .setText("Edit your profile here!")
  .setTextColorResource(R.color.white_87)
  .setTextSize(15f)
  .setIconDrawableResource(R.drawable.ic_edit)
  .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
  .setArrowSize(10)
  .setArrowPosition(0.5f)
  .setPadding(12)
  .setCornerRadius(8f)
  .setBackgroundColorResource(R.color.skyBlue)
  .setBalloonAnimation(BalloonAnimation.ELASTIC)
  .setLifecycleOwner(lifecycle)
  .build()
```

### Create Balloon with Kotlin DSL
We can also create an instance of the Balloon with the Kotlin DSL.

<details>
 <summary>Keep reading for more details</summary>

You can create an instance of the Balloon with `createBalloon` as the example below:
```kotlin
    @Preview
    @Composable
    fun ToggleTabPreview2() {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
        ) {
            ToggleTab(modifier = Modifier.fillMaxWidth(0.6f),titleList = listOf("Male", "Famele"), onTabSelected = {})
        }
    }
```
</details>

### Create Balloon with Java
You can create an instance of the Balloon with Java by using the `Balloon.Builder` class.

<details>
 <summary>Keep reading for more details</summary>

You can create an instance of the Balloon as the following example below: 
```kotlin
Balloon balloon = new Balloon.Builder(context)
   @Preview
@Composable
fun ToggleTabPreview1() {
    var selectedPageIndex by remember {
        mutableStateOf(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth()
                .background(Color.White), horizontalArrangement = Arrangement.Center
        ) {
            ToggleTab(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.9f)
                    .clip(ShapeDefaults.ExtraLarge),
                onTabSelected = { index ->
                    selectedPageIndex = index
                },
                titleList = listOf("First", "Second", "Third"),
                tabItemTextStyle = TextStyle.Default.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        var backgroundColor: Color = when (selectedPageIndex) {
            0 -> Color.Green
            1 -> Color.Magenta
            2 -> Color.Cyan
            else -> {
                Color.Green
            }
        }
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
                .background(backgroundColor)
        ) {

        }
    }
}
```
</details>



## Find this library useful? :heart:
:star: <br>
Also, __[follow me](https://github.com/ocetin00)__ on GitHub for my next creations! 

# License
```xml
Copyright 2019 ocetin00 (Oğuzhan Çetin)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
