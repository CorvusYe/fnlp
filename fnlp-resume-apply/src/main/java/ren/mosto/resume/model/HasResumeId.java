package ren.mosto.resume.model;

/**
 * Created by ye on 2017/11/19.
 */
public interface HasResumeId<T> extends BaseModel<T> {

    T getResumeId();

    void setResumeId(T resumeId);

}
