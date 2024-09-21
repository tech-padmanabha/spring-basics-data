# Spring boot data

## Basic examples of data Jpa

### Work with @OneToMany & @ManyToOne Mapping

**@OneToMany**
Basics of JPA is you need to Provide the @Entity and @Id in your Entity class.

> Fallow Bellow

```java
@Setter
@Getter
@Entity
@Table(name="dept")
public class Department {

	@Id
	@Column(name = "deptno",length = 2)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer departmentNo;

	@Column(name = "dname",length = 14)
	private String departmentName;

	@Column(name = "loc",length = 13)
	private String location;

//  To solve recursive problems in serialization for infinite data
//	@JsonManagedReference

	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	private Set<Employee> employees;

}
```

+ Here in Column we provided name and the length
+ In @OneToMany jpa default `fetch = FetchType.LAZY` is LAZY so we will not touch it.
+ Where we are going to mapping/releating the data we are providing `mappedBy = "department"` with the appropriate defined name.
+ What are the operations`(CRUD)` we can do over the releative table those information we need to provide at `cascade = CascadeType.ALL`.

> In Other side you need to Handle it.

**@ManyToOne**
In releationship we need to provide the data like,

```java
@Setter
@Getter
@Entity
@Table(name = "emp")
public class Employee {

	@Id
	@Column(name = "empno", length = 4)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;

	@Column(name = "ename", length = 20)
	private String empName;

	@Column(name = "job", length = 9)
	private String job;

	@Column(name = "mgr", length = 4)
	private Integer manager;

	@Column(name = "hiredate")
	private LocalDate hireDate;

	@Column(name = "sal", precision = 7, scale = 2)
	private BigDecimal salary;

	@Column(name = "comm", precision = 7, scale = 2)
	private BigDecimal commission;

//	@JsonBackReference // If we use Entity directly as dto then we can use
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "deptno")
	private Department department;

	public Employee() {

	}
}
```

Here Basic information we need to provide.
+ Provide the join Column Name `@JoinColumn`.
+ With that we can provide the what are the operations we can do in
bidirectional relationship between them.

> [!CAUTION]
> At the time of finding the all data or releative data there are change of recursive infinite data occures while loading.

Fallow the Notes
> 
> [!NOTE]
> To Handle the recursive infinite data problemes here we can use Dto class, we can stop where the recurssion happens.

or

> [!NOTE]
> Here ater geting the data jackson go dip to dip, for prevent that.we can use `@JsonManagedReference` at Parent claas and `@JsonBackReference` at Child class level, And `@JsonIgnore` is there we can use as well.

> [!IMPORTANT]
> You can falow the above example properly to avoid these errors.

### Work with @ManyToMany Mapping
