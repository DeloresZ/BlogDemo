create table TBL_USER
(
  userid         VARCHAR2(255),
  uname          VARCHAR2(32) unique,
  blogname       VARCHAR2(32),
  userpass       VARCHAR2(32),
  email          VARCHAR2(32),
  descriptions   VARCHAR2(32),
  createtime     VARCHAR2(32),
  lastmodifytime DATE,
  delflag        CHAR(1)
);