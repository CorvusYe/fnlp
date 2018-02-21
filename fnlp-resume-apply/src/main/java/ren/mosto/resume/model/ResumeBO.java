package ren.mosto.resume.model;

import java.util.Date;
import java.util.List;

/**
 * Created by ye on 2017/11/18.
 */
public class ResumeBO<T> implements Resume<T> {

    /** 简历附件 */
    private List<ResumeAttachment<T>> attachment;

    /**  基本信息 */
    private ResumeBase baseInfo;

    /** 获得证书 */
    private List<ResumeCertificate<T>> certificate;

    /** 项目经验 */
    private List<ResumeProjectExperience<T>> project;

    /**  教育经历 */
    private List<ResumeEducationHistory<T>> education;

    /**  工作经验 */
    private List<ResumeWorkHistory<T>> experience;

    /**  求职意向 */
    private ResumeIntention<T> intention;

    /**  技能 */
    private List<ResumeSkill<T>> skill;

    /** 申请职位 */
    private Position<T> position;

    /**
     * 投递时间
     */
    private Date applyTime;

    /**
     * 推荐人信息
     */
    private ResumeIntroducer<T> introducer;

    /** 家庭成员信息 */
    private List<ResumeFamily<T>> family;

    /** 其他信息 */
    private List<ResumeOthers<T>> others;

    /** 在校荣誉 */
    private List<ResumePrize<T>> prize;

    /** 在校职位 */
    private List<ResumeSchoolPost<T>> schoolPost;

    /** 培训经历 */
    private List<ResumeTrainHistory<T>> train;

    /** 简历解析成功标识 */
    private boolean success;

    @Override
    public List<ResumeAttachment<T>> getAttachment() {
        return attachment;
    }

    @Override
    public void setAttachment(List attachment) {
        this.attachment = attachment;
    }

    @Override
    public ResumeBase getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(ResumeBase baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    public List<ResumeCertificate<T>> getCertificate() {
        return certificate;
    }

    @Override
    public void setCertificate(List certificate) {
        this.certificate = certificate;
    }

    @Override
    public List getProject() {
        return project;
    }

    @Override
    public void setProject(List project) {
        this.project = project;
    }

    @Override
    public List getEducation() {
        return education;
    }

    @Override
    public void setEducation(List education) {
        this.education = education;
    }

    @Override
    public List getExperience() {
        return experience;
    }

    @Override
    public void setExperience(List experience) {
        this.experience = experience;
    }

    @Override
    public ResumeIntention<T> getIntention() {
        return intention;
    }

    @Override
    public void setIntention(ResumeIntention<T> intention) {
        this.intention = intention;
    }

    @Override
    public List<ResumeSkill<T>> getSkill() {
        return skill;
    }

    @Override
    public void setSkill(List skill) {
        this.skill = skill;
    }

    @Override
    public Position<T> getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position<T> position) {
        this.position = position;
    }

    @Override
    public Date getApplyTime() {
        return applyTime;
    }

    @Override
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    @Override
    public ResumeIntroducer<T> getIntroducer() {
        return introducer;
    }

    @Override
    public void setIntroducer(ResumeIntroducer<T> introducer) {
        this.introducer = introducer;
    }

    @Override
    public List getFamily() {
        return family;
    }

    @Override
    public void setFamily(List family) {
        this.family = family;
    }

    @Override
    public List getOthers() {
        return others;
    }

    @Override
    public void setOthers(List others) {
        this.others = others;
    }

    @Override
    public List getPrize() {
        return prize;
    }

    @Override
    public void setPrize(List prize) {
        this.prize = prize;
    }

    @Override
    public List getSchoolPost() {
        return schoolPost;
    }

    @Override
    public void setSchoolPost(List schoolPost) {
        this.schoolPost = schoolPost;
    }

    @Override
    public List<ResumeTrainHistory<T>> getTrain() {
        return train;
    }

    @Override
    public void setTrain(List train) {
        this.train = train;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
