package test2.view;

import test2.controller.Controller;
import test2.model.dto.Dto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    private View(){}
    private static final View instance = new View();
    public static View getInstance(){return instance;}
    private Controller bc = Controller.getInstance();
    Scanner scan = new Scanner(System.in);

    //메인화면
    public void index(){
        for(;;){
            try{
            System.out.println("-----------------------");
            System.out.println("1.물품등록 | 2.전체물품조회 | 3.물품정보수정 | 4.등록물품삭제 ");
            System.out.println("-----------------------");
            System.out.print("선택 >"); int num = scan.nextInt();
            if(num==1){write();
            }else if(num==2){findAll();
            }else if(num==3){update();
            }else if(num==4){
            }else{System.out.println("없는 기능 번호입니다");}
            }catch (InputMismatchException e1){
                System.out.println("잘못된 입력방식입니다" + e1);
                scan = new Scanner(System.in);
            }catch (Exception e2){
                System.out.println("시스템오류" + e2);
            }
        }
    }

    //1. 물품등록
    public void write(){
        scan.nextLine();
        System.out.print("닉네임 : "); String nickname = scan.nextLine();
        System.out.print("물품명 : "); String product = scan.next();
        System.out.print("설명 : "); String content = scan.next();
        System.out.print("가격 : "); int  price = scan.nextInt();
        System.out.print("비밀번호 : "); int  pwd = scan.nextInt();
        System.out.print("연락처 : "); String phone = scan.next();
        boolean result = bc.write(nickname , product , content , price , pwd , phone);
        if(result){
            System.out.println("물품등록완료");
        }else{
            System.out.println("물품등록실패");
        }
    }
    //2. 물품조회
    public void findAll(){
        ArrayList<Dto> products = bc.findAll();
        for(Dto product : products){
            System.out.printf("번호 : %d , 닉네임 : %s , 물품 : %s , 설명 : %s , 가격 : %d , 연락처 : %s , 판매여부 : %b , 등록일 : %s \n",
            product.getBno() , product.getNickname() , product.getProduct() , product.getContent() , product.getPrice() , product.getPhone() , product.isAvailable() , product.getBdate());
        }
    }
    //3. 물품정보수정
    public void update(){
        System.out.print("수정할 게시물번호 : "); int bno =scan.nextInt();
        System.out.print("비밀번호 : "); int pwd = scan.nextInt();
        System.out.print("물품명 : "); String product = scan.next();
        System.out.print("설명 : "); String content = scan.next();
        System.out.print("가격 : ");int price = scan.nextInt();
        System.out.print("연락처 : "); String phone = scan.next();
        System.out.print("판매여부(판매면 true|판매완료면 false를 입력하세요) : "); boolean isAvailable = scan.nextBoolean();
        boolean result = bc.update(bno, pwd, product, content, price, phone, isAvailable);
        if(result){
            System.out.println("게시물 수정완료");
        }else{
            System.out.println("게시물 수정 실패");
        }
    }
    //4. 등록물품 삭제
    public void delete(){
        System.out.print("삭제할 게시물번호 : "); int bno = scan.nextInt();
        System.out.print("비밀번호 : "); int pwd = scan.nextInt();
        boolean result = bc.delete(bno);
        if(result){
            System.out.println("게시물 삭제완료");
        }else{
            System.out.println("게시물 삭제 실패");
        }
    } //12311

}// c end
