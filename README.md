<h1 align="center">Toggle-Tab </h1></br>

<p align="center">
:toggle-tab: Toggle Tab
</p>
</br>


### Gradle
Add the dependency below to your **module**'s `build.gradle` file:

```gradle
dependencies {
    implementation "com.github.skydoves:balloon:1.5.2"
}
```


</details>

## How to Use
Balloon supports both Kotlin and Java projects, so you can reference it by your language.

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
val balloon = createBalloon(context) {
  setWidthRatio(1.0f)
  setHeight(BalloonSizeSpec.WRAP)
  setText("Edit your profile here!")
  setTextColorResource(R.color.white_87)
  setTextSize(15f)
  setIconDrawableResource(R.drawable.ic_edit)
  setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
  setArrowSize(10)
  setArrowPosition(0.5f)
  setPadding(12)
  setCornerRadius(8f)
  setBackgroundColorResource(R.color.skyBlue)
  setBalloonAnimation(BalloonAnimation.ELASTIC)
  setLifecycleOwner(lifecycle)
  build()
}
```
</details>

### Create Balloon with Java
You can create an instance of the Balloon with Java by using the `Balloon.Builder` class.

<details>
 <summary>Keep reading for more details</summary>

You can create an instance of the Balloon as the following example below: 
```java
Balloon balloon = new Balloon.Builder(context)
    .setArrowSize(10)
    .setArrowOrientation(ArrowOrientation.TOP)
    .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
    .setArrowPosition(0.5f)
    .setWidth(BalloonSizeSpec.WRAP)
    .setHeight(65)
    .setTextSize(15f)
    .setCornerRadius(4f)
    .setAlpha(0.9f)
    .setText("You can access your profile from now on.")
    .setTextColor(ContextCompat.getColor(context, R.color.white_93))
    .setTextIsHtml(true)
    .setIconDrawable(ContextCompat.getDrawable(context, R.drawable.ic_profile))
    .setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
    .setOnBalloonClickListener(onBalloonClickListener)
    .setBalloonAnimation(BalloonAnimation.FADE)
    .setLifecycleOwner(lifecycleOwner)
    .build();
```
</details>

### Show up Balloon
We can show up the Balloon using the functions below. If we use `showAlign__` method, we can show up the Balloon based on alignments (**top, bottom, right, left**). Also, we can adjust specific positions of the Balloon by using `x-Offset` and `y-Offset` parameters. <br>

```kotlin
balloon.showAlignTop(anchor: View) // shows the balloon on an anchor view as the top alignment.
balloon.showAlignTop(anchor: View, xOff: Int, yOff: Int) // shows top alignment with x-off and y-off.
balloon.showAlignBottom(anchor: View) // shows the balloon on an anchor view as the bottom alignment.
balloon.showAlignBottom(anchor: View, xOff: Int, yOff: Int) // shows bottom alignment with x-off and y-off.
balloon.showAlignRight(anchor: View) // shows the balloon on an anchor view as the right alignment.
balloon.showAlignRight(anchor: View, xOff: Int, yOff: Int) // shows right alignment with x-off and y-off.
balloon.showAlignLeft(anchor: View) // shows the balloon on an anchor view as the left alignment.
balloon.showAlignLeft(anchor: View, xOff: Int, yOff: Int) // shows left alignment with x-off and y-off.
balloon.showAsDropDown(anchor: View) // shows the balloon as a dropdown without any alignments.
balloon.showAsDropDown(anchor: View, xOff: Int, yOff: Int) // shows no alignments with x-off and y-off.
balloon.showAtCenter(anchor: View, xOff: Int, yOff: Int, centerAlign: BalloonCenterAlign.TOP)
// shows the balloon over the anchor view (overlap) as the center aligns.
```


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
