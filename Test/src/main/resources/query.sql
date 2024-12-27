CREATE TABLE IF NOT EXISTS Students (
  ID  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  Name TEXT NOT NULL,
  GroupName TEXT NOT NULL,
  Score
  INTEGER NOT NULL
 );

 SELECT * FROM Students;
 SELECT * FROM Students WHERE ID > 3
 SELECT GroupName FROM Students WHERE ID = 2

 INSERT INTO Students (Name, GroupName, Score) VALUES ("Bob", "Tbz11", 80);

 UPDATE Students SET Score = 90 WHERE Name = "Bob";

 DELETE FROM Students WHERE ID = 0;