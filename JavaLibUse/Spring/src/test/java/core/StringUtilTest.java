package core;

import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * Created by yuyufeng on 2017/5/10.
 */
public class StringUtilTest {
    @Test
    public void test() {


//        StringUtils.hasLength(null) = false;
//        StringUtils.hasLength("") = false;
//        StringUtils.hasLength(" ") = true;
//        StringUtils.hasLength("Hello") = true;
//
//        StringUtils.hasText(null) = false;
//        StringUtils.hasText("") = false;
//        StringUtils.hasText(" ") = false;
//        StringUtils.hasText("12345") = true;
//        StringUtils.hasText(" 12345 ") = true;
//
//        //是否包含空白字符
//        StringUtils.containsWhitespace(null)=false;
//        StringUtils.containsWhitespace("")=false;
//        StringUtils.containsWhitespace("a")=false;
//        StringUtils.containsWhitespace("abc")=false;
//        StringUtils.containsWhitespace("abc")=false;
//        StringUtils.containsWhitespace(" ")=true;
//        StringUtils.containsWhitespace(" a")=true;
//        StringUtils.containsWhitespace("abc ")=true;
//        StringUtils.containsWhitespace("a b")=true
//        StringUtils.containsWhitespace("a  b")
//
//        StringUtils.trimWhitespace(null)=null;
//        StringUtils.trimWhitespace("")="";
//        StringUtils.trimWhitespace(" ")="";
//        StringUtils.trimWhitespace("/t")="";
//        StringUtils.trimWhitespace(" a")="a";
//        StringUtils.trimWhitespace("a ")="a";
//        StringUtils.trimWhitespace(" a ")="a";
        System.out.println(StringUtils.trimWhitespace(" a b "));//="a b";
//
//        StringUtils.trimLeadingWhitespace(null)=null;
//        StringUtils.trimLeadingWhitespace("")="";
//        StringUtils.trimLeadingWhitespace(" ")="";
//        StringUtils.trimLeadingWhitespace("/t")="";
//        StringUtils.trimLeadingWhitespace(" a")="a";
//        StringUtils.trimLeadingWhitespace("a ")="a ";
//        StringUtils.trimLeadingWhitespace(" a ")="a ";
//        StringUtils.trimLeadingWhitespace(" a b ")="a b "
//        StringUtils.trimLeadingWhitespace(" a b  c ")="a b  c "
//
//        StringUtils.trimTrailingWhitespace(null)=null;
//        StringUtils.trimTrailingWhitespace(" ")="";
//        StringUtils.trimTrailingWhitespace("/t")="";
//        StringUtils.trimTrailingWhitespace("a ")="a";
//        StringUtils.trimTrailingWhitespace(" a")=" a";
//        StringUtils.trimTrailingWhitespace(" a ")=" a";
//        StringUtils.trimTrailingWhitespace(" a b ")=" a b";
//        StringUtils.trimTrailingWhitespace(" a b  c ")=" a b  c";
//
//
//        StringUtils.trimAllWhitespace("")="";
//        StringUtils.trimAllWhitespace(" ")="";
//        StringUtils.trimAllWhitespace("/t")="";
//        StringUtils.trimAllWhitespace(" a")="a";
//        StringUtils.trimAllWhitespace("a ")="a";
//        StringUtils.trimAllWhitespace(" a ")="a";
//        StringUtils.trimAllWhitespace(" a b ")="ab";
//        StringUtils.trimAllWhitespace(" a b  c "="abc";
//        // 统计一个子字符串在字符串出现的次数
//        StringUtils.countOccurrencesOf(null, null) == 0;
//        StringUtils.countOccurrencesOf("s", null) == 0;
//        StringUtils.countOccurrencesOf(null, "s") == 0;
//        StringUtils.countOccurrencesOf("erowoiueoiur", "WERWER") == 0;
//        StringUtils.countOccurrencesOf("erowoiueoiur", "x")=0;
//        StringUtils.countOccurrencesOf("erowoiueoiur", " ") == 0;
//        StringUtils.countOccurrencesOf("erowoiueoiur", "") == 0;
//        StringUtils.countOccurrencesOf("erowoiueoiur", "e") == 2;
//        StringUtils.countOccurrencesOf("erowoiueoiur", "oi") == 2;
//        StringUtils.countOccurrencesOf("erowoiueoiur", "oiu") == 2;
//        StringUtils.countOccurrencesOf("erowoiueoiur", "oiur") == 1;
//        StringUtils.countOccurrencesOf("erowoiueoiur", "r") == 2;
//
//        //字符串替换
//        String inString = "a6AazAaa77abaa";
//        String oldPattern = "aa";
//        String newPattern = "foo";
//        // Simple replace
//        String s = StringUtils.replace(inString, oldPattern, newPattern);
//        s.equals("a6AazAfoo77abfoo")=true;
//
//        // Non match: no change
//        s = StringUtils.replace(inString, "qwoeiruqopwieurpoqwieur", newPattern);
//        s.equals(inString)=true
//        s = StringUtils.replace(inString, oldPattern, null);
//        s.equals(inString)=true
//
//        // Null old pattern: should ignore
//        s = StringUtils.replace(inString, null, newPattern);
//        s.equals(inString)=true
//
//        //删除字符串
//        String inString = "The quick brown fox jumped over the lazy dog";
//        String noThe = StringUtils.delete(inString, "the");
//        noThe.equals("The quick brown fox jumped over  lazy dog")=true;
//        String nohe = StringUtils.delete(inString, "he");
//        nohe.equals("T quick brown fox jumped over t lazy dog")=true;
//        String nosp = StringUtils.delete(inString, " ");
//        nosp.equals("Thequickbrownfoxjumpedoverthelazydog")=true;
//        String killEnd = StringUtils.delete(inString, "dog");
//        killEnd.equals("The quick brown fox jumped over the lazy ")=true;
//        String mismatch = StringUtils.delete(inString, "dxxcxcxog");
//        mismatch.equals(inString)=true;
//
//        //删除任何字符
//        //源代码如下
//        //char c = inString.charAt(i);
//        //如果不存在 c 值，则返回 -1
//        //if (charsToDelete.indexOf(c) == -1) {
//        //out.append(c);
//        //}
//
//        String inString = "Able was I ere I saw Elba";
//
//        String res = StringUtils.deleteAny(inString, "I");
//        res.equals("Able was  ere  saw Elba")=true;
//        res = StringUtils.deleteAny(inString, "AeEba!");
//        res.equals("l ws I r I sw l")=true;
//        String mismatch = StringUtils.deleteAny(inString, "#@$#$^");
//        mismatch.equals(inString)=true;
//
//        //源代码如下 return (str != null ? "'" + str + "'" : null);
//        assertEquals("'myString'", StringUtils.quote("myString"));
//        assertEquals("''", StringUtils.quote(""));
//        assertNull(StringUtils.quote(null));
//        //将第一个字符改大写
//        StringUtils.capitalize(Str)
//        //将第一个个字符改小写
//        StringUtils.uncapitalize(str)
//
//        //mypath/myfile.txt" -> "myfile.txt
//        //获取字符串文件名和扩展名
//        StringUtils.getFilename("myfile").equals("myfile")=true;
//        StringUtils.getFilename("mypath/myfile".equals("myfile")=true;
//        StringUtils.getFilename("mypath/myfile".equals("myfile")=true;
//        StringUtils.getFilename("myfile.txt").equals("myfile.txt")=true;
//        StringUtils.getFilename("mypath/myfile.txt").equals("myfile.txt")=true;
//
//        // 获取字符串扩展名,以.分隔
//        StringUtils.getFilenameExtension("myfile")=null;
//        StringUtils.getFilenameExtension("myPath/myfile")=null;
//        StringUtils.getFilenameExtension("myfile.").equals("")=true;
//        StringUtils.getFilenameExtension("myPath/myfile.").equals("")=true;
//        StringUtils.StringUtils.getFilenameExtension("myfile.txt").equals("txt")=true;
//        StringUtils.getFilenameExtension("mypath/myfile.txt").equals("txt")=true;
//
//        //舍去文件名扩展名
//        StringUtils.stripFilenameExtension(null)=true;
//        StringUtils.stripFilenameExtension("").equals("")=true;
//        StringUtils.stripFilenameExtension("myfile").equals("myfile")=true;
//        StringUtils.stripFilenameExtension("mypath/myfile").equals("mypath/myfile")=true;
//        StringUtils.stripFilenameExtension("myfile.").equals("myfile")=true;
//        StringUtils.stripFilenameExtension("mypath/myfile.").equals("mypath/myfile")=true;
//        StringUtils.stripFilenameExtension("mypath/myfile.").equals("mypath/myfile")=true;
//        StringUtils.stripFilenameExtension("myfile.txt").equals("myfile")=true;
//        StringUtils.stripFilenameExtension("mypath/myfile.txt").equals("mypath/myfile")=true
    }
}
