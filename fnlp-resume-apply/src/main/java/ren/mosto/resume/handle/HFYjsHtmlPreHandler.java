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
public class HFYjsHtmlPreHandler implements ResumePreHandler<String> {
    @Override
    public String[] handle(String html) {
        Document doc = Jsoup.parse(html, "utf-8");
            /*
             * 获取HTML的编码格式
             */
        String content=doc.select("head>meta").eq(0).first().attr("content");
        String charset=content.split(";")[1].trim().split("=")[1];
        if(!"gbk".equalsIgnoreCase(charset)){
            doc = Jsoup.parse(html, charset);
        }
        String contentText = ReduceHtmlTextUtil.removeHtmlTag(doc.toString()).replace("*", "");
        log.debug(contentText);
        return new String[]{ contentText };
    }
}
