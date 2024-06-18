# NetworkConnectionTest

This is a simple program to test ipv6 network connection with your jre.

# To use
Compile the code and get the jar from `build/libs/`, then execute it: `java -jar NetworkConnectionTest.jar`

For test purpose, I added `Thread.sleep(20000);`, so it will first stuck for 20s.

Default test address is `[2001:470:1:18::115]:80` (is `ipv6.test-ipv6.com`).

You can change test address in command line argument:
```
java -jar NetworkConnectionTest.jar [host] [port]
```

or through system property:
```
java -DtestHost=<host> -DtestPort=<port> NetworkConnectionTest.jar
```

that's all!

# To use (Minecraft mod)

the Minecraft mod version required Fabric Loader 0.15.7+ to load,
and it will quit the game after test has completed.
nothing else excepts.
