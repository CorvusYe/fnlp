package ren.mosto.resume.model;

import java.util.Date;

/**
 * Created by ye on 2017/11/19.
 */
public interface ResumeBase<T> extends BaseModel<T> {

    String getCode();

    void setCode(String code);

    String getName();

    void setName(String name);

    String getSex();

    void setSex(String sex);

    Date getBirthday();

    void setBirthday(Date birthday);

    String getMobile();

    void setMobile(String mobile);

    String getEmail();

    void setEmail(String email);

    Date getGraduationTime();

    void setGraduationTime(Date graduationTime);

    String getAccountAddress();

    void setAccountAddress(String accountAddress);

    String getNativePlace();

    void setNativePlace(String nativePlace);

    String getIdNumber();

    void setIdNumber(String idNumber);

    String getMaritalStatus();

    void setMaritalStatus(String maritalStatus);

    String getPoliticalStatus();

    void setPoliticalStatus(String politicalStatus);

    String getExperience();

    void setExperience(String experience);

    String getFaceUrl();

    void setFaceUrl(String faceUrl);

    Date getCreateTime();

    void setCreateTime(Date createTime);

    String getSource();

    void setSource(String source);

    String getWorkExperience();

    void setWorkExperience(String workExperience);

    String getHasGraduated();

    void setHasGraduated(String hasGraduated);

    String getIntentionXdf();

    void setIntentionXdf(String intentionXdf);

    Date getInviteTime();

    void setInviteTime(Date inviteTime);

    String getAddress();

    void setAddress(String address);

    String getNation();

    void setNation(String nation);

    String getApplyState();

    void setApplyState(String applyState);

    String getRemark();

    void setRemark(String remark);

    Date getInterviewTime();

    void setInterviewTime(Date interviewTime);

    String getSelfIntroduce();

    void setSelfIntroduce(String selfIntroduce);

    String getApplyPosition();

    void setApplyPosition(String applyPosition);

    String getHrCompanyId();

    void setHrCompanyId(String hrCompanyId);

    String getDeliveryDate();

    void setDeliveryDate(String deliveryDate);

    String getResumeLink();

    void setResumeLink(String resumeLink);

    String getDeliveryDateStart();

    void setDeliveryDateStart(String deliveryDateStart);

    String getDeliveryDateEnd();

    void setDeliveryDateEnd(String deliveryDateEnd);


}
