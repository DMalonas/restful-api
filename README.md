# events
Manage different data sources with identical json structure (but different properties)
The correct way is to do it with jackson polymorphism (had to solve these two issues below first):

1)
https://stackoverflow.com/questions/72396593/jackson-mapper-could-not-resolve-subtype-of-simple-type-class-missing-type


And when I beyond that


2)
https://stackoverflow.com/questions/15833979/java-jackson-deserialize-complex-polymorphic-object-model-jsonmappingexception
