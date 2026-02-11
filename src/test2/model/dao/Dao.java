package test2.model.dao;

import test2.model.dto.Dto;
import test2.view.View;

import java.sql.*;
import java.util.ArrayList;

public class Dao {
    private Dao(){connect();}
    private static final Dao instance = new Dao();
    public static Dao getInstance(){return instance;}

    //데이터베이스 연동
    // 연동할 db서버의 정보
    private String url = "jdbc:mysql://localhost:3306/testservice";
    private String user = "root";private String password="1234";
    //연동 인터페이스 변수 선언
    private Connection conn;
    //연동 함수 정의
    private void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url , user , password);
            System.out.println("데이터베이스 연동 성공");
        }catch (Exception e){System.out.println("데이터베이스 연동 실패");}
    }

    //물품등록
    public boolean write(String nickname , String product , String content , int price , int pwd , String phone){
        try{
            //sql 작성
                String sql = "insert into product(nickname , product , content , price , pwd , phone)values(?,?,?,?,?,?)";
            //연동된 인터페이스에 sql기재
            PreparedStatement ps = conn.prepareStatement(sql);
            //sql에 기대횐 인터페이스에 sql 매개변수 대입
            ps.setString(1 , nickname);
            ps.setString(2 , product);
            ps.setString(3 , content);
            ps.setInt(4, price);
            ps.setInt(5 , pwd);
            ps.setString(6, phone);
            //sql실행
            int count = ps.executeUpdate();
            //결과제어
            if(count ==1){return true;}
            else{return false;}
        }catch (SQLException e){
            System.out.println("SQL 문법 오류" + e);
        }
        return false;
    }

    //전체물품목록조회
    public ArrayList<Dto> findAll() {
        ArrayList<Dto> products = new ArrayList<>();
        try{String sql = "select * from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int bno = rs.getInt("bno");
                String nickname = rs.getString("nickname");
                String product = rs.getString("product");
                String content = rs.getString("content");
                int price = rs.getInt("price");
                int pwd = rs.getInt("pwd");
                String phone = rs.getString("phone");
                boolean isAvailable = rs.getBoolean("isAvailable");
                String bdate =rs.getString("bdate");
                Dto dto = new Dto(bno , nickname , product , content , price , pwd , phone , isAvailable , bdate);
                products.add(dto);
            }
        }catch (SQLException e){System.out.println("SQL 문법발생 2" + e);}
        return products;
    }
    //물품 정보 수정
    public boolean update(int bno , int pwd, String product , String content , int price , String phone , boolean isAvailable){

        try{
            String sql = "update product set product=?,content=?,price=?,phone=?,isAvailable=? where bno = ? and pwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product);
            ps.setString(2, content);
            ps.setInt(3, price);
            ps.setString(4, phone);
            ps.setBoolean(5 , isAvailable);
            ps.setInt(6, bno);
            ps.setInt(7, pwd);
            int count = ps.executeUpdate();
            if(count ==1){return true;}
            else{return false;}
        }catch (SQLException e){System.out.println("sql 문법발생 3" + e);}
        return false;
    }

    //물품 삭제
    public boolean delete(int bno , int pwd){
        try{
            String sql = "delete from product where bno = ? and pwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            ps.setInt(2 ,pwd);
            int count = ps.executeUpdate();
            if(count ==1){return true;}
            else{return false;}
        }catch (SQLException e){System.out.println("sql문법발생 4 " + e);}
        return false;
    }








}//c end
