# Time Of Day


Define a data abstraction for representing times of day. Allow the client to create a TimeOfDay object that represents a time of day with given hours and minutes, and to obtain the hours, to obtain the minutes, and to obtain the minutes since midnight of a given TimeOfDay object. Also allow the client to set the hours, the minutes, and the minutes since midnight.

Create a test suite for this data abstraction.

Implement this data abstraction twice, using different representations: once, where a TimeOfDay object stores the hours and the minutes, and once where it stores the minutes since midnight. Both versions should expose exactly the same API and make exactly the same test suite succeed.

First define the data abstraction's API and the test suite, and commit it to GitHub. Use "throw new RuntimeException("Not yet implemented");" for the method and constructor bodies. At this point, the data abstraction and test suite are accepted by Eclipse without red underlines, and by reasoning about the test suite based on the API documentation you can conclude that the test suite should succeed for any correct implementation of the data abstraction, but of course the test suite does not yet succeed. Then develop the first implementation, run the test suite (which should now succeed) and commit it, and then change it into the second version, run the test suite again (which should again succeed) and commit it.
