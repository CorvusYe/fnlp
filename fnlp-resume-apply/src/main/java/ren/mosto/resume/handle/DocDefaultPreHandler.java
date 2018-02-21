package ren.mosto.resume.handle;

import ren.mosto.resume.ResumePreHandler;
import ren.mosto.resume.utils.ReadWordResumeByPoiUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;

/**
 * Created by ye on 2017/12/5.
 */
@Slf4j
public class DocDefaultPreHandler implements ResumePreHandler<InputStream> {
    @Override
    public String[] handle(InputStream in) {
        String contentText = ReadWordResumeByPoiUtil.getTextByPoi(in);
        log.debug(contentText);
        return new String[]{ contentText, null };
    }
}
