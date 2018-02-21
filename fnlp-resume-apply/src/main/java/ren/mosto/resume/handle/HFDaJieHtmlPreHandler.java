package ren.mosto.resume.handle;

import ren.mosto.resume.ResumePreHandler;
import ren.mosto.resume.utils.ReduceHtmlTextUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by ye on 2017/12/5.
 */
@Slf4j
public class HFDaJieHtmlPreHandler implements ResumePreHandler<String> {
    @Override
    public String[] handle(String html) {

        Document doc = Jsoup.parse(html, "gbk");
            /*
             * 获取HTML的编码格式
             */
        String content = doc.select("head>meta").eq(0).first().attr("content");
        String charset = content.split(";")[1].trim().split("=")[1];
        if (!"gbk".equalsIgnoreCase(charset)) {
            doc = Jsoup.parse(html, charset);
        }
        //完全移除HTML标签
        String contentText = ReduceHtmlTextUtil.removeHtmlTag(doc.toString()).replace("*", "");
        log.debug(contentText);
        //保留部分HTML标签
        String contentText1 = ReduceHtmlTextUtil.removeHtmlTag2(doc.toString(), "<(?!br)(?!span)(?![/]span)[^>]*>").replace("*", "");
        log.debug(contentText1);
        return new String[]{ contentText, contentText1 };
    }
}
