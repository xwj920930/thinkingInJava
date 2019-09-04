package chapter7;

/**
 * @Description
 * 调用子类的参数构造方法时候，
 * 会默认调用父类的默认构造器，
 * 当没有默认构造器的时候必须显式调用super（父类必须包含此类参数构造）
 * @Author yuki
 * @Date 2018/12/20 15:45
 * @Version 1.0
 **/
class Game{
//    Game(){
//        System.out.println("Game()");
//    }
    Game(int i){
        System.out.println("Game(i)");
    }
}
public class BoardGame extends Game{
    BoardGame(int i){
        super(i);
        System.out.println("BoardGame(i)");
    }

    public static void main(String[] args) {
        BoardGame boardGame=new BoardGame(1);
    }
}
