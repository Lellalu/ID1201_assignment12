# ID1201_assignment12
This is an assignemnt for the course ID1201, Algorithms and Data Structures, at KTH Royal Institute of Techonology. 
This assignment is about implementing and exploring the graph and try to find shortest path between two nodes.

## How run

This is an example of how to compile and test this project.

```bash
mvn clean && mvn compile && mvn test
```

In main, we have implemented a benchmark that tests different versions of implementations to find the shortest path by entering a starting city, see [Main.java](https://github.com/Lellalu/ID1201_assignment12/blob/main/src/main/java/se/kth/id1201/Main.java) 
for more details. To run this:

```bash
exec:java -Dexec.args="./data/train.csv Stockholm"
```