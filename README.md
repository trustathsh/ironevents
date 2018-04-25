ironevents
=======
ironevents includes the event pojos for other iron projects like ironvas_EventsToAMQP.
In the case you want easily use a iron project that emits events, you can import this project as dependency to process the events in your own code.

If you use an iron project, just look in the pom dependencies to clearify if the iron project use ironevents.

If you like to build ironvas EventsToAMQP by your own you can use the
latest code from the [GitHub repository][githubrepo].


Requirements
============
To use the binary package of ironevents you need the following components:

* OpenJDK Version 1.8 or higher

If you have downloaded the source code and want to build ironevents by
yourself Maven 3 is also needed.


Configuration
=============
You do not have to configure anything.


Building
========
You can build ironevents by executing:

	$ mvn package

in the root directory of the ironvas project.
Maven should download all further needed dependencies for you. After a successful
build you should find the `ironevents-x.x.x-bundle.zip` in the `target` sub-directory.


Running
=======
To run the binary package of ironevents simply execute:

	$ ./start.sh

But you will only see a message, that this project has currently no function.
It only holds the data definitions.

Using
=======

Run maven install to install the dependency in your local .m2 cache.
After that you should be able to use it in other projects.

    $ mvn install

Feedback
========
If you have any questions, problems or comments, please contact
	<f4-i-trust@lists.hs-hannover.de>


LICENSE
=======
ironevents is licensed under the [Apache License, Version 2.0] [5].


Note
====

ironevents is an experimental prototype and is not suitable for productive use. 

Feel free to fork/contribute.

[3]: http://www.trustedcomputinggroup.org/developers/trusted_network_connect
[4]: https://github.com/trustathsh
[5]: http://www.apache.org/licenses/LICENSE-2.0.html
[githubrepo]: https://github.com/trustathsh/ironevents
