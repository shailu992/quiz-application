
CREATE TABLE quiz.user_information (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL,
    address VARCHAR(200) ,
    phone_number BIGINT  NOT NULL
);
CREATE TABLE quiz.login (
    user_id INT ,
    login_time DATETIME NOT NULL,
    logout_time DATETIME,
    FOREIGN KEY (user_id) REFERENCES user_information(user_id)
);

CREATE TABLE quiz.question (
    question_id INT PRIMARY KEY  ,
    question VARCHAR(500) NOT NULL,
    is_active boolean,
    created_by VARCHAR(255) NOT NULL,
    created_date DATETIME,
    updated_by VARCHAR(255),
    updated_date DATETIME
);


CREATE TABLE quiz.answer (
    answer_id INT  PRIMARY KEY ,
    answer VARCHAR(300) NOT NULL,
    is_active boolean,
    created_by VARCHAR(255) NOT NULL ,
    created_date DATETIME,
    updated_by VARCHAR(255),
    updated_date DATETIME
);

CREATE TABLE question_answer (
    question_id INT,
    answer_id INT ,
    is_active boolean,
    created_by VARCHAR(255) NOT NULL ,
    created_date DATETIME,
    updated_by VARCHAR(255),
    updated_date DATETIME ,
    FOREIGN KEY (question_id) REFERENCES question(question_id),
    FOREIGN KEY (answer_id) REFERENCES answer(answer_id)
);

CREATE TABLE user_score (
    user_id INT ,
    score INT NOT NULL,
    created_by VARCHAR(255) NOT NULL ,
    created_date DATETIME,
    updated_by VARCHAR(255),
    updated_date DATETIME ,
    FOREIGN KEY (user_id) REFERENCES user_information(user_id)

);

CREATE TABLE user_reviews (
    user_id INT ,
    rating INT NOT NULL,
    comments VARCHAR(50) ,
    created_by VARCHAR(255) NOT NULL ,
    created_date DATETIME,
    updated_by VARCHAR(255),
    updated_date DATETIME ,
    FOREIGN KEY (user_id) REFERENCES user_information(user_id)
);

CREATE TABLE quiz.answer_options (
    question_id INT,
    answer_id INT ,
    is_active boolean,
    created_by VARCHAR(255) NOT NULL ,
    created_date DATETIME,
    updated_by VARCHAR(255),
    updated_date DATETIME ,
    FOREIGN KEY (question_id) REFERENCES question(question_id),
    FOREIGN KEY (answer_id) REFERENCES answer(answer_id)
);


