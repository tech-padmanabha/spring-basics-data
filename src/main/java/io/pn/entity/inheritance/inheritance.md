# Inheritance Mapping Strategies
## Single Table
* Maps all entities in inheritance tree to a **Single Database Table**
* **A discriminator column** indicates the type/class of data in the row
* **Table has** columns for all fields
* **Each row will** will only use a subset of the fields
* **Unused** fields are stores as `null`

Example : 

SingleEngine.java
```Java
@Data
@Entity
@Table(name = "single_engine")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// there are optional, if we don't define then hibernate take the column_name as DTYPE
@DiscriminatorColumn(name = "engine_type",discriminatorType = DiscriminatorType.STRING)
public abstract class SingleEngine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String engineName;
    private String fuelCapacity;
}
```
SingleBike.java
```java
package io.pn.entity.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity

//It defines as value in table engine columns engine_type
@DiscriminatorValue("Bike")
public class SingleBike extends SingleEngine{

    private String mileage;

}

```
SingleJeep.java
```Java
package io.pn.entity.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("Jeep")
public class SingleJeep extends SingleEngine {

    private String wheelSize;
    private String color;
}

```
- *@Inheritance* Specify the inheritance strategy. Possible values `SINGLE_TABLE`, `TABLE_PER_CLASS`, `JOINED`.
- *@DiscriminatorColumn* Name of the column that holds the discriminator values. Default to `DTYPE`.
- *@DiscriminatorValue* A unique value that describes a given subclass. Default to `class` name.


> [!NOTE]
> Write the Test case for these program and see the result

## Table per Class
* It creates per class one table.

Example:

PerClassEngine.java
```Java
@Data
@Entity
@Table(name = "robot_engine")
// If table TABLE_PER_CLASS is here then GeneratorType should be GenerationType.TABLE
// It creates a sequence generator table and maintain the sequence with thread safe manner
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PerClassEngine {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String engineName;
    private String fuelCapacity;
}
```
PerClassBike.java
```Java
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PerClassBike extends PerClassEngine {

    private String mileage;

}
```
PerClassJeep.java
```Java
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PerClassJeep extends PerClassEngine {

    private String wheelSize;
    private String color;
}
```

> [!NOTE]
> When `InheritanceType.TABLE_PER_CLASS `then ID generator should be `GenerationType.TABLE`. It Generates the ID in thread safe manner.
## Joined Table
* For the Inheritance table tree, all `classes` are mapped to a `table`.
* Superclass table contains fields common to all subclasses
* Subclass tables contain only fields specific to the subclass
* Inheritance is modeled with a `foreign key`.
* Hibernate will `Join` the data based on `primary key` and `foreign key`.

Example:
JoinedEngine.java
```Java
@Data
@Entity
@Table(name = "ai_engine")
//  InheritanceType.JOINED help us to map relation between parent and child,
//  Parent Primary key act as foreign key in child table
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class JoinedEngine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String engineName;
    private String fuelCapacity;
}
```
JoinedBike.java
```Java
@Data
@Entity
public class JoinedBike extends JoinedEngine {
    private String mileage;
}
```
JoinedJeep.java
```Java
@Data
@Entity
public class JoinedJeep extends JoinedEngine {
    private String wheelSize;
    private String color;
}
```
> [!NOTE]
> It Joins with subclass tables only. strategy should be `GenerationType.IDENTITY`.

## Mapped superclass
* For the inheritance tree. subclass is mapped to a `table`.
* Each table has the inherited fields and fields defined in the subclass
* The mapped `superclass` is no longer a `separate table/entity` (no @Entity)
* Only the `subclasses` will use `@Entity`.
* Only the `subclasses` will have `tables` in the database.
* Steps:
   - In superclass annotate with `@MappedSuperclass`
   - In subclass, remove the annotation like `@Entity`,`@Table`,`@Inheritance`.
   - In subclasses, use normal Hibernate annotation `@Entity`.

Example:
Engine.java

```Java
//@Entity
//@Table(name = "ai_engine")
// @Inheritance(strategy = InheritanceType.JOINED)

@MappedSuperclass
public abstract class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String engineName;
    private String fuelCapacity;
}
```
Bike.java
```Java
@Data
@Entity
public class Bike extends Engine {
    private String mileage;

}
```
Jeep.java
```Java
@Data
@Entity
public class Jeep extends Engine {
    private String wheelSize;
    private String color;
}
```
> [!NOTE]
> Based on the requirement you can choose among them.
4th method is `preferable`.

### Guidance
* Best Performance with queries and write operations.`Single table `
* Good performance for queries of subclasses and data integrity. `Table Per Class` or `Mapped Superclass`
* Normalized database design and data integrity. `Joined Table`
