# Secure Pref - Secure Shared Preference Library for Android
a android library wich allows to insert data to shared preference fast and scure with flexibility.It also use [MCrypt](https://github.com/serpro/Android-PHP-Encrypt-Decrypt) to encrypt data.


## Installation

1. Add https://jitpack.io to your project.

	```
	allprojects {
	   repositories {
	      jcenter()
	      maven { url "https://jitpack.io" }
	   }
	}
	```
2. Include the library in your ``build.gradle``

```gradle
dependencies{
    implementation 'com.github.mehdi-ghorbani97:secure_pref:1.0'
}
```


## Setup

 Initialize the shared preference inside the onCreate of the Application class of your app :
 
 
 ```Java
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the SecurePref class
	// SecurePref.initialize(context , random 15 character string , random 15 character string);
	SecurePref.initialize(getApplicationContext(), "Hu27jf!:nV,K6C78", "_].MF6p#N7K*b^3j");
	
    
    }
}
```
## Usage
After initialization, you can use simple one-line methods to save values to the shared preferences anywhere in your app, such as:

- `Prefs.putString(key, string)`
- `Prefs.putLong(key, long)`
- `Prefs.putBoolean(key, boolean)` 

Retrieving data from the Shared Preferences can be as simple as:

    String data = Prefs.getString(key, default value)
 
 ## Contact   
 Please fell free to contact me if there is any problem when using the library.
 - **Email**: mehdighor23@gmail.com
 



 
