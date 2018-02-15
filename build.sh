javac -Xlint *.java
jar cfe RedSquare.jar Main *.class
rm *.class
java -jar RedSquare.jar