create table TBL_BLOGGER
(
  bid         NUMBER(5),
  userid      NUMBER(5),
  title       VARCHAR2(32),
  blogcontent VARCHAR2(1000),
  cid         NUMBER(5),
  lv          NUMBER(5),
  readable    CHAR(1),
  createtime  DATE,
  delflag     CHAR(1)
);