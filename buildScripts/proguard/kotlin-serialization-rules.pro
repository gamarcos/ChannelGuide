-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt # core serialization annotations

# kotlinx-serialization-json specific. Add this if you have java.lang.NoClassDefFoundError kotlinx.serialization.json.JsonObjectSerializer
-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}

-keep,includedescriptorclasses class com.luizalabs.pmob.megazord.**$$serializer { *; }
-keepclassmembers class com.luizalabs.pmob.megazord.** {
    *** Companion;
}
-keepclasseswithmembers class com.luizalabs.pmob.megazord.** {
    kotlinx.serialization.KSerializer serializer(...);
}
