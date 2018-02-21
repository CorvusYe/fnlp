package ren.mosto.resume;

import ren.mosto.resume.model.Resume;

/**
 * 简历后置处理器，主要用于数据格式调整，字典转换
 * Created by ye on 2017/12/17.
 */
public interface ResumeSufHandler {

    void handle(Resume resume, String channel);

}
