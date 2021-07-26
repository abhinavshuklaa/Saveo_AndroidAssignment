# Saveo_AndroidAssignment(UI + MVVM + Retrofit + RecyclerView with Pagination)
##Problem Statement
> Develop an android app with a movie list and show movie detail when click as shown in 
design.

##ScreenShots
![Ist](https://user-images.githubusercontent.com/56826217/126928288-409b35d6-1e00-4f35-b258-976dd24b09d1.png)
![IVth](https://user-images.githubusercontent.com/56826217/126928276-bba2677d-9de7-45ae-8605-0acf0e17d2d5.png)
![IInd](https://user-images.githubusercontent.com/56826217/126928283-45c52859-c175-4846-b455-13184bbeb32c.png)
![IIIrd](https://user-images.githubusercontent.com/56826217/126928282-4204dab4-603e-4704-a2b0-9c65a286e0cd.png)



## Must Follow
-  Must be in Kotlin.
- Must use Retrofit for Network call.
- Design must be as accurate as possible.
- Use pagination (populate more data when the list is scrolled).
- Max 2 days is allowed for assignment submission.
- Write readable code
- Functions/Methods name must reflect its objective/purpose.
- Use MVVM architecture.

## Technology/Stack Used

**In this project I have used the following tech stack.**
- Kotlin 
- Android
- MVVM architecture
- Retrofit

To get a local copy up and running follow these simple example steps.

### Dependencies/libraries used
-    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation 'androidx.core:core-ktx:1.5.0'
    implementation 'androidx.appcompat:appcompat:1.3.0'
    implementation 'com.google.android.material:material:1.3.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    implementation 'androidx.paging:paging-runtime:3.1.0-alpha03'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'

    def jetpack_version = "2.3.0"
    def arch_version = '2.2.0-alpha01'
    def retrofit_version = "2.9.0"
    def coroutines = "1.4.1"
    def kotlinCoroutineVersion = "1.4.2"

    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-extensions:$arch_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$arch_version"

    //Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion"
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation "com.squareup.okhttp3:logging-interceptor:4.0.1"
    implementation 'de.hdodenhof:circleimageview:3.1.0'

    implementation 'androidx.recyclerview:recyclerview:1.2.1'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
    implementation 'com.todkars:shimmer-recyclerview:0.4.1'
    implementation 'com.facebook.shimmer:shimmer:0.5.0'

    //lottie animations
    implementation "com.airbnb.android:lottie:3.7.0"

//ZoomLayoutManager
    implementation 'com.github.Spikeysanju:ZoomRecylerLayout:1.0'

### Install

After making a clone of this repo open your cmd/terminal and use by installing in your phone.


### Please fork the repository and then use it on your own. If you want to collaborate with us on this project then please feel free to reach out to us.


## Show your support

Give a ⭐️ if you like this project!


