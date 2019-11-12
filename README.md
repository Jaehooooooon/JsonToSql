# JsonToSql
java program that parses json data &amp; inserts to sqlite database

RoomList, Room : 데이터 담을 인스턴스 용 클래스 (Json 데이터 폼에 맞게)

InsertApp : 데이터들 받아서 sql

CheckJSON : 지정된 경로의 로컬 json 파일 받아서 json 으로 파싱하여 String 으로 반환

JsonParserClass : main 가지고 있음. json 데이터 파싱해서 인스턴스 화, 강의실 호수에서 층수 뽑아내기, sql 실행

