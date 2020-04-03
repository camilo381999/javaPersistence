# javaPersistence
La base de datos se llama MiBaseDatosDB y se crea con el script a continuacion:

CREATE TABLE ESTUDIANTES 
    (
     studentId INTEGER NOT NULL PRIMARY KEY, 
     firstName VARCHAR (50) NOT NULL , 
     lastName VARCHAR (50) NOT NULL , 
     yearLevel INTEGER NOT NULL 
    );

CREATE TABLE CURSO 
    (
     courseId INTEGER NOT NULL PRIMARY KEY, 
     courseName VARCHAR (50) NOT NULL , 
     credits INTEGER NOT NULL , 
     semestre INTEGER NOT NULL , 
     cupos INTEGER NOT NULL 
    );

CREATE TABLE MATRICULA 
    (
     studentId INTEGER NOT NULL, 
     courseId INTEGER NOT NULL, 
     matriculaId INTEGER NOT NULL PRIMARY KEY, 
     FOREIGN KEY (studentId) REFERENCES ESTUDIANTES(studentId),
     FOREIGN KEY (courseId) REFERENCES CURSO(courseId)
    );
