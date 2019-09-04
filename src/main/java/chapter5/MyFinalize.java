package chapter5;

/**
 * @Description finalize函数可能用法
 * @Author yuki
 * @Date 2018/12/12 18:41
 * @Version 1.0
 **/
public class MyFinalize {
    static class Book{
        boolean checkout=false;
        Book(boolean checkout){
            this.checkout=checkout;
        }
        void checkin(){
            checkout=false;
        }
        @Override
        protected void finalize() throws Throwable {
            if (checkout){
                System.out.println("error:checkout");
            }
//            super.finalize();
        }
    }
    public static void main(String[] args) {
        Book book1=new Book(true);
        book1.checkin();
        new Book(true);
        System.gc();
    }
}
