select * from tab;
select * from board;
select * from REPLYBOARD;

-- 댓글 게시판
drop table replyBoard;
create table replyBoard (
	rno number primary key, --댓글 번호(시퀀스를 현재 쓰고 있지 않지만 시퀀스 써도 괜찮다)
	bno number not null references board(num), --부모의 번호와 같다
	replytext varchar2(500) not null,
	replyer varchar2(50) not null,
	regdate date not null, --글을 작성한 날짜
	updatedate date not null --글을 수정한 날짜
);
select * from REPLYBOARD;
select * from board order by num desc;
insert into REPLYBOARD values(10,262,'11','나',sysdate,sysdate);