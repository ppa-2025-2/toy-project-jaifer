CREATE        TABLE     EVIDENCES(
id            UUID      Primary key,
Content_type  varchat(200) Not null,
content       Bytea        Not null,
filename      varchat(100) not null,

);