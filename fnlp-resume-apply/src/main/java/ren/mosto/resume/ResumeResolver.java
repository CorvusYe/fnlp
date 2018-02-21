package ren.mosto.resume;

import ren.mosto.resume.model.Resume;

/**
 * 不同解析器的接口
 * @author yeweicheng@xdf.cn 2017-11-19 16:02:08
 */
public interface ResumeResolver {

    /**
     *
     * @param content 包含简历信息的文本
     * @return
     */
    Resume resolve(int contentType, String... content);

}
