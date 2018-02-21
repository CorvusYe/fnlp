package ren.mosto.resume.model;

import java.util.Date;
import java.util.List;

/**
 * Created by ye on 2017/11/19.
 */
public interface Resume<T> {

    List getAttachment();

    void setAttachment(List attachment);

    ResumeBase<T> getBaseInfo();

    void setBaseInfo(ResumeBase<T> baseInfo);

    List getCertificate();

    void setCertificate(List certificate);

    List getProject();

    void setProject(List project);

    List getEducation();

    void setEducation(List education);

    List getExperience();

    void setExperience(List experience);

    ResumeIntention<T> getIntention();

    void setIntention(ResumeIntention<T> intention);

    List getSkill();

    void setSkill(List skill);

    Position<T> getPosition();

    void setPosition(Position<T> position);

    Date getApplyTime();

    void setApplyTime(Date applyTime);

    ResumeIntroducer<T> getIntroducer();

    void setIntroducer(ResumeIntroducer<T> introducer);

    List getFamily();

    void setFamily(List family);

    List getOthers();

    void setOthers(List others);

    List getPrize();

    void setPrize(List prizes);

    List getSchoolPost();

    void setSchoolPost(List resumeSchoolPosts);

    List getTrain();

    void setTrain(List resumeTrainHistories);

    boolean isSuccess();

    void setSuccess(boolean isSuccess);

}
