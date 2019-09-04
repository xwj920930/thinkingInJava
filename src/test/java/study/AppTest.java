package study;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    private static void combine(char[] c,int begin,int len,StringBuffer sb){
        if (len==0){
            System.out.println(sb);
            return;
        }
        if (begin==c.length){
            return;
        }
        sb.append(c[begin]);
        combine(c,begin+1,len-1,sb);
        sb.deleteCharAt(sb.length()-1);
        combine(c,begin+1,len,sb);
    }
    public static void main(String[] args) {
        String s="abc";
        char[] c=s.toCharArray();
        StringBuffer sb=new StringBuffer("");
        int len=c.length;
        for (int i=0;i<=len;i++){
            combine(c,0,i,sb);
        }
    }
}
