package test2.controller;

import test2.model.dao.Dao;
import test2.model.dto.Dto;
import test2.view.View;

import java.util.ArrayList;

public class Controller {
    private Controller(){}
    private static final Controller instance = new Controller();
    public static Controller getInstance(){return instance;}
    private Dao bd = Dao.getInstance();

    //물품등록
    public boolean write(String nickname , String product , String content , int price , int pwd , String phone){
        boolean result =bd.write(nickname, product, content, price, pwd, phone);
        return result;
    }
    //물품리스트조회
    public ArrayList<Dto> findAll(){
        ArrayList<Dto> result = bd.findAll();
        return result;
    }
    //물품수정
    public boolean update(int bno , int pwd, String product , String content , int price , String phone , boolean isAvailable){
        boolean result = bd.update(bno, pwd, product, content, price, phone, isAvailable);
        return result;
    }

    //물품삭제
    public boolean delete(int bno){
        boolean result = bd.delete(bno);
        return result;
    }
}
