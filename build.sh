javac -Xlint *.java
jar cfe RedSquareFX.jar Main *.class style.css bg.jpg
rm *.class
java -jar RedSquareFX.jar