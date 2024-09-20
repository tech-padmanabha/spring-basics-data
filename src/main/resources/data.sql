
--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `deptno` int NOT NULL,
  `loc` varchar(13) NOT NULL,
  `dname` varchar(14) NOT NULL,
  PRIMARY KEY (`deptno`),
  UNIQUE KEY `UKeqtojfe82cvoqjp8rao519fig` (`loc`),
  UNIQUE KEY `UKekpf7xfhf1n4m2bcymtf364bq` (`dname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;

INSERT INTO dept(deptno,dname,loc) VALUES (10,'ACCOUNTING','NEW YORK'),
(20,'RESEARCH','DALLAS'),
(30,'SALES','CHICAGO'),
(40,'OPERATIONS','BOSTON');

UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` int NOT NULL,
  `empno` int NOT NULL,
  `hiredate` date DEFAULT NULL,
  `mgr` int DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `job` varchar(9) DEFAULT NULL,
  `ename` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`empno`),
  KEY `FKfqt0j25nlvjwt7qt1t3x7v6qf` (`deptno`),
  CONSTRAINT `FKfqt0j25nlvjwt7qt1t3x7v6qf` FOREIGN KEY (`deptno`) REFERENCES `dept` (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;

INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7369,'SMITH','CLERK',7902,'1980-12-17','800.00',NULL,'20');
INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ('7499','ALLEN','SALESMAN','7698','1981-02-20','1600.00','300.00','30');
INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ('7521','WARD','SALESMAN','7698','1981-02-22','1250.00','500.00','30');
INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ('7566','JONES','MANAGER','7839','1981-04-02','2975.00',NULL,'20');
INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ('7654','MARTIN','SALESMAN','7698','1981-09-28','1250.00','1400.00','30');
INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ('7698','BLAKE','MANAGER','7839','1981-05-01','2850.00',NULL,'30');
INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ('7782','CLARK','MANAGER','7839','1981-06-09','2450.00',NULL,'10');
INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ('7788','SCOTT','ANALYST','7566','1982-12-09','3000.00',NULL,'20');
INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ('7839','KING','PRESIDENT',NULL,'1981-11-17','5000.00',NULL,'10');
INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ('7844','TURNER','SALESMAN','7698','1981-09-08','1500.00','0.00','30');
INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ('7876','ADAMS','CLERK','7788','1983-01-12','1100.00',NULL,'20');
INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ('7900','JAMES','CLERK','7698','1981-12-03','950.00',NULL,'30');
INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ('7902','FORD','ANALYST','7566','1981-12-03','3000.00',NULL,'20');
INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ('7934','MILLER','CLERK','7782','1982-01-23','1300.00',NULL,'10');

UNLOCK TABLES;

--
-- Table structure for table `salgrade`
--

DROP TABLE IF EXISTS `salgrade`;

CREATE TABLE `salgrade` (
  `grade` int NOT NULL,
  `hisal` decimal(7,2) DEFAULT NULL,
  `losal` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `salgrade`
--

LOCK TABLES `salgrade` WRITE;

INSERT INTO `salgrade` VALUES (1,700.00,1200.00),(2,1201.00,1400.00),(3,1401.00,2000.00),(4,2001.00,3000.00),(5,3001.00,9999.00);

UNLOCK TABLES;

