# carolyn-tries-clojure

My first clojure attempts

## Format time

Given some seconds, format them as years, days, hours, minutes and seconds 

Eg 3662 is formatted as "1 hour, 1 minute and 2 seconds"

### Run

###### On command line

    lein run

This should prompt you to enter a number of seconds ..

###### As a jar

Build the jar first
    
    lein uberjar
    
Run

    java -jar ./target/uberjar/carolyn-tries-clojure-0.1.0-SNAPSHOT-standalone.jar    

###### In IDE

Find & click the green play arrow next to the main function in core.clj


## Prereqs (in progress!)

Not sure what you need just to run? But to develop

1. JDK 8 or above (actually only tested with 11 - and not sure if you need JDK or just JRE)
2. [Leiningen](https://leiningen.org/) the clojure build tool (this comes with the clojure compiler so it's the only thing you need to install) 
 I used [SDKMan](https://sdkman.io/) to install, `sdk install leiningen`

## IDE

Use IntelliJ IDEA with the [Cursive](https://cursive-ide.com/) plugin