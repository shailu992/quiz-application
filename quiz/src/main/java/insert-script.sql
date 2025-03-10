

--script for inserting questions
insert into quiz.question (question_id,question,is_active,created_by) values(1,'Number of primitive data types in Java are?',1,'SYSTEM');
insert into quiz.question (question_id,question,is_active,created_by) values(2,'What is the size of float and double in java?',1,'SYSTEM');
insert into quiz.question (question_id,question,is_active,created_by) values(3,'Automatic type conversion is possible in which of the possible cases?',1,'SYSTEM');
insert into quiz.question (question_id,question,is_active,created_by) values(4,'When an array is passed to a method, what does the method receive?',1,'SYSTEM');
insert into quiz.question (question_id,question,is_active,created_by) values(5,'Select the valid statement to declare and initialize an array?',1,'SYSTEM');
insert into quiz.question (question_id,question,is_active,created_by) values(6,'Arrays in java are-',1,'SYSTEM');
insert into quiz.question (question_id,question,is_active,created_by) values(7,'When is the object created with new keyword?',1,'SYSTEM');
insert into quiz.question (question_id,question,is_active,created_by) values(8,'Identify the corrected definition of a package.',1,'SYSTEM');
insert into quiz.question (question_id,question,is_active,created_by) values(9,'Identify the keyword among the following that makes a variable belong to a class,rather than being defined for each instance of the class.',1,'SYSTEM');
insert into quiz.question (question_id,question,is_active,created_by) values(10,'compareTo()returns',1,'SYSTEM');


-- script for inserting answers to each question
insert into quiz.answer (answer_id,answer,is_active,created_by) values(1,'6',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(2,'7',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(3,'8',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(4,'9',1,'SYSTEM');

insert into quiz.answer (answer_id,answer,is_active,created_by) values(5,'32 and 64',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(6,'32 and 32',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(7,'64 and 64',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(8,'64 and 32',1,'SYSTEM');

insert into quiz.answer (answer_id,answer,is_active,created_by) values(9,'Byte to int',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(10,'int to long',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(11,'Long to int',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(12,'Short to int',1,'SYSTEM');

insert into quiz.answer (answer_id,answer,is_active,created_by) values(13,'The reference of the array',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(14,'A copy of the array',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(15,'Length of the array',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(16,'Copy of first element',1,'SYSTEM');

insert into quiz.answer (answer_id,answer,is_active,created_by) values(17,'int[] A={}',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(18,'int[] A={1,2,3}',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(19,'int[] A=(1,2,3)',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(20,'int[][] A={1,2,3}',1,'SYSTEM');

insert into quiz.answer (answer_id,answer,is_active,created_by) values(21,'Object references',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(22,'Objects',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(23,'Primitive data type',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(24,'None',1,'SYSTEM');

insert into quiz.answer (answer_id,answer,is_active,created_by) values(25,'At run time',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(26,'At compile time',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(27,'Depends on the code',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(28,'None',1,'SYSTEM');

insert into quiz.answer (answer_id,answer,is_active,created_by) values(29,'A package is a collection of editing tools',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(30,'A package is a collection of classes',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(31,'A package is a collection of classes and inheritence',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(32,'A package is a collection of inheritence',1,'SYSTEM');

insert into quiz.answer (answer_id,answer,is_active,created_by) values(33,'final',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(34,'static',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(35,'volatile',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(36,'abstract',1,'SYSTEM');

insert into quiz.answer (answer_id,answer,is_active,created_by) values(37,'True',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(38,'False',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(39,'An int value',1,'SYSTEM');
insert into quiz.answer (answer_id,answer,is_active,created_by) values(40,'None',1,'SYSTEM');

--script for mapping questions to answers
insert into quiz.question_answer (question_id,answer_id,is_active,created_by) values(1,3,1,'SYSTEM');
insert into quiz.question_answer (question_id,answer_id,is_active,created_by) values(2,5,1,'SYSTEM');
insert into quiz.question_answer (question_id,answer_id,is_active,created_by) values(3,10,1,'SYSTEM');
insert into quiz.question_answer (question_id,answer_id,is_active,created_by) values(4,13,1,'SYSTEM');
insert into quiz.question_answer (question_id,answer_id,is_active,created_by) values(5,18,1,'SYSTEM');
insert into quiz.question_answer (question_id,answer_id,is_active,created_by) values(6,22,1,'SYSTEM');
insert into quiz.question_answer (question_id,answer_id,is_active,created_by) values(7,25,1,'SYSTEM');
insert into quiz.question_answer (question_id,answer_id,is_active,created_by) values(8,31,1,'SYSTEM');
insert into quiz.question_answer (question_id,answer_id,is_active,created_by) values(9,34,1,'SYSTEM');
insert into quiz.question_answer (question_id,answer_id,is_active,created_by) values(10,39,1,'SYSTEM');

--script for mapping answer choices to each question
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(1,1,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(1,2,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(1,3,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(1,4,1,'SYSTEM');

insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(2,5,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(2,6,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(2,7,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(2,8,1,'SYSTEM');

insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(3,9,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(3,10,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(3,11,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(3,12,1,'SYSTEM');

insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(4,13,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(4,14,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(4,15,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(4,16,1,'SYSTEM');

insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(5,17,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(5,18,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(5,19,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(5,20,1,'SYSTEM');

insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(6,21,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(6,22,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(6,23,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(6,24,1,'SYSTEM');

insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(7,25,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(7,26,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(7,27,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(7,28,1,'SYSTEM');

insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(8,29,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(8,30,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(8,31,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(8,32,1,'SYSTEM');

insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(9,33,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(9,34,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(9,35,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(9,36,1,'SYSTEM');

insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(10,37,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(10,38,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(10,39,1,'SYSTEM');
insert into quiz.answer_options (question_id,answer_id,is_active,created_by) values(10,40,1,'SYSTEM');









