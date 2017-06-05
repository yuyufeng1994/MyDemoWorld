package TextRank;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.dic.Dictionary;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuyufeng on 2017/5/24.
 */
public class AnalyzerUtil {


    public static void main(String[] args) throws IOException {
        /*//读入停用词文件
        BufferedReader StopWordFileBr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(""))));
        //用来存放停用词的集合
        Set<String> stopWordSet = new HashSet<String>();
        //初如化停用词集
        String stopWord = null;
        for(; (stopWord = StopWordFileBr.readLine()) != null;){
            stopWordSet.add(stopWord);
        }*/
        analyzerString("巴巴快巴是互联网+道路客运公司巴巴快巴俞育峰是我，美丽的我");
    }

    public static List<String> analyzerString(String str) throws IOException {
        List<String> list = new ArrayList<>();
        String query = str;

        // 构建IK分词器，使用smart分词模式
        Analyzer analyzer = new IKAnalyzer(true);
        // 获取Lucene的TokenStream对象
        TokenStream ts = null;

        try {
            ts = analyzer.tokenStream("",
                    new StringReader(query));

            // 获取词元位置属性
            OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
            // 获取词元文本属性
            CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
            // 获取词元文本属性
            TypeAttribute type = ts.addAttribute(TypeAttribute.class);

            // 重置TokenStream（重置StringReader）
            ts.reset();
            // 迭代获取分词结果
            while (ts.incrementToken()) {
                String termStr = term.toString();

//                System.out.print(termStr +" "+ Dictionary.getSingleton().isStopWord(term.buffer(),0,term.length())+"|");
//                list.add(termStr);

            }
            // 关闭TokenStream（关闭StringReader）
            ts.end(); // Perform end-of-stream operations, e.g. set the final
            // offset.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 释放TokenStream的所有资源
            if (ts != null) {
                try {
                    ts.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
