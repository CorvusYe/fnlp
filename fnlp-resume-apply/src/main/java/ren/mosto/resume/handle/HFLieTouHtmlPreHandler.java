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
public class HFLieTouHtmlPreHandler implements ResumePreHandler<String> {

    @Override
    public String[] handle(String html) {
        Document doc = Jsoup.parse(html, "gb2312");
            /*
             * 获取HTML的编码格式
             */
        String content=doc.select("meta").eq(0).first().attr("content");
        String charset=content.split(";")[1].trim().split("=")[1];
        if(!"gb2312".equalsIgnoreCase(charset)){
            doc = Jsoup.parse(html, charset);
        }
        String contentText = ReduceHtmlTextUtil.removeHtmlTag(doc.toString());
        log.debug(contentText);
        return new String[]{ contentText };
    }

}
