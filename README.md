WALLAPOP CODE TEST
===

Resolution of the tech exercise for Android Developer in WALLAPOP

How is made
===

* The application is build based on Clean Architecture and MVP (Model-View-Presenter)
all the data sources are mapped between api and application domains.
* The pattern repository is used to access the data
* Dagger2 for dependency injection with a Component per view
* Programing with clean code in mind, the project use checkstyle to guarantee a
correct code
* There are three important class AbstractActivity, AbstractFragment and
 AbstractAdapterView these classes manage all the lifecycle binding between
 view and presenter, also do the view injections and dependency injection.

Test
===

A few test for coverage can be found in the project

### UNIT TEST

Can be found in app/src/test/java mockito is used for class mock

### UI TEST

Can be found in app/src/androidTest/java

Images
===

![Demo Screenshot][1]

![Demo Screenshot][2]

![Demo Screenshot][3]

Marvel api
===

The application uses Marvel Api to fetch the data, if you want to compile
the application please put the keys on
com.github.glomadrian.wallapopcodetest.app.di.module.DataSourceModule;

APK
===

You can download a sample apk form [here](./art/adrianWallapopCodeTest.apk)

Developed By
------------
Adrián García Lomas - <glomadrian@gmail.com>
* [Twitter](https://twitter.com/glomadrian)
* [LinkedIn](https://es.linkedin.com/in/glomadrian )

[1]: ./art/1.png
[2]: ./art/2.png
[3]: ./art/3.png
