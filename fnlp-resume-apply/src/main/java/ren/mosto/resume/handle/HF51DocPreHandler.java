package ren.mosto.resume.handle;

import ren.mosto.resume.ResumePreHandler;
import ren.mosto.resume.utils.ReadWordResumeByPoiUtil;

import java.io.InputStream;

/**
 * Created by ye on 2017/11/21.
 */
public class HF51DocPreHandler implements ResumePreHandler<InputStream> {

    @Override
    public String[] handle(InputStream input) {
        String doc= ReadWordResumeByPoiUtil.getTextByPoi(input);
        String contentText = doc.replaceAll("\\s*|\t|\r|\n", "");
        return new String[]{doc};
    }

}
