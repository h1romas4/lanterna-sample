# Lanterna Sample

![](https://github.com/h1romas4/lanterna-sample/workflows/Java%20CI/badge.svg)

This repos provide Lanterna sample source by Groovy.

## Lanterna

> [Java library for creating text-based GUIs](https://github.com/mabe02/lanterna)
>
> Lanterna is a Java library allowing you to write easy semi-graphical user interfaces in a text-only environment, very similar to the C library curses but with more functionality. Lanterna is supporting xterm compatible terminals and terminal emulators such as konsole, gnome-terminal, putty, xterm and many more. One of the main benefits of lanterna is that it's not dependent on any native library but runs 100% in pure Java.

## Screenshot

![screenshot](https://github.com/h1romas4/lanterna-sample/blob/master/docs/lanterna-sample.png)

## Development

```
$ git clone https://github.com/h1romas4/lanterna-sample.git
$ cd lanterna-sample
$ ./gradlew shadowJar
$ java -jar build/libs/lanterna-sample-all.jar
```
