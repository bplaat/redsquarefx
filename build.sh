javac -Xlint *.java
jar cfe RedSquareFX.jar Main *.class
rm *.class
java -jar RedSquareFX.jar