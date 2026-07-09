# Hands on 4: Difference between JPA, Hibernate and Spring Data JPA

## Java Persistence API (JPA)
* JSR 338 Specification for persisting, reading and managing data from Java objects.
* Does not contain a concrete implementation of the specification.
* Hibernate is one of the implementations of JPA.

## Hibernate
* ORM Tool that implements JPA.

## Spring Data JPA
* Does not have a JPA implementation, but reduces boilerplate code.
* This is another level of abstraction over a JPA implementation provider like Hibernate.
* Manages transactions.

---

## Code Comparison

Refer to the code snippets below on how the code compares between Hibernate and Spring Data JPA.

### Hibernate

```java
/* Method to CREATE an employee in the database */
public Integer addEmployee(Employee employee){
    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;
    
    try {
        tx = session.beginTransaction();
        employeeID = (Integer) session.save(employee); 
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace(); 
    } finally {
        session.close(); 
    }
    return employeeID;
}
```

### Spring Data JPA

**EmployeeRepository.java**
```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
```

**EmployeeService.java**
```java
@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee) {
    employeeRepository.save(employee);
}
```

---

## Reference Links
* [What is the difference between Hibernate and Spring Data JPA?](https://dzone.com/articles/what-is-the-difference-between-hibernate-and-sprin-1)
* [What is JPA? Introduction to the Java Persistence API](https://www.javaworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html)
