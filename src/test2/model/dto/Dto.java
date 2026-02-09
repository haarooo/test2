package test2.model.dto;

public class Dto {
    private int bno ;
    private String nickname;
    private String product;
    private String content;
    private int price;
    private int pwd;
    private String phone;
    private boolean isAvailable;
    private String bdate;

    public Dto(){}

    public Dto( int bno , String nickname, String product, String content, int price, int pwd, String phone, boolean isAvailable, String bdate) {
        this.bno = bno;
        this.nickname = nickname;
        this.product = product;
        this.content = content;
        this.price = price;
        this.pwd = pwd;
        this.phone = phone;
        this.isAvailable = isAvailable;
        this.bdate = bdate;

    }

    public int getBno() {return bno;}
    public void setBno(int bno) {this.bno = bno;}
    public String getNickname() {return nickname;}
    public void setNickname(String nickname) {this.nickname = nickname;}
    public String getProduct() {return product;}
    public void setProduct(String product) {this.product = product;}
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}
    public int getPwd() {return pwd;}
    public void setPwd(int pwd) {this.pwd = pwd;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public boolean isAvailable() {return isAvailable;}
    public void setIsAvailable(boolean isAvailable) {this.isAvailable = isAvailable;}
    public String getBdate() {return bdate;}
    public void setBdate(String bdate) {this.bdate = bdate;}

    @Override
    public String toString() {
        return "Dto{" +
                "bno=" + bno +
                ", nickname='" + nickname + '\'' +
                ", productName='" + product + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", pwd=" + pwd +
                ", phone='" + phone + '\'' +
                ", available=" + isAvailable +
                ", bdate='" + bdate + '\'' +
                '}';
    }
}
