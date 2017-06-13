package hash;

/**
 * Created by yuyufeng on 2017/6/13.
 */
public class HashTest {
    private static int HASHSIZE = 20;

    // 建立长度为100的散列表
    private static String[] arr = new String[HASHSIZE];

    public static void main(String[] args) {
        insert("ab5");
        insert("abc");
        insert("qew");
        insert("oiu");
        insert("dad7");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("[" + i + "]=" + arr[i]);
        }

        String sv = "ab5";
        System.out.println(sv + "位置：" + find(sv));

        sv = "oiu";
        System.out.println(sv + "位置：" + find(sv));

        sv = "hah";
        System.out.println(sv + "位置：" + find(sv));

    }

    public static void insert(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) + i;
        }
        int index = sum % 13;

        // 发生冲突 线性寻址法
        while (true) {
            if (index >= HASHSIZE) {
                System.err.println("插入失败：" + str);
            }
            if (arr[index] == null) {
                arr[index] = str;
                break;
            } else {
                index++;
            }

        }

    }

    public static int find(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) + i;
        }
        int index = sum % 13;
        // 发生冲突 线性寻址法
        while (true) {
            if (index >= HASHSIZE) {
                System.err.println("没有数据：" + str);
                return 404;
            }
            if (str.equals(arr[index])) {
                return index;
            } else {
                index++;
            }

        }

    }
}
