CREATE TABLE BOARD_TBL
(
    BNO     INT auto_increment PRIMARY KEY,
    TITLE   VARCHAR(100),
    CONTENT VARCHAR(255),
    REGDATE TIMESTAMP,
    BTYPE   VARCHAR(10)
)

CREATE TABLE USER_TBL
(
    ID   INT auto_increment PRIMARY KEY,
    NAME VARCHAR(10),
    TYPE VARCHAR(10)
)

