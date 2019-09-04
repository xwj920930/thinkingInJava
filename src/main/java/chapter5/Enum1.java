package chapter5;

/**
 * enum通用写法
 */
public enum Enum1 {
    S(0,"small"),M(1,"medium"),L(2,"large");
    private int code;
    private String name;
    Enum1(int code,String name){
        this.code=code;
        this.name=name;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static Enum1 getByCode(int code){
        for (Enum1 enum1 : Enum1.values()) {
            if (code==enum1.getCode()){
                return enum1;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(Enum1.S);
        System.out.println(Enum1.L.getCode());
    }
}
