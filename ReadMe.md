## tutorial
https://docs.oracle.com/javase/tutorial/rmi/TOC.html

```bat
mvn archetype:generate -DgroupId=org.example 
                    -DartifactId=java-rmi
                    -DarchetypeArtifactId=maven-archetype-quickstart
                    -DinteractiveMode=false
```

Creating and Installing a Security Manager

```java
if (System.getSecurityManager() == null) {
    System.setSecurityManager(new SecurityManager());
}
```
