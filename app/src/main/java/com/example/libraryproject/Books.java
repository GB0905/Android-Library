package com.example.libraryproject;

//북 클래스
public class Books {
    int img;                //도서 이미지
    String title = "";      //도서 제목
    String writer = "";     //도서 정보
    String location = "";   //도서 청구기호
    String rentbook = "";   //도서 상태 (대출 가능 여부, 분실 여부)

    public Books(int img,String title, String writer, String location,String rentbook) {
        super();
        this.img = img;
        this.title = title;
        this.writer = writer;
        this.location = location;
        this.rentbook = rentbook;
    }
    public Books() { }
}
