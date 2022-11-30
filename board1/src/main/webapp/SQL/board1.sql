-- 게시판
select * from tab;
select * from board;
-- num값과 ref값이 한개의 파일에서 동시에 작업을 하기 때문에 둘이 시퀀스를 넣을 수 없다.max함수로 +1시켜야함
create table board (
	num number primary key, -- key
	writer varchar2(20) not null, -- 작성자
	subject varchar2(50) not null, -- 제목
	content varchar2(500) not null, -- 본문
	email varchar2(30) , -- 이메일
	readcount number default 0, -- 읽은 횟수
	passwd varchar2(12) not null, -- 암호
	ref number not null, -- 답변글끼리 그룹
	re_step number not null, -- ref내의 순서
	re_level number not null, -- 들여쓰기
	ip varchar2(20) not null, -- 작성자 ip
	reg_date date not null, -- 작성일
	del char(1) -- 글을 삭제하면 'Y', 글을 입력하면 'N'
);
update board set readcount = 51 where num = 250;