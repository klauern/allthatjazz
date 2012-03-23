allthatjazz
===========

I'm a big fan of [Dropwizard](http://dropwizard.codahale.com), and I thought
it would be a really fun Java project to get acquainted with RESTful APIs, clean
Java libraries like [JDBI](http://www.jdbi.org), and just have some fun with
Java. 

This project is really the [dropwizard-example](https://github.com/codahale/dropwizard/tree/master/dropwizard-example), with some minor tweaks to handle running [BackboneJS](http://documentcloud.github.com/backbone/) and
[Twitter Bootstrap](https://twitter.github.com/bootstrap).

I think this is fun stuff, and I was unaware of how cool and easy Backbone is
to get running.

Check this project out if you'd like to toy with it.  I'd suggest starting by
understanding what is required to run Dropwizard:

  * Java 6+
  * Maven

And then you can bootstrap the app and just go with it:

    mvn install
    java -jar target/allthatjazz-1.0.0-SNAPSHOT.jar setup hello-world.yml

    # then, run it
    
    java -jar target/allthatjazz-1.0.0-SNAPSHOT.jar server hello-world.yml


This is really just a facny front-end for a few really polished libraries.
I'd really just look at the [Dropwizard documentation](http://dropwizard.codahale.com)
to really learn what this is about.
