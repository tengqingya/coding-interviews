import static java.lang.System.out;

/**
 * Author: 王俊超
 * Date: 2015-04-21
 * Time: 19:09
 * Declaration: All Rights Reserved !!!
 */
public class Test04 {
    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“。
     *
     * @param string     要转换的字符数组
     * @param usedLength 已经字符数组中已经使用的长度
     * @return 转换后使用的字符长度，-1表示处理失败
     */

    public static int t(char args[],int length){
        int l = length*3;
        char res[] = new char[l];
        int j=l-1;
        for(int i=length-1;i>=0;i--){
            if(args[i] == ' '){
                //是空格
                res[j--] = '0';
                res[j--] = '2';
                res[j--] = '%';
            }else {
                res[j--] = args[i];
            }
        }
        out.println(new String(res) +"-----") ;
        return l- j;
    }











































    public static int replaceBlank(char[] string, int usedLength) {
        // 判断输入是否合法
        if (string == null || string.length < usedLength) {
            return -1;
        }

        // 统计字符数组中的空白字符数
        int whiteCount = 0;
        for (int i = 0; i < usedLength; i++) {
            if (string[i] == ' ') {
                whiteCount++;
            }
        }

        // 计算转换后的字符长度是多少
        int targetLength = whiteCount * 2 + usedLength;
        int tmp = targetLength; // 保存长度结果用于返回
        if (targetLength > string.length) { // 如果转换后的长度大于数组的最大长度，直接返回失败
            return -1;
        }

        // 如果没有空白字符就不用处理
        if (whiteCount == 0) {
            return usedLength;
        }

        usedLength--; // 从后向前，第一个开始处理的字符
        targetLength--; // 处理后的字符放置的位置

        // 字符中有空白字符，一直处理到所有的空白字符处理完
        while (usedLength >= 0 && usedLength < targetLength) {
            // 如是当前字符是空白字符，进行"%20"替换
            if (string[usedLength] == ' ') {
                string[targetLength--] = '0';
                string[targetLength--] = '2';
                string[targetLength--] = '%';
            } else { // 否则移动字符
                string[targetLength--] = string[usedLength];
            }
            usedLength--;
        }

        return tmp;
    }













    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';
//%20e%20%20re%20%20a%20p%20
//%20e%20%20re%20%20a%20p%20
        int length = replaceBlank(string, 12);
//        int t = t(string, 12);
        out.println(new String(string, 0, length));
//        out.println(t);
    }
}
