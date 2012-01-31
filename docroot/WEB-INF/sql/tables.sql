create table EnqueteNoticia (
	enqueteNoticiaId LONG not null primary key,
	questionId LONG,
	articleId LONG
);

create table EnqueteNoticia_EnqueteNoticia (
	enqueteNoticiaId LONG not null primary key,
	pollId LONG,
	articleId LONG
);