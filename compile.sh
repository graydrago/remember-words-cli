#! /bin/sh
if [ ! -d ./out ]; then
    mkdir out
fi
javac -d out -cp ./ ru/graydrago/Main.java

